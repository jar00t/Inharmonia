// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Lists;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.inharmonia.app.Main.Pages.Home.Lists.Quantity.QuantityListAdapter;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class QuantityListAdapter$QuantityListViewHolder_ViewBinding implements Unbinder {
  private QuantityListAdapter.QuantityListViewHolder target;

  @UiThread
  public QuantityListAdapter$QuantityListViewHolder_ViewBinding(QuantityListAdapter.QuantityListViewHolder target,
      View source) {
    this.target = target;

    target.mName = Utils.findRequiredViewAsType(source, R.id.tvName, "field 'mName'", TextView.class);
    target.mTotal = Utils.findRequiredViewAsType(source, R.id.tvTotal, "field 'mTotal'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    QuantityListAdapter.QuantityListViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mName = null;
    target.mTotal = null;
  }
}
