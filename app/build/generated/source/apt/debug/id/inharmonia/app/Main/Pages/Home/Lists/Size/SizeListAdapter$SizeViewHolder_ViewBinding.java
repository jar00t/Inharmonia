// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Lists.Size;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SizeListAdapter$SizeViewHolder_ViewBinding implements Unbinder {
  private SizeListAdapter.SizeViewHolder target;

  private View view2131230815;

  private View view2131230816;

  @UiThread
  public SizeListAdapter$SizeViewHolder_ViewBinding(final SizeListAdapter.SizeViewHolder target,
      View source) {
    this.target = target;

    View view;
    target.mIcon = Utils.findRequiredViewAsType(source, R.id.ivIcon, "field 'mIcon'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.ibDecreaseButton, "field 'mDecreaseButton' and method 'decreaseValue'");
    target.mDecreaseButton = Utils.castView(view, R.id.ibDecreaseButton, "field 'mDecreaseButton'", ImageButton.class);
    view2131230815 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.decreaseValue();
      }
    });
    view = Utils.findRequiredView(source, R.id.ibIncreaseButton, "field 'mIncreaseButton' and method 'increaseValue'");
    target.mIncreaseButton = Utils.castView(view, R.id.ibIncreaseButton, "field 'mIncreaseButton'", ImageButton.class);
    view2131230816 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.increaseValue();
      }
    });
    target.mNumberValue = Utils.findRequiredViewAsType(source, R.id.tvNumberValue, "field 'mNumberValue'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SizeListAdapter.SizeViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mIcon = null;
    target.mDecreaseButton = null;
    target.mIncreaseButton = null;
    target.mNumberValue = null;

    view2131230815.setOnClickListener(null);
    view2131230815 = null;
    view2131230816.setOnClickListener(null);
    view2131230816 = null;
  }
}
