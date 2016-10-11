package mpsoftware.ltd.smsforlife.Fragment;


import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import mpsoftware.ltd.smsforlife.Adapter.TabViewPagerWishlistAdapter;
import mpsoftware.ltd.smsforlife.MainActivity;
import mpsoftware.ltd.smsforlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WishlistFragment extends Fragment {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabViewPagerWishlistAdapter mTabAdapter;
    public WishlistFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_wishlist, container, false);
        setHasOptionsMenu(true);
        getActivity().setTitle("Favourite SMS");
        FloatingActionButton floatingActionButton = ((MainActivity) getActivity()).getFloatingActionButton();
        if (floatingActionButton != null) {
            floatingActionButton.hide();
        }

        mViewPager = (ViewPager) view.findViewById(R.id.viewpager_wishlist);
        mTabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs_wishlist);
        mTabAdapter = new TabViewPagerWishlistAdapter(getChildFragmentManager(),getActivity());
        mViewPager.setAdapter(mTabAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        return view;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_wishlist);
        item.setVisible(false);
    }
}
