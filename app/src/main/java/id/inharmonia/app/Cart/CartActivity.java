package id.inharmonia.app.Cart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.Cart.Lists.Cart.CartList;
import id.inharmonia.app.Cart.Lists.Cart.CartListAdapter;
import id.inharmonia.app.R;

public class CartActivity extends AppCompatActivity {

    @BindView(R.id.ibBackButton)
    ImageButton mBackButton;

    @BindView(R.id.rv_cart_list)
    RecyclerView mRecyclerView;

    @BindView(R.id.tvSubTotal)
    TextView mSubTotal;

    @BindView(R.id.llListLayout)
    LinearLayout mListLayout;

    @BindView(R.id.cvCheckoutButton)
    CardView mCheckoutButton;

    @BindView(R.id.tvCheckoutText)
    TextView mCheckoutText;

    @BindView(R.id.tvSelectAll)
    TextView mSelectAll;

    @BindView(R.id.cbCheckAll)
    CheckBox mCheckAll;

    @BindView(R.id.cvSelectStoreButton)
    CardView mSelectStoreButton;

    List<CartList> mCartList;
    List<String[]> cartData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ButterKnife.bind(this);

        cartData = new ArrayList<>();
        cartData.add(new String[]{"1", "gambar", "f4,a4,a5", "56,576,5"});
        cartData.add(new String[]{"2", "dokumen", "f4,a4", "76,5"});
        cartData.add(new String[]{"3", "gambar", "f4,a4,a5", "56,76,78"});

        setList();
    }

    @OnClick(R.id.cbCheckAll)
    public void checkAll() {
        CheckBox cartSelect;
        Boolean isChecked = mCheckAll.isChecked();
        for(int i = 0; i < mRecyclerView.getAdapter().getItemCount(); i++) {
            cartSelect = mRecyclerView.findViewHolderForAdapterPosition(i).itemView.findViewById(R.id.cbCartSelect);
            cartSelect.setChecked(isChecked);
        }
    }

    @OnClick(R.id.ibBackButton)
    public void exit() { finish(); }

    public void setList() {
        if(cartData.size() != 0) {
            mCartList = new ArrayList<>();
            for(int i = 0; i < cartData.size(); i++) {
                mCartList.add(new CartList(cartData.get(i)[0], cartData.get(i)[1], cartData.get(i)[2], cartData.get(i)[3],false));
            }
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
            mRecyclerView.setFocusable(false);
            mRecyclerView.setAdapter(new CartListAdapter(this, mCartList, this));
        }
    }

    public void setReport(int selectedCartTotal, List<CartList> listCart, List<String> selectedCart) {
        if(selectedCartTotal == 0) {
            mSubTotal.setText("0");
            mSubTotal.setTextColor(getResources().getColor(R.color.colorGrey));
            mCheckoutButton.setCardBackgroundColor(getResources().getColor(R.color.colorLightGrey));
            mCheckoutText.setTextColor(getResources().getColor(R.color.colorGrey));
            setMargins(mListLayout, 0,0,0,70);
            mSelectStoreButton.setVisibility(View.GONE);
        } else {
            mSubTotal.setText(String.format("%s lembar", selectedCartTotal));
            mSubTotal.setTextColor(getResources().getColor(R.color.colorPurple));
            mCheckoutButton.setCardBackgroundColor(getResources().getColor(R.color.colorPurple));
            mCheckoutText.setTextColor(getResources().getColor(R.color.colorWhite));
            setMargins(mListLayout, 0,0,0,120);
            mSelectStoreButton.setVisibility(View.VISIBLE);
        }

        mCheckAll.setChecked(listCart.size() == selectedCart.size());
        if(listCart.size() == 0) {
            mCheckAll.setChecked(false);
            mCheckAll.setEnabled(false);
        } else {
            mCheckAll.setChecked(true);
            mCheckAll.setEnabled(true);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private void setMargins (View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();

            final float scale = getBaseContext().getResources().getDisplayMetrics().density;

            int l =  (int)(left * scale + 0.5f);
            int r =  (int)(right * scale + 0.5f);
            int t =  (int)(top * scale + 0.5f);
            int b =  (int)(bottom * scale + 0.5f);

            p.setMargins(l, t, r, b);
            view.requestLayout();
        }
    }

}
