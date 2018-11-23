package id.inharmonia.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ImageView mBackButton;
    ImageView mClearButton;
    EditText mSearchInput;
    ListView mKeywordList;
    ListView mStoreList;
    ListView mDesignerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        mBackButton = findViewById(R.id.ivBackButton);
        mClearButton = findViewById(R.id.ivClearButton);
        mSearchInput = findViewById(R.id.etSearchInput);
        mKeywordList = (ListView) findViewById(R.id.lvKeywordList);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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

        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchInput.setText("");
            }
        });

        String[] keywords = new String[] {
                "Nusawarna",
                "Berkah Abadi"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.lv_text_item_row, R.id.tvTitle, keywords);
        mKeywordList.setAdapter(adapter);
        mKeywordList.setScrollContainer(false);

        mStoreList = (ListView) findViewById(R.id.lvStoreList);

        ArrayList<ImageTextSubList> mList = new ArrayList<>();
        mList.add(new ImageTextSubList(R.drawable.in_blank_square, "Nusawarna Digital Printing" , "Jl.Suradireja No.0..."));
        mList.add(new ImageTextSubList(R.drawable.in_blank_square, "Tempat Cetak Damai Abadi" , "Jl.Belakang No.0..."));


        ImageTextSubListAdapter mImageTextSubListAdapter = new ImageTextSubListAdapter(this, mList);
        mStoreList.setAdapter(mImageTextSubListAdapter);
        mStoreList.setScrollContainer(false);

        mDesignerList = (ListView) findViewById(R.id.lvDesignerList);

        ArrayList<ImageTextSubList> cDesignerList = new ArrayList<>();
        cDesignerList.add(new ImageTextSubList(R.drawable.in_blank_square, "Muhammad Yusuf Nur Fajar" , "myn.fajar@gmail.com"));
        cDesignerList.add(new ImageTextSubList(R.drawable.in_blank_square, "Asep Silet" , "asep.silet@gmail.com"));

        ImageTextSubListAdapter mDesignerListAdapter = new ImageTextSubListAdapter(this, cDesignerList);
        mDesignerList.setAdapter(mDesignerListAdapter);
        mDesignerList.setScrollContainer(false);
    }

}
