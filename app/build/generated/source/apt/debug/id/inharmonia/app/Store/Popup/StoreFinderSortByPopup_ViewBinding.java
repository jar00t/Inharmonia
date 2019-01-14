// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Store.Popup;

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

public class StoreFinderSortByPopup_ViewBinding implements Unbinder {
  private StoreFinderSortByPopup target;

  private View view2131296373;

  @UiThread
  public StoreFinderSortByPopup_ViewBinding(final StoreFinderSortByPopup target, View source) {
    this.target = target;

    View view;
    target.rv_list_sort_by = Utils.findRequiredViewAsType(source, R.id.rv_list_sort_by, "field 'rv_list_sort_by'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.ib_button_close_popup, "field 'ib_button_close_popup' and method 'hide_me'");
    target.ib_button_close_popup = Utils.castView(view, R.id.ib_button_close_popup, "field 'ib_button_close_popup'", ImageButton.class);
    view2131296373 = view;
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
    StoreFinderSortByPopup target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv_list_sort_by = null;
    target.ib_button_close_popup = null;

    view2131296373.setOnClickListener(null);
    view2131296373 = null;
  }
}
