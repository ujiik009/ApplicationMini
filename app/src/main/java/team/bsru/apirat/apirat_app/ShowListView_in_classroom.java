package team.bsru.apirat.apirat_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class ShowListView_in_classroom extends AppCompatActivity {
    private String Json_String, student_code, student_sec,json_list_array;
    private Boolean status_server;
    private ListView show_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list_view_in_classroom);
        Json_String = getIntent().getStringExtra("json_data").toString();
        show_list = (ListView) findViewById(R.id.showListViews);
        try {
            JSONObject jsonObject = new JSONObject(Json_String);
            student_code = jsonObject.getString("student_code");
            student_sec = jsonObject.getString("student_sec");
            Myconstant myconstant = new Myconstant();

            GetDatatoserver getDatatoserver = new GetDatatoserver(ShowListView_in_classroom.this);
            getDatatoserver.execute(myconstant.getServiceShowListDate() +
                    "student_code=" + student_code + "&" +
                    "sec=" + student_sec
            );
            String jsonRespo = getDatatoserver.get();
            try {

                JSONObject jsonObject1 = new JSONObject(jsonRespo);
                status_server = jsonObject1.getBoolean("status");
                json_list_array = jsonObject1.getString("data");

                if (status_server == true){
                    JSONArray jsonArray = new JSONArray(json_list_array);
                    final String date[] = new String[jsonArray.length()];
                    final String status[] = new String[jsonArray.length()];

                    for (int i =0 ;i< jsonArray.length();i++){

                        JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                        date[i] = jsonObject2.getString("date");
                        status[i] = jsonObject2.getString("status_student");

                    }

                    Adapter_list_date adapter_list_date  = new Adapter_list_date(ShowListView_in_classroom.this,
                            date,status);
                    show_list.setAdapter(adapter_list_date);

                    //Toast.makeText(ShowListView_in_classroom.this,json_list_array.toString(),Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(ShowListView_in_classroom.this,status_server.toString(),Toast.LENGTH_LONG).show();
                }

            } catch (Exception e) {
                Log.d("ice",e.toString());
            }

        } catch (Exception e) {

        }

    }
}
