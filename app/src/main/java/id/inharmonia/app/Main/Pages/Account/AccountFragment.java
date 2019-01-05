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
import id.inharmonia.app.Main.Pages.Account.Adapter.MenuListAdapter;
import id.inharmonia.app.Main.Pages.Account.List.MenuList;
import id.inharmonia.app.R;

public class AccountFragment extends Fragment {

    @BindView(R.id.rv_list_link_menu)
    RecyclerView rv_list_link_menu;

    List<MenuList> list_menu;
    MenuList list_item_menu;

    public AccountFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        ButterKnife.bind(this, view);

        rv_list_link_menu.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        rv_list_link_menu.setFocusable(false);

        list_menu = new ArrayList<>();

        list_item_menu = new MenuList("Profil", R.drawable.in_ic_profile);
        list_menu.add(list_item_menu);
        list_item_menu = new MenuList("Pengaturan", R.drawable.in_ic_setting);
        list_menu.add(list_item_menu);
        list_item_menu = new MenuList("Bantuan", R.drawable.in_ic_help);
        list_menu.add(list_item_menu);
        list_item_menu = new MenuList("Hubungi Kami", R.drawable.in_ic_contact);
        list_menu.add(list_item_menu);
        list_item_menu = new MenuList("Kebijakan Privasi", R.drawable.in_ic_secure);
        list_menu.add(list_item_menu);

        rv_list_link_menu.setAdapter(new MenuListAdapter(getActivity(), list_menu, R.layout.rv_item_link_menu));

        return view;
    }

}
