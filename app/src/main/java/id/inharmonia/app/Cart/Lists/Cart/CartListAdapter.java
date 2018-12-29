package id.inharmonia.app.Cart.Lists.Cart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.Cart.CartActivity;
import id.inharmonia.app.Cart.Lists.Quantity.QuantityListAdapter;
import id.inharmonia.app.Main.Pages.Home.Lists.Quantity.QuantityList;
import id.inharmonia.app.R;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.CartListViewHolder> {

    final Context mContext;
    private List<CartList> mCartList;

    List<String> checkedCart = new ArrayList<>();
    List<Integer> cartTotal = new ArrayList<>();
    int checkedCartTotal = 0;

    CartActivity mCartActivity;

    public CartListAdapter(Context mContext, List<CartList> mCartList, CartActivity mCartActivity) {
        this.mContext = mContext;
        this.mCartList = mCartList;
        this.mCartActivity = mCartActivity;
    }

    @NonNull
    @Override
    public CartListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_cart_list_item_row, parent, false);
        return new CartListViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartListViewHolder holder, final int position) {
        switch (mCartList.get(position).getCartName()) {
            case "dokumen":
                holder.mIcon.setImageResource(R.drawable.in_thumb_documents_square);
                holder.mName.setText(mContext.getString(R.string.dokumen));
                break;
            case "gambar":
                holder.mIcon.setImageResource(R.drawable.in_thumb_pictures_square);
                holder.mName.setText(mContext.getString(R.string.gambar));
                break;
        }
        holder.mSizeList.setText(String.format("Ukuran %s", mCartList.get(position).getCartType().toUpperCase().replaceAll(",", ", ")));
        setList(holder, position);
        holder.mCartSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.mCartSelect.isChecked()) {
                    if(!checkedCart.get(holder.getAdapterPosition()).equals("deleted")) checkedCart.set(holder.getAdapterPosition(), "checked");
                    checkedCartTotal = checkedCartTotal + cartTotal.get(holder.getAdapterPosition());
                    mCartActivity.setSubTotal(checkedCartTotal, checkedCart, getItemCount());
                } else {
                    if(!checkedCart.get(holder.getAdapterPosition()).equals("deleted")) checkedCart.set(holder.getAdapterPosition(), "unchecked");
                    if(checkedCartTotal > 0) checkedCartTotal = checkedCartTotal - cartTotal.get(holder.getAdapterPosition());
                    mCartActivity.setSubTotal(checkedCartTotal, checkedCart, getItemCount());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCartList.size();
    }

    public void setList(@NonNull CartListViewHolder holder, int position) {
        int grandTotal = 0;

        holder.mQuantityList = new ArrayList<>();
        String[] sizes = mCartList.get(position).getCartType().split(",");
        String[] quantities = mCartList.get(position).getCartQuantity().split(",");
        for(int s = 0; s < sizes.length; s++) {
            grandTotal = grandTotal + Integer.parseInt(quantities[s]);
            holder.mQuantityListItem = new QuantityList(String.format("Ukuran %s", sizes[s].toUpperCase()), String.format("%s lembar", quantities[s]));
            holder.mQuantityList.add(holder.mQuantityListItem);
        }
        cartTotal.add(grandTotal);
        checkedCart.add("unchecked");
        holder.mQuantityListRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 1));
        holder.mQuantityListRecyclerView.setFocusable(false);
        holder.mQuantityListRecyclerView.setAdapter(new QuantityListAdapter(mContext, holder.mQuantityList, R.layout.rv_quantity_list_item_row));

        holder.mTotal.setText(String.format("%s lembar", grandTotal));
    }

    public class CartListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.clCartItem)
        ConstraintLayout mCartItem;

        @BindView(R.id.ivIcon)
        ImageView mIcon;

        @BindView(R.id.tvName)
        TextView mName;

        @BindView(R.id.tvSizeList)
        TextView mSizeList;

        @BindView(R.id.ivToggleButton)
        ImageView mToggleButton;

        @BindView(R.id.cvCartDetail)
        CardView mCartDetail;

        @BindView(R.id.rv_quantity_list)
        RecyclerView mQuantityListRecyclerView;

        @BindView(R.id.tvTotal)
        TextView mTotal;

        @BindView(R.id.cbCartSelect)
        CheckBox mCartSelect;

        @BindView(R.id.cvCartDeleteButton)
        CardView mCartDeleteButton;

        List<QuantityList> mQuantityList;
        QuantityList mQuantityListItem;

        boolean isUp;

        CartListViewHolder(final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            isUp = true;
        }

        @OnClick(R.id.cvCartDeleteButton)
        public void deleteCart() {
            if(checkedCart.get(getAdapterPosition()).equals("checked")) {
                if(checkedCartTotal > 0) checkedCartTotal = checkedCartTotal - cartTotal.get(getAdapterPosition());
            }
            checkedCart.set(getAdapterPosition(), "deleted");
            cartTotal.remove(getAdapterPosition());
            mCartList.remove(getAdapterPosition());
            notifyItemRemoved(getAdapterPosition());
            mCartActivity.setSubTotal(checkedCartTotal, checkedCart, getItemCount());
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

