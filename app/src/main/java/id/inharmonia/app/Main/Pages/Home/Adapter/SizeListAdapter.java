package id.inharmonia.app.Main.Pages.Home.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.Main.Pages.Home.List.SizeList;
import id.inharmonia.app.Main.Pages.Home.Popup.SizeQuantityPopup;
import id.inharmonia.app.R;

public class SizeListAdapter extends RecyclerView.Adapter<SizeListAdapter.Holder> {

    final Context adapter_context;
    SizeQuantityPopup popup_size_quantity;
    private List<SizeList> list_size;
    private int layout_type;

    public List<String[]> data_all;
    public List<String[]> data_filtered;

    int value_total;

    public SizeListAdapter(Context adapter_context, List<SizeList> list_size, int layout_type, SizeQuantityPopup popup_size_quantity) {
        this.adapter_context = adapter_context;
        this.popup_size_quantity = popup_size_quantity;
        this.list_size = list_size;
        this.layout_type = layout_type;
    }

    public void set_data(List<String[]> data_quantity) {
        this.data_all = data_quantity;
    }

    public List<String[]> get_data() {
        data_filtered = new ArrayList<>();
        for(int i = 0; i < data_all.size(); i++) {
            if (!data_all.get(i)[1].equals("0")) {
                data_filtered.add(new String[]{data_all.get(i)[0], data_all.get(i)[1]});
            }
        }
        return data_filtered;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout_type, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.iv_icon.setImageResource(list_size.get(position).get_icon());
    }

    @Override
    public int getItemCount() {
        return list_size.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_icon)
        ImageView iv_icon;

        @BindView(R.id.ib_button_decrease)
        ImageButton ib_button_decrease;

        @BindView(R.id.ib_button_increase)
        ImageButton ib_button_increase;

        @BindView(R.id.bt_button_add)
        Button bt_button_add;

        @BindView(R.id.ll_quantity_customer)
        LinearLayout ll_quantity_customer;

        @BindView(R.id.et_number_value)
        EditText et_number_value;

        Holder(final View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            et_number_value.setCursorVisible(false);
            et_number_value.addTextChangedListener(new TextWatcher() {

                String value;
                int old_value = 0;
                int new_value = 0;

                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    value = et_number_value.getText().toString();
                    if (!value.isEmpty()) old_value = Integer.parseInt(value);
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    value = et_number_value.getText().toString();
                    if (!value.isEmpty()) {
                        new_value = Integer.parseInt(value);
                        if (new_value <= 0) new_value = 0;

                        if (old_value < new_value) value_total = value_total + (new_value - old_value);
                        if (old_value > new_value) value_total = value_total - (old_value - new_value);
                        if (old_value == new_value && value_total == 0) value_total = new_value;

                        if (value_total <= 0) value_total = 0;

                        if (new_value == 0) {
                            SizeListAdapter.this.data_all.get(getAdapterPosition())[1] = "0";
                        } else {
                            SizeListAdapter.this.data_all.get(getAdapterPosition())[1] = String.valueOf(new_value);
                        }
                        check_button(value_total);
                        popup_size_quantity.update_total(value_total);
                    } else {
                        et_number_value.setText("0");
                    }
                }

            });
        }

        @OnClick(R.id.bt_button_add)
        public void show_quantity_customer() {
            bt_button_add.setVisibility(View.GONE);
            ll_quantity_customer.setVisibility(View.VISIBLE);
            et_number_value.setText("1");
        }

        @OnClick(R.id.et_number_value)
        public void focus_me() {
            et_number_value.setCursorVisible(true);
        }

        @OnClick(R.id.ib_button_decrease)
        public void decrease_value() {
            int old_value = 0;
            if (!et_number_value.getText().toString().isEmpty()) old_value = Integer.parseInt(et_number_value.getText().toString());
            int new_value = old_value - 1;
            if (new_value <= 0) new_value = 0;
            if (new_value == 0) {
                et_number_value.setText("0");
                SizeListAdapter.this.data_all.get(getAdapterPosition())[1] = "0";
            } else {
                et_number_value.setText(String.valueOf(new_value));
                SizeListAdapter.this.data_all.get(getAdapterPosition())[1] = String.valueOf(new_value);
            }
            check_button(value_total);
            popup_size_quantity.update_total(value_total);
        }

        @OnClick(R.id.ib_button_increase)
        public void increase_value() {
            int old_value = 0;
            if (!et_number_value.getText().toString().isEmpty()) old_value = Integer.parseInt(et_number_value.getText().toString());
            int new_value = old_value + 1;
            et_number_value.setText(String.valueOf(new_value));
            SizeListAdapter.this.data_all.get(getAdapterPosition())[1] = String.valueOf(new_value);
            popup_size_quantity.enable_button();
            popup_size_quantity.update_total(value_total);
        }

        private void check_button(int value_total) {
            if (value_total == 0) {
                popup_size_quantity.disable_button();
            } else {
                popup_size_quantity.enable_button();
            }
        }

    }

}

