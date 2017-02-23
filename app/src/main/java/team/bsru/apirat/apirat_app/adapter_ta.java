package team.bsru.apirat.apirat_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by ikool009 on 24/2/2560.
 */

public class Adapter_ta extends BaseAdapter {
    private Context context;
    private String[] name,tel;

    private String[] img_address;
    private TextView nameTextView, telTextView;
    private ImageView img_ta;

    public Adapter_ta(Context context, String[] name, String[] tel, String[] img_address) {
        this.context = context;
        this.name = name;
        this.tel = tel;
        this.img_address = img_address;
    }

    @Override
    public int getCount() {
        return name.length;
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
        View view1 = layoutInflater.inflate(R.layout.item_ta, viewGroup, false);
        nameTextView = (TextView) view1.findViewById(R.id.name_ta_textVeiw);
        telTextView = (TextView) view1.findViewById(R.id.tel_ta_textView);
        img_ta = (ImageView) view1.findViewById(R.id.img_ta);

        nameTextView.setText("TA "+name[i].toString());
        telTextView.setText(tel[i].toString());
        Picasso.with(context).load(img_address[i].toString()).into(img_ta);


        return view1;
    }
}
