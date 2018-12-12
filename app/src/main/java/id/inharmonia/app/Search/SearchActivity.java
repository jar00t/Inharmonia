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
import id.inharmonia.app.Search.Lists.Store.StoreList;
import id.inharmonia.app.Search.Lists.Store.StoreListAdapter;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.ibBackButton)
    ImageButton mBackButton;

    @BindView(R.id.ibClearButton)
    ImageButton mClearButton;

    @BindView(R.id.etSearchInput)
    EditText mSearchInput;

    @BindView(R.id.rv_store_list)
    RecyclerView mRecyclerView;

    List<StoreList> mStoreList;
    StoreList mStoreItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ButterKnife.bind(this);

        mSearchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (mSearchInput.getText().toString().matches("")) {
                    mClearButton.setVisibility(View.INVISIBLE);
                } else {
                    mClearButton.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        setList();
    }

    @OnClick(R.id.ibBackButton)
    public void exit() {
        finish();
    }

    @OnClick(R.id.ibClearButton)
    public void clear() {
        mSearchInput.setText("");
    }

    public void setList() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setFocusable(false);

        mStoreList = new ArrayList<>();

        mStoreItem = new StoreList(
                "Nusawarna Digital Printing",
                "Jl.Suradireja No.00 Purwakarta"
        );
        mStoreList.add(mStoreItem);

        mStoreItem = new StoreList(
                "Tukang Cetak Berkah Abadi",
                "Jl.Belakang No.00 Purwakarta"
        );
        mStoreList.add(mStoreItem);

        mStoreItem = new StoreList(
                "Makmur Sentosa Digital",
                "Jl.Jalan ke Tengah Jalan di Purwakarta"
        );
        mStoreList.add(mStoreItem);

        mRecyclerView.setAdapter(new StoreListAdapter(this, mStoreList));
    }

}
