package id.inharmonia.app.Store.Popup;

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
import id.inharmonia.app.R;
import id.inharmonia.app.Store.Adapter.SortByListAdapter;
import id.inharmonia.app.Store.List.SortByList;
import id.inharmonia.app.Store.StoreFinderActivity;

public class StoreFinderSortByPopup extends BottomSheetDialogFragment {

    @BindView(R.id.rv_list_sort_by)
    public RecyclerView rv_list_sort_by;

    @BindView(R.id.ib_button_close_popup)
    public ImageButton ib_button_close_popup;

    public List<SortByList> list_sort_by;
    List<String[]> data_sort_by;

    StoreFinderActivity activity_store_finder;

    int count_user_try_open = 0;

    public StoreFinderSortByPopup() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popup_sort_by, container, false);

        ButterKnife.bind(this, view);

        data_sort_by = new ArrayList<>();
        data_sort_by.add(new String[]{"Lokasi", "in_ic_location"});
        data_sort_by.add(new String[]{"Biaya", "in_ic_cost"});
        data_sort_by.add(new String[]{"Reputasi", "in_ic_badge"});

        set_list();

        return view;
    }

    public void set_list() {
        if(data_sort_by.size() != 0) {
            Bundle data_sheet = getArguments();
            list_sort_by = new ArrayList<>();
            for(int i = 0; i < data_sort_by.size(); i++) {
                int icon = this.getResources().getIdentifier(data_sort_by.get(i)[1], "drawable", getActivity().getPackageName());
                list_sort_by.add(new SortByList(data_sort_by.get(i)[0], icon, (data_sort_by.get(i)[0].equals(data_sheet.getString("selectedSortBy")))));
            }
            rv_list_sort_by.setLayoutManager(new GridLayoutManager(getActivity(), 1));
            rv_list_sort_by.setFocusable(false);
            rv_list_sort_by.setAdapter(new SortByListAdapter(getActivity(), list_sort_by, R.layout.rv_item_link_menu, this));
        }
    }

    public void send_mom(StoreFinderActivity activity_store_finder) {
        this.activity_store_finder = activity_store_finder;
    }

    public Boolean check_sheet() {
        count_user_try_open = count_user_try_open + 1;
        return (count_user_try_open <= 1);
    }

    public void set_selected_sort_by(String sort_by) {
        activity_store_finder.set_selected_sort_by(sort_by);
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
