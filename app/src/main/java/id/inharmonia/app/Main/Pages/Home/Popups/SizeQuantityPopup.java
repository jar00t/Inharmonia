package id.inharmonia.app.Main.Pages.Home.Popups;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.Main.Pages.Home.Lists.Size.SizeList;
import id.inharmonia.app.Main.Pages.Home.Lists.Size.SizeListAdapter;
import id.inharmonia.app.R;

public class SizeQuantityPopup extends BottomSheetDialogFragment {

    @BindView(R.id.rv_type_list)
    public RecyclerView mRecyclerView;

    @BindView(R.id.tvPopupTitle)
    public TextView mPopupTitle;

    @BindView(R.id.ibClosePopup)
    public ImageButton mClosePopup;

    @BindView(R.id.btAddToCart)
    public Button mAddToCartButton;

    public List<SizeList> mSizeList;
    public SizeList mSizeItem;

    public SizeQuantityPopup() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popup_size_quantity, container, false);

        ButterKnife.bind(this, view);

        Typeface harabara_mais_font = Typeface.createFromAsset(getContext().getApplicationContext().getAssets(),  "fonts/harabara-mais.ttf");
        mPopupTitle.setTypeface(harabara_mais_font);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setFocusable(false);

        mSizeList = new ArrayList<>();

        mSizeItem = new SizeList(R.drawable.in_thumb_text_size_a4_square);
        mSizeList.add(mSizeItem);
        mSizeItem = new SizeList(R.drawable.in_thumb_text_size_a5_square);
        mSizeList.add(mSizeItem);
        mSizeItem = new SizeList(R.drawable.in_thumb_text_size_f4_square);
        mSizeList.add(mSizeItem);
        mRecyclerView.setAdapter(new SizeListAdapter(getActivity(), mSizeList, R.layout.rv_size_quantity_item_row));

        return view;
    }

    @OnClick(R.id.ibClosePopup)
    public void hideMe() {
        dismiss();
    }

    @OnClick(R.id.btAddToCart)
    public void addToCart() {

    }

}