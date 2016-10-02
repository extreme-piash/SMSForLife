package mpsoftware.ltd.smsforlife.Fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import mpsoftware.ltd.smsforlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FullSMSFragment extends Fragment {

    TextView textViewFullSMS;

    public FullSMSFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_full_sm, container, false);

        textViewFullSMS = (TextView)view.findViewById(R.id.textViewFullSMS);
        getSMS();

        return view;
    }
    public void getSMS(){
        Bundle bundleSMS = new Bundle();

        bundleSMS = getArguments();
        String fullSMS = bundleSMS.getString("fullSMS");
        textViewFullSMS.setText(fullSMS);

       // Toast.makeText(getActivity(), bundleSMS.getString("fullSMS"),Toast.LENGTH_SHORT).show();
    }

}
