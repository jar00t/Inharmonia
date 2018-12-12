// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.synnapps.carouselview.CarouselView;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding implements Unbinder {
  private HomeFragment target;

  private View view2131296356;

  @UiThread
  public HomeFragment_ViewBinding(final HomeFragment target, View source) {
    this.target = target;

    View view;
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_menu_list, "field 'mRecyclerView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.ibSearchOpener, "field 'mSearchOpener' and method 'openSearch'");
    target.mSearchOpener = Utils.castView(view, R.id.ibSearchOpener, "field 'mSearchOpener'", ImageButton.class);
    view2131296356 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.openSearch();
      }
    });
    target.mPromoSlider = Utils.findRequiredViewAsType(source, R.id.clPromoSlide, "field 'mPromoSlider'", CarouselView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.mSearchOpener = null;
    target.mPromoSlider = null;

    view2131296356.setOnClickListener(null);
    view2131296356 = null;
  }
}
