package id.inharmonia.app.Cart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;

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
            mRecyclerView.setAdapter(new CartListAdapter(this, mCartList));
        }
    }

}
