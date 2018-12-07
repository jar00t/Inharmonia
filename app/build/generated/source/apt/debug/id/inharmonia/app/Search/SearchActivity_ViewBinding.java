// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Search;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchActivity_ViewBinding implements Unbinder {
  private SearchActivity target;

  private View view2131230814;

  private View view2131230815;

  private View view2131230955;

  private View view2131230965;

  private View view2131230954;

  @UiThread
  public SearchActivity_ViewBinding(SearchActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchActivity_ViewBinding(final SearchActivity target, View source) {
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
    target.mKeywordList = Utils.findRequiredViewAsType(source, R.id.lvKeywordList, "field 'mKeywordList'", ListView.class);
    target.mStoreList = Utils.findRequiredViewAsType(source, R.id.lvStoreList, "field 'mStoreList'", ListView.class);
    target.mDesignerList = Utils.findRequiredViewAsType(source, R.id.lvDesignerList, "field 'mDesignerList'", ListView.class);
    view = Utils.findRequiredView(source, R.id.tvKeywordListMore, "field 'mKeywordListMore' and method 'moreKeywordList'");
    target.mKeywordListMore = Utils.castView(view, R.id.tvKeywordListMore, "field 'mKeywordListMore'", TextView.class);
    view2131230955 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.moreKeywordList();
      }
    });
    view = Utils.findRequiredView(source, R.id.tvStoreListMore, "field 'mStoreListMore' and method 'moreStoreList'");
    target.mStoreListMore = Utils.castView(view, R.id.tvStoreListMore, "field 'mStoreListMore'", TextView.class);
    view2131230965 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.moreStoreList();
      }
    });
    view = Utils.findRequiredView(source, R.id.tvDesignerListMore, "field 'mDesignerListMore' and method 'moreDesignerList'");
    target.mDesignerListMore = Utils.castView(view, R.id.tvDesignerListMore, "field 'mDesignerListMore'", TextView.class);
    view2131230954 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.moreDesignerList();
      }
    });
    target.mListTitleStore = Utils.findRequiredViewAsType(source, R.id.tvListTitleStore, "field 'mListTitleStore'", TextView.class);
    target.mListTitleDesigner = Utils.findRequiredViewAsType(source, R.id.tvListTitleDesigner, "field 'mListTitleDesigner'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBackButton = null;
    target.mClearButton = null;
    target.mSearchInput = null;
    target.mKeywordList = null;
    target.mStoreList = null;
    target.mDesignerList = null;
    target.mKeywordListMore = null;
    target.mStoreListMore = null;
    target.mDesignerListMore = null;
    target.mListTitleStore = null;
    target.mListTitleDesigner = null;

    view2131230814.setOnClickListener(null);
    view2131230814 = null;
    view2131230815.setOnClickListener(null);
    view2131230815 = null;
    view2131230955.setOnClickListener(null);
    view2131230955 = null;
    view2131230965.setOnClickListener(null);
    view2131230965 = null;
    view2131230954.setOnClickListener(null);
    view2131230954 = null;
  }
}
