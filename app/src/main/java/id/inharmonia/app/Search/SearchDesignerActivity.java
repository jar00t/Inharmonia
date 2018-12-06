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
import id.inharmonia.app.Search.Lists.Designer.DesignerList;
import id.inharmonia.app.Search.Lists.Designer.DesignerListAdapter;

public class SearchDesignerActivity extends AppCompatActivity {

    @BindView(R.id.ibBackButton)
    ImageButton mBackButton;

    @BindView(R.id.ibClearButton)
    ImageButton mClearButton;

    @BindView(R.id.etSearchInput)
    EditText mSearchInput;

    @BindView(R.id.lvDesignerList)
    ListView mDesignerList;

    Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_designer);

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

        String[] designerList = new String[] {
                "in_blank_square/Muhammad Yusuf Nur Fajar/myn.fajar@gmail.com",
                "in_blank_square/Asep Silet/asep.silet@gmail.com",
                "in_blank_square/Muhammad Yusuf Nur Fajar/myn.fajar@gmail.com"
        };
        if (designerList.length != 0) { setDesignerList(designerList); }
    }

    @OnClick(R.id.ibBackButton)
    public void exit() {
        finish();
    }

    @OnClick(R.id.ibClearButton)
    public void clear() {
        mSearchInput.setText("");
    }

    public void setDesignerList(String[] mList) {
        ArrayList<DesignerList> nList = new ArrayList<>();
        for(int i = 0; i< mList.length; i++){
            String[] cList = mList[i].split("/");
            nList.add(new DesignerList(getResources().getIdentifier(cList[0],"drawable", getPackageName()), cList[1], cList[2]));
        }
        mDesignerList.setAdapter(new DesignerListAdapter(this, nList));
    }

}
