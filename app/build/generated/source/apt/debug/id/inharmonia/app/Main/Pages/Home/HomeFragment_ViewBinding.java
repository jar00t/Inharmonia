// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Home;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
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

  private View view2131296367;

  private View view2131296526;

  @UiThread
  public HomeFragment_ViewBinding(final HomeFragment target, View source) {
    this.target = target;

    View view;
    target.sv_content_home = Utils.findRequiredViewAsType(source, R.id.sv_content_home, "field 'sv_content_home'", ScrollView.class);
    target.rv_list_moni_trans = Utils.findRequiredViewAsType(source, R.id.rv_list_moni_trans, "field 'rv_list_moni_trans'", RecyclerView.class);
    target.rv_list_moni_print = Utils.findRequiredViewAsType(source, R.id.rv_list_moni_print, "field 'rv_list_moni_print'", RecyclerView.class);
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
    view2131296367 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.open_cart();
      }
    });
    target.tv_cart_total = Utils.findRequiredViewAsType(source, R.id.tv_cart_total, "field 'tv_cart_total'", TextView.class);
    target.cl_promo_slide = Utils.findRequiredViewAsType(source, R.id.cl_promo_slide, "field 'cl_promo_slide'", CarouselView.class);
    target.tv_link_more_moni_trans = Utils.findRequiredViewAsType(source, R.id.tv_link_more_moni_trans, "field 'tv_link_more_moni_trans'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_link_more_moni_print, "field 'tv_link_more_moni_print' and method 'more_moni_print'");
    target.tv_link_more_moni_print = Utils.castView(view, R.id.tv_link_more_moni_print, "field 'tv_link_more_moni_print'", TextView.class);
    view2131296526 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.more_moni_print();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.sv_content_home = null;
    target.rv_list_moni_trans = null;
    target.rv_list_moni_print = null;
    target.cv_button_search = null;
    target.ib_button_cart = null;
    target.tv_cart_total = null;
    target.cl_promo_slide = null;
    target.tv_link_more_moni_trans = null;
    target.tv_link_more_moni_print = null;

    view2131296321.setOnClickListener(null);
    view2131296321 = null;
    view2131296367.setOnClickListener(null);
    view2131296367 = null;
    view2131296526.setOnClickListener(null);
    view2131296526 = null;
  }
}
