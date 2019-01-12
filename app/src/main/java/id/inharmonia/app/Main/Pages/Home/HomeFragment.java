package id.inharmonia.app.Main.Pages.Home;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.Animation.BounceActivity;
import id.inharmonia.app.Cart.CartActivity;
import id.inharmonia.app.Main.Pages.Home.Adapter.ProductListAdapter;
import id.inharmonia.app.Main.Pages.Home.List.MoniPrintList;
import id.inharmonia.app.Main.Pages.Home.Adapter.MoniPrintListAdapter;
import id.inharmonia.app.Main.Pages.Home.List.ProductList;
import id.inharmonia.app.Main.Pages.Home.Popup.AllPrintTypePopup;
import id.inharmonia.app.R;
import id.inharmonia.app.Search.SearchActivity;

public class HomeFragment extends Fragment {

    @BindView(R.id.ll_container_header)
    LinearLayout ll_container_header;

    @BindView(R.id.sv_container_content)
    ScrollView sv_container_content;

    @BindView(R.id.rv_list_product)
    RecyclerView rv_list_product;

    @BindView(R.id.rv_list_moni_print)
    RecyclerView rv_list_moni_print;

    @BindView(R.id.cv_button_search)
    CardView cv_button_search;

    @BindView(R.id.ib_button_cart)
    ImageButton ib_button_cart;

    @BindView(R.id.tv_cart_total)
    TextView tv_cart_total;

    @BindView(R.id.cl_promo_slide)
    CarouselView cl_promo_slide;

    @BindView(R.id.tv_link_more_moni_print)
    TextView tv_link_more_moni_print;

    List<ProductList> list_product;
    List<MoniPrintList> list_moniprint;

    int[] sample_image = {R.drawable.in_blank_landscape, R.drawable.in_blank_landscape, R.drawable.in_blank_landscape, R.drawable.in_blank_landscape, R.drawable.in_blank_landscape};

    AllPrintTypePopup popup_all_print_type = new AllPrintTypePopup();

    public HomeFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, view);

        cl_promo_slide.setPageCount(sample_image.length);
        cl_promo_slide.setImageListener(imageListener);

        sv_container_content.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                ll_container_header.setBackgroundColor((sv_container_content.getScrollY() > 0)? getResources().getColor(R.color.colorWhite) : Color.TRANSPARENT);
                ll_container_header.getBackground().setAlpha((sv_container_content.getScrollY() <= 255)? sv_container_content.getScrollY() : 255);
            }
        });

        set_product_list();
        set_moniprint_list();

        return view;
    }

    public void set_product_list() {
        list_product = new ArrayList<>();

        list_product.add(new ProductList("MoniTrans", R.drawable.in_ic_monitrans_motor_small, true));
        list_product.add(new ProductList("MoniFood", R.drawable.in_ic_monifood_mangkok_small, true));
        list_product.add(new ProductList("MoniHealth", R.drawable.in_ic_monihealth_hati_small, true));
        list_product.add(new ProductList("MoniShop", R.drawable.in_ic_monishop_keranjang_small, true));
        list_product.add(new ProductList("MoniPrint", R.drawable.in_ic_moniprint_printer_small, true));
        list_product.add(new ProductList("MoniFix", R.drawable.in_ic_monifix_obeng_small, true));
        list_product.add(new ProductList("MoniTeach", R.drawable.in_ic_moniteach_buku_small, true));
        list_product.add(new ProductList("MoniJob", R.drawable.in_ic_monijob_koper_small, true));
        list_product.add(new ProductList("MoniRent", R.drawable.in_ic_monirent_kunci_small, true));
        list_product.add(new ProductList("Lainnya", R.drawable.in_more_square, true));

        rv_list_product.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        rv_list_product.setFocusable(false);
        rv_list_product.setAdapter(new ProductListAdapter(getActivity(), list_product, R.layout.rv_item_menu_grid, this));
    }

    public void set_moniprint_list() {
        list_moniprint = new ArrayList<>();

        list_moniprint.add(new MoniPrintList("Dokumen", R.drawable.in_thumb_moniprint_documents_square, true));
        list_moniprint.add(new MoniPrintList("Gambar", R.drawable.in_thumb_moniprint_pictures_square, true));
        list_moniprint.add(new MoniPrintList("Brosur", R.drawable.in_thumb_moniprint_brochure_square, false));
        list_moniprint.add(new MoniPrintList("Undangan", R.drawable.in_thumb_moniprint_invitation_square, false));
        list_moniprint.add(new MoniPrintList("Spanduk", R.drawable.in_thumb_moniprint_spanduk_square, false));
        list_moniprint.add(new MoniPrintList("Stand Banner", R.drawable.in_thumb_moniprint_stand_banner_square, false));
        list_moniprint.add(new MoniPrintList("Kartu Nama", R.drawable.in_thumb_moniprint_namecard_square, false));
        list_moniprint.add(new MoniPrintList("Lainnya", R.drawable.in_more_square, true));

        rv_list_moni_print.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv_list_moni_print.setFocusable(false);
        rv_list_moni_print.setAdapter(new MoniPrintListAdapter(getActivity(), list_moniprint, R.layout.rv_item_menu, this));

        tv_link_more_moni_print.setVisibility(View.VISIBLE);
    }

    public void update_cart() {
        final Animation animate_button = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);

        BounceActivity interpolator = new BounceActivity(0.2, 20);
        animate_button.setInterpolator(interpolator);

        tv_cart_total.setVisibility(View.VISIBLE);
        tv_cart_total.startAnimation(animate_button);
        tv_cart_total.setText(String.format("%s", (Integer.parseInt(tv_cart_total.getText().toString()) + 1)));
        popup_message("Pesanan berhasil ditambahkan ke keranjang");
    }

    public void popup_message(String messages) {
        AlertDialog.Builder popup_message = new AlertDialog.Builder(getActivity(), R.style.DialogTheme);
        View popup_view_message = getLayoutInflater().inflate(R.layout.dialog_popup_message, null);
        popup_message.setView(popup_view_message);

        TextView the_message = popup_view_message.findViewById(R.id.tv_message);
        the_message.setText(messages);

        popup_message.setPositiveButton("Ok Sip", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }

        });

        Dialog dialog_popup_message = popup_message.create();
        dialog_popup_message.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog_popup_message.setCancelable(true);

        dialog_popup_message.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog_popup_message.show();
    }

    @OnClick(R.id.tv_link_more_moni_print)
    public void more_moni_print() {
        if (popup_all_print_type.check_sheet()) {
            popup_all_print_type.send_mom(this);
            popup_all_print_type.show(getActivity().getSupportFragmentManager(), popup_all_print_type.getTag());
        }
    }

    @OnClick(R.id.cv_button_search)
    public void open_search() {
        getActivity().startActivity(new Intent(getActivity(), SearchActivity.class));
    }

    @OnClick(R.id.ib_button_cart)
    public void open_cart() {
        getActivity().startActivity(new Intent(getActivity(), CartActivity.class));
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sample_image[position]);
        }
    };

}
