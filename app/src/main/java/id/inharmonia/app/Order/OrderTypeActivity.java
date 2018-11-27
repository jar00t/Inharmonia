package id.inharmonia.app.Order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import id.inharmonia.app.R;

public class OrderTypeActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<TypeList> mTypeList;
    TypeList mTypeItem;
    ImageView mBackButton;
    EditText mSearchInput;
    ImageView mClearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_type);

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

        mRecyclerView = findViewById(R.id.rv_type_list);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mTypeList = new ArrayList<>();

        mTypeItem = new TypeList("Dokumen", R.drawable.in_thumb_documents_square);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Gambar", R.drawable.in_thumb_pictures_square);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Flyer", R.drawable.in_thumb_flyer_square);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Undangan", R.drawable.in_blank_square);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Spanduk", R.drawable.in_blank_square);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("X-Banner", R.drawable.in_blank_square);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Kartu Nama", R.drawable.in_blank_square);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Sticker", R.drawable.in_blank_square);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Lainnya", R.drawable.in_more_square);
        mTypeList.add(mTypeItem);

        TypeListAdapter mTypeListAdapter = new TypeListAdapter(this, mTypeList, R.layout.rv_menu_item_row);
        mRecyclerView.setAdapter(mTypeListAdapter);
    }
}
