package mpsoftware.ltd.smsforlife.Fragment;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mpsoftware.ltd.smsforlife.Adapter.SmsDataAdapter;
import mpsoftware.ltd.smsforlife.MainActivity;
import mpsoftware.ltd.smsforlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BanglaSubFragment extends Fragment {

    private RecyclerView mRecyclerViewBanglaSub;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> mStringList;
    private SmsDataAdapter mSmsAdapter;

    public BanglaSubFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bangla_sub, container, false);
        setStringArrayByPosition();
        mRecyclerViewBanglaSub = (RecyclerView)view.findViewById(R.id.recylerViewBanglaSub);
        FloatingActionButton floatingActionButton = ((MainActivity) getActivity()).getFloatingActionButton();
        if (floatingActionButton != null) {
            floatingActionButton.show();
        }
        mLayoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerViewBanglaSub.setLayoutManager(mLayoutManager);
        mSmsAdapter = new SmsDataAdapter(getActivity(), mStringList);
        mRecyclerViewBanglaSub.setAdapter(mSmsAdapter);

        mSmsAdapter.setOnItemClickListener(new SmsDataAdapter.RVClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                Bundle bundleSMS = new Bundle();
                bundleSMS.putString("fullSMS", mStringList.get(position));
                bundleSMS.putStringArrayList("smsArray",  mStringList);
                bundleSMS.putInt("smsPosition", position);

                Fragment fragment = new FullSMSFragment();
                fragment.setArguments(bundleSMS);
                FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content_main, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

               /* String shareBody = mStringList.get(position);
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));*/
            }
        });
    return view;
    }


    public void setStringArrayByPosition(){
        Bundle bundleSMSPositon = new Bundle();
        bundleSMSPositon = getArguments();
        int position = bundleSMSPositon.getInt("position");
        switch (position){
            case 0:
                mStringList =new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.BanglaSMSEidMubarok)));
                break;
            case 1:
                mStringList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.BanglaSMSAdvice)));
                break;
            default:
                mStringList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.BanglaSMSEidMubarok)));
                break;

        }
    }
}
