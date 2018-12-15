// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home.Lists.Size;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SizeListAdapter$SizeViewHolder_ViewBinding implements Unbinder {
  private SizeListAdapter.SizeViewHolder target;

  private View view2131296356;

  private View view2131296357;

  private View view2131296331;

  @UiThread
  public SizeListAdapter$SizeViewHolder_ViewBinding(final SizeListAdapter.SizeViewHolder target,
      View source) {
    this.target = target;

    View view;
    target.mIcon = Utils.findRequiredViewAsType(source, R.id.ivIcon, "field 'mIcon'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.ibDecreaseButton, "field 'mDecreaseButton' and method 'decreaseValue'");
    target.mDecreaseButton = Utils.castView(view, R.id.ibDecreaseButton, "field 'mDecreaseButton'", ImageButton.class);
    view2131296356 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.decreaseValue();
      }
    });
    view = Utils.findRequiredView(source, R.id.ibIncreaseButton, "field 'mIncreaseButton' and method 'increaseValue'");
    target.mIncreaseButton = Utils.castView(view, R.id.ibIncreaseButton, "field 'mIncreaseButton'", ImageButton.class);
    view2131296357 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.increaseValue();
      }
    });
    view = Utils.findRequiredView(source, R.id.etNumberValue, "field 'mNumberValue' and method 'focusMe'");
    target.mNumberValue = Utils.castView(view, R.id.etNumberValue, "field 'mNumberValue'", EditText.class);
    view2131296331 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.focusMe();
      }
    });
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

    view2131296356.setOnClickListener(null);
    view2131296356 = null;
    view2131296357.setOnClickListener(null);
    view2131296357 = null;
    view2131296331.setOnClickListener(null);
    view2131296331 = null;
  }
}
