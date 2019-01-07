package id.inharmonia.app.Main.Pages.Order.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
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
import id.inharmonia.app.Main.Pages.Order.List.OrderList;
import id.inharmonia.app.Main.Pages.Order.OrderDetailActivity;
import id.inharmonia.app.R;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.Holder> {

    final Context adapter_context;
    private List<OrderList> list_order;

    public OrderListAdapter(Context adapter_context, List<OrderList> list_order) {
        this.adapter_context = adapter_context;
        this.list_order = list_order;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_order, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tv_order_code.setText(list_order.get(position).get_code());
        holder.tv_order_status.setText(list_order.get(position).get_status_text());
        holder.iv_order_status.setImageResource(list_order.get(position).get_status_icon());
        holder.tv_store_name.setText(list_order.get(position).get_store_name());
        holder.tv_store_address.setText(list_order.get(position).get_store_address());
        holder.tv_buyer_name.setText(list_order.get(position).get_buyer_name());
        holder.tv_buyer_address.setText(list_order.get(position).get_buyer_address());
        holder.tv_date_time.setText(list_order.get(position).get_date_time());
    }

    @Override
    public int getItemCount() {
        return list_order.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_order_code)
        TextView tv_order_code;

        @BindView(R.id.tv_order_status)
        TextView tv_order_status;

        @BindView(R.id.iv_order_status)
        ImageView iv_order_status;

        @BindView(R.id.tv_name)
        TextView tv_store_name;

        @BindView(R.id.tv_address)
        TextView tv_store_address;

        @BindView(R.id.tv_buyer_name)
        TextView tv_buyer_name;

        @BindView(R.id.tv_buyer_address)
        TextView tv_buyer_address;

        @BindView(R.id.tv_date_time)
        TextView tv_date_time;

        @BindView(R.id.cv_item)
        CardView cv_item_type;

        Holder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.cv_item)
        public void go_to_detail() {
            Intent intent = new Intent();
            switch (getAdapterPosition()){
                case 0 :
                    intent = new Intent(itemView.getContext(), OrderDetailActivity.class);
                    break;
                case 1 :
                    intent = new Intent(itemView.getContext(), OrderDetailActivity.class);
                    break;
                case 2 :
                    intent = new Intent(itemView.getContext(), OrderDetailActivity.class);
                    break;
            }
            itemView.getContext().startActivity(intent);
        }

    }

}
