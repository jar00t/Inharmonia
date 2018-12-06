// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.inharmonia.app.Main.Pages.Home.Lists.MainMenu.MainMenuAdapter;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainMenuAdapter$MenuViewHolder_ViewBinding implements Unbinder {
  private MainMenuAdapter.MenuViewHolder target;

  @UiThread
  public MainMenuAdapter$MenuViewHolder_ViewBinding(MainMenuAdapter.MenuViewHolder target,
      View source) {
    this.target = target;

    target.layoutBottomSheet = Utils.findRequiredViewAsType(source, R.id.bottom_sheet, "field 'layoutBottomSheet'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainMenuAdapter.MenuViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.layoutBottomSheet = null;
  }
}
