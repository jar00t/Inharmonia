package id.inharmonia.app.Main.Pages.Home.Popups;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.Main.Pages.Home.Lists.Type.TypeList;
import id.inharmonia.app.Main.Pages.Home.Lists.Type.TypeListAdapter;
import id.inharmonia.app.R;

public class AllPrintTypePopup extends BottomSheetDialogFragment {

    @BindView(R.id.rv_type_list)
    public RecyclerView mRecyclerView;

    @BindView(R.id.ibClosePopup)
    public ImageButton mClosePopup;

    public List<TypeList> mTypeList;
    public TypeList mTypeItem;

    int userTryOpenCount = 0;

    public AllPrintTypePopup() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popup_all_print_type, container, false);

        ButterKnife.bind(this, view);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        mRecyclerView.setFocusable(false);

        mTypeList = new ArrayList<>();

        mTypeItem = new TypeList("Dokumen", R.drawable.in_thumb_documents_square, true);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Gambar", R.drawable.in_thumb_pictures_square, true);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Flyer", R.drawable.in_thumb_flyer_square, false);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Undangan", R.drawable.in_thumb_invitation_square, false);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Spanduk", R.drawable.in_thumb_spanduk_square, false);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Stand Banner", R.drawable.in_thumb_stand_banner_square, false);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Kartu Nama", R.drawable.in_thumb_namecard_square, false);
        mTypeList.add(mTypeItem);
        mTypeItem = new TypeList("Sticker", R.drawable.in_thumb_sticker_square, false);
        mTypeList.add(mTypeItem);

        mRecyclerView.setAdapter(new TypeListAdapter(getActivity(), mTypeList, R.layout.rv_menu_item_row));

        return view;
    }

    public Boolean checkSheet() {
        userTryOpenCount = userTryOpenCount + 1;
        return (userTryOpenCount <= 1);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        userTryOpenCount = 0;
    }

    @OnClick(R.id.ibClosePopup)
    public void hideMe() {
        dismiss();
    }

}