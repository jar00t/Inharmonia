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

  private View view2131296367;

  private View view2131296299;

  private View view2131296322;

  @UiThread
  public CartActivity_ViewBinding(CartActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CartActivity_ViewBinding(final CartActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ib_button_back, "field 'ib_button_back' and method 'exit'");
    target.ib_button_back = Utils.castView(view, R.id.ib_button_back, "field 'ib_button_back'", ImageButton.class);
    view2131296367 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.exit();
      }
    });
    target.rv_list_cart = Utils.findRequiredViewAsType(source, R.id.rv_list_cart, "field 'rv_list_cart'", RecyclerView.class);
    target.tv_sub_total = Utils.findRequiredViewAsType(source, R.id.tv_sub_total, "field 'tv_sub_total'", TextView.class);
    target.ll_layout_list = Utils.findRequiredViewAsType(source, R.id.ll_layout_list, "field 'll_layout_list'", LinearLayout.class);
    target.cv_button_checkout = Utils.findRequiredViewAsType(source, R.id.cv_button_checkout, "field 'cv_button_checkout'", CardView.class);
    target.tv_checkout = Utils.findRequiredViewAsType(source, R.id.tv_checkout, "field 'tv_checkout'", TextView.class);
    target.tv_select_all = Utils.findRequiredViewAsType(source, R.id.tv_select_all, "field 'tv_select_all'", TextView.class);
    view = Utils.findRequiredView(source, R.id.cb_select_all, "field 'cb_select_all' and method 'select_all'");
    target.cb_select_all = Utils.castView(view, R.id.cb_select_all, "field 'cb_select_all'", CheckBox.class);
    view2131296299 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.select_all();
      }
    });
    view = Utils.findRequiredView(source, R.id.cv_button_store_selecter, "field 'cv_button_store_selecter' and method 'go_to_store_finder'");
    target.cv_button_store_selecter = Utils.castView(view, R.id.cv_button_store_selecter, "field 'cv_button_store_selecter'", CardView.class);
    view2131296322 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.go_to_store_finder();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CartActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ib_button_back = null;
    target.rv_list_cart = null;
    target.tv_sub_total = null;
    target.ll_layout_list = null;
    target.cv_button_checkout = null;
    target.tv_checkout = null;
    target.tv_select_all = null;
    target.cb_select_all = null;
    target.cv_button_store_selecter = null;

    view2131296367.setOnClickListener(null);
    view2131296367 = null;
    view2131296299.setOnClickListener(null);
    view2131296299 = null;
    view2131296322.setOnClickListener(null);
    view2131296322 = null;
  }
}
