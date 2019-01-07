package id.inharmonia.app.Store.Tool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;

public class StoreFinderFilterActivity extends AppCompatActivity {

    @BindView(R.id.ib_button_close)
    ImageButton ib_button_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_finder_filter);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.ib_button_close)
    public void exit() {
        finish();
    }
}
