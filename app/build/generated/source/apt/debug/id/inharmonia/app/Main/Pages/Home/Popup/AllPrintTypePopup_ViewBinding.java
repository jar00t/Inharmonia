// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Popup;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AllPrintTypePopup_ViewBinding implements Unbinder {
  private AllPrintTypePopup target;

  private View view2131296370;

  @UiThread
  public AllPrintTypePopup_ViewBinding(final AllPrintTypePopup target, View source) {
    this.target = target;

    View view;
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
  }

  @Override
  @CallSuper
  public void unbind() {
    AllPrintTypePopup target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv_list_type = null;
    target.ib_button_close_popup = null;

    view2131296370.setOnClickListener(null);
    view2131296370 = null;
  }
}
