package mpsoftware.ltd.smsforlife.Fragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mpsoftware.ltd.smsforlife.Adapter.FullSMSViewPagerAdapter;
import mpsoftware.ltd.smsforlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FullSMSFragment extends Fragment {


    private ViewPager mPager;
    private FullSMSViewPagerAdapter mPagerAdapter;
    private Bundle mBundleSMS;
    private List<String> mStringArray;
    private int mCurrentPage;

    public FullSMSFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_full_sms, container, false);
        mPager = (ViewPager)view.findViewById(R.id.viewpagerFullSMS);
        mStringArray = new ArrayList<>();
        mBundleSMS = new Bundle();
        mBundleSMS = getArguments();
        mStringArray = mBundleSMS.getStringArrayList("smsArray");
        mCurrentPage = mBundleSMS.getInt("smsPosition");

        mPagerAdapter = new FullSMSViewPagerAdapter(getFragmentManager(), mStringArray, getActivity());
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(mCurrentPage);

        return view;
    }

}
