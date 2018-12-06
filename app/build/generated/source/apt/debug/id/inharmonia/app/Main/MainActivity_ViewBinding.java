// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.mBottomNavigationView = Utils.findRequiredViewAsType(source, R.id.navigation, "field 'mBottomNavigationView'", BottomNavigationView.class);
    target.mViewPager = Utils.findRequiredViewAsType(source, R.id.fragment_container, "field 'mViewPager'", ViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBottomNavigationView = null;
    target.mViewPager = null;
  }
}
