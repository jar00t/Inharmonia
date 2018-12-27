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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ButterKnife.bind(this);

        setList();
    }

    @OnClick(R.id.ibBackButton)
    public void exit() { finish(); }

    public void setList() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setFocusable(false);

        mCartList = new ArrayList<>();

        mCartItem = new CartList();
        mCartList.add(mCartItem);

        mCartItem = new CartList();
        mCartList.add(mCartItem);

        mCartItem = new CartList();
        mCartList.add(mCartItem);

        mRecyclerView.setAdapter(new CartListAdapter(this, mCartList));
    }

}
