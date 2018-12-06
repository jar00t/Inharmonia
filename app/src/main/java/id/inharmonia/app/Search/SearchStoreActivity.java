package id.inharmonia.app.Search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;
import id.inharmonia.app.Search.Lists.Store.StoreList;
import id.inharmonia.app.Search.Lists.Store.StoreListAdapter;

public class SearchStoreActivity extends AppCompatActivity {

    @BindView(R.id.ibBackButton)
    ImageButton mBackButton;

    @BindView(R.id.ibClearButton)
    ImageButton mClearButton;

    @BindView(R.id.etSearchInput)
    EditText mSearchInput;

    @BindView(R.id.lvStoreList)
    ListView mStoreList;

    Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_store);

        ButterKnife.bind(this);

        mBundle = getIntent().getExtras();
        if (!mBundle.getString("keywordValue").isEmpty()) {
            mSearchInput.setText(mBundle.getString("keywordValue"));
            mSearchInput.setSelection(mBundle.getString("keywordValue").length());
            mClearButton.setVisibility(View.VISIBLE);
        }

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

        String[] storeList = new String[] {
                "in_blank_square/Nusawarna Digital Printing/Jl.Suradireja No.0...",
                "in_blank_square/Tempat Cetak Damai Abadi/Jl.Belakang No.0...",
                "in_blank_square/Nusawarna Digital Printing/Jl.Suradireja No.0..."
        };
        if (storeList.length != 0) { setStoreList(storeList); }
    }

    @OnClick(R.id.ibBackButton)
    public void exit() {
        finish();
    }

    @OnClick(R.id.ibClearButton)
    public void clear() {
        mSearchInput.setText("");
    }

    public void setStoreList(String[] mList) {
        ArrayList<StoreList> nList = new ArrayList<>();
        for(int i = 0; i< mList.length; i++){
            String[] cList = mList[i].split("/");
            nList.add(new StoreList(getResources().getIdentifier(cList[0],"drawable", getPackageName()), cList[1], cList[2]));
        }
        mStoreList.setAdapter(new StoreListAdapter(this, nList));
    }

}
