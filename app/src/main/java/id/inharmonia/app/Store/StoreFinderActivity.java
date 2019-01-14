package id.inharmonia.app.Store;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;
import id.inharmonia.app.Store.Adapter.StoreListAdapter;
import id.inharmonia.app.Store.List.StoreList;
import id.inharmonia.app.Store.Popup.StoreFinderSortByPopup;
import id.inharmonia.app.Store.Tool.StoreFinderFilterActivity;

public class StoreFinderActivity extends AppCompatActivity {

    @BindView(R.id.ib_button_back)
    ImageButton ib_button_back;

    @BindView(R.id.tv_page_name)
    TextView tv_page_name;

    @BindView(R.id.rv_list_store)
    RecyclerView rv_list_store;

    @BindView(R.id.fl_button_filter)
    FrameLayout fl_button_filter;

    @BindView(R.id.fl_button_sort_by)
    FrameLayout fl_button_sort_by;

    @BindView(R.id.fl_button_switch_layout)
    FrameLayout fl_button_switch_layout;

    @BindView(R.id.iv_button_toggle_sort_by)
    ImageView iv_button_toggle_sort_by;

    @BindView(R.id.iv_button_toggle_layout)
    ImageView iv_button_toggle_layout;

    @BindView(R.id.tv_sort_by)
    TextView tv_sort_by;

    List<StoreList> list_store;
    List<String[]> data_store;

    String sort_by_orientation = "asc";
    String layout_type = "grid";

    StoreFinderSortByPopup popup_store_finder_sort_by = new StoreFinderSortByPopup();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_finder);

        ButterKnife.bind(this);

        data_store = new ArrayList<>();
        data_store.add(new String[]{"1", "in_blank_square", "Nusawarna Digital Printing", "Purwakarta", "2500000", "free_ongkir", "favorited"});
        data_store.add(new String[]{"2", "in_blank_square", "Tukang Cetak Berkah Abadi", "Bandung", "5000000", "", "favorited"});
        data_store.add(new String[]{"3", "in_blank_square", "Tukang Cetak Pengkolan", "Jakarta", "10000000", "free_ongkir", ""});
        data_store.add(new String[]{"4", "in_blank_square", "Nusawarna Digital Printing", "Purwakarta", "2500000", "free_ongkir", "favorited"});
        data_store.add(new String[]{"5", "in_blank_square", "Tukang Cetak Berkah Abadi", "Bandung", "5000000", "", "favorited"});
        data_store.add(new String[]{"6", "in_blank_square", "Tukang Cetak Pengkolan", "Jakarta", "10000000", "free_ongkir", ""});
        data_store.add(new String[]{"7", "in_blank_square", "Nusawarna Digital Printing", "Purwakarta", "2500000", "free_ongkir", "favorited"});
        data_store.add(new String[]{"8", "in_blank_square", "Tukang Cetak Berkah Abadi", "Bandung", "5000000", "", "favorited"});
        data_store.add(new String[]{"9", "in_blank_square", "Tukang Cetak Pengkolan", "Jakarta", "10000000", "free_ongkir", ""});
        data_store.add(new String[]{"10", "in_blank_square", "Nusawarna Digital Printing", "Purwakarta", "2500000", "free_ongkir", "favorited"});
        data_store.add(new String[]{"11", "in_blank_square", "Tukang Cetak Berkah Abadi", "Bandung", "5000000", "", "favorited"});
        data_store.add(new String[]{"12", "in_blank_square", "Tukang Cetak Pengkolan", "Jakarta", "10000000", "free_ongkir", ""});

        set_list();
    }

    @OnClick(R.id.fl_button_filter)
    public void open_filter() {
        startActivity(new Intent(this, StoreFinderFilterActivity.class));
    }

    @OnClick(R.id.fl_button_sort_by)
    public void show_sort_by() {
        if (popup_store_finder_sort_by.check_sheet()) {
            Bundle data_sheet = new Bundle();
            data_sheet.putString("selectedSortBy", tv_sort_by.getText().toString());

            popup_store_finder_sort_by.send_mom(this);
            popup_store_finder_sort_by.setArguments(data_sheet);
            popup_store_finder_sort_by.show(this.getSupportFragmentManager(), popup_store_finder_sort_by.getTag());
        }
    }

    @OnClick(R.id.iv_button_toggle_sort_by)
    public void toggle_sort_by() {
        if(sort_by_orientation.equals("asc")) {
            iv_button_toggle_sort_by.setImageResource(R.drawable.in_ic_sort_desc);
            sort_by_orientation = "desc";
        } else {
            iv_button_toggle_sort_by.setImageResource(R.drawable.in_ic_sort_asc);
            sort_by_orientation = "asc";
        }
    }

    @OnClick(R.id.fl_button_switch_layout)
    public void switch_layout() {
        if(layout_type.equals("grid")) {
            iv_button_toggle_layout.setImageResource(R.drawable.in_ic_grid);
            layout_type = "list";
        } else {
            iv_button_toggle_layout.setImageResource(R.drawable.in_ic_list);
            layout_type = "grid";
        }
        set_list();
    }

    @OnClick(R.id.ib_button_back)
    public void exit() {
        finish();
    }

    public void set_selected_sort_by(String sort_by) {
        tv_sort_by.setText(sort_by);
    }

    public void set_list() {
        if(data_store.size() != 0) {
            list_store = new ArrayList<>();
            for(int i = 0; i < data_store.size(); i++) {
                int icon = this.getResources().getIdentifier(data_store.get(i)[1], "drawable", this.getPackageName());
                list_store.add(new StoreList(Integer.parseInt(data_store.get(i)[0]), icon, data_store.get(i)[2], data_store.get(i)[3], Integer.parseInt(data_store.get(i)[4]), (data_store.get(i)[5].equals("free_ongkir")), (data_store.get(i)[6].equals("favorited"))));
            }
            rv_list_store.setFocusable(false);
            rv_list_store.setLayoutManager(new GridLayoutManager(this, (layout_type.equals("grid"))? 2 : 1));
            rv_list_store.setAdapter(new StoreListAdapter(this, list_store, (layout_type.equals("grid"))? R.layout.rv_item_store_finder : R.layout.rv_list_item_store_finder));
        }
    }
}
