package id.inharmonia.app.Main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.inharmonia.app.Main.Pages.Account.AccountFragment;
import id.inharmonia.app.Main.Pages.Home.HomeFragment;
import id.inharmonia.app.Main.Pages.Order.OrderFragment;
import id.inharmonia.app.R;
import id.inharmonia.app.Main.Adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bnv_navigation)
    BottomNavigationView bnv_navigation;

    @BindView(R.id.vp_fragment_container)
    ViewPager vp_fragment_container;

    MenuItem prev_menu_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        bnv_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        vp_fragment_container.setCurrentItem(0);
                        break;
                    case R.id.navigation_order:
                        vp_fragment_container.setCurrentItem(1);
                        break;
                    case R.id.navigation_account:
                        vp_fragment_container.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });

        vp_fragment_container.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prev_menu_item != null) {
                    prev_menu_item.setChecked(false);
                } else {
                    bnv_navigation.getMenu().getItem(0).setChecked(false);
                }
                bnv_navigation.getMenu().getItem(position).setChecked(true);
                prev_menu_item = bnv_navigation.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(vp_fragment_container);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new OrderFragment());
        adapter.addFragment(new AccountFragment());
        viewPager.setAdapter(adapter);
    }

}
