package com.example.android.phonecalltest;

/**
 * Created by khanh on 12/11/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
//        return new TabFragment();
        // Which Fragment should be dislpayed by the viewpager for the given position
        // In my case we are showing up only one fragment in all the three tabs so we are
        // not worrying about the position and just returning the TabFragment
        switch (position) {
            case 0:
                HomeFragment tab1 = new HomeFragment();
                return tab1;
            case 1:
                TabFragment tab2 = new TabFragment();
                return tab2;
            case 2:
                TabFragment tab3 = new TabFragment();
                return tab3;
            case 3:
                TabFragment tab4 = new TabFragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;           // As there are only 3 Tabs
    }
}

