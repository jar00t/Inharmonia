package id.inharmonia.app.Cart;

import android.content.Intent;
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
import id.inharmonia.app.Cart.List.CartList;
import id.inharmonia.app.Cart.Adapter.CartListAdapter;
import id.inharmonia.app.Main.MainActivity;
import id.inharmonia.app.R;
import id.inharmonia.app.Store.StoreFinderActivity;

public class CartActivity extends AppCompatActivity {

    @BindView(R.id.ib_button_back)
    ImageButton ib_button_back;

    @BindView(R.id.rv_list_cart)
    RecyclerView rv_list_cart;

    @BindView(R.id.tv_sub_total)
    TextView tv_sub_total;

    @BindView(R.id.ll_layout_list)
    LinearLayout ll_layout_list;

    @BindView(R.id.cv_button_checkout)
    CardView cv_button_checkout;

    @BindView(R.id.tv_checkout)
    TextView tv_checkout;

    @BindView(R.id.tv_select_all)
    TextView tv_select_all;

    @BindView(R.id.cb_select_all)
    CheckBox cb_select_all;

    @BindView(R.id.cv_button_store_selecter)
    CardView cv_button_store_selecter;

    List<CartList> list_cart;
    List<String[]> data_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ButterKnife.bind(this);

        data_cart = new ArrayList<>();
        data_cart.add(new String[]{"1", "gambar", "f4,a4,a5", "56,576,5"});
        data_cart.add(new String[]{"2", "dokumen", "f4,a4", "76,5"});
        data_cart.add(new String[]{"3", "gambar", "f4,a4,a5", "56,76,78"});

        set_list();
    }

    @OnClick(R.id.cb_select_all)
    public void select_all() {
        CheckBox cart_selecter;
        Boolean is_selected = cb_select_all.isChecked();
        for(int i = 0; i < rv_list_cart.getAdapter().getItemCount(); i++) {
            cart_selecter = rv_list_cart.findViewHolderForAdapterPosition(i).itemView.findViewById(R.id.cb_cart_selecter);
            cart_selecter.setChecked(is_selected);
        }
    }

    @OnClick(R.id.cv_button_store_selecter)
    public void go_to_store_finder() {
        startActivity(new Intent(this, StoreFinderActivity.class));
    }

    @OnClick(R.id.ib_button_back)
    public void exit() { finish(); }

    public void set_list() {
        if(data_cart.size() != 0) {
            list_cart = new ArrayList<>();
            for(int i = 0; i < data_cart.size(); i++) {
                list_cart.add(new CartList(data_cart.get(i)[0], data_cart.get(i)[1], data_cart.get(i)[2], data_cart.get(i)[3],false));
            }
            rv_list_cart.setLayoutManager(new GridLayoutManager(this, 1));
            rv_list_cart.setFocusable(false);
            rv_list_cart.setAdapter(new CartListAdapter(this, list_cart, this));
        }
    }

    public void set_report(int cart_selected_total, List<CartList> list_cart, List<String> cart_selected) {
        if(cart_selected_total == 0) {
            tv_sub_total.setText("0");
            tv_sub_total.setTextColor(getResources().getColor(R.color.colorGrey));
            cv_button_checkout.setCardBackgroundColor(getResources().getColor(R.color.colorLightGrey));
            tv_checkout.setTextColor(getResources().getColor(R.color.colorGrey));
            set_margins(ll_layout_list, 0,0,0,70);
            cv_button_store_selecter.setVisibility(View.GONE);
        } else {
            tv_sub_total.setText(String.format("%s lembar", cart_selected_total));
            tv_sub_total.setTextColor(getResources().getColor(R.color.colorPurple));
            cv_button_checkout.setCardBackgroundColor(getResources().getColor(R.color.colorPurple));
            tv_checkout.setTextColor(getResources().getColor(R.color.colorWhite));
            set_margins(ll_layout_list, 0,0,0,120);
            cv_button_store_selecter.setVisibility(View.VISIBLE);
        }

        cb_select_all.setChecked(list_cart.size() == cart_selected.size());
        if(list_cart.size() == 0) {
            cb_select_all.setChecked(false);
            cb_select_all.setEnabled(false);
        } else {
            cb_select_all.setEnabled(true);
        }
    }

    @SuppressWarnings("SameParameterValue")
    private void set_margins(View view, int left, int top, int right, int bottom) {
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
