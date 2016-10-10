package mpsoftware.ltd.smsforlife.Adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentStatePagerAdapter;

import mpsoftware.ltd.smsforlife.Fragment.BanglaSMSFragment;
import mpsoftware.ltd.smsforlife.Fragment.BanglaWishlistFragment;
import mpsoftware.ltd.smsforlife.Fragment.EnglishSMSFragment;
import mpsoftware.ltd.smsforlife.Fragment.EnglishWishlistFragment;

/**
 * Created by piash on 10/11/16.
 */

public class TabViewPagerWishlistAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    public TabViewPagerWishlistAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new BanglaWishlistFragment();
            case 1:
                return new EnglishWishlistFragment();
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return " বাংলা";
            case 1:
                return "English";
        }
        return null;
    }

}
