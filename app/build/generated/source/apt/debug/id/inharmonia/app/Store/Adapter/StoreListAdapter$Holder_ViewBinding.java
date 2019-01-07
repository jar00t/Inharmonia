// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Store.Adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StoreListAdapter$Holder_ViewBinding implements Unbinder {
  private StoreListAdapter.Holder target;

  private View view2131296384;

  @UiThread
  public StoreListAdapter$Holder_ViewBinding(final StoreListAdapter.Holder target, View source) {
    this.target = target;

    View view;
    target.iv_store_picture = Utils.findRequiredViewAsType(source, R.id.iv_store_picture, "field 'iv_store_picture'", ImageView.class);
    target.tv_store_name = Utils.findRequiredViewAsType(source, R.id.tv_store_name, "field 'tv_store_name'", TextView.class);
    target.tv_store_location = Utils.findRequiredViewAsType(source, R.id.tv_store_location, "field 'tv_store_location'", TextView.class);
    target.tv_cost = Utils.findRequiredViewAsType(source, R.id.tv_cost, "field 'tv_cost'", TextView.class);
    target.iv_free_ongkir = Utils.findRequiredViewAsType(source, R.id.iv_free_ongkir, "field 'iv_free_ongkir'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.iv_button_favorite, "field 'iv_button_favorite' and method 'toggle_favorite'");
    target.iv_button_favorite = Utils.castView(view, R.id.iv_button_favorite, "field 'iv_button_favorite'", ImageView.class);
    view2131296384 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.toggle_favorite();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    StoreListAdapter.Holder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.iv_store_picture = null;
    target.tv_store_name = null;
    target.tv_store_location = null;
    target.tv_cost = null;
    target.iv_free_ongkir = null;
    target.iv_button_favorite = null;

    view2131296384.setOnClickListener(null);
    view2131296384 = null;
  }
}
