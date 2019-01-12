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

  private View view2131296370;

  @UiThread
  public WebActivity_ViewBinding(WebActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WebActivity_ViewBinding(final WebActivity target, View source) {
    this.target = target;

    View view;
    target.wv_container_web = Utils.findRequiredViewAsType(source, R.id.wv_container_web, "field 'wv_container_web'", WebView.class);
    target.tv_page_name = Utils.findRequiredViewAsType(source, R.id.tv_page_name, "field 'tv_page_name'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ib_button_back, "field 'ib_button_back' and method 'exit'");
    target.ib_button_back = Utils.castView(view, R.id.ib_button_back, "field 'ib_button_back'", ImageButton.class);
    view2131296370 = view;
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

    target.wv_container_web = null;
    target.tv_page_name = null;
    target.ib_button_back = null;

    view2131296370.setOnClickListener(null);
    view2131296370 = null;
  }
}
