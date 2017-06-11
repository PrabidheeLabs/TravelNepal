package com.prabidhee.www.travelnepalv2;

import android.support.design.widget.TabLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;


import com.prabidhee.www.travelnepalv2.fragment.HomeFragment;
import com.prabidhee.www.travelnepalv2.fragment.PlacesFragment;
import com.prabidhee.www.travelnepalv2.fragment.AdventureFragment;
import com.prabidhee.www.travelnepalv2.fragment.ShopFragment;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar_draw;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        toolbar_draw=(Toolbar) findViewById(R.id.toolbar_draw) ;
        setSupportActionBar(toolbar_draw);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        tabLayout.setupWithViewPager(viewPager);

        setupViewPager(viewPager);
        setIconForTabs();
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment) {
            mFragmentList.add(fragment);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }

    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment());
        adapter.addFrag(new PlacesFragment());
        adapter.addFrag(new AdventureFragment());
        adapter.addFrag(new ShopFragment());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        getSupportActionBar().setTitle("Home");
                        break;
                    case 1:
                        getSupportActionBar().setTitle("Places");
                        break;
                    case 2:
                        getSupportActionBar().setTitle("Adventures");
                        break;
                    case 3:
                        getSupportActionBar().setTitle("Nearby");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setIconForTabs() {

        int[] tabIcons = {
                R.mipmap.ic_home,
                R.mipmap.ic_shoppingcart,
                R.mipmap.ic_home,
                R.mipmap.ic_shoppingcart,
        };

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
    }
}
