package mpsoftware.ltd.smsforlife.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import mpsoftware.ltd.smsforlife.Adapter.SmsDataAdapter;
import mpsoftware.ltd.smsforlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnglishSubFragment extends Fragment {

    private RecyclerView mRecyclerViewBanglaSub;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> mStringList;
    private SmsDataAdapter mSmsAdapter;
    public EnglishSubFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_english_sub, container, false);

        mRecyclerViewBanglaSub = (RecyclerView)view.findViewById(R.id.recylerViewEnglishSub);

        mLayoutManager = new GridLayoutManager(getActivity(), 1);
        mRecyclerViewBanglaSub.setLayoutManager(mLayoutManager);
        mStringList = Arrays.asList(getResources().getStringArray(R.array.BanglaSMSList));
        mSmsAdapter = new SmsDataAdapter(getActivity(), mStringList);
        mRecyclerViewBanglaSub.setAdapter(mSmsAdapter);
        return view;
    }

}
