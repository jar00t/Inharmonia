package id.inharmonia.app.Store.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
        holder.tv_store_location.setText(list_store.get(position).get_location());
        holder.tv_cost.setText(duit(list_store.get(position).get_cost()));
        if(list_store.get(position).get_is_free_ongkir()) holder.iv_free_ongkir.setVisibility(View.VISIBLE);
        if(list_store.get(position).get_is_favorited()) holder.iv_button_favorite.setImageResource(R.drawable.in_ic_heart_on);
    }

    @Override
    public int getItemCount() {
        return list_store.size();
    }

    public String duit(int duit) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        return String.format("Rp. %s,-", formatter.format(duit));
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_store_picture)
        ImageView iv_store_picture;

        @BindView(R.id.tv_store_name)
        TextView tv_store_name;

        @BindView(R.id.tv_store_location)
        TextView tv_store_location;

        @BindView(R.id.tv_cost)
        TextView tv_cost;

        @BindView(R.id.iv_free_ongkir)
        ImageView iv_free_ongkir;

        @BindView(R.id.iv_button_favorite)
        ImageView iv_button_favorite;

        Holder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.iv_button_favorite)
        public void toggle_favorite() {
            list_store.get(getAdapterPosition()).set_is_favorited(!list_store.get(getAdapterPosition()).get_is_favorited());
            list_store.get(getAdapterPosition()).set_is_free_ongkir(list_store.get(getAdapterPosition()).get_is_free_ongkir());
            notifyItemChanged(getAdapterPosition());
        }

    }

}
