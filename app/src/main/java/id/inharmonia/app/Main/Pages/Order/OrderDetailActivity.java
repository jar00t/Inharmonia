package id.inharmonia.app.Main.Pages.Order;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;

public class OrderDetailActivity extends AppCompatActivity {

    @BindView(R.id.ibBackButton)
    ImageButton mBackButton;

    @BindView(R.id.tvPageName)
    TextView mPageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        ButterKnife.bind(this);

        Typeface comfortaa_regular_font = Typeface.createFromAsset(this.getApplicationContext().getAssets(),  "fonts/comfortaa-regular.ttf");
        mPageName.setTypeface(comfortaa_regular_font);
    }

    @OnClick(R.id.ibBackButton)
    public void exit() {
        finish();
    }

}
