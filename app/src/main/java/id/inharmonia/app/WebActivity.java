package id.inharmonia.app;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {

    WebView mWebView;
    TextView mPageName;
    ImageButton mBackButton;
    Bundle mBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        mBundle = getIntent().getExtras();

        if (!mBundle.getString("pageTitle").isEmpty()) {
            mPageName = findViewById(R.id.tvPageName);
            mPageName.setText(mBundle.getString("pageTitle"));
        }

        final ProgressDialog mProgressDialog = ProgressDialog.show(WebActivity.this, "", "Loading...", true);

        mWebView  = findViewById(R.id.wvWebContainer);

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

        mBackButton = findViewById(R.id.ibBackButton);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
