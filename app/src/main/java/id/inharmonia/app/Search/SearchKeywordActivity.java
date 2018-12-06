package id.inharmonia.app.Search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;

public class SearchKeywordActivity extends AppCompatActivity {

    @BindView(R.id.ibBackButton)
    ImageButton mBackButton;

    @BindView(R.id.ibClearButton)
    ImageButton mClearButton;

    @BindView(R.id.etSearchInput)
    EditText mSearchInput;

    @BindView(R.id.lvKeywordList)
    ListView mKeywordList;

    Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_keyword);

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

        String[] keywordList = new String[] {
                "Nusawarna",
                "Berkah Abadi",
                "Nusawarna"
        };
        if (keywordList.length != 0) { setKeywordList(keywordList); }
    }

    @OnClick(R.id.ibBackButton)
    public void exit() {
        finish();
    }

    @OnClick(R.id.ibClearButton)
    public void clear() {
        mSearchInput.setText("");
    }

    public void setKeywordList(String[] mList) {
        mKeywordList.setAdapter(new ArrayAdapter<>(this, R.layout.lv_text_item_row, R.id.tvTitle, mList));
    }

}
