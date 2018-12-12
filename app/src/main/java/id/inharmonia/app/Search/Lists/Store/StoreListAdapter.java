package id.inharmonia.app.Search.Lists.Store;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.inharmonia.app.R;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.StoreListViewHolder> {

    final Context mContext;
    private List<StoreList> mStoreList;

    public StoreListAdapter(Context mContext, List<StoreList> mStoreList) {
        this.mContext = mContext;
        this.mStoreList = mStoreList;
    }

    @NonNull
    @Override
    public StoreListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_store_list_item_row, parent, false);
        return new StoreListViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreListViewHolder holder, int position) {
        holder.mStoreName.setText(mStoreList.get(position).getStoreName());
        holder.mStoreAddress.setText(mStoreList.get(position).getStoreAddress());
    }

    @Override
    public int getItemCount() {
        return mStoreList.size();
    }

    public class StoreListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvStoreName)
        TextView mStoreName;

        @BindView(R.id.tvStoreAddress)
        TextView mStoreAddress;

        @BindView(R.id.cvMenuItem)
        CardView mMenuItem;

        StoreListViewHolder(final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

    }

}
