package team.bsru.apirat.apirat_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ShowQR extends AppCompatActivity {
    private ImageView imageViewQR;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_qr);

        //bind widget
        imageViewQR = (ImageView) findViewById(R.id.imageView4);
        textView = (TextView) findViewById(R.id.text);
        //textView.setText(getIntent().getStringExtra("pic"));
        Picasso.with(ShowQR.this).load(getIntent().getStringExtra("pic")).into(imageViewQR);
    }
}
