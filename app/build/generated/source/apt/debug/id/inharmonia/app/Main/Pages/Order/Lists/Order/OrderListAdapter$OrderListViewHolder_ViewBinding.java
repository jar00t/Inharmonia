// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Order.Lists.Order;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderListAdapter$OrderListViewHolder_ViewBinding implements Unbinder {
  private OrderListAdapter.OrderListViewHolder target;

  private View view2131296314;

  @UiThread
  public OrderListAdapter$OrderListViewHolder_ViewBinding(final OrderListAdapter.OrderListViewHolder target,
      View source) {
    this.target = target;

    View view;
    target.mOrderCode = Utils.findRequiredViewAsType(source, R.id.tvOrderCode, "field 'mOrderCode'", TextView.class);
    target.mOrderStatusText = Utils.findRequiredViewAsType(source, R.id.tvOrderStatus, "field 'mOrderStatusText'", TextView.class);
    target.mOrderStatusIcon = Utils.findRequiredViewAsType(source, R.id.ivOrderStatus, "field 'mOrderStatusIcon'", ImageView.class);
    target.mStoreName = Utils.findRequiredViewAsType(source, R.id.tvStoreName, "field 'mStoreName'", TextView.class);
    target.mStoreAddress = Utils.findRequiredViewAsType(source, R.id.tvStoreAddress, "field 'mStoreAddress'", TextView.class);
    target.mBuyerName = Utils.findRequiredViewAsType(source, R.id.tvBuyerName, "field 'mBuyerName'", TextView.class);
    target.mBuyerAddress = Utils.findRequiredViewAsType(source, R.id.tvBuyerAddress, "field 'mBuyerAddress'", TextView.class);
    target.mOrderDateTime = Utils.findRequiredViewAsType(source, R.id.tvOrderDateTime, "field 'mOrderDateTime'", TextView.class);
    view = Utils.findRequiredView(source, R.id.cvMenuItem, "field 'mMenuItem' and method 'goToDetails'");
    target.mMenuItem = Utils.castView(view, R.id.cvMenuItem, "field 'mMenuItem'", CardView.class);
    view2131296314 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.goToDetails();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderListAdapter.OrderListViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mOrderCode = null;
    target.mOrderStatusText = null;
    target.mOrderStatusIcon = null;
    target.mStoreName = null;
    target.mStoreAddress = null;
    target.mBuyerName = null;
    target.mBuyerAddress = null;
    target.mOrderDateTime = null;
    target.mMenuItem = null;

    view2131296314.setOnClickListener(null);
    view2131296314 = null;
  }
}
