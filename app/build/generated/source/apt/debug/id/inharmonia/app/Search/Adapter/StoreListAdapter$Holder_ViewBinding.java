// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Search.Adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StoreListAdapter$Holder_ViewBinding implements Unbinder {
  private StoreListAdapter.Holder target;

  @UiThread
  public StoreListAdapter$Holder_ViewBinding(StoreListAdapter.Holder target, View source) {
    this.target = target;

    target.tv_name = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tv_name'", TextView.class);
    target.tv_address = Utils.findRequiredViewAsType(source, R.id.tv_address, "field 'tv_address'", TextView.class);
    target.cv_item_type = Utils.findRequiredViewAsType(source, R.id.cv_item, "field 'cv_item_type'", CardView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StoreListAdapter.Holder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_name = null;
    target.tv_address = null;
    target.cv_item_type = null;
  }
}
