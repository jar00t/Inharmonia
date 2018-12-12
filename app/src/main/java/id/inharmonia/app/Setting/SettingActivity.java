package id.inharmonia.app.Setting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.ibBackButton)
    ImageButton mBackButton;

    @BindView(R.id.tvPageName)
    TextView mPageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.ibBackButton)
    public void exit() {
        finish();
    }

}
