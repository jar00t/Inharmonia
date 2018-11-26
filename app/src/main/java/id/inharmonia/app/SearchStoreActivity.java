package id.inharmonia.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchStoreActivity extends AppCompatActivity {

    ImageView mBackButton;
    ImageView mClearButton;
    EditText mSearchInput;
    ListView mStoreList;

    Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_store);

        mBundle = getIntent().getExtras();

        mBackButton = findViewById(R.id.ivBackButton);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSearchInput = findViewById(R.id.etSearchInput);

        mClearButton = findViewById(R.id.ivClearButton);
        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchInput.setText("");
            }
        });

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

    public void setStoreList(String[] mList) {
        ArrayList<ImageTextSubList> nList = new ArrayList<>();
        for(int i = 0; i< mList.length; i++){
            String[] cList = mList[i].split("/");
            nList.add(new ImageTextSubList(getResources().getIdentifier(cList[0],"drawable", getPackageName()), cList[1], cList[2]));
        }
        mStoreList = findViewById(R.id.lvStoreList);
        ImageTextSubListAdapter mImageTextSubListAdapter = new ImageTextSubListAdapter(this, nList);
        mStoreList.setAdapter(mImageTextSubListAdapter);
    }
}