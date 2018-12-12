package id.inharmonia.app.Main.Pages.Order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;

public class OrderNewActivity extends AppCompatActivity {

    @BindView(R.id.ibBackButton)
    ImageButton mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_new);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.ibBackButton)
    public void exit() {
        finish();
    }

}
