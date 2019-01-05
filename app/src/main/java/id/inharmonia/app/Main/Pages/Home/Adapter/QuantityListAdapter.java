package id.inharmonia.app.Main.Pages.Home.Adapter;

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
import id.inharmonia.app.Main.Pages.Home.List.QuantityList;
import id.inharmonia.app.R;

public class QuantityListAdapter extends RecyclerView.Adapter<QuantityListAdapter.Holder> {

    final Context adapter_context;
    private List<QuantityList> list_quantity;
    private int layout_type;

    public QuantityListAdapter(Context adapter_context, List<QuantityList> list_quantity, int layout_type) {
        this.adapter_context = adapter_context;
        this.list_quantity = list_quantity;
        this.layout_type = layout_type;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout_type, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tv_name.setText(list_quantity.get(position).get_name());
        holder.tv_total.setText(list_quantity.get(position).get_total());
    }

    @Override
    public int getItemCount() {
        return list_quantity.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView tv_name;

        @BindView(R.id.tv_total)
        TextView tv_total;

        Holder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

}
