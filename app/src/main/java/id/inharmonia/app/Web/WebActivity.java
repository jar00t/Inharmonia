package id.inharmonia.app.Web;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.inharmonia.app.R;

public class WebActivity extends AppCompatActivity {

    @BindView(R.id.wv_container_web)
    WebView wv_container_web;

    @BindView(R.id.tv_page_name)
    TextView tv_page_name;

    @BindView(R.id.ib_button_back)
    ImageButton ib_button_back;

    Bundle bundle_me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        ButterKnife.bind(this);

        bundle_me = getIntent().getExtras();
        if (!bundle_me.getString("pageTitle").isEmpty()) {
            tv_page_name.setText(bundle_me.getString("pageTitle"));
        }

        final ProgressDialog dialog_progress = ProgressDialog.show(WebActivity.this, "", "Loading...", true);
        wv_container_web.getSettings().setJavaScriptEnabled(true);
        wv_container_web.getSettings().setLoadWithOverviewMode(true);
        wv_container_web.getSettings().setUseWideViewPort(true);
        wv_container_web.getSettings().setBuiltInZoomControls(true);

        wv_container_web.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(WebActivity.this, description, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                dialog_progress.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                dialog_progress.dismiss();
            }
        });

        wv_container_web.loadUrl("https://www.detik.com/");
    }

    @OnClick(R.id.ib_button_back)
    public void exit() {
        finish();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv_container_web.canGoBack()) {
            wv_container_web.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
