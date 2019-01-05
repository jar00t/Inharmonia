package id.inharmonia.app.Main.Pages.Home.Adapter;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.os.Bundle;
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
import id.inharmonia.app.Main.Pages.Home.List.MenuList;
import id.inharmonia.app.Main.Pages.Home.Popup.AllPrintTypePopup;
import id.inharmonia.app.Main.Pages.Home.Popup.SizeQuantityPopup;
import id.inharmonia.app.R;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.Holder> {

    final Context adapter_context;
    private List<MenuList> list_menu;
    private int layout_type;
    HomeFragment fragment_home;

    SizeQuantityPopup popup_size_quantity = new SizeQuantityPopup();
    AllPrintTypePopup popup_all_print_type = new AllPrintTypePopup();

    public MenuListAdapter(Context adapter_context, List<MenuList> list_menu, int layout_type, HomeFragment fragment_home) {
        this.adapter_context = adapter_context;
        this.list_menu = list_menu;
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
        holder.tv_title.setText(list_menu.get(position).get_name());
        holder.iv_icon.setImageResource(list_menu.get(position).get_icon());
        holder.cv_item_menu.setEnabled(list_menu.get(position).get_is_enabled());
        if (!holder.cv_item_menu.isEnabled()) {
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(0);
            holder.iv_icon.setColorFilter(new ColorMatrixColorFilter(matrix));
            holder.tv_title.setTextColor(adapter_context.getResources().getColor(R.color.colorGrey));
            holder.iv_label_corner.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return list_menu.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tv_title;

        @BindView(R.id.iv_icon)
        ImageView iv_icon;

        @BindView(R.id.cv_item_type)
        CardView cv_item_menu;

        @BindView(R.id.iv_label_corner)
        ImageView iv_label_corner;

        Holder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cv_item_type)
        public void go_to() {
            switch (getAdapterPosition()){
                default:
                    if (popup_size_quantity.check_sheet()) {
                        Bundle data_sheet = new Bundle();
                        data_sheet.putInt("icon", list_menu.get(getAdapterPosition()).get_icon());
                        data_sheet.putString("title", list_menu.get(getAdapterPosition()).get_name());

                        popup_size_quantity.send_mom(fragment_home);
                        popup_size_quantity.setArguments(data_sheet);
                        popup_size_quantity.show(((FragmentActivity) adapter_context).getSupportFragmentManager(), popup_size_quantity.getTag());
                    }
                    break;
                case 7 :
                    if (popup_all_print_type.check_sheet()) {
                        popup_all_print_type.send_mom(fragment_home);
                        popup_all_print_type.show(((FragmentActivity) adapter_context).getSupportFragmentManager(), popup_all_print_type.getTag());
                    }
                    break;
            }
        }

    }

}
