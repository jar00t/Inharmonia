// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Cart.Lists.Cart;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CartListAdapter$CartListViewHolder_ViewBinding implements Unbinder {
  private CartListAdapter.CartListViewHolder target;

  private View view2131296379;

  @UiThread
  public CartListAdapter$CartListViewHolder_ViewBinding(final CartListAdapter.CartListViewHolder target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ivToggleButton, "field 'mToggleButton' and method 'toggleDetail'");
    target.mToggleButton = Utils.castView(view, R.id.ivToggleButton, "field 'mToggleButton'", ImageView.class);
    view2131296379 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toggleDetail();
      }
    });
    target.mCartDetail = Utils.findRequiredViewAsType(source, R.id.cvCartDetail, "field 'mCartDetail'", CardView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CartListAdapter.CartListViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToggleButton = null;
    target.mCartDetail = null;

    view2131296379.setOnClickListener(null);
    view2131296379 = null;
  }
}
