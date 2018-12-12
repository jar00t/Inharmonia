package id.inharmonia.app.Main.Pages.Home.Popups;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.Main.Pages.Home.Lists.Quantity.QuantityList;
import id.inharmonia.app.Main.Pages.Home.Lists.Quantity.QuantityListAdapter;
import id.inharmonia.app.Main.Pages.Home.Lists.Size.SizeList;
import id.inharmonia.app.Main.Pages.Home.Lists.Size.SizeListAdapter;
import id.inharmonia.app.R;

public class SizeQuantityPopup extends BottomSheetDialogFragment {

    @BindView(R.id.rv_type_list)
    public RecyclerView mRecyclerView;

    @BindView(R.id.ibClosePopup)
    public ImageButton mClosePopup;

    @BindView(R.id.btAddToCart)
    public Button mAddToCartButton;

    @BindView(R.id.btNextStep)
    public Button mNextStepButton;

    public SizeListAdapter mSizeListAdapter;
    public List<SizeList> mSizeList;
    public SizeList mSizeItem;

    private String[] supportedSize = {"a4", "a5", "f4"};
    public List<String[]> quantityData;

    public SizeQuantityPopup() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popup_size_quantity, container, false);

        ButterKnife.bind(this, view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setFocusable(false);

        mSizeList = new ArrayList<>();
        quantityData = new ArrayList<>();

        for(int i = 0; i < supportedSize.length; i++) {
            int icon = getActivity().getResources().getIdentifier("in_thumb_text_size_" + supportedSize[i] + "_square", "drawable", getActivity().getPackageName());
            mSizeItem = new SizeList(icon);
            mSizeList.add(mSizeItem);
            quantityData.add(new String[]{supportedSize[i], "0"});
        }

        mSizeListAdapter = new SizeListAdapter(getActivity(), mSizeList, R.layout.rv_size_quantity_item_row);
        mRecyclerView.setAdapter(mSizeListAdapter);
        mSizeListAdapter.setData(quantityData);

        return view;
    }

    @OnClick(R.id.ibClosePopup)
    public void hideMe() {
        dismiss();
    }

    @OnClick(R.id.btAddToCart)
    public void addToCart() {
        confirmSizeQuantity();
    }

    @OnClick(R.id.btNextStep)
    public void nextStep() {
        confirmSizeQuantity();
    }

    public void confirmSizeQuantity() {
        AlertDialog.Builder builderConfirmSizeQuantity = new AlertDialog.Builder(getActivity(), R.style.DialogTheme);
        View dialogConfirmSizeQuantityView = getLayoutInflater().inflate(R.layout.dialog_size_quantity_confirmation, null);
        builderConfirmSizeQuantity.setView(dialogConfirmSizeQuantityView);

        showQuantityList(dialogConfirmSizeQuantityView);

        builderConfirmSizeQuantity.setPositiveButton("Ok Sip", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }

        });

        builderConfirmSizeQuantity.setNegativeButton("Batal", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }

        });

        Dialog dialogConfirmSizeQuantity = builderConfirmSizeQuantity.create();
        dialogConfirmSizeQuantity.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialogConfirmSizeQuantity.setCancelable(true);
        dialogConfirmSizeQuantity.setTitle("Konfirmasi Pesanan");

        dialogConfirmSizeQuantity.show();
    }

    private void showQuantityList(View dialogView) {
        quantityData = mSizeListAdapter.getData();

        if (quantityData.size() != 0) {
            List<QuantityList> mQuantityList;
            QuantityList mQuantityListItem;
            mQuantityList = new ArrayList<>();

            RecyclerView mQuantityListRecyclerView = dialogView.findViewById(R.id.rv_quantity_list);
            mQuantityListRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
            mQuantityListRecyclerView.setFocusable(false);

            for(int i = 0; i < quantityData.size(); i++) {
                mQuantityListItem = new QuantityList(quantityData.get(i)[0], quantityData.get(i)[1]);
                mQuantityList.add(mQuantityListItem);
            }

            mQuantityListRecyclerView.setAdapter(new QuantityListAdapter(getActivity(), mQuantityList, R.layout.rv_quantity_list_item_row));
        }
    }

}