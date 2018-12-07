// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Search;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchDesignerActivity_ViewBinding implements Unbinder {
  private SearchDesignerActivity target;

  private View view2131230812;

  private View view2131230813;

  @UiThread
  public SearchDesignerActivity_ViewBinding(SearchDesignerActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchDesignerActivity_ViewBinding(final SearchDesignerActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ibBackButton, "field 'mBackButton' and method 'exit'");
    target.mBackButton = Utils.castView(view, R.id.ibBackButton, "field 'mBackButton'", ImageButton.class);
    view2131230812 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.exit();
      }
    });
    view = Utils.findRequiredView(source, R.id.ibClearButton, "field 'mClearButton' and method 'clear'");
    target.mClearButton = Utils.castView(view, R.id.ibClearButton, "field 'mClearButton'", ImageButton.class);
    view2131230813 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.clear();
      }
    });
    target.mSearchInput = Utils.findRequiredViewAsType(source, R.id.etSearchInput, "field 'mSearchInput'", EditText.class);
    target.mDesignerList = Utils.findRequiredViewAsType(source, R.id.lvDesignerList, "field 'mDesignerList'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchDesignerActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackButton = null;
    target.mClearButton = null;
    target.mSearchInput = null;
    target.mDesignerList = null;

    view2131230812.setOnClickListener(null);
    view2131230812 = null;
    view2131230813.setOnClickListener(null);
    view2131230813 = null;
  }
}
