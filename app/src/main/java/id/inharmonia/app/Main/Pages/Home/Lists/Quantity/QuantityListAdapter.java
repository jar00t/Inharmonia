package id.inharmonia.app.Main.Pages.Home.Lists.Quantity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.inharmonia.app.R;

public class QuantityListAdapter extends RecyclerView.Adapter<QuantityListAdapter.QuantityListViewHolder> {

    final Context mContext;
    private List<QuantityList> mQuantityList;
    private int mLayoutType;

    public QuantityListAdapter(Context mContext, List<QuantityList> mQuantityList, int mLayoutType) {
        this.mContext = mContext;
        this.mQuantityList = mQuantityList;
        this.mLayoutType = mLayoutType;
    }

    @NonNull
    @Override
    public QuantityListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(mLayoutType, parent, false);
        return new QuantityListViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull QuantityListViewHolder holder, int position) {
        holder.mName.setText(mQuantityList.get(position).getSizeName());
        holder.mTotal.setText(mQuantityList.get(position).getSizeTotal());
    }

    @Override
    public int getItemCount() {
        return mQuantityList.size();
    }

    public class QuantityListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvName)
        TextView mName;

        @BindView(R.id.tvTotal)
        TextView mTotal;

        QuantityListViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
