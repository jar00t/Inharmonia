package id.inharmonia.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView mRecyclerView;
    List<MainMenu> mMenuList;
    MainMenu mMenuItem;

    public HomeFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = view.findViewById(R.id.rv_menu_list);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 3);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mMenuList = new ArrayList<>();

        mMenuItem = new MainMenu("Dokumen", R.drawable.in_blank_square);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Foto", R.drawable.in_blank_square);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Flyer", R.drawable.in_blank_square);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Pamflet", R.drawable.in_blank_square);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("Spanduk", R.drawable.in_blank_square);
        mMenuList.add(mMenuItem);
        mMenuItem = new MainMenu("X-Banner", R.drawable.in_blank_square);
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
