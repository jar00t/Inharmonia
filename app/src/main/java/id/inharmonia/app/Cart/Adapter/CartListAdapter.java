package id.inharmonia.app.Cart.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import id.inharmonia.app.Cart.CartActivity;
import id.inharmonia.app.Cart.List.CartList;
import id.inharmonia.app.Cart.List.QuantityList;
import id.inharmonia.app.R;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.Holder> {

    final Context adapter_context;
    private List<CartList> list_cart;

    CartActivity activity_cart;
    List<String> cart_selected = new ArrayList<>();
    Integer cart_selected_total = 0;

    public CartListAdapter(Context adapter_context, List<CartList> list_cart, CartActivity activity_cart) {
        this.adapter_context = adapter_context;
        this.list_cart = list_cart;
        this.activity_cart = activity_cart;
    }

    @NonNull
    @Override
    public CartListAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list_item_cart, parent, false);
        return new CartListAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartListAdapter.Holder holder, final int position) {
        switch (list_cart.get(position).get_name()) {
            case "dokumen":
                holder.iv_icon.setImageResource(R.drawable.in_thumb_moniprint_documents_square);
                holder.tv_name.setText(adapter_context.getString(R.string.dokumen));
                break;
            case "gambar":
                holder.iv_icon.setImageResource(R.drawable.in_thumb_moniprint_pictures_square);
                holder.tv_name.setText(adapter_context.getString(R.string.gambar));
                break;
        }
        holder.tv_list_size.setText(String.format("Ukuran %s", list_cart.get(position).get_type().toUpperCase().replaceAll(",", ", ")));
        holder.cb_cart_selecter.setChecked(list_cart.get(position).get_is_selected());
        set_list(holder, position);
    }

    @Override
    public int getItemCount() {
        return list_cart.size();
    }

    public void set_list(@NonNull CartListAdapter.Holder holder, int position) {
        int total_me = 0;
        holder.list_quantity = new ArrayList<>();
        String[] sizes = list_cart.get(position).get_type().split(",");
        String[] quantities = list_cart.get(position).get_quantity().split(",");
        for(int s = 0; s < sizes.length; s++) {
            holder.list_item_quantity = new QuantityList(String.format("Ukuran %s", sizes[s].toUpperCase()), String.format("%s lembar", quantities[s]));
            holder.list_quantity.add(holder.list_item_quantity);
            total_me = total_me + Integer.parseInt(quantities[s]);
        }
        if(total_me > 0) holder.tv_total.setText(String.format("%s lembar", total_me));
        holder.rv_list_quantity.setLayoutManager(new GridLayoutManager(adapter_context, 1));
        holder.rv_list_quantity.setFocusable(false);
        holder.rv_list_quantity.setAdapter(new QuantityListAdapter(adapter_context, holder.list_quantity, R.layout.rv_list_item_quantity));
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.cl_item_cart)
        ConstraintLayout cl_item_cart;

        @BindView(R.id.iv_icon)
        ImageView iv_icon;

        @BindView(R.id.tv_name)
        TextView tv_name;

        @BindView(R.id.tv_list_size)
        TextView tv_list_size;

        @BindView(R.id.iv_button_toggle)
        ImageView iv_button_toggle;

        @BindView(R.id.cv_cart_detail)
        CardView cv_cart_detail;

        @BindView(R.id.rv_list_quantity)
        RecyclerView rv_list_quantity;

        @BindView(R.id.tv_total)
        TextView tv_total;

        @BindView(R.id.cb_cart_selecter)
        CheckBox cb_cart_selecter;

        @BindView(R.id.cv_button_cart_deleter)
        CardView cv_button_cart_deleter;

        List<QuantityList> list_quantity;
        QuantityList list_item_quantity;
        AlertDialog.Builder builder_quantity_confirm_size = null;

        Boolean is_up;

        Holder(final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            is_up = true;
        }

        @OnCheckedChanged(R.id.cb_cart_selecter)
        public void select_cart() {
            list_cart.get(getAdapterPosition()).set_is_selected(cb_cart_selecter.isChecked());
            String[] quantities = list_cart.get(getAdapterPosition()).get_quantity().split(",");
            if(cb_cart_selecter.isChecked()) {
                cart_selected.add(list_cart.get(getAdapterPosition()).get_id());
                for(int i = 0; i < quantities.length; i++) cart_selected_total = cart_selected_total + Integer.parseInt(quantities[i]);
            } else {
                cart_selected.remove(list_cart.get(getAdapterPosition()).get_id());
                for(int i = 0; i < quantities.length; i++) cart_selected_total = cart_selected_total - Integer.parseInt(quantities[i]);
            }
            activity_cart.set_report(cart_selected_total, list_cart, cart_selected);
        }

        @OnClick(R.id.cv_button_cart_deleter)
        public void delete_cart() {
            if (builder_quantity_confirm_size == null){
                builder_quantity_confirm_size = new AlertDialog.Builder(adapter_context, R.style.DialogTheme);
                LayoutInflater inflater = (LayoutInflater) adapter_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view_quantity_confirm_size = inflater.inflate(R.layout.dialog_popup_message, null);
                builder_quantity_confirm_size.setView(view_quantity_confirm_size);

                TextView messages = view_quantity_confirm_size.findViewById(R.id.tv_message);
                messages.setText(adapter_context.getString(R.string.q_hapus_dari_keranjang));

                builder_quantity_confirm_size.setPositiveButton("Ok Sip", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(cb_cart_selecter.isChecked()) {
                            list_cart.get(getAdapterPosition()).set_is_selected(false);
                            String[] quantities = list_cart.get(getAdapterPosition()).get_quantity().split(",");
                            cart_selected.remove(list_cart.get(getAdapterPosition()).get_id());
                            for (int i = 0; i < quantities.length; i++) cart_selected_total = cart_selected_total - Integer.parseInt(quantities[i]);
                        }
                        list_cart.remove(getAdapterPosition());
                        notifyItemRemoved(getAdapterPosition());
                        activity_cart.set_report(cart_selected_total, list_cart, cart_selected);
                        dialog.dismiss();
                    }

                });

                builder_quantity_confirm_size.setNegativeButton("Batal", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }

                });

                Dialog dialog_quantity_confirm_size = builder_quantity_confirm_size.create();
                dialog_quantity_confirm_size.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
                dialog_quantity_confirm_size.setCancelable(true);

                dialog_quantity_confirm_size.requestWindowFeature(Window.FEATURE_NO_TITLE);

                dialog_quantity_confirm_size.show();
                dialog_quantity_confirm_size.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        builder_quantity_confirm_size = null;
                    }
                });
            }
        }

        @OnClick(R.id.iv_button_toggle)
        public void toggle_detail() {
            if (is_up) {
                iv_button_toggle.animate().rotation(180).start();
                slide_down();
            } else {
                iv_button_toggle.animate().rotation(0).start();
                slide_up();
            }
            is_up = !is_up;
        }

        public void slide_up(){
            cv_cart_detail.setVisibility(View.GONE);
        }

        public void slide_down(){
            cv_cart_detail.setVisibility(View.VISIBLE);
        }

    }

}

