// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Search.Lists.Store;

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

public class StoreListAdapter$StoreListViewHolder_ViewBinding implements Unbinder {
  private StoreListAdapter.StoreListViewHolder target;

  @UiThread
  public StoreListAdapter$StoreListViewHolder_ViewBinding(StoreListAdapter.StoreListViewHolder target,
      View source) {
    this.target = target;

    target.mStoreName = Utils.findRequiredViewAsType(source, R.id.tvStoreName, "field 'mStoreName'", TextView.class);
    target.mStoreAddress = Utils.findRequiredViewAsType(source, R.id.tvStoreAddress, "field 'mStoreAddress'", TextView.class);
    target.mMenuItem = Utils.findRequiredViewAsType(source, R.id.cvMenuItem, "field 'mMenuItem'", CardView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StoreListAdapter.StoreListViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mStoreName = null;
    target.mStoreAddress = null;
    target.mMenuItem = null;
  }
}
