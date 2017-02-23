package team.bsru.apirat.apirat_app;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Call_TA extends AppCompatActivity {
    private String json_data_ta;
    private ListView taListView;
    private Button back_list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call__t);
        json_data_ta = getIntent().getStringExtra("data_ta");

        taListView = (ListView) findViewById(R.id.ta_Listview);
        back_list_view = (Button) findViewById(R.id.btn_back);

        try {
            JSONArray jsonArray = new JSONArray(json_data_ta);
            final String name[] = new String[jsonArray.length()];
            final String tel[] = new String[jsonArray.length()];
            final String img_address[] = new String[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                name[i] = jsonObject.getString("name");
                tel[i] = jsonObject.getString("ta_tel");
                img_address[i] = jsonObject.getString("img_address");
            }

            Adapter_ta adapter_ta = new Adapter_ta(Call_TA.this, name, tel, img_address);
            taListView.setAdapter(adapter_ta);
            taListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + tel[i]));

                    if (ActivityCompat.checkSelfPermission(Call_TA.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    startActivity(intent);

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }// try

        back_list_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
