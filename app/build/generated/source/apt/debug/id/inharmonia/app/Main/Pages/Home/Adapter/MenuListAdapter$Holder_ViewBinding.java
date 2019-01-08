// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Adapter;

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

public class MenuListAdapter$Holder_ViewBinding implements Unbinder {
  private MoniPrintListAdapter.Holder target;

  private View view2131296324;

  @UiThread
  public MenuListAdapter$Holder_ViewBinding(final MoniPrintListAdapter.Holder target, View source) {
    this.target = target;

    View view;
    target.tv_title = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tv_title'", TextView.class);
    target.iv_icon = Utils.findRequiredViewAsType(source, R.id.iv_icon, "field 'iv_icon'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.cv_item, "field 'cv_item_menu' and method 'go_to'");
    target.cv_item_menu = Utils.castView(view, R.id.cv_item, "field 'cv_item_menu'", CardView.class);
    view2131296324 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.go_to();
      }
    });
    target.iv_label_corner = Utils.findRequiredViewAsType(source, R.id.iv_label_corner, "field 'iv_label_corner'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MoniPrintListAdapter.Holder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_title = null;
    target.iv_icon = null;
    target.cv_item_menu = null;
    target.iv_label_corner = null;

    view2131296324.setOnClickListener(null);
    view2131296324 = null;
  }
}
