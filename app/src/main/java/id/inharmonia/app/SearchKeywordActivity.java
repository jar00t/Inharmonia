package id.inharmonia.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

public class SearchKeywordActivity extends AppCompatActivity {

    ImageView mBackButton;
    ImageView mClearButton;
    EditText mSearchInput;
    ListView mKeywordList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_keyword);

        mBackButton = findViewById(R.id.ivBackButton);
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

        mClearButton = findViewById(R.id.ivClearButton);
        mClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchInput.setText("");
            }
        });

        String[] keywordList = new String[] {
                "Nusawarna",
                "Berkah Abadi",
                "Nusawarna"
        };
        if (keywordList.length != 0) { setKeywordList(keywordList); }
    }

    public void setKeywordList(String[] mList) {
        mKeywordList = findViewById(R.id.lvKeywordList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.lv_text_item_row, R.id.tvTitle, mList);
        mKeywordList.setAdapter(adapter);
    }

}
