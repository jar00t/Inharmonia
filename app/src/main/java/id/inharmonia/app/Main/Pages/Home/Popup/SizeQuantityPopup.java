package id.inharmonia.app.Main.Pages.Home.Popup;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.Main.Pages.Home.HomeFragment;
import id.inharmonia.app.Main.Pages.Home.List.QuantityList;
import id.inharmonia.app.Main.Pages.Home.Adapter.QuantityListAdapter;
import id.inharmonia.app.Main.Pages.Home.List.SizeList;
import id.inharmonia.app.Main.Pages.Home.Adapter.SizeListAdapter;
import id.inharmonia.app.R;

public class SizeQuantityPopup extends BottomSheetDialogFragment {

    @BindView(R.id.iv_selected_type_icon)
    ImageView iv_selected_type_icon;

    @BindView(R.id.tv_selected_type_title)
    TextView tv_selected_type_title;

    @BindView(R.id.tv_quantity_total)
    TextView tv_quantity_total;

    @BindView(R.id.rv_list_type)
    public RecyclerView rv_list_type;

    @BindView(R.id.ib_button_close_popup)
    public ImageButton ib_button_close_popup;

    @BindView(R.id.fl_button_add_to_cart)
    public FrameLayout fl_button_add_to_cart;

    @BindView(R.id.fl_button_next_step)
    public FrameLayout fl_button_next_step;

    @BindView(R.id.bt_button_add_to_cart)
    public Button bt_button_add_to_cart;

    @BindView(R.id.bt_button_next_step)
    public Button bt_button_next_step;

    public SizeListAdapter adapter_list_size;
    public List<SizeList> list_size;
    public SizeList item_size;

    String[] supported_size;
    public List<String[]> data_quantity;

    int count_user_try_open = 0;
    AlertDialog.Builder builder_confirm_size_quantity = null;

    HomeFragment fragment_home;

    public SizeQuantityPopup() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popup_size_quantity, container, false);

        ButterKnife.bind(this, view);

        set_selected_type();

        rv_list_type.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rv_list_type.setFocusable(false);

        list_size = new ArrayList<>();
        data_quantity = new ArrayList<>();

        for(int i = 0; i < supported_size.length; i++) {
            int icon = getActivity().getResources().getIdentifier("in_thumb_text_size_" + supported_size[i] + "_square", "drawable", getActivity().getPackageName());
            item_size = new SizeList(icon);
            list_size.add(item_size);
            data_quantity.add(new String[]{supported_size[i], "0"});
        }

        adapter_list_size = new SizeListAdapter(getActivity(), list_size, R.layout.rv_item_size_quantity, this);
        rv_list_type.setAdapter(adapter_list_size);
        adapter_list_size.set_data(data_quantity);

        return view;
    }

    public Boolean check_sheet() {
        count_user_try_open = count_user_try_open + 1;
        return (count_user_try_open <= 1);
    }

    public void send_mom(HomeFragment fragment_home) {
        this.fragment_home = fragment_home;
    }

    public void set_selected_type() {
        Bundle data_sheet = getArguments();

        iv_selected_type_icon.setImageResource(data_sheet.getInt("icon"));
        tv_selected_type_title.setText(data_sheet.getString("title"));

        switch (data_sheet.getString("title")) {
            case "Gambar":
                supported_size = new String[]{"a4", "a5"};
                break;
            case "Dokumen":
                supported_size = new String[]{"a4", "a5", "f4"};
                break;
        }
    }

    public void enable_button() {
        bt_button_next_step.setEnabled(true);
        bt_button_add_to_cart.setEnabled(true);
        bt_button_next_step.setAlpha(1);
        bt_button_add_to_cart.setAlpha(1);
        fl_button_next_step.setAlpha(1);
        fl_button_add_to_cart.setAlpha(1);
    }

    public void disable_button() {
        bt_button_next_step.setEnabled(false);
        bt_button_add_to_cart.setEnabled(false);
        bt_button_next_step.setAlpha(0.5f);
        bt_button_add_to_cart.setAlpha(0.5f);
        fl_button_next_step.setAlpha(0.5f);
        fl_button_add_to_cart.setAlpha(0.5f);
    }

    public void update_total(int new_total) {
        if (new_total == 0) {
            tv_quantity_total.setText(String.valueOf(new_total));
            tv_quantity_total.setVisibility(View.GONE);
        } else {
            tv_quantity_total.setVisibility(View.VISIBLE);
            tv_quantity_total.setText(String.format("%s lembar", new_total));
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        count_user_try_open = 0;
    }

    @OnClick(R.id.ib_button_close_popup)
    public void hide_me() {
        dismiss();
    }

    @OnClick(R.id.bt_button_add_to_cart)
    public void add_to_cart() {
        confirm_size_quantity("add");
    }

    @OnClick(R.id.bt_button_next_step)
    public void next_step() {
        confirm_size_quantity("next");
    }

    public void confirm_size_quantity(final String action) {
        if (builder_confirm_size_quantity == null){
            builder_confirm_size_quantity = new AlertDialog.Builder(getActivity(), R.style.DialogTheme);
            View dialog_view_confirm_size_quantity = getLayoutInflater().inflate(R.layout.dialog_size_quantity_confirmation, null);
            builder_confirm_size_quantity.setView(dialog_view_confirm_size_quantity);

            show_list_quantity(dialog_view_confirm_size_quantity);

            builder_confirm_size_quantity.setPositiveButton("Ok Sip", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (action.equals("add")) update_cart();
                    dialog.dismiss();
                }

            });

            builder_confirm_size_quantity.setNegativeButton("Batal", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }

            });

            Dialog dialog_confirm_size_quantity = builder_confirm_size_quantity.create();
            dialog_confirm_size_quantity.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog_confirm_size_quantity.setCancelable(true);

            View custom_title = getLayoutInflater().inflate(R.layout.ad_dialog_title, null);
            TextView the_title = custom_title.findViewById(R.id.tv_title);
            the_title.setText(R.string.konfirmasi_pesanan);
            ((AlertDialog) dialog_confirm_size_quantity).setCustomTitle(custom_title);

            dialog_confirm_size_quantity.show();
            dialog_confirm_size_quantity.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    builder_confirm_size_quantity = null;
                }
            });
        }
    }

    private void show_list_quantity(View dialogView) {
        data_quantity = adapter_list_size.get_data();

        if (data_quantity.size() != 0) {
            List<QuantityList> list_quantity;
            QuantityList list_item_quantity;
            list_quantity = new ArrayList<>();

            TextView tv_total = dialogView.findViewById(R.id.tv_total);
            tv_total.setText(tv_quantity_total.getText().toString());

            RecyclerView rv_list_quantity = dialogView.findViewById(R.id.rv_list_quantity);
            rv_list_quantity.setLayoutManager(new GridLayoutManager(getActivity(), 1));
            rv_list_quantity.setFocusable(false);

            for(int i = 0; i < data_quantity.size(); i++) {
                list_item_quantity = new QuantityList(String.format("Ukuran %s", data_quantity.get(i)[0].toUpperCase()), String.format("%s lembar", data_quantity.get(i)[1]));
                list_quantity.add(list_item_quantity);
            }

            rv_list_quantity.setAdapter(new QuantityListAdapter(getActivity(), list_quantity, R.layout.rv_list_item_quantity));
        }

    }

    private void update_cart() {
        fragment_home.update_cart();
        dismiss();
    }

}