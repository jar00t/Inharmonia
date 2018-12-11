// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Popups;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SizeQuantityPopup_ViewBinding implements Unbinder {
  private SizeQuantityPopup target;

  private View view2131230816;

  private View view2131230756;

  private View view2131230757;

  @UiThread
  public SizeQuantityPopup_ViewBinding(final SizeQuantityPopup target, View source) {
    this.target = target;

    View view;
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_type_list, "field 'mRecyclerView'", RecyclerView.class);
    target.mPopupTitle = Utils.findRequiredViewAsType(source, R.id.tvPopupTitle, "field 'mPopupTitle'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ibClosePopup, "field 'mClosePopup' and method 'hideMe'");
    target.mClosePopup = Utils.castView(view, R.id.ibClosePopup, "field 'mClosePopup'", ImageButton.class);
    view2131230816 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.hideMe();
      }
    });
    view = Utils.findRequiredView(source, R.id.btAddToCart, "field 'mAddToCartButton' and method 'addToCart'");
    target.mAddToCartButton = Utils.castView(view, R.id.btAddToCart, "field 'mAddToCartButton'", Button.class);
    view2131230756 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.addToCart();
      }
    });
    view = Utils.findRequiredView(source, R.id.btNextStep, "field 'mNextStepButton' and method 'nextStep'");
    target.mNextStepButton = Utils.castView(view, R.id.btNextStep, "field 'mNextStepButton'", Button.class);
    view2131230757 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.nextStep();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SizeQuantityPopup target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.mPopupTitle = null;
    target.mClosePopup = null;
    target.mAddToCartButton = null;
    target.mNextStepButton = null;

    view2131230816.setOnClickListener(null);
    view2131230816 = null;
    view2131230756.setOnClickListener(null);
    view2131230756 = null;
    view2131230757.setOnClickListener(null);
    view2131230757 = null;
  }
}
