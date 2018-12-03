package id.inharmonia.app.Account;

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

import id.inharmonia.app.R;
import id.inharmonia.app.SettingActivity;
import id.inharmonia.app.WebActivity;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    final Context mContext;
    private List<Menu> mMenuList;
    private int mLayoutType;

    MenuAdapter(Context mContext, List<Menu> mMenuList, int mLayoutType) {
        this.mContext = mContext;
        this.mMenuList = mMenuList;
        this.mLayoutType = mLayoutType;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(mLayoutType, parent, false);
        return new MenuViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.mTitle.setText(mMenuList.get(position).getMenuName());
        holder.mIcon.setImageResource(mMenuList.get(position).getMenuIcon());
    }

    @Override
    public int getItemCount() {
        return mMenuList.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        ImageView mIcon;
        CardView mMenuItem;

        MenuViewHolder(final View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.tvTitle);
            mIcon = itemView.findViewById(R.id.ivIcon);

            mMenuItem = itemView.findViewById(R.id.cvMenuItem);
            mMenuItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
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
                            setPageTitle(intent, "Pusat Bantuan");
                            break;
                        case 3 :
                            intent = new Intent(itemView.getContext(), WebActivity.class);
                            setPageTitle(intent, "Tentang Kami");
                            break;
                        case 4 :
                            intent = new Intent(itemView.getContext(), WebActivity.class);
                            setPageTitle(intent, "Hubungi Kami");
                            break;
                        case 5 :
                            intent = new Intent(itemView.getContext(), WebActivity.class);
                            setPageTitle(intent, "Kebijakan Privasi");
                            break;
                    }
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        public void setPageTitle(Intent i, String mPageTitle) {
            Bundle mBundle = new Bundle();
            mBundle.putString("pageTitle", mPageTitle);
            i.putExtras(mBundle);
        }
    }

}
