package id.inharmonia.app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainMenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    private Context mContext;
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
}

class MenuViewHolder extends RecyclerView.ViewHolder {
    TextView mTitle;
    ImageView mIcon;

    MenuViewHolder(View itemView) {
        super(itemView);

        mTitle = itemView.findViewById(R.id.tvTitle);
        mIcon = itemView.findViewById(R.id.ivIcon);
    }
}
