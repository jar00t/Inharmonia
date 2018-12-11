// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Order;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderNewActivity_ViewBinding implements Unbinder {
  private OrderNewActivity target;

  private View view2131230814;

  @UiThread
  public OrderNewActivity_ViewBinding(OrderNewActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OrderNewActivity_ViewBinding(final OrderNewActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ibBackButton, "field 'mBackButton' and method 'exit'");
    target.mBackButton = Utils.castView(view, R.id.ibBackButton, "field 'mBackButton'", ImageButton.class);
    view2131230814 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.exit();
      }
    });
    target.mPageName = Utils.findRequiredViewAsType(source, R.id.tvPageName, "field 'mPageName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderNewActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackButton = null;
    target.mPageName = null;

    view2131230814.setOnClickListener(null);
    view2131230814 = null;
  }
}
