// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Popups;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SizeQuantityPopup_ViewBinding implements Unbinder {
  private SizeQuantityPopup target;

  private View view2131296358;

  private View view2131296293;

  private View view2131296294;

  @UiThread
  public SizeQuantityPopup_ViewBinding(final SizeQuantityPopup target, View source) {
    this.target = target;

    View view;
    target.mSelectedTypeIcon = Utils.findRequiredViewAsType(source, R.id.ivSelectedTypeIcon, "field 'mSelectedTypeIcon'", ImageView.class);
    target.mSelectedTypeTitle = Utils.findRequiredViewAsType(source, R.id.tvSelectedTypeTitle, "field 'mSelectedTypeTitle'", TextView.class);
    target.mQuantityTotal = Utils.findRequiredViewAsType(source, R.id.tvQuantityTotal, "field 'mQuantityTotal'", TextView.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_type_list, "field 'mRecyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.ibClosePopup, "field 'mClosePopup' and method 'hideMe'");
    target.mClosePopup = Utils.castView(view, R.id.ibClosePopup, "field 'mClosePopup'", ImageButton.class);
    view2131296358 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.hideMe();
      }
    });
    target.mAddToCartFrame = Utils.findRequiredViewAsType(source, R.id.flAddToCart, "field 'mAddToCartFrame'", FrameLayout.class);
    target.mNextStepFrame = Utils.findRequiredViewAsType(source, R.id.flNextStep, "field 'mNextStepFrame'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.btAddToCart, "field 'mAddToCartButton' and method 'addToCart'");
    target.mAddToCartButton = Utils.castView(view, R.id.btAddToCart, "field 'mAddToCartButton'", Button.class);
    view2131296293 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.addToCart();
      }
    });
    view = Utils.findRequiredView(source, R.id.btNextStep, "field 'mNextStepButton' and method 'nextStep'");
    target.mNextStepButton = Utils.castView(view, R.id.btNextStep, "field 'mNextStepButton'", Button.class);
    view2131296294 = view;
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

    target.mSelectedTypeIcon = null;
    target.mSelectedTypeTitle = null;
    target.mQuantityTotal = null;
    target.mRecyclerView = null;
    target.mClosePopup = null;
    target.mAddToCartFrame = null;
    target.mNextStepFrame = null;
    target.mAddToCartButton = null;
    target.mNextStepButton = null;

    view2131296358.setOnClickListener(null);
    view2131296358 = null;
    view2131296293.setOnClickListener(null);
    view2131296293 = null;
    view2131296294.setOnClickListener(null);
    view2131296294 = null;
  }
}
