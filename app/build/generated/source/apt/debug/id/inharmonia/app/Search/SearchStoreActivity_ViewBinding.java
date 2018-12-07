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

public class SearchStoreActivity_ViewBinding implements Unbinder {
  private SearchStoreActivity target;

  private View view2131230814;

  private View view2131230815;

  @UiThread
  public SearchStoreActivity_ViewBinding(SearchStoreActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchStoreActivity_ViewBinding(final SearchStoreActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ibBackButton, "field 'mBackButton' and method 'exit'");
    target.mBackButton = Utils.castView(view, R.id.ibBackButton, "field 'mBackButton'", ImageButton.class);
    view2131230814 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.exit();
      }
    });
    view = Utils.findRequiredView(source, R.id.ibClearButton, "field 'mClearButton' and method 'clear'");
    target.mClearButton = Utils.castView(view, R.id.ibClearButton, "field 'mClearButton'", ImageButton.class);
    view2131230815 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.clear();
      }
    });
    target.mSearchInput = Utils.findRequiredViewAsType(source, R.id.etSearchInput, "field 'mSearchInput'", EditText.class);
    target.mStoreList = Utils.findRequiredViewAsType(source, R.id.lvStoreList, "field 'mStoreList'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchStoreActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackButton = null;
    target.mClearButton = null;
    target.mSearchInput = null;
    target.mStoreList = null;

    view2131230814.setOnClickListener(null);
    view2131230814 = null;
    view2131230815.setOnClickListener(null);
    view2131230815 = null;
  }
}
