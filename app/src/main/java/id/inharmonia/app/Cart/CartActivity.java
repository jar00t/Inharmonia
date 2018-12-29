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
import java.util.Collections;
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
    CartList mCartItem;

    List<String[]> cartData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ButterKnife.bind(this);

        cartData = new ArrayList<>();
        cartData.add(new String[]{"gambar", "f4,a4,a5", "56,576,5"});
        cartData.add(new String[]{"dokumen", "f4,a4", "76,5"});
        cartData.add(new String[]{"gambar", "f4,a4,a5", "56,76,78"});

        setList();

        mCheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < mRecyclerView.getAdapter().getItemCount(); i++) {
                    CheckBox cartSelect = mRecyclerView.findViewHolderForAdapterPosition(i).itemView.findViewById(R.id.cbCartSelect);
                    if(mCheckAll.isChecked()) {
                        if(!cartSelect.isChecked()) cartSelect.performClick();
                        mCheckAll.setChecked(true);
                    } else {
                        if(cartSelect.isChecked()) cartSelect.performClick();
                        mCheckAll.setChecked(false);
                    }
                }
            }
        });
    }

    @OnClick(R.id.ibBackButton)
    public void exit() { finish(); }

    public void setList() {
        if(cartData.size() != 0) {
            mCartList = new ArrayList<>();
            for(int i = 0; i < cartData.size(); i++) {
                mCartItem = new CartList(cartData.get(i)[0], cartData.get(i)[1], cartData.get(i)[2]);
                mCartList.add(mCartItem);
            }
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
            mRecyclerView.setFocusable(false);
            mRecyclerView.setAdapter(new CartListAdapter(this, mCartList, this));
        }
    }

    public void setSubTotal(int subtotal, List<String> checkedCart, int totalCart) {
        int totalCheckedCart = checkedCart.size() - Collections.frequency(checkedCart, "unchecked");
        if(totalCart != 0 && subtotal > 0) {
            mSubTotal.setText(String.format("%s lembar", subtotal));
            mCheckoutButton.setEnabled(true);
            mCheckoutButton.setCardBackgroundColor(getResources().getColor(R.color.colorPurple));
            mCheckoutText.setTextColor(getResources().getColor(R.color.colorWhite));
            mSubTotal.setTextColor(getResources().getColor(R.color.colorPurple));

            setMargins(mListLayout,0,0,0,120);
            mSelectStoreButton.setVisibility(View.VISIBLE);
        } else {
            mSubTotal.setText("0");
            mCheckoutButton.setEnabled(false);
            mCheckoutButton.setCardBackgroundColor(getResources().getColor(R.color.colorLightGrey));
            mCheckoutText.setTextColor(getResources().getColor(R.color.colorGrey));
            mSubTotal.setTextColor(getResources().getColor(R.color.colorGrey));

            setMargins(mListLayout,0,0,0,70);
            mSelectStoreButton.setVisibility(View.GONE);
        }

        mSelectAll.setText(String.format("%s", totalCheckedCart));

        if(checkedCart != null) {
            if(totalCart != 0 && totalCheckedCart != 0 && totalCheckedCart == totalCart) {
                if(!mCheckAll.isEnabled()) mCheckAll.setEnabled(true);
                mCheckAll.setChecked(true);
            } else {
                if(totalCart == 0) mCheckAll.setEnabled(false);
                mCheckAll.setChecked(false);
            }
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
