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

    private TextView mTextFullSMS;
    private TextView mTextPageNumber;
    private TextView mTexViewTotalPage;
    private String mFullSmS;
    private int mPage;
    private int mTotalCount;
    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }

    public static ScreenSlidePageFragment newInstance(int page,int totalCount, String FullSmS) {
        
        Bundle args = new Bundle();
        args.putInt("pagenumber", page);
        args.putString("fullsms", FullSmS);
        args.putInt("totalCount", totalCount);

        
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt("pagenumber", 0);
        mFullSmS = getArguments().getString("fullsms");
        mTotalCount = getArguments().getInt("totalCount");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
         mTextFullSMS = (TextView)view.findViewById(R.id.FullSMS);
         mTextPageNumber = (TextView)view.findViewById(R.id.pagerNumber);
         mTexViewTotalPage = (TextView)view.findViewById(R.id.totalPage);
         mTextFullSMS.setText(mFullSmS);
         mTexViewTotalPage.setText(String.valueOf(mTotalCount));
         mTextPageNumber.setText(String.valueOf(mPage+1));

        return view;
    }

}
