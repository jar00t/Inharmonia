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

public class SearchDesignerActivity extends AppCompatActivity {

    ImageView mBackButton;
    ImageView mClearButton;
    EditText mSearchInput;
    ListView mDesignerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_designer);

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

        String[] designerList = new String[] {
                "in_blank_square/Muhammad Yusuf Nur Fajar/myn.fajar@gmail.com",
                "in_blank_square/Asep Silet/asep.silet@gmail.com",
                "in_blank_square/Muhammad Yusuf Nur Fajar/myn.fajar@gmail.com"
        };
        if (designerList.length != 0) { setDesignerList(designerList); }
    }

    public void setDesignerList(String[] mList) {
        ArrayList<ImageTextSubList> nList = new ArrayList<>();
        for(int i = 0; i< mList.length; i++){
            String[] cList = mList[i].split("/");
            nList.add(new ImageTextSubList(getResources().getIdentifier(cList[0],"drawable", getPackageName()), cList[1], cList[2]));
        }
        mDesignerList = findViewById(R.id.lvDesignerList);
        ImageTextSubListAdapter mDesignerListAdapter = new ImageTextSubListAdapter(this, nList);
        mDesignerList.setAdapter(mDesignerListAdapter);
    }
}
