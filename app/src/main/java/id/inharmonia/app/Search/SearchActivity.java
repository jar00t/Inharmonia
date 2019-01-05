package id.inharmonia.app.Search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;
import id.inharmonia.app.Search.List.StoreList;
import id.inharmonia.app.Search.Adapter.StoreListAdapter;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.ib_button_back)
    ImageButton ib_button_back;

    @BindView(R.id.ib_button_clear)
    ImageButton ib_button_clear;

    @BindView(R.id.et_input_search)
    EditText et_input_search;

    @BindView(R.id.rv_list_store)
    RecyclerView rv_list_store;

    List<StoreList> list_store;
    StoreList item_store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ButterKnife.bind(this);

        et_input_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (et_input_search.getText().toString().matches("")) {
                    ib_button_clear.setVisibility(View.INVISIBLE);
                } else {
                    ib_button_clear.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        set_list();
    }

    @OnClick(R.id.ib_button_back)
    public void exit() {
        finish();
    }

    @OnClick(R.id.ib_button_clear)
    public void clear() {
        et_input_search.setText("");
    }

    public void set_list() {
        rv_list_store.setLayoutManager(new GridLayoutManager(this, 1));
        rv_list_store.setFocusable(false);

        list_store = new ArrayList<>();

        item_store = new StoreList(
                "Nusawarna Digital Printing",
                "Jl.Suradireja No.00 Purwakarta"
        );
        list_store.add(item_store);

        item_store = new StoreList(
                "Tukang Cetak Berkah Abadi",
                "Jl.Belakang No.00 Purwakarta"
        );
        list_store.add(item_store);

        item_store = new StoreList(
                "Makmur Sentosa Digital",
                "Jl.Jalan ke Tengah Jalan di Purwakarta"
        );
        list_store.add(item_store);

        rv_list_store.setAdapter(new StoreListAdapter(this, list_store));
    }

}
