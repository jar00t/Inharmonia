// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Order.Adapter;

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

public class OrderListAdapter$Holder_ViewBinding implements Unbinder {
  private OrderListAdapter.Holder target;

  private View view2131296324;

  @UiThread
  public OrderListAdapter$Holder_ViewBinding(final OrderListAdapter.Holder target, View source) {
    this.target = target;

    View view;
    target.tv_order_code = Utils.findRequiredViewAsType(source, R.id.tv_order_code, "field 'tv_order_code'", TextView.class);
    target.tv_order_status = Utils.findRequiredViewAsType(source, R.id.tv_order_status, "field 'tv_order_status'", TextView.class);
    target.iv_order_status = Utils.findRequiredViewAsType(source, R.id.iv_order_status, "field 'iv_order_status'", ImageView.class);
    target.tv_store_name = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tv_store_name'", TextView.class);
    target.tv_store_address = Utils.findRequiredViewAsType(source, R.id.tv_address, "field 'tv_store_address'", TextView.class);
    target.tv_buyer_name = Utils.findRequiredViewAsType(source, R.id.tv_buyer_name, "field 'tv_buyer_name'", TextView.class);
    target.tv_buyer_address = Utils.findRequiredViewAsType(source, R.id.tv_buyer_address, "field 'tv_buyer_address'", TextView.class);
    target.tv_date_time = Utils.findRequiredViewAsType(source, R.id.tv_date_time, "field 'tv_date_time'", TextView.class);
    view = Utils.findRequiredView(source, R.id.cv_item_type, "field 'cv_item_type' and method 'go_to_detail'");
    target.cv_item_type = Utils.castView(view, R.id.cv_item_type, "field 'cv_item_type'", CardView.class);
    view2131296324 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.go_to_detail();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderListAdapter.Holder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_order_code = null;
    target.tv_order_status = null;
    target.iv_order_status = null;
    target.tv_store_name = null;
    target.tv_store_address = null;
    target.tv_buyer_name = null;
    target.tv_buyer_address = null;
    target.tv_date_time = null;
    target.cv_item_type = null;

    view2131296324.setOnClickListener(null);
    view2131296324 = null;
  }
}
