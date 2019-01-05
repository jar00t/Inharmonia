package id.inharmonia.app.Main.Pages.Home.Popup;

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
import id.inharmonia.app.Main.Pages.Home.HomeFragment;
import id.inharmonia.app.Main.Pages.Home.List.TypeList;
import id.inharmonia.app.Main.Pages.Home.Adapter.TypeListAdapter;
import id.inharmonia.app.R;

public class AllPrintTypePopup extends BottomSheetDialogFragment {

    @BindView(R.id.rv_list_type)
    public RecyclerView rv_list_type;

    @BindView(R.id.ib_button_close_popup)
    public ImageButton ib_button_close_popup;

    public List<TypeList> list_type;
    public TypeList item_type;

    HomeFragment fragment_home;

    int count_user_try_open = 0;

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

        rv_list_type.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        rv_list_type.setFocusable(false);

        list_type = new ArrayList<>();

        item_type = new TypeList("Dokumen", R.drawable.in_thumb_documents_square, true);
        list_type.add(item_type);
        item_type = new TypeList("Gambar", R.drawable.in_thumb_pictures_square, true);
        list_type.add(item_type);
        item_type = new TypeList("Flyer", R.drawable.in_thumb_flyer_square, false);
        list_type.add(item_type);
        item_type = new TypeList("Undangan", R.drawable.in_thumb_invitation_square, false);
        list_type.add(item_type);
        item_type = new TypeList("Spanduk", R.drawable.in_thumb_spanduk_square, false);
        list_type.add(item_type);
        item_type = new TypeList("Stand Banner", R.drawable.in_thumb_stand_banner_square, false);
        list_type.add(item_type);
        item_type = new TypeList("Kartu Nama", R.drawable.in_thumb_namecard_square, false);
        list_type.add(item_type);
        item_type = new TypeList("Sticker", R.drawable.in_thumb_sticker_square, false);
        list_type.add(item_type);

        rv_list_type.setAdapter(new TypeListAdapter(getActivity(), list_type, R.layout.rv_item_menu, fragment_home));

        return view;
    }

    public void send_mom(HomeFragment fragment_home) {
        this.fragment_home = fragment_home;
    }

    public Boolean check_sheet() {
        count_user_try_open = count_user_try_open + 1;
        return (count_user_try_open <= 1);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        count_user_try_open = 0;
    }

    @OnClick(R.id.ib_button_close_popup)
    public void hide_me() {
        dismiss();
    }

}