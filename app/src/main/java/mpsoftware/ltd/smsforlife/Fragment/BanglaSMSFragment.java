package mpsoftware.ltd.smsforlife.Fragment;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FlipInTopXAnimator;
import mpsoftware.ltd.smsforlife.Adapter.SmsDataAdapter;
import mpsoftware.ltd.smsforlife.MainActivity;
import mpsoftware.ltd.smsforlife.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BanglaSMSFragment extends Fragment {

    private RecyclerView mRecyclerViewBangla;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> mStringList;
    private SmsDataAdapter mSmsAdapter;

    // newInstance constructor for creating fragment with arguments
    public BanglaSMSFragment(){

    }
    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_banglasms, container, false);

        mRecyclerViewBangla = (RecyclerView)view.findViewById(R.id.recylerViewBangla);
        FloatingActionButton floatingActionButton = ((MainActivity) getActivity()).getFloatingActionButton();
        if (floatingActionButton != null) {
            floatingActionButton.show();
        }

        FlipInTopXAnimator animator = new FlipInTopXAnimator();
        animator.setAddDuration(2000);
        animator.setRemoveDuration(2000);
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerViewBangla.setLayoutManager(mLayoutManager);
        mStringList = Arrays.asList(getResources().getStringArray(R.array.BanglaSMSList));
        mSmsAdapter = new SmsDataAdapter(getActivity(), mStringList);
        mRecyclerViewBangla.setItemAnimator(animator);
        mRecyclerViewBangla.setAdapter(mSmsAdapter);

        mSmsAdapter.setOnItemClickListener(new SmsDataAdapter.RVClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                Bundle bundleSMSTopic = new Bundle();
                bundleSMSTopic.putInt("position", position);
                bundleSMSTopic.putString("smstitle", mStringList.get(position));
                Fragment fragment = new BanglaSubFragment();
                fragment.setArguments(bundleSMSTopic);
                FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_main, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return view;
    }

}
