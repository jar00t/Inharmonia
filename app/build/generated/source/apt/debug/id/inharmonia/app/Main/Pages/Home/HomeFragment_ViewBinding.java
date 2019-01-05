// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.synnapps.carouselview.CarouselView;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeFragment_ViewBinding implements Unbinder {
  private HomeFragment target;

  private View view2131296321;

  private View view2131296364;

  @UiThread
  public HomeFragment_ViewBinding(final HomeFragment target, View source) {
    this.target = target;

    View view;
    target.rv_list_menu = Utils.findRequiredViewAsType(source, R.id.rv_list_menu, "field 'rv_list_menu'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.cv_button_search, "field 'cv_button_search' and method 'open_search'");
    target.cv_button_search = Utils.castView(view, R.id.cv_button_search, "field 'cv_button_search'", CardView.class);
    view2131296321 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.open_search();
      }
    });
    view = Utils.findRequiredView(source, R.id.ib_button_cart, "field 'ib_button_cart' and method 'open_cart'");
    target.ib_button_cart = Utils.castView(view, R.id.ib_button_cart, "field 'ib_button_cart'", ImageButton.class);
    view2131296364 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.open_cart();
      }
    });
    target.tv_cart_total = Utils.findRequiredViewAsType(source, R.id.tv_cart_total, "field 'tv_cart_total'", TextView.class);
    target.cl_promo_slide = Utils.findRequiredViewAsType(source, R.id.cl_promo_slide, "field 'cl_promo_slide'", CarouselView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rv_list_menu = null;
    target.cv_button_search = null;
    target.ib_button_cart = null;
    target.tv_cart_total = null;
    target.cl_promo_slide = null;

    view2131296321.setOnClickListener(null);
    view2131296321 = null;
    view2131296364.setOnClickListener(null);
    view2131296364 = null;
  }
}
