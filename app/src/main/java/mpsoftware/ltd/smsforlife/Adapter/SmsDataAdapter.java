package mpsoftware.ltd.smsforlife.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import mpsoftware.ltd.smsforlife.R;

/**
 * Created by piash on 9/22/16.
 */

public class SmsDataAdapter extends RecyclerView.Adapter<SmsDataAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mStringList;
    private RVClickListener mRVClickListener;

    public SmsDataAdapter(Context context, List<String> stringList) {
        this.mContext = context;
        this.mStringList = stringList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewSMS;
        public ViewHolder(View itemView) {
            super(itemView);

            textViewSMS = (TextView)itemView.findViewById(R.id.textViewSMS);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            mRVClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(RVClickListener mRVClickListener) {
        this.mRVClickListener = mRVClickListener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.smsadapter_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Typeface type = Typeface.createFromAsset(mContext.getAssets(),"SolaimanLipi.ttf");
        holder.textViewSMS.setText(mStringList.get(position));
        holder.textViewSMS.setTypeface(type);

    }

    @Override
    public int getItemCount() {
        return mStringList.size();
    }

    public interface RVClickListener {
        public void onItemClick(int position, View v);
    }

}
