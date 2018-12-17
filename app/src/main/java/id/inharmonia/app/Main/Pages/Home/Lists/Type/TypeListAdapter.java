package id.inharmonia.app.Main.Pages.Home.Lists.Type;

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
import id.inharmonia.app.Main.Pages.Home.Popups.SizeQuantityPopup;
import id.inharmonia.app.R;

public class TypeListAdapter extends RecyclerView.Adapter<TypeListAdapter.TypeViewHolder> {

    final Context mContext;
    private List<TypeList> mTypeList;
    private int mLayoutType;

    SizeQuantityPopup mSizeQuantityPopup = new SizeQuantityPopup();

    public TypeListAdapter(Context mContext, List<TypeList> mTypeList, int mLayoutType) {
        this.mContext = mContext;
        this.mTypeList = mTypeList;
        this.mLayoutType = mLayoutType;
    }

    @NonNull
    @Override
    public TypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(mLayoutType, parent, false);
        return new TypeViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeViewHolder holder, int position) {
        holder.mTitle.setText(mTypeList.get(position).getTypeName());
        holder.mIcon.setImageResource(mTypeList.get(position).getTypeIcon());
        holder.mTypeItem.setEnabled(mTypeList.get(position).getTypeEnabled());
        if (!holder.mTypeItem.isEnabled()) {
            ColorMatrix matrix = new ColorMatrix();
            matrix.setSaturation(0);
            holder.mIcon.setColorFilter(new ColorMatrixColorFilter(matrix));
            holder.mTitle.setTextColor(mContext.getResources().getColor(R.color.colorGrey));
            holder.mLabelCorner.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return mTypeList.size();
    }

    public class TypeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTitle)
        TextView mTitle;

        @BindView(R.id.ivIcon)
        ImageView mIcon;

        @BindView(R.id.cvMenuItem)
        CardView mTypeItem;

        @BindView(R.id.ivLabelCorner)
        ImageView mLabelCorner;

        TypeViewHolder(final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cvMenuItem)
        public void showAll() {
            if (mSizeQuantityPopup.checkSheet()) {
                Bundle sheetData = new Bundle();
                sheetData.putInt("icon", mTypeList.get(getAdapterPosition()).getTypeIcon());
                sheetData.putString("title", mTypeList.get(getAdapterPosition()).getTypeName());

                mSizeQuantityPopup.setArguments(sheetData);
                mSizeQuantityPopup.show(((FragmentActivity)mContext).getSupportFragmentManager(), mSizeQuantityPopup.getTag());
            }
        }

    }

}

