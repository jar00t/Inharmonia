// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Order;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderNewActivity_ViewBinding implements Unbinder {
  private OrderNewActivity target;

  private View view2131296359;

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
    view2131296359 = view;
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
    OrderNewActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackButton = null;

    view2131296359.setOnClickListener(null);
    view2131296359 = null;
  }
}
