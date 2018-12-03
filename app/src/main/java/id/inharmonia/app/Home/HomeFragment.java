package id.inharmonia.app.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import id.inharmonia.app.R;
import id.inharmonia.app.Search.SearchActivity;

public class HomeFragment extends Fragment {

    RecyclerView mRecyclerView;
    List<MainMenu> mMenuList;
    MainMenu mMenuItem;
    CardView mSearchOpener;

    public HomeFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mSearchOpener = view.findViewById(R.id.cvSearchOpener);

        mSearchOpener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), SearchActivity.class);
                getActivity().startActivity(myIntent);
            }
        });

        mRecyclerView = view.findViewById(R.id.rv_menu_list);
        mRecyclerView.setFocusable(false);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 3);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mMenuList = new ArrayList<>();

        mMenuItem = new MainMenu("Dokumen", R.drawable.in_thumb_documents_square);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Gambar", R.drawable.in_thumb_pictures_square);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Flyer", R.drawable.in_thumb_flyer_square);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Undangan", R.drawable.in_thumb_invitation_square);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Spanduk", R.drawable.in_thumb_spanduk_square);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Stand Banner", R.drawable.in_thumb_stand_banner_square);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Kartu Nama", R.drawable.in_blank_square);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Sticker", R.drawable.in_blank_square);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Lainnya", R.drawable.in_more_square);
        mMenuList.add(mMenuItem);

        MainMenuAdapter mMainMenuAdapter = new MainMenuAdapter(getActivity(), mMenuList, R.layout.rv_menu_item_row);
        mRecyclerView.setAdapter(mMainMenuAdapter);

        return view;
    }

}
