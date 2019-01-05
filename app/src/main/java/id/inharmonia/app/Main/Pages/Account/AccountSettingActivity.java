package id.inharmonia.app.Main.Pages.Account;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;

public class AccountSettingActivity extends AppCompatActivity {

    @BindView(R.id.ib_button_back)
    ImageButton ib_button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setting);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ib_button_back)
    public void exit() {
        finish();
    }

}
