// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Cart.Adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CartListAdapter$Holder_ViewBinding implements Unbinder {
  private CartListAdapter.Holder target;

  private View view2131296380;

  private View view2131296298;

  private View view2131296318;

  @UiThread
  public CartListAdapter$Holder_ViewBinding(final CartListAdapter.Holder target, View source) {
    this.target = target;

    View view;
    target.cl_item_cart = Utils.findRequiredViewAsType(source, R.id.cl_item_cart, "field 'cl_item_cart'", ConstraintLayout.class);
    target.iv_icon = Utils.findRequiredViewAsType(source, R.id.iv_icon, "field 'iv_icon'", ImageView.class);
    target.tv_name = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tv_name'", TextView.class);
    target.tv_list_size = Utils.findRequiredViewAsType(source, R.id.tv_list_size, "field 'tv_list_size'", TextView.class);
    view = Utils.findRequiredView(source, R.id.iv_button_toggle, "field 'iv_button_toggle' and method 'toggle_detail'");
    target.iv_button_toggle = Utils.castView(view, R.id.iv_button_toggle, "field 'iv_button_toggle'", ImageView.class);
    view2131296380 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toggle_detail();
      }
    });
    target.cv_cart_detail = Utils.findRequiredViewAsType(source, R.id.cv_cart_detail, "field 'cv_cart_detail'", CardView.class);
    target.rv_list_quantity = Utils.findRequiredViewAsType(source, R.id.rv_list_quantity, "field 'rv_list_quantity'", RecyclerView.class);
    target.tv_total = Utils.findRequiredViewAsType(source, R.id.tv_total, "field 'tv_total'", TextView.class);
    view = Utils.findRequiredView(source, R.id.cb_cart_selecter, "field 'cb_cart_selecter' and method 'select_cart'");
    target.cb_cart_selecter = Utils.castView(view, R.id.cb_cart_selecter, "field 'cb_cart_selecter'", CheckBox.class);
    view2131296298 = view;
    ((CompoundButton) view).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton p0, boolean p1) {
        target.select_cart();
      }
    });
    view = Utils.findRequiredView(source, R.id.cv_button_cart_deleter, "field 'cv_button_cart_deleter' and method 'delete_cart'");
    target.cv_button_cart_deleter = Utils.castView(view, R.id.cv_button_cart_deleter, "field 'cv_button_cart_deleter'", CardView.class);
    view2131296318 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.delete_cart();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CartListAdapter.Holder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.cl_item_cart = null;
    target.iv_icon = null;
    target.tv_name = null;
    target.tv_list_size = null;
    target.iv_button_toggle = null;
    target.cv_cart_detail = null;
    target.rv_list_quantity = null;
    target.tv_total = null;
    target.cb_cart_selecter = null;
    target.cv_button_cart_deleter = null;

    view2131296380.setOnClickListener(null);
    view2131296380 = null;
    ((CompoundButton) view2131296298).setOnCheckedChangeListener(null);
    view2131296298 = null;
    view2131296318.setOnClickListener(null);
    view2131296318 = null;
  }
}
