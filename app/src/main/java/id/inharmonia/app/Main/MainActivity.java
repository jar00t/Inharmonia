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
import id.inharmonia.app.Main.Adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.navigation)
    BottomNavigationView mBottomNavigationView;

    @BindView(R.id.fragment_container)
    ViewPager mViewPager;

    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.navigation_order:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.navigation_account:
                        mViewPager.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    mBottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                mBottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = mBottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new OrderFragment());
        adapter.addFragment(new AccountFragment());
        viewPager.setAdapter(adapter);
    }

}
