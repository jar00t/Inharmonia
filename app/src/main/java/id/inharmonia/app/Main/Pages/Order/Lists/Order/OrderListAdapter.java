package id.inharmonia.app.Main.Pages.Order.Lists.Order;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
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
import id.inharmonia.app.Main.Pages.Order.OrderDetailActivity;
import id.inharmonia.app.R;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderListViewHolder> {

    final Context mContext;
    private List<OrderList> mOrderList;

    public OrderListAdapter(Context mContext, List<OrderList> mOrderList) {
        this.mContext = mContext;
        this.mOrderList = mOrderList;
    }

    @NonNull
    @Override
    public OrderListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_order_item_row, parent, false);
        return new OrderListViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderListViewHolder holder, int position) {
        holder.mOrderCode.setText(mOrderList.get(position).getOrderCode());
        holder.mOrderStatusText.setText(mOrderList.get(position).getOrderStatusText());
        holder.mOrderStatusIcon.setImageResource(mOrderList.get(position).getOrderStatusIcon());
        holder.mStoreName.setText(mOrderList.get(position).getStoreName());
        holder.mStoreAddress.setText(mOrderList.get(position).getStoreAddress());
        holder.mBuyerName.setText(mOrderList.get(position).getBuyerName());
        holder.mBuyerAddress.setText(mOrderList.get(position).getBuyerAddress());
        holder.mOrderDateTime.setText(mOrderList.get(position).getOrderDateTime());
    }

    @Override
    public int getItemCount() {
        return mOrderList.size();
    }

    public class OrderListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvOrderCode)
        TextView mOrderCode;

        @BindView(R.id.tvOrderStatus)
        TextView mOrderStatusText;

        @BindView(R.id.ivOrderStatus)
        ImageView mOrderStatusIcon;

        @BindView(R.id.tvStoreName)
        TextView mStoreName;

        @BindView(R.id.tvStoreAddress)
        TextView mStoreAddress;

        @BindView(R.id.tvBuyerName)
        TextView mBuyerName;

        @BindView(R.id.tvBuyerAddress)
        TextView mBuyerAddress;

        @BindView(R.id.tvOrderDateTime)
        TextView mOrderDateTime;

        @BindView(R.id.cvMenuItem)
        CardView mMenuItem;

        OrderListViewHolder(final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            Typeface harabara_mais_font = Typeface.createFromAsset(itemView.getContext().getApplicationContext().getAssets(),  "fonts/harabara-mais.ttf");
            Typeface comfortaa_regular_font = Typeface.createFromAsset(itemView.getContext().getApplicationContext().getAssets(),  "fonts/comfortaa-regular.ttf");

            mOrderCode.setTypeface(comfortaa_regular_font);
            mOrderStatusText.setTypeface(harabara_mais_font);
            mStoreName.setTypeface(harabara_mais_font);
            mStoreAddress.setTypeface(comfortaa_regular_font);
            mBuyerName.setTypeface(harabara_mais_font);
            mBuyerAddress.setTypeface(comfortaa_regular_font);
            mOrderDateTime.setTypeface(comfortaa_regular_font);
        }

        @OnClick(R.id.cvMenuItem)
        public void goToDetails() {
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
