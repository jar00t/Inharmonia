package id.inharmonia.app.Cart.Lists.Cart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.CartListViewHolder> {

    final Context mContext;
    private List<CartList> mCartList;

    public CartListAdapter(Context mContext, List<CartList> mCartList) {
        this.mContext = mContext;
        this.mCartList = mCartList;
    }

    @NonNull
    @Override
    public CartListAdapter.CartListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_cart_list_item_row, parent, false);
        return new CartListAdapter.CartListViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartListAdapter.CartListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mCartList.size();
    }

    public class CartListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivToggleButton)
        ImageView mToggleButton;

        @BindView(R.id.cvCartDetail)
        CardView mCartDetail;

        boolean isUp;

        CartListViewHolder(final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            isUp = true;
        }

        @OnClick(R.id.ivToggleButton)
        public void toggleDetail() {
            if (isUp) {
                mToggleButton.animate().rotation(180).start();
                slideDown();
            } else {
                mToggleButton.animate().rotation(0).start();
                slideUp();
            }
            isUp = !isUp;
        }

        public void slideUp(){
            mCartDetail.setVisibility(View.GONE);
        }

        public void slideDown(){
            mCartDetail.setVisibility(View.VISIBLE);
        }

    }

}

