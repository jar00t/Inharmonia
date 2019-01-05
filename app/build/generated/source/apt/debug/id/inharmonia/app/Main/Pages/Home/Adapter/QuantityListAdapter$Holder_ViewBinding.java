// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class QuantityListAdapter$Holder_ViewBinding implements Unbinder {
  private QuantityListAdapter.Holder target;

  @UiThread
  public QuantityListAdapter$Holder_ViewBinding(QuantityListAdapter.Holder target, View source) {
    this.target = target;

    target.tv_name = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tv_name'", TextView.class);
    target.tv_total = Utils.findRequiredViewAsType(source, R.id.tv_total, "field 'tv_total'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    QuantityListAdapter.Holder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_name = null;
    target.tv_total = null;
  }
}
