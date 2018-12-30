// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Cart;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CartActivity_ViewBinding implements Unbinder {
  private CartActivity target;

  private View view2131296362;

  private View view2131296298;

  @UiThread
  public CartActivity_ViewBinding(CartActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CartActivity_ViewBinding(final CartActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ibBackButton, "field 'mBackButton' and method 'exit'");
    target.mBackButton = Utils.castView(view, R.id.ibBackButton, "field 'mBackButton'", ImageButton.class);
    view2131296362 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.exit();
      }
    });
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_cart_list, "field 'mRecyclerView'", RecyclerView.class);
    target.mSubTotal = Utils.findRequiredViewAsType(source, R.id.tvSubTotal, "field 'mSubTotal'", TextView.class);
    target.mListLayout = Utils.findRequiredViewAsType(source, R.id.llListLayout, "field 'mListLayout'", LinearLayout.class);
    target.mCheckoutButton = Utils.findRequiredViewAsType(source, R.id.cvCheckoutButton, "field 'mCheckoutButton'", CardView.class);
    target.mCheckoutText = Utils.findRequiredViewAsType(source, R.id.tvCheckoutText, "field 'mCheckoutText'", TextView.class);
    target.mSelectAll = Utils.findRequiredViewAsType(source, R.id.tvSelectAll, "field 'mSelectAll'", TextView.class);
    view = Utils.findRequiredView(source, R.id.cbCheckAll, "field 'mCheckAll' and method 'checkAll'");
    target.mCheckAll = Utils.castView(view, R.id.cbCheckAll, "field 'mCheckAll'", CheckBox.class);
    view2131296298 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.checkAll();
      }
    });
    target.mSelectStoreButton = Utils.findRequiredViewAsType(source, R.id.cvSelectStoreButton, "field 'mSelectStoreButton'", CardView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CartActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackButton = null;
    target.mRecyclerView = null;
    target.mSubTotal = null;
    target.mListLayout = null;
    target.mCheckoutButton = null;
    target.mCheckoutText = null;
    target.mSelectAll = null;
    target.mCheckAll = null;
    target.mSelectStoreButton = null;

    view2131296362.setOnClickListener(null);
    view2131296362 = null;
    view2131296298.setOnClickListener(null);
    view2131296298 = null;
  }
}
