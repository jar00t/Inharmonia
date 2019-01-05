// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SizeListAdapter$Holder_ViewBinding implements Unbinder {
  private SizeListAdapter.Holder target;

  private View view2131296366;

  private View view2131296367;

  private View view2131296293;

  private View view2131296342;

  @UiThread
  public SizeListAdapter$Holder_ViewBinding(final SizeListAdapter.Holder target, View source) {
    this.target = target;

    View view;
    target.iv_icon = Utils.findRequiredViewAsType(source, R.id.iv_icon, "field 'iv_icon'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.ib_button_decrease, "field 'ib_button_decrease' and method 'decrease_value'");
    target.ib_button_decrease = Utils.castView(view, R.id.ib_button_decrease, "field 'ib_button_decrease'", ImageButton.class);
    view2131296366 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.decrease_value();
      }
    });
    view = Utils.findRequiredView(source, R.id.ib_button_increase, "field 'ib_button_increase' and method 'increase_value'");
    target.ib_button_increase = Utils.castView(view, R.id.ib_button_increase, "field 'ib_button_increase'", ImageButton.class);
    view2131296367 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.increase_value();
      }
    });
    view = Utils.findRequiredView(source, R.id.bt_button_add, "field 'bt_button_add' and method 'show_quantity_customer'");
    target.bt_button_add = Utils.castView(view, R.id.bt_button_add, "field 'bt_button_add'", Button.class);
    view2131296293 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.show_quantity_customer();
      }
    });
    target.ll_quantity_customer = Utils.findRequiredViewAsType(source, R.id.ll_quantity_customer, "field 'll_quantity_customer'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.et_number_value, "field 'et_number_value' and method 'focus_me'");
    target.et_number_value = Utils.castView(view, R.id.et_number_value, "field 'et_number_value'", EditText.class);
    view2131296342 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.focus_me();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SizeListAdapter.Holder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.iv_icon = null;
    target.ib_button_decrease = null;
    target.ib_button_increase = null;
    target.bt_button_add = null;
    target.ll_quantity_customer = null;
    target.et_number_value = null;

    view2131296366.setOnClickListener(null);
    view2131296366 = null;
    view2131296367.setOnClickListener(null);
    view2131296367 = null;
    view2131296293.setOnClickListener(null);
    view2131296293 = null;
    view2131296342.setOnClickListener(null);
    view2131296342 = null;
  }
}
