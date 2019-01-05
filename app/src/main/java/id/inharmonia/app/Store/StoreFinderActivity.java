package id.inharmonia.app.Store;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;
import id.inharmonia.app.Store.Adapter.StoreListAdapter;
import id.inharmonia.app.Store.List.StoreList;

public class StoreFinderActivity extends AppCompatActivity {

    @BindView(R.id.ib_button_back)
    ImageButton ib_button_back;

    @BindView(R.id.tv_page_name)
    TextView tv_page_name;

    @BindView(R.id.rv_list_store)
    RecyclerView rv_list_store;

    List<StoreList> list_store;
    List<String[]> data_store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_finder);

        ButterKnife.bind(this);

        data_store = new ArrayList<>();
        data_store.add(new String[]{"1", "in_blank_square", "Nusawarna Digital Printing", "Purwakarta", "2500000", "free_ongkir", "favorited"});
        data_store.add(new String[]{"2", "in_blank_square", "Tukang Cetak Berkah Abadi", "Bandung", "5000000", "", "favorited"});
        data_store.add(new String[]{"3", "in_blank_square", "Tukang Cetak Pengkolan", "Jakarta", "10000000", "free_ongkir", ""});

        set_list();
    }

    @OnClick(R.id.ib_button_back)
    public void exit() {
        finish();
    }

    public void set_list() {
        if(data_store.size() != 0) {
            list_store = new ArrayList<>();
            for(int i = 0; i < data_store.size(); i++) {
                int icon = this.getResources().getIdentifier(data_store.get(i)[1], "drawable", this.getPackageName());
                list_store.add(new StoreList(Integer.parseInt(data_store.get(i)[0]), icon, data_store.get(i)[2], data_store.get(i)[3], Integer.parseInt(data_store.get(i)[4]), (data_store.get(i)[5].equals("free_ongkir")), (data_store.get(i)[6].equals("favorited"))));
            }
            rv_list_store.setLayoutManager(new GridLayoutManager(this, 2));
            rv_list_store.setFocusable(false);
            rv_list_store.setAdapter(new StoreListAdapter(this, list_store, R.layout.rv_item_store_finder));
        }
    }
}
