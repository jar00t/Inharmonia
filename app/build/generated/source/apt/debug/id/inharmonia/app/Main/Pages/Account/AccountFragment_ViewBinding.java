// Generated code from Butter Knife. Do not modify!
package id.inharmonia.app.Main.Pages.Account;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.inharmonia.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AccountFragment_ViewBinding implements Unbinder {
  private AccountFragment target;

  @UiThread
  public AccountFragment_ViewBinding(AccountFragment target, View source) {
    this.target = target;

    target.mUserFullName = Utils.findRequiredViewAsType(source, R.id.tvUserFullName, "field 'mUserFullName'", TextView.class);
    target.mUserEmail = Utils.findRequiredViewAsType(source, R.id.tvUserEmail, "field 'mUserEmail'", TextView.class);
    target.mAppName = Utils.findRequiredViewAsType(source, R.id.tvAppName, "field 'mAppName'", TextView.class);
    target.mAppVersion = Utils.findRequiredViewAsType(source, R.id.tvAppVersion, "field 'mAppVersion'", TextView.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.rv_menu_link_list, "field 'mRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AccountFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mUserFullName = null;
    target.mUserEmail = null;
    target.mAppName = null;
    target.mAppVersion = null;
    target.mRecyclerView = null;
  }
}
