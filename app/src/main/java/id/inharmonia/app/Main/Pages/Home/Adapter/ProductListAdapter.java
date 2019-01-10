package id.inharmonia.app.Main.Pages.Home.Adapter;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.Main.Pages.Home.HomeFragment;
import id.inharmonia.app.Main.Pages.Home.List.ProductList;
import id.inharmonia.app.Main.Pages.Home.Popup.AllPrintTypePopup;
import id.inharmonia.app.R;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.Holder> {

    final Context adapter_context;
    private List<ProductList> list_product;
    private int layout_type;

    HomeFragment fragment_home;

    AllPrintTypePopup popup_all_print_type = new AllPrintTypePopup();

    public ProductListAdapter(Context adapter_context, List<ProductList> list_product, int layout_type, HomeFragment fragment_home) {
        this.adapter_context = adapter_context;
        this.list_product = list_product;
        this.layout_type = layout_type;
        this.fragment_home = fragment_home;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout_type, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tv_title.setText(list_product.get(position).get_name());
        holder.iv_icon.setImageResource(list_product.get(position).get_icon());
        holder.cv_item_menu.setEnabled(list_product.get(position).get_is_enabled());
        if (!holder.cv_item_menu.isEnabled()) {
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(0);
            holder.iv_icon.setColorFilter(new ColorMatrixColorFilter(matrix));
            holder.tv_title.setTextColor(adapter_context.getResources().getColor(R.color.colorGrey));
        }
    }

    @Override
    public int getItemCount() {
        return list_product.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tv_title;

        @BindView(R.id.iv_icon)
        ImageView iv_icon;

        @BindView(R.id.cv_item)
        CardView cv_item_menu;

        Holder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cv_item)
        public void go_to() {
            switch (getAdapterPosition()){
                case 4:
                    if (popup_all_print_type.check_sheet()) {
                        popup_all_print_type.send_mom(fragment_home);
                        popup_all_print_type.show(((FragmentActivity) adapter_context).getSupportFragmentManager(), popup_all_print_type.getTag());
                    }
                    break;
                default:
                    break;
            }
        }

    }

}
