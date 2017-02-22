package team.bsru.apirat.apirat_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class show_QR extends AppCompatActivity {
    private ImageView qr_codeImageView;
    private Button backButton;
    private String str_json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__qr);

        // bind widgid
        qr_codeImageView = (ImageView) findViewById(R.id.qr_code_img);
        backButton = (Button) findViewById(R.id.btn_back);
        str_json = getIntent().getStringExtra("str_json_data").toString();
        //Picasso.with(ShowQR.this).load(getIntent().getStringExtra("pic")).into(imageViewQR);


        try {
            JSONObject data_obj = new JSONObject(str_json);
            String address_QR = data_obj.getString("address_QR");
            Picasso.with(show_QR.this).load(address_QR).into(qr_codeImageView);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
