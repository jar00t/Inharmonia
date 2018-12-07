// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Account.Lists.Menu;

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

public class MenuAdapter$MenuViewHolder_ViewBinding implements Unbinder {
  private MenuAdapter.MenuViewHolder target;

  private View view2131230778;

  @UiThread
  public MenuAdapter$MenuViewHolder_ViewBinding(final MenuAdapter.MenuViewHolder target,
      View source) {
    this.target = target;

    View view;
    target.mTitle = Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'mTitle'", TextView.class);
    target.mIcon = Utils.findRequiredViewAsType(source, R.id.ivIcon, "field 'mIcon'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.cvMenuItem, "field 'mMenuItem' and method 'goTo'");
    target.mMenuItem = Utils.castView(view, R.id.cvMenuItem, "field 'mMenuItem'", CardView.class);
    view2131230778 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.goTo();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MenuAdapter.MenuViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTitle = null;
    target.mIcon = null;
    target.mMenuItem = null;

    view2131230778.setOnClickListener(null);
    view2131230778 = null;
  }
}
