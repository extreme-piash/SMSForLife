package mpsoftware.ltd.smsforlife.Fragment;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.FlipInTopXAnimator;
import mpsoftware.ltd.smsforlife.Adapter.SmsDataAdapter;
import mpsoftware.ltd.smsforlife.R;
import mpsoftware.ltd.smsforlife.favdatabase.WishlistHandler;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnglishWishlistFragment extends Fragment {
    private RecyclerView mRecyclerViewWishlist;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> mStringList;
    private SmsDataAdapter mSmsAdapter;
    private WishlistHandler mWishlisHandler;

    public EnglishWishlistFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_english_wishlist, container, false);
        mRecyclerViewWishlist = (RecyclerView)view.findViewById(R.id.recylerViewEnglishWishlist);

        mWishlisHandler = new WishlistHandler(getActivity());
        FlipInTopXAnimator animator = new FlipInTopXAnimator();
        animator.setAddDuration(2000);
        animator.setRemoveDuration(2000);
        mLayoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerViewWishlist.setLayoutManager(mLayoutManager);
        mStringList = mWishlisHandler.getAllWishlistEnglish();
        mSmsAdapter = new SmsDataAdapter(getActivity(), mStringList);
        mRecyclerViewWishlist.setItemAnimator(animator);
        mRecyclerViewWishlist.setAdapter(mSmsAdapter);

        mSmsAdapter.setOnItemClickListener(new SmsDataAdapter.RVClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Bundle bundleSMS = new Bundle();
                bundleSMS.putString("fullSMS", mStringList.get(position));
                bundleSMS.putStringArrayList("smsArray",  mStringList);
                bundleSMS.putInt("smsPosition", position);
                bundleSMS.putString("smstrack","English");

                Fragment fragment = new FullSMSFragment();
                fragment.setArguments(bundleSMS);
                FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_main, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

    return view;
    }

}
