package mpsoftware.ltd.smsforlife.Fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mpsoftware.ltd.smsforlife.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {

    TextView mTextFullSMS;
    TextView mTextPageNumber;
    private String mFullSmS;
    private int mPage;
    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    public static ScreenSlidePageFragment newInstance(int page, String FullSmS) {
        
        Bundle args = new Bundle();
        args.putInt("pagenumber", page);
        args.putString("fullsms", FullSmS);

        
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt("pagenumber", 0);
        mFullSmS = getArguments().getString("fullsms");
        Log.e("Sms", "newInstance: "+mFullSmS );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
         mTextFullSMS = (TextView)view.findViewById(R.id.FullSMS);
         mTextPageNumber = (TextView)view.findViewById(R.id.pagerNumber);
         mTextFullSMS.setText(mFullSmS);
         mTextPageNumber.setText(String.valueOf(mPage));

        return view;
    }

}
