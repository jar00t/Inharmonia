// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Store.Adapter;

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

public class SortByListAdapter$Holder_ViewBinding implements Unbinder {
  private SortByListAdapter.Holder target;

  private View view2131296325;

  @UiThread
  public SortByListAdapter$Holder_ViewBinding(final SortByListAdapter.Holder target, View source) {
    this.target = target;

    View view;
    target.tv_title = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tv_title'", TextView.class);
    target.iv_icon = Utils.findRequiredViewAsType(source, R.id.iv_icon, "field 'iv_icon'", ImageView.class);
    target.iv_sign = Utils.findRequiredViewAsType(source, R.id.iv_sign, "field 'iv_sign'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.cv_item, "field 'cv_item' and method 'select_it'");
    target.cv_item = Utils.castView(view, R.id.cv_item, "field 'cv_item'", CardView.class);
    view2131296325 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.select_it();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    SortByListAdapter.Holder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_title = null;
    target.iv_icon = null;
    target.iv_sign = null;
    target.cv_item = null;

    view2131296325.setOnClickListener(null);
    view2131296325 = null;
  }
}
