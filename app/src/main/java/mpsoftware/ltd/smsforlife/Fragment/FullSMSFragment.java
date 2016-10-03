package mpsoftware.ltd.smsforlife.Fragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
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

    TextView textViewFullSMS;
    private static final int NUM_PAGES = 5;
    private ViewPager mPager;
    private FullSMSViewPagerAdapter mPagerAdapter;
    private List<String> mStringArray;

    public FullSMSFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_full_sms, container, false);

       // textViewFullSMS = (TextView)view.findViewById(R.id.textViewFullSMS);
       // getSMS();
        mStringArray = new ArrayList<>();

        for (int i = 0; i <10 ; i++) {
            mStringArray.add("right"+i);
        }


        mPager = (ViewPager)view.findViewById(R.id.viewpagerFullSMS);
        mPagerAdapter = new FullSMSViewPagerAdapter(getFragmentManager(), mStringArray, getActivity());
        mPager.setAdapter(mPagerAdapter);

        return view;
    }
    public void getSMS(){
        Bundle bundleSMS = new Bundle();

        bundleSMS = getArguments();
        String fullSMS = bundleSMS.getString("fullSMS");
        textViewFullSMS.setText(fullSMS);
       // Toast.makeText(getActivity(), bundleSMS.getString("fullSMS"),Toast.LENGTH_SHORT).show();
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new ScreenSlidePageFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}
