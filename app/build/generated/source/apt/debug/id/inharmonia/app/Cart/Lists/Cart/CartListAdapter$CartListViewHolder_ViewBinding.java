// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Cart.Lists.Cart;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CartListAdapter$CartListViewHolder_ViewBinding implements Unbinder {
  private CartListAdapter.CartListViewHolder target;

  private View view2131296384;

  private View view2131296317;

  @UiThread
  public CartListAdapter$CartListViewHolder_ViewBinding(final CartListAdapter.CartListViewHolder target,
      View source) {
    this.target = target;

    View view;
    target.mCartItem = Utils.findRequiredViewAsType(source, R.id.clCartItem, "field 'mCartItem'", ConstraintLayout.class);
    target.mIcon = Utils.findRequiredViewAsType(source, R.id.ivIcon, "field 'mIcon'", ImageView.class);
    target.mName = Utils.findRequiredViewAsType(source, R.id.tvName, "field 'mName'", TextView.class);
    target.mSizeList = Utils.findRequiredViewAsType(source, R.id.tvSizeList, "field 'mSizeList'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ivToggleButton, "field 'mToggleButton' and method 'toggleDetail'");
    target.mToggleButton = Utils.castView(view, R.id.ivToggleButton, "field 'mToggleButton'", ImageView.class);
    view2131296384 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toggleDetail();
      }
    });
    target.mCartDetail = Utils.findRequiredViewAsType(source, R.id.cvCartDetail, "field 'mCartDetail'", CardView.class);
    target.mQuantityListRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_quantity_list, "field 'mQuantityListRecyclerView'", RecyclerView.class);
    target.mTotal = Utils.findRequiredViewAsType(source, R.id.tvTotal, "field 'mTotal'", TextView.class);
    target.mCartSelect = Utils.findRequiredViewAsType(source, R.id.cbCartSelect, "field 'mCartSelect'", CheckBox.class);
    view = Utils.findRequiredView(source, R.id.cvCartDeleteButton, "field 'mCartDeleteButton' and method 'deleteCart'");
    target.mCartDeleteButton = Utils.castView(view, R.id.cvCartDeleteButton, "field 'mCartDeleteButton'", CardView.class);
    view2131296317 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.deleteCart();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CartListAdapter.CartListViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mCartItem = null;
    target.mIcon = null;
    target.mName = null;
    target.mSizeList = null;
    target.mToggleButton = null;
    target.mCartDetail = null;
    target.mQuantityListRecyclerView = null;
    target.mTotal = null;
    target.mCartSelect = null;
    target.mCartDeleteButton = null;

    view2131296384.setOnClickListener(null);
    view2131296384 = null;
    view2131296317.setOnClickListener(null);
    view2131296317 = null;
  }
}
