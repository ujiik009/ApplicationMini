package team.bsru.apirat.apirat_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class ShowOverView extends AppCompatActivity {
    private Button blue,green, red;
    private String json_data,student_code,sec,jsonReturn;
    private  Boolean status;
    private String count_date_check,student_inclass, student_not_inclass;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_over_view);
        blue = (Button) findViewById(R.id.push_button1);
        green = (Button) findViewById(R.id.push_button);
        red = (Button) findViewById(R.id.push_button4);
        back = (Button) findViewById(R.id.btn_back_overview);
        json_data = getIntent().getStringExtra("data_json");
        GetDatatoserver getDatatoserver = new GetDatatoserver(ShowOverView.this);
        Myconstant myconstant = new Myconstant();

        try {
            JSONObject jsonObject = new JSONObject(json_data);
            student_code = jsonObject.getString("student_code");
            sec = jsonObject.getString("student_sec");

            getDatatoserver.execute(myconstant.getServicegetOverview()
                    +"sec="+sec+"&"
                    +"student_code="+student_code
            );
            try {
                jsonReturn = getDatatoserver.get().toString();

                JSONObject jsonObject1 = new JSONObject(jsonReturn);
                status = jsonObject1.getBoolean("status");
                count_date_check = jsonObject1.getString("count_date_check");
                student_inclass = jsonObject1.getString("student_inclass");
                student_not_inclass = jsonObject1.getString("student_not_inclass");



                if ( status== true){
                    blue.setText(count_date_check);
                    green.setText(student_inclass);
                    red.setText(student_not_inclass);
                    //Toast.makeText(ShowOverView.this,status.toString(),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ShowOverView.this,status.toString(),Toast.LENGTH_SHORT).show();
                }
//
            }catch (Exception e){
                Toast.makeText(ShowOverView.this,"respont error",Toast.LENGTH_SHORT).show();
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
