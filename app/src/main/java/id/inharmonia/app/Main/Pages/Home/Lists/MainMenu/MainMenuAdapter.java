package id.inharmonia.app.Main.Pages.Home.Lists.MainMenu;

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
        holder.mMenuItem.setEnabled(mMenuList.get(position).getMenuEnabled());
        if (!holder.mMenuItem.isEnabled()) {
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(0);
            holder.mIcon.setColorFilter(new ColorMatrixColorFilter(matrix));
            holder.mTitle.setTextColor(mContext.getResources().getColor(R.color.colorGrey));
        }
    }

    @Override
    public int getItemCount() {
        return mMenuList.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTitle)
        TextView mTitle;

        @BindView(R.id.ivIcon)
        ImageView mIcon;

        @BindView(R.id.cvMenuItem)
        CardView mMenuItem;

        MenuViewHolder(final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cvMenuItem)
        public void goTo() {
            switch (getAdapterPosition()){
                default:
                    Bundle sheetData = new Bundle();
                    sheetData.putInt("icon", mMenuList.get(getAdapterPosition()).getMenuIcon());
                    sheetData.putString("title", mMenuList.get(getAdapterPosition()).getMenuName());

                    SizeQuantityPopup mSizeQuantityPopup = new SizeQuantityPopup();
                    mSizeQuantityPopup.setArguments(sheetData);
                    mSizeQuantityPopup.show(((FragmentActivity)mContext).getSupportFragmentManager(), mSizeQuantityPopup.getTag());
                    break;
                case 7 :
                    AllPrintTypePopup mAllPrintTypePopup = new AllPrintTypePopup();
                    mAllPrintTypePopup.show(((FragmentActivity)mContext).getSupportFragmentManager(), mAllPrintTypePopup.getTag());
                    break;
            }
        }

    }

}
