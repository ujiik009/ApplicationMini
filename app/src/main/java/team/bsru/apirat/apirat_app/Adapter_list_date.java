package team.bsru.apirat.apirat_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by ikool009 on 26/2/2560.
 */

public class Adapter_list_date extends BaseAdapter{
    private Context context;
    private String[] date,status;
    private TextView numtimeTextView,datetimeTextView, statusTextView;

    public Adapter_list_date(Context context, String[] date, String[] status) {
        this.context = context;
        this.date = date;
        this.status = status;
    }


    @Override
    public int getCount() {
        return date.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.item_list_time, viewGroup, false);
        numtimeTextView = (TextView) view1.findViewById(R.id.numdate);
        datetimeTextView = (TextView) view1.findViewById(R.id.date);
        statusTextView = (TextView) view1.findViewById(R.id.status);

        numtimeTextView.setText("ครั้งที่ "+(i+1));
        datetimeTextView.setText(date[i]);

        if (status[i].equals("true")){
            statusTextView.setBackgroundResource(R.color.pass);
            statusTextView.setText("มา");
        }else{
            statusTextView.setBackgroundResource(R.color.notpass);
            statusTextView.setText("ขาด");
        }


        return view1;
    }
}
