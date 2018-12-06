package id.inharmonia.app.Main.Pages.Home.Lists.MainMenu;

import android.content.Context;
import android.graphics.Typeface;
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

import id.inharmonia.app.Main.Pages.Home.Popups.AllPrintTypePopup;
import id.inharmonia.app.Main.Pages.Home.Popups.SizeQuantityPopup;
import id.inharmonia.app.R;

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.MenuViewHolder> {

    final Context mContext;
    private List<MainMenu> mMenuList;
    private int mLayoutType;

    public MainMenuAdapter(Context mContext, List<MainMenu> mMenuList, int mLayoutType) {
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

            Typeface harabara_mais_font = Typeface.createFromAsset(itemView.getContext().getApplicationContext().getAssets(),  "fonts/harabara-mais.ttf");
            mTitle.setTypeface(harabara_mais_font);

            mMenuItem = itemView.findViewById(R.id.cvMenuItem);
            mMenuItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (getAdapterPosition()){
                        default:
                            SizeQuantityPopup mSizeQuantityPopup = new SizeQuantityPopup();
                            mSizeQuantityPopup.show(((FragmentActivity)mContext).getSupportFragmentManager(), mSizeQuantityPopup.getTag());
                            break;
                        case 7 :
                            AllPrintTypePopup mAllPrintTypePopup = new AllPrintTypePopup();
                            mAllPrintTypePopup.show(((FragmentActivity)mContext).getSupportFragmentManager(), mAllPrintTypePopup.getTag());
                            break;
                    }
                }
            });
        }
    }

}
