package id.inharmonia.app.Store.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.inharmonia.app.R;
import id.inharmonia.app.Store.List.StoreList;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.Holder> {

    final Context adapter_context;
    private List<StoreList> list_store;
    private int layout_type;

    public StoreListAdapter(Context adapter_context, List<StoreList> list_store, int layout_type) {
        this.adapter_context = adapter_context;
        this.list_store = list_store;
        this.layout_type = layout_type;
    }

    @NonNull
    @Override
    public StoreListAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout_type, parent, false);
        return new StoreListAdapter.Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreListAdapter.Holder holder, int position) {
        holder.iv_store_picture.setImageResource(list_store.get(position).get_picture());
        holder.tv_store_name.setText(list_store.get(position).get_name());
    }

    @Override
    public int getItemCount() {
        return list_store.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_store_picture)
        ImageView iv_store_picture;

        @BindView(R.id.tv_store_name)
        TextView tv_store_name;

        Holder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}