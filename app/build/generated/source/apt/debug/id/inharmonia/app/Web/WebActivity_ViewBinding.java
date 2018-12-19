// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Web;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WebActivity_ViewBinding implements Unbinder {
  private WebActivity target;

  private View view2131296354;

  @UiThread
  public WebActivity_ViewBinding(WebActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WebActivity_ViewBinding(final WebActivity target, View source) {
    this.target = target;

    View view;
    target.mWebView = Utils.findRequiredViewAsType(source, R.id.wvWebContainer, "field 'mWebView'", WebView.class);
    target.mPageName = Utils.findRequiredViewAsType(source, R.id.tvPageName, "field 'mPageName'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ibBackButton, "field 'mBackButton' and method 'exit'");
    target.mBackButton = Utils.castView(view, R.id.ibBackButton, "field 'mBackButton'", ImageButton.class);
    view2131296354 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.exit();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    WebActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mWebView = null;
    target.mPageName = null;
    target.mBackButton = null;

    view2131296354.setOnClickListener(null);
    view2131296354 = null;
  }
}
