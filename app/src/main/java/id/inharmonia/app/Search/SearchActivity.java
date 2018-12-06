package id.inharmonia.app.Search;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import id.inharmonia.app.R;
import id.inharmonia.app.Search.Lists.Designer.DesignerList;
import id.inharmonia.app.Search.Lists.Designer.DesignerListAdapter;
import id.inharmonia.app.Search.Lists.Store.StoreList;
import id.inharmonia.app.Search.Lists.Store.StoreListAdapter;

public class SearchActivity extends AppCompatActivity {

    ImageButton mBackButton;
    ImageButton mClearButton;
    EditText mSearchInput;
    ListView mKeywordList;
    ListView mStoreList;
    ListView mDesignerList;
    TextView mKeywordListMore;
    TextView mStoreListMore;
    TextView mDesignerListMore;

    TextView mListTitleStore;
    TextView mListTitleDesigner;

    String mKeywordValue;

    Bundle mBundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mListTitleStore = findViewById(R.id.tvListTitleStore);
        mListTitleDesigner = findViewById(R.id.tvListTitleDesigner);

        Typeface harabara_mais_font = Typeface.createFromAsset(getAssets(),  "fonts/harabara-mais.ttf");
        mListTitleStore.setTypeface(harabara_mais_font);
        mListTitleDesigner.setTypeface(harabara_mais_font);

        mBackButton = findViewById(R.id.ibBackButton);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSearchInput = findViewById(R.id.etSearchInput);
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

        mClearButton = findViewById(R.id.ibClearButton);
        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchInput.setText("");
            }
        });

        mKeywordListMore = findViewById(R.id.tvKeywordListMore);
        mKeywordListMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SearchActivity.this, SearchKeywordActivity.class);
                getCurrentKeyword(myIntent);
                SearchActivity.this.startActivity(myIntent);
            }
        });

        mStoreListMore = findViewById(R.id.tvStoreListMore);
        mStoreListMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SearchActivity.this, SearchStoreActivity.class);
                getCurrentKeyword(myIntent);
                SearchActivity.this.startActivity(myIntent);
            }
        });

        mDesignerListMore = findViewById(R.id.tvDesignerListMore);
        mDesignerListMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(SearchActivity.this, SearchDesignerActivity.class);
                getCurrentKeyword(myIntent);
                SearchActivity.this.startActivity(myIntent);
            }
        });

        setList();
    }

    public void setList() {
        String[] keywordList = new String[] {
                "Nusawarna",
                "Berkah Abadi",
                "Nusawarna"
        };
        String[] storeList = new String[] {
                "in_blank_square/Nusawarna Digital Printing/Jl.Suradireja No.0...",
                "in_blank_square/Tempat Cetak Damai Abadi/Jl.Belakang No.0...",
                "in_blank_square/Nusawarna Digital Printing/Jl.Suradireja No.0..."
        };
        String[] designerList = new String[] {
                "in_blank_square/Muhammad Yusuf Nur Fajar/myn.fajar@gmail.com",
                "in_blank_square/Asep Silet/asep.silet@gmail.com",
                "in_blank_square/Muhammad Yusuf Nur Fajar/myn.fajar@gmail.com"
        };

        if (keywordList.length != 0) { setKeywordList(keywordList); }
        if (storeList.length != 0) { setStoreList(storeList); }
        if (designerList.length != 0) { setDesignerList(designerList); }
    }

    public void setKeywordList(String[] mList) {
        mKeywordList = findViewById(R.id.lvKeywordList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.lv_text_item_row, R.id.tvTitle, mList);
        mKeywordList.setAdapter(adapter);
        setDynamicHeight(mKeywordList);
    }

    public void setStoreList(String[] mList) {
        ArrayList<StoreList> nList = new ArrayList<>();
        for(int i = 0; i< mList.length; i++){
            String[] cList = mList[i].split("/");
            nList.add(new StoreList(getResources().getIdentifier(cList[0],"drawable", getPackageName()), cList[1], cList[2]));
        }
        mStoreList = findViewById(R.id.lvStoreList);
        StoreListAdapter mStoreListAdapter = new StoreListAdapter(this, nList);
        mStoreList.setAdapter(mStoreListAdapter);
        setDynamicHeight(mStoreList);
    }

    public void setDesignerList(String[] mList) {
        ArrayList<DesignerList> nList = new ArrayList<>();
        for(int i = 0; i< mList.length; i++){
            String[] cList = mList[i].split("/");
            nList.add(new DesignerList(getResources().getIdentifier(cList[0],"drawable", getPackageName()), cList[1], cList[2]));
        }
        mDesignerList = findViewById(R.id.lvDesignerList);
        DesignerListAdapter mDesignerListAdapter = new DesignerListAdapter(this, nList);
        mDesignerList.setAdapter(mDesignerListAdapter);
        setDynamicHeight(mDesignerList);
    }

    public static void setDynamicHeight(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            return;
        }
        int height = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            height += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = height + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(layoutParams);
        listView.requestLayout();
    }

    public void getCurrentKeyword(Intent i) {
        mKeywordValue = mSearchInput.getText().toString();
        mBundle.putString("keywordValue", mKeywordValue);
        i.putExtras(mBundle);
    }

}
