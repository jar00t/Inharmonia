// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Search;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchActivity_ViewBinding implements Unbinder {
  private SearchActivity target;

  private View view2131296366;

  private View view2131296368;

  @UiThread
  public SearchActivity_ViewBinding(SearchActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchActivity_ViewBinding(final SearchActivity target, View source) {
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
    view = Utils.findRequiredView(source, R.id.ib_button_clear, "field 'ib_button_clear' and method 'clear'");
    target.ib_button_clear = Utils.castView(view, R.id.ib_button_clear, "field 'ib_button_clear'", ImageButton.class);
    view2131296368 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.clear();
      }
    });
    target.et_input_search = Utils.findRequiredViewAsType(source, R.id.et_input_search, "field 'et_input_search'", EditText.class);
    target.rv_list_store = Utils.findRequiredViewAsType(source, R.id.rv_list_store, "field 'rv_list_store'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ib_button_back = null;
    target.ib_button_clear = null;
    target.et_input_search = null;
    target.rv_list_store = null;

    view2131296366.setOnClickListener(null);
    view2131296366 = null;
    view2131296368.setOnClickListener(null);
    view2131296368 = null;
  }
}
