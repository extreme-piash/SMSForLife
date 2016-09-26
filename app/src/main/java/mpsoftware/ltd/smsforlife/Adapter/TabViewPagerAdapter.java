package mpsoftware.ltd.smsforlife.Adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentStatePagerAdapter;

import mpsoftware.ltd.smsforlife.Fragment.BanglaSMSFragment;
import mpsoftware.ltd.smsforlife.Fragment.EnglishSMSFragment;

/**
 * Created by piash on 9/25/16.
 */

public class TabViewPagerAdapter extends FragmentStatePagerAdapter {

    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { " বাংলা", "English" };
    private Context context;

    public TabViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new BanglaSMSFragment();
            case 1:
                return new EnglishSMSFragment();
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        /*switch (position) {
            case 0:
                return "Home";
            case 1:
                return "Crazy";
        }
        return null;*/

        return tabTitles[position];
    }
}
