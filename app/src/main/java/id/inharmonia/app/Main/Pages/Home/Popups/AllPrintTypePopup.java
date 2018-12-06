package id.inharmonia.app.Main.Pages.Home.Popups;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.inharmonia.app.Main.Pages.Home.Lists.Type.TypeList;
import id.inharmonia.app.Main.Pages.Home.Lists.Type.TypeListAdapter;
import id.inharmonia.app.R;

public class AllPrintTypePopup extends BottomSheetDialogFragment {

    public RecyclerView mRecyclerView;
    public List<TypeList> mTypeList;
    public TypeList mTypeItem;
    public TextView mPopupTitle;
    public ImageButton mClosePopup;

    public AllPrintTypePopup() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.popup_all_print_type, container, false);

        Typeface harabara_mais_font = Typeface.createFromAsset(getContext().getApplicationContext().getAssets(),  "fonts/harabara-mais.ttf");

        mPopupTitle = view.findViewById(R.id.tvPopupTitle);
        mPopupTitle.setTypeface(harabara_mais_font);

        mClosePopup = view.findViewById(R.id.ibClosePopup);
        mClosePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        mRecyclerView = view.findViewById(R.id.rv_type_list);
        mRecyclerView.setFocusable(false);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 4);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mTypeList = new ArrayList<>();

        mTypeItem = new TypeList("Dokumen", R.drawable.in_thumb_documents_square);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Gambar", R.drawable.in_thumb_pictures_square);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Flyer", R.drawable.in_thumb_flyer_square);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Undangan", R.drawable.in_thumb_invitation_square);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Spanduk", R.drawable.in_thumb_spanduk_square);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Stand Banner", R.drawable.in_thumb_stand_banner_square);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Kartu Nama", R.drawable.in_blank_square);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Sticker", R.drawable.in_blank_square);
        mTypeList.add(mTypeItem);

        TypeListAdapter mTypeListAdapter = new TypeListAdapter(getActivity(), mTypeList, R.layout.rv_menu_item_row);
        mRecyclerView.setAdapter(mTypeListAdapter);

        return view;
    }
}