package id.inharmonia.app.Main.Pages.Account.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import id.inharmonia.app.Main.Pages.Account.AccountSettingActivity;
import id.inharmonia.app.Main.Pages.Account.List.MenuList;
import id.inharmonia.app.R;
import id.inharmonia.app.Setting.SettingActivity;
import id.inharmonia.app.Web.WebActivity;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.Holder> {

    final Context adapter_context;
    private List<MenuList> list_menu;
    private int layout_type;

    public MenuListAdapter(Context adapter_context, List<MenuList> list_menu, int layout_type) {
        this.adapter_context = adapter_context;
        this.list_menu = list_menu;
        this.layout_type = layout_type;
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

        @BindView(R.id.cv_item)
        CardView cv_item_menu;

        Holder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cv_item)
        public void go_to() {
            Intent intent = new Intent();
            switch (getAdapterPosition()){
                case 0 :
                    intent = new Intent(itemView.getContext(), AccountSettingActivity.class);
                    break;
                case 1 :
                    intent = new Intent(itemView.getContext(), SettingActivity.class);
                    break;
                case 2 :
                    intent = new Intent(itemView.getContext(), WebActivity.class);
                    set_title_page(intent, "Pusat Bantuan");
                    break;
                case 3 :
                    intent = new Intent(itemView.getContext(), WebActivity.class);
                    set_title_page(intent, "Hubungi Kami");
                    break;
                case 4 :
                    intent = new Intent(itemView.getContext(), WebActivity.class);
                    set_title_page(intent, "Kebijakan Privasi");
                    break;
            }
            itemView.getContext().startActivity(intent);
        }

        public void set_title_page(Intent i, String title_page) {
            Bundle bundle_me = new Bundle();
            bundle_me.putString("pageTitle", title_page);
            i.putExtras(bundle_me);
        }

    }

}
