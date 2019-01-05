package id.inharmonia.app.Search.Adapter;

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
import id.inharmonia.app.Search.List.StoreList;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.Holder> {

    final Context adapter_context;
    private List<StoreList> list_store;

    public StoreListAdapter(Context adapter_context, List<StoreList> list_store) {
        this.adapter_context = adapter_context;
        this.list_store = list_store;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_list_item_store, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tv_name.setText(list_store.get(position).get_name());
        holder.tv_address.setText(list_store.get(position).get_address());
    }

    @Override
    public int getItemCount() {
        return list_store.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView tv_name;

        @BindView(R.id.tv_address)
        TextView tv_address;

        @BindView(R.id.cv_item_type)
        CardView cv_item_type;

        Holder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
