package id.inharmonia.app.Main.Pages.Account;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.inharmonia.app.Main.Pages.Account.Lists.Menu.Menu;
import id.inharmonia.app.Main.Pages.Account.Lists.Menu.MenuAdapter;
import id.inharmonia.app.R;

public class AccountFragment extends Fragment {

    @BindView(R.id.rv_menu_link_list)
    RecyclerView mRecyclerView;

    List<Menu> mMenuList;
    Menu mMenuItem;

    public AccountFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        ButterKnife.bind(this, view);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        mRecyclerView.setFocusable(false);

        mMenuList = new ArrayList<>();

        mMenuItem = new Menu("Profil", R.drawable.in_ic_profile);
        mMenuList.add(mMenuItem);
        mMenuItem = new Menu("Pengaturan", R.drawable.in_ic_setting);
        mMenuList.add(mMenuItem);
        mMenuItem = new Menu("Bantuan", R.drawable.in_ic_help);
        mMenuList.add(mMenuItem);
        mMenuItem = new Menu("Hubungi Kami", R.drawable.in_ic_contact);
        mMenuList.add(mMenuItem);
        mMenuItem = new Menu("Kebijakan Privasi", R.drawable.in_ic_secure);
        mMenuList.add(mMenuItem);

        mRecyclerView.setAdapter(new MenuAdapter(getActivity(), mMenuList, R.layout.rv_menu_link_item_row));

        return view;
    }

}
