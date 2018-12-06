package id.inharmonia.app.Main.Pages.Home.Lists.Type;

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

import id.inharmonia.app.Main.Pages.Home.Popups.SizeQuantityPopup;
import id.inharmonia.app.R;

public class TypeListAdapter extends RecyclerView.Adapter<TypeListAdapter.TypeViewHolder> {

    final Context mContext;
    private List<TypeList> mTypeList;
    private int mLayoutType;

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
    }

    @Override
    public int getItemCount() {
        return mTypeList.size();
    }

    public class TypeViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        ImageView mIcon;
        CardView mTypeItem;

        TypeViewHolder(final View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.tvTitle);
            mIcon = itemView.findViewById(R.id.ivIcon);

            Typeface harabara_mais_font = Typeface.createFromAsset(itemView.getContext().getApplicationContext().getAssets(),  "fonts/harabara-mais.ttf");
            mTitle.setTypeface(harabara_mais_font);

            mTypeItem = itemView.findViewById(R.id.cvMenuItem);
            mTypeItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SizeQuantityPopup mSizeQuantityPopup = new SizeQuantityPopup();
                    mSizeQuantityPopup.show(((FragmentActivity)mContext).getSupportFragmentManager(), mSizeQuantityPopup.getTag());
                }
            });
        }
    }

}

