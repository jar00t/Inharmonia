// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Lists.Type;

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

public class TypeListAdapter$TypeViewHolder_ViewBinding implements Unbinder {
  private TypeListAdapter.TypeViewHolder target;

  private View view2131230776;

  @UiThread
  public TypeListAdapter$TypeViewHolder_ViewBinding(final TypeListAdapter.TypeViewHolder target,
      View source) {
    this.target = target;

    View view;
    target.mTitle = Utils.findRequiredViewAsType(source, R.id.tvTitle, "field 'mTitle'", TextView.class);
    target.mIcon = Utils.findRequiredViewAsType(source, R.id.ivIcon, "field 'mIcon'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.cvMenuItem, "field 'mTypeItem' and method 'showAll'");
    target.mTypeItem = Utils.castView(view, R.id.cvMenuItem, "field 'mTypeItem'", CardView.class);
    view2131230776 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.showAll();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    TypeListAdapter.TypeViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTitle = null;
    target.mIcon = null;
    target.mTypeItem = null;

    view2131230776.setOnClickListener(null);
    view2131230776 = null;
  }
}