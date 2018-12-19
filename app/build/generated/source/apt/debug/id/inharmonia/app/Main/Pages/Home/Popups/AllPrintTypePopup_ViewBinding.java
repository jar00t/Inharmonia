// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Popups;

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

  private View view2131296357;

  @UiThread
  public AllPrintTypePopup_ViewBinding(final AllPrintTypePopup target, View source) {
    this.target = target;

    View view;
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_type_list, "field 'mRecyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.ibClosePopup, "field 'mClosePopup' and method 'hideMe'");
    target.mClosePopup = Utils.castView(view, R.id.ibClosePopup, "field 'mClosePopup'", ImageButton.class);
    view2131296357 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.hideMe();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    AllPrintTypePopup target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.mClosePopup = null;

    view2131296357.setOnClickListener(null);
    view2131296357 = null;
  }
}
