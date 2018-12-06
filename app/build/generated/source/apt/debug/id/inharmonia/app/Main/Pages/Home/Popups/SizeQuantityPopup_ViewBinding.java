// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Popups;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SizeQuantityPopup_ViewBinding implements Unbinder {
  private SizeQuantityPopup target;

  private View view2131230756;

  @UiThread
  public SizeQuantityPopup_ViewBinding(final SizeQuantityPopup target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btAddToCart, "field 'mAddToCartButton' and method 'addToCart'");
    target.mAddToCartButton = Utils.castView(view, R.id.btAddToCart, "field 'mAddToCartButton'", Button.class);
    view2131230756 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.addToCart();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SizeQuantityPopup target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mAddToCartButton = null;

    view2131230756.setOnClickListener(null);
    view2131230756 = null;
  }
}
