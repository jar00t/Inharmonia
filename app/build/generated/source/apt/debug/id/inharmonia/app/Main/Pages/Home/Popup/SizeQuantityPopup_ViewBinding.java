// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Popup;

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

  private View view2131296370;

  private View view2131296294;

  private View view2131296295;

  @UiThread
  public SizeQuantityPopup_ViewBinding(final SizeQuantityPopup target, View source) {
    this.target = target;

    View view;
    target.iv_selected_type_icon = Utils.findRequiredViewAsType(source, R.id.iv_selected_type_icon, "field 'iv_selected_type_icon'", ImageView.class);
    target.tv_selected_type_title = Utils.findRequiredViewAsType(source, R.id.tv_selected_type_title, "field 'tv_selected_type_title'", TextView.class);
    target.tv_quantity_total = Utils.findRequiredViewAsType(source, R.id.tv_quantity_total, "field 'tv_quantity_total'", TextView.class);
    target.rv_list_type = Utils.findRequiredViewAsType(source, R.id.rv_list_type, "field 'rv_list_type'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.ib_button_close_popup, "field 'ib_button_close_popup' and method 'hide_me'");
    target.ib_button_close_popup = Utils.castView(view, R.id.ib_button_close_popup, "field 'ib_button_close_popup'", ImageButton.class);
    view2131296370 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.hide_me();
      }
    });
    target.fl_button_add_to_cart = Utils.findRequiredViewAsType(source, R.id.fl_button_add_to_cart, "field 'fl_button_add_to_cart'", FrameLayout.class);
    target.fl_button_next_step = Utils.findRequiredViewAsType(source, R.id.fl_button_next_step, "field 'fl_button_next_step'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.bt_button_add_to_cart, "field 'bt_button_add_to_cart' and method 'add_to_cart'");
    target.bt_button_add_to_cart = Utils.castView(view, R.id.bt_button_add_to_cart, "field 'bt_button_add_to_cart'", Button.class);
    view2131296294 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.add_to_cart();
      }
    });
    view = Utils.findRequiredView(source, R.id.bt_button_next_step, "field 'bt_button_next_step' and method 'next_step'");
    target.bt_button_next_step = Utils.castView(view, R.id.bt_button_next_step, "field 'bt_button_next_step'", Button.class);
    view2131296295 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.next_step();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SizeQuantityPopup target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.iv_selected_type_icon = null;
    target.tv_selected_type_title = null;
    target.tv_quantity_total = null;
    target.rv_list_type = null;
    target.ib_button_close_popup = null;
    target.fl_button_add_to_cart = null;
    target.fl_button_next_step = null;
    target.bt_button_add_to_cart = null;
    target.bt_button_next_step = null;

    view2131296370.setOnClickListener(null);
    view2131296370 = null;
    view2131296294.setOnClickListener(null);
    view2131296294 = null;
    view2131296295.setOnClickListener(null);
    view2131296295 = null;
  }
}
