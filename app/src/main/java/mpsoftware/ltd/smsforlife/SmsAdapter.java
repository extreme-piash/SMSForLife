package mpsoftware.ltd.smsforlife;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by piash on 9/22/16.
 */

public class SmsAdapter extends RecyclerView.Adapter<SmsAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mStringList;

    public SmsAdapter(Context context, List<String> stringList) {
        this.mContext = context;
        this.mStringList = stringList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewSMS;
        public ViewHolder(View itemView) {
            super(itemView);

            textViewSMS = (TextView)itemView.findViewById(R.id.textViewSMS);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.smsadapter_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textViewSMS.setText(mStringList.get(position));
    }

    @Override
    public int getItemCount() {
        return mStringList.size();
    }


}
