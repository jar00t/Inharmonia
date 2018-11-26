package id.inharmonia.app.Order;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import id.inharmonia.app.R;

public class OrderFragment extends Fragment {

    RecyclerView mRecyclerView;
    List<OrderList> mOrderList;
    OrderList mOrderItem;

    public OrderFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        mRecyclerView = view.findViewById(R.id.rv_order_list);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mOrderList = new ArrayList<>();

        mOrderItem = new OrderList(
                "DP-1234567890",
                "Selesai",
                R.drawable.ic_assignment_turned_in_green_24dp,
                "Nusawarna Digital Printing",
                "Jl.Suradireja No.00 Purwakarta",
                "Muhammad Yusuf Nur Fajar",
                "Jl.Surawinata No.04 Purwakarta",
                "12 Desember 2018 - 12:12"
        );
        mOrderList.add(mOrderItem);

        mOrderItem = new OrderList(
                "DP-8123912837",
                "Dikirim",
                R.drawable.ic_local_shipping_orange_24dp,
                "Tukang Cetak Berkah Abadi",
                "Jl.Belakang No.00 Purwakarta",
                "Asep Silet",
                "Jl.Depan No.04 Purwakarta",
                "12 November 2018 - 20:12"
        );
        mOrderList.add(mOrderItem);

        mOrderItem = new OrderList(
                "DP-2348291834",
                "Diproses",
                R.drawable.ic_update_orange_24dp,
                "Makmur Sentosa Digital",
                "Jl.Jalan ke Tengah Jalan di Purwakarta",
                "Dadang Gantar",
                "Jl.Rata di Aspal Purwakarta",
                "1 November 2018 - 10:12"
        );
        mOrderList.add(mOrderItem);

        OrderListAdapter mOrderListAdapter = new OrderListAdapter(getActivity(), mOrderList);
        mRecyclerView.setAdapter(mOrderListAdapter);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        getActivity().setTitle(R.string.title_order);

        return view;
    }

}
