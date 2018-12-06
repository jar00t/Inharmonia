package id.inharmonia.app.Main.Pages.Home.Popups;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;

public class SizeQuantityPopup extends BottomSheetDialogFragment {

    @BindView(R.id.btAddToCart)
    public Button mAddToCartButton;

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

        return view;
    }

    @OnClick(R.id.btAddToCart)
    public void addToCart() {

    }

}