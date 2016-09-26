package mpsoftware.ltd.smsforlife.Fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mpsoftware.ltd.smsforlife.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnglishSMSFragment extends Fragment {

    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public EnglishSMSFragment(){

    }


    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
        tvLabel.setText(" English" );
        return view;
    }

}
