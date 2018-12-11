package id.inharmonia.app.Web;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Typeface;
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

    @BindView(R.id.wvWebContainer)
    WebView mWebView;

    @BindView(R.id.tvPageName)
    TextView mPageName;

    @BindView(R.id.ibBackButton)
    ImageButton mBackButton;

    Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        ButterKnife.bind(this);

        Typeface comfortaa_regular_font = Typeface.createFromAsset(this.getApplicationContext().getAssets(),  "fonts/comfortaa-regular.ttf");
        mPageName.setTypeface(comfortaa_regular_font);

        mBundle = getIntent().getExtras();
        if (!mBundle.getString("pageTitle").isEmpty()) {
            mPageName.setText(mBundle.getString("pageTitle"));
        }

        final ProgressDialog mProgressDialog = ProgressDialog.show(WebActivity.this, "", "Loading...", true);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setBuiltInZoomControls(true);

        mWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(WebActivity.this, description, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                mProgressDialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mProgressDialog.dismiss();
            }
        });

        mWebView.loadUrl("https://www.detik.com/");
    }

    @OnClick(R.id.ibBackButton)
    public void exit() {
        finish();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
