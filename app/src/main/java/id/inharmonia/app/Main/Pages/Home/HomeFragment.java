package id.inharmonia.app.Main.Pages.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.Main.Pages.Home.Lists.MainMenu.MainMenu;
import id.inharmonia.app.Main.Pages.Home.Lists.MainMenu.MainMenuAdapter;
import id.inharmonia.app.R;
import id.inharmonia.app.Search.SearchActivity;

public class HomeFragment extends Fragment {

    @BindView(R.id.rv_menu_list)
    RecyclerView mRecyclerView;

    @BindView(R.id.ibSearchOpener)
    ImageButton mSearchOpener;

    @BindView(R.id.clPromoSlide)
    CarouselView mPromoSlider;

    List<MainMenu> mMenuList;
    MainMenu mMenuItem;
    int[] sampleImages = {R.drawable.in_blank_landscape, R.drawable.in_blank_landscape, R.drawable.in_blank_landscape, R.drawable.in_blank_landscape, R.drawable.in_blank_landscape};

    public HomeFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, view);

        mPromoSlider.setPageCount(sampleImages.length);
        mPromoSlider.setImageListener(imageListener);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        mRecyclerView.setFocusable(false);

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
        mMenuItem = new MainMenu("Lainnya", R.drawable.in_more_square);
        mMenuList.add(mMenuItem);

        mRecyclerView.setAdapter(new MainMenuAdapter(getActivity(), mMenuList, R.layout.rv_menu_item_row));

        return view;
    }

    @OnClick(R.id.ibSearchOpener)
    public void openSearch() {
        getActivity().startActivity(new Intent(getActivity(), SearchActivity.class));
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

}
