package mpsoftware.ltd.smsforlife.Fragment;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
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
public class EnglishSMSFragment extends Fragment {

    private RecyclerView mRecyclerViewBangla;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> mStringList;
    private SmsDataAdapter mSmsAdapter;

    // newInstance constructor for creating fragment with arguments
    public EnglishSMSFragment(){

    }


    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_englishsms, container, false);

        mRecyclerViewBangla = (RecyclerView)view.findViewById(R.id.recylerViewEnglish);
        mLayoutManager = new GridLayoutManager(getActivity(), 2);
        mRecyclerViewBangla.setLayoutManager(mLayoutManager);
        mStringList = Arrays.asList(getResources().getStringArray(R.array.EnglishSMSList));
        mSmsAdapter = new SmsDataAdapter(getActivity(), mStringList);
        mRecyclerViewBangla.setAdapter(mSmsAdapter);

        mSmsAdapter.setOnItemClickListener(new SmsDataAdapter.RVClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                Bundle bundleSMSTopic = new Bundle();
                bundleSMSTopic.putInt("position",position);
                bundleSMSTopic.putString("smstitle",mStringList.get(position));
                Fragment fragment = new EnglishSubFragment();
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
