// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Lists.MainMenu;

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

public class MainMenuAdapter$MenuViewHolder_ViewBinding implements Unbinder {
  private MainMenuAdapter.MenuViewHolder target;

  private View view2131296313;

  @UiThread
  public MainMenuAdapter$MenuViewHolder_ViewBinding(final MainMenuAdapter.MenuViewHolder target,
      View source) {
    this.target = target;

    View view;
    target.mTitle = Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'mTitle'", TextView.class);
    target.mIcon = Utils.findRequiredViewAsType(source, R.id.ivIcon, "field 'mIcon'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.cvMenuItem, "field 'mMenuItem' and method 'goTo'");
    target.mMenuItem = Utils.castView(view, R.id.cvMenuItem, "field 'mMenuItem'", CardView.class);
    view2131296313 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.goTo();
      }
    });
    target.mLabelCorner = Utils.findRequiredViewAsType(source, R.id.ivLabelCorner, "field 'mLabelCorner'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainMenuAdapter.MenuViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTitle = null;
    target.mIcon = null;
    target.mMenuItem = null;
    target.mLabelCorner = null;

    view2131296313.setOnClickListener(null);
    view2131296313 = null;
  }
}
