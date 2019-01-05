// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Setting;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingActivity_ViewBinding implements Unbinder {
  private SettingActivity target;

  private View view2131296366;

  @UiThread
  public SettingActivity_ViewBinding(SettingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SettingActivity_ViewBinding(final SettingActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ib_button_back, "field 'ib_button_back' and method 'exit'");
    target.ib_button_back = Utils.castView(view, R.id.ib_button_back, "field 'ib_button_back'", ImageButton.class);
    view2131296366 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.exit();
      }
    });
    target.tv_page_name = Utils.findRequiredViewAsType(source, R.id.tv_page_name, "field 'tv_page_name'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SettingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ib_button_back = null;
    target.tv_page_name = null;

    view2131296366.setOnClickListener(null);
    view2131296366 = null;
  }
}
