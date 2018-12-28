package id.inharmonia.app.Cart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
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

    @BindView(R.id.cvCheckoutButton)
    CardView mCheckoutButton;

    @BindView(R.id.tvCheckoutText)
    TextView mCheckoutText;

    @BindView(R.id.cbCheckAll)
    CheckBox mCheckAll;

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

        setList(false);

        mCheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCheckAll.isChecked()) {
                    setList(true);
                } else {
                    setList(false);
                }
            }
        });
    }

    @OnClick(R.id.ibBackButton)
    public void exit() { finish(); }

    public void setList(boolean isCheckAll) {
        if(cartData.size() != 0) {
            mCartList = new ArrayList<>();
            for(int i = 0; i < cartData.size(); i++) {
                mCartItem = new CartList(cartData.get(i)[0], cartData.get(i)[1], cartData.get(i)[2]);
                mCartList.add(mCartItem);
            }
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
            mRecyclerView.setFocusable(false);
            mRecyclerView.setAdapter(new CartListAdapter(this, mCartList, this, isCheckAll));
        }
    }

    public void setSubTotal(int subtotal, List<String> checkedCart, int totalCart) {
        if(subtotal != 0) {
            mSubTotal.setText(String.format("%s lembar", subtotal));
            mCheckoutButton.setEnabled(true);
            mCheckoutButton.setCardBackgroundColor(getResources().getColor(R.color.colorPurple));
            mCheckoutText.setTextColor(getResources().getColor(R.color.colorWhite));
            mSubTotal.setTextColor(getResources().getColor(R.color.colorPurple));
        } else {
            mSubTotal.setText("0");
            mCheckoutButton.setEnabled(false);
            mCheckoutButton.setCardBackgroundColor(getResources().getColor(R.color.colorLightGrey));
            mCheckoutText.setTextColor(getResources().getColor(R.color.colorGrey));
            mSubTotal.setTextColor(getResources().getColor(R.color.colorGrey));
        }

        if(checkedCart != null) {
            if(checkedCart.size() == totalCart) {
                mCheckAll.setChecked(true);
            } else {
                mCheckAll.setChecked(false);
            }
        }
    }

}
