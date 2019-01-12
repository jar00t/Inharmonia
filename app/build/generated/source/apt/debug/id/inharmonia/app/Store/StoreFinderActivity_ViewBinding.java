// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Store;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StoreFinderActivity_ViewBinding implements Unbinder {
  private StoreFinderActivity target;

  private View view2131296370;

  private View view2131296356;

  private View view2131296358;

  private View view2131296359;

  private View view2131296392;

  @UiThread
  public StoreFinderActivity_ViewBinding(StoreFinderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public StoreFinderActivity_ViewBinding(final StoreFinderActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ib_button_back, "field 'ib_button_back' and method 'exit'");
    target.ib_button_back = Utils.castView(view, R.id.ib_button_back, "field 'ib_button_back'", ImageButton.class);
    view2131296370 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.exit();
      }
    });
    target.tv_page_name = Utils.findRequiredViewAsType(source, R.id.tv_page_name, "field 'tv_page_name'", TextView.class);
    target.rv_list_store = Utils.findRequiredViewAsType(source, R.id.rv_list_store, "field 'rv_list_store'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.fl_button_filter, "field 'fl_button_filter' and method 'open_filter'");
    target.fl_button_filter = Utils.castView(view, R.id.fl_button_filter, "field 'fl_button_filter'", FrameLayout.class);
    view2131296356 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.open_filter();
      }
    });
    view = Utils.findRequiredView(source, R.id.fl_button_sort_by, "field 'fl_button_sort_by' and method 'show_sort_by'");
    target.fl_button_sort_by = Utils.castView(view, R.id.fl_button_sort_by, "field 'fl_button_sort_by'", FrameLayout.class);
    view2131296358 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.show_sort_by();
      }
    });
    view = Utils.findRequiredView(source, R.id.fl_button_switch_layout, "field 'fl_button_switch_layout' and method 'switch_layout'");
    target.fl_button_switch_layout = Utils.castView(view, R.id.fl_button_switch_layout, "field 'fl_button_switch_layout'", FrameLayout.class);
    view2131296359 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.switch_layout();
      }
    });
    view = Utils.findRequiredView(source, R.id.iv_button_toggle_sort_by, "field 'iv_button_toggle_sort_by' and method 'toggle_sort_by'");
    target.iv_button_toggle_sort_by = Utils.castView(view, R.id.iv_button_toggle_sort_by, "field 'iv_button_toggle_sort_by'", ImageView.class);
    view2131296392 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toggle_sort_by();
      }
    });
    target.iv_button_toggle_layout = Utils.findRequiredViewAsType(source, R.id.iv_button_toggle_layout, "field 'iv_button_toggle_layout'", ImageView.class);
    target.tv_sort_by = Utils.findRequiredViewAsType(source, R.id.tv_sort_by, "field 'tv_sort_by'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StoreFinderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ib_button_back = null;
    target.tv_page_name = null;
    target.rv_list_store = null;
    target.fl_button_filter = null;
    target.fl_button_sort_by = null;
    target.fl_button_switch_layout = null;
    target.iv_button_toggle_sort_by = null;
    target.iv_button_toggle_layout = null;
    target.tv_sort_by = null;

    view2131296370.setOnClickListener(null);
    view2131296370 = null;
    view2131296356.setOnClickListener(null);
    view2131296356 = null;
    view2131296358.setOnClickListener(null);
    view2131296358 = null;
    view2131296359.setOnClickListener(null);
    view2131296359 = null;
    view2131296392.setOnClickListener(null);
    view2131296392 = null;
  }
}
