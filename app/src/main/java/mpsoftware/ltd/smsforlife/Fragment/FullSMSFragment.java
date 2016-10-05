package mpsoftware.ltd.smsforlife.Fragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mpsoftware.ltd.smsforlife.Adapter.FullSMSViewPagerAdapter;
import mpsoftware.ltd.smsforlife.MainActivity;
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
    private ImageView mImageViewForward;
    private ImageView mImageViewBackward;
    private ImageView mImageViewSend;
    private int mCurrentViewPager;

    public FullSMSFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_full_sms, container, false);
        mPager = (ViewPager)view.findViewById(R.id.viewpagerFullSMS);
        mImageViewForward = (ImageView)view.findViewById(R.id.forwardButton);
        mImageViewBackward = (ImageView)view.findViewById(R.id.backwardButton);
        mImageViewSend = (ImageView)view.findViewById(R.id.sendSMS);
        FloatingActionButton floatingActionButton = ((MainActivity) getActivity()).getFloatingActionButton();
        if (floatingActionButton != null) {
            floatingActionButton.hide();
        }
        mStringArray = new ArrayList<>();
        mBundleSMS = new Bundle();
        mBundleSMS = getArguments();
        mStringArray = mBundleSMS.getStringArrayList("smsArray");
        mCurrentPage = mBundleSMS.getInt("smsPosition");

        mBundleSMS.putInt("totalCount", mStringArray.size());

        mPagerAdapter = new FullSMSViewPagerAdapter(getFragmentManager(), mStringArray, mStringArray.size(), getActivity());
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(mCurrentPage);

        SendBFButton();

        return view;
    }

    public void SendBFButton(){
        mImageViewForward.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mCurrentPage = mPager.getCurrentItem();
                        mPager.setCurrentItem(++mCurrentPage);
                    }
                }
        );

        mImageViewBackward.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mCurrentPage = mPager.getCurrentItem();
                        mPager.setCurrentItem(--mCurrentPage);
                    }
                }
        );

        mImageViewSend.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String shareBody = mStringArray.get(mPager.getCurrentItem());
                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "Share using"));
                    }
                }
        );

    }

}
