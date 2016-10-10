package mpsoftware.ltd.smsforlife.Adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentStatePagerAdapter;

import java.util.List;

import mpsoftware.ltd.smsforlife.Fragment.ScreenSlidePageFragment;

/**
 * Created by piash on 10/3/16.
 */

public class FullSMSViewPagerAdapter extends FragmentStatePagerAdapter {
    private int NUM_PAGES = 5;
    private List<String > mSMSArrayList;
    private Context mContext;
    private int mTotalCount;
    private String mSMSTrack;

    public FullSMSViewPagerAdapter(FragmentManager fm, List<String> mSMSArrayList,int totalCount, String smsTrack, Context mContext) {
        super(fm);
        this.mSMSArrayList = mSMSArrayList;
        this.mContext = mContext;
        this.mTotalCount = totalCount;
        this.mSMSTrack = smsTrack;
    }

    @Override
    public Fragment getItem(int position) {
        return new ScreenSlidePageFragment().newInstance(position, mTotalCount, mSMSTrack, mSMSArrayList.get(position));
    }

    @Override
    public int getCount() {
        return mSMSArrayList.size();
    }
}
