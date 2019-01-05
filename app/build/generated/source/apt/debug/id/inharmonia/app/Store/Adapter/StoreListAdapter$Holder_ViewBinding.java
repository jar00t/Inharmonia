// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Store.Adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
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

    target.iv_store_picture = Utils.findRequiredViewAsType(source, R.id.iv_store_picture, "field 'iv_store_picture'", ImageView.class);
    target.tv_store_name = Utils.findRequiredViewAsType(source, R.id.tv_store_name, "field 'tv_store_name'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StoreListAdapter.Holder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.iv_store_picture = null;
    target.tv_store_name = null;
  }
}
