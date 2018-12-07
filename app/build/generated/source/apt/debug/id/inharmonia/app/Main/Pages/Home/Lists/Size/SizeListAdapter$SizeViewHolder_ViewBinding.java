// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Lists.Size;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SizeListAdapter$SizeViewHolder_ViewBinding implements Unbinder {
  private SizeListAdapter.SizeViewHolder target;

  @UiThread
  public SizeListAdapter$SizeViewHolder_ViewBinding(SizeListAdapter.SizeViewHolder target,
      View source) {
    this.target = target;

    target.mIcon = Utils.findRequiredViewAsType(source, R.id.ivIcon, "field 'mIcon'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SizeListAdapter.SizeViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mIcon = null;
  }
}
