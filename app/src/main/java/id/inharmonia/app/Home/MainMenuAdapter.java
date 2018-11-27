package id.inharmonia.app.Home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import id.inharmonia.app.Order.OrderNewActivity;
import id.inharmonia.app.Order.OrderTypeActivity;
import id.inharmonia.app.R;
import id.inharmonia.app.WebActivity;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.MenuViewHolder> {

    final Context mContext;
    private List<MainMenu> mMenuList;
    private int mLayoutType;

    MainMenuAdapter(Context mContext, List<MainMenu> mMenuList, int mLayoutType) {
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
                            intent = new Intent(itemView.getContext(), OrderNewActivity.class);
                            break;
                        case 1 :
                            intent = new Intent(itemView.getContext(), OrderNewActivity.class);
                            break;
                        case 2 :
                            intent = new Intent(itemView.getContext(), OrderNewActivity.class);
                            break;
                        case 3 :
                            intent = new Intent(itemView.getContext(), OrderNewActivity.class);
                            break;
                        case 4 :
                            intent = new Intent(itemView.getContext(), OrderNewActivity.class);
                            break;
                        case 5 :
                            intent = new Intent(itemView.getContext(), OrderNewActivity.class);
                            break;
                        case 6 :
                            intent = new Intent(itemView.getContext(), OrderNewActivity.class);
                            break;
                        case 7 :
                            intent = new Intent(itemView.getContext(), OrderNewActivity.class);
                            break;
                        case 8 :
                            intent = new Intent(itemView.getContext(), OrderTypeActivity.class);
                            break;
                    }
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }

}
