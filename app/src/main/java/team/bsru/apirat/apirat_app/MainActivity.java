package team.bsru.apirat.apirat_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    // Explicit

    private Button singinButton,createButton;
    private EditText user_input, pass_input;
    private Boolean status;
    private String message;
    private String str_json_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind Widget
        singinButton = (Button) findViewById(R.id.SingIn);
        createButton = (Button) findViewById(R.id.CreateButton);
        user_input = (EditText) findViewById(R.id.user_input);
        pass_input = (EditText) findViewById(R.id.pass_input);

        singinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowAlert showAlert = new ShowAlert(MainActivity.this);
                if (user_input.getText().toString().trim().equals("")||pass_input.getText().toString().trim().equals("")) {

                    Toast.makeText(MainActivity.this, "กรุณากรอกให้ครบ", Toast.LENGTH_SHORT).show();
                }else{
                    try {
                        //showAlert.ShowDialog("Welcome",user_input.getText().toString());
                        GetDatatoserver loginDatatoserver = new GetDatatoserver(MainActivity.this);
                        Myconstant myconstant = new Myconstant();
                        loginDatatoserver.execute(myconstant.getServiceLogin() +
                                "username=" + user_input.getText() + "&" +
                                "password=" + pass_input.getText()
                        );
                        String strJson = loginDatatoserver.get();
                        JSONArray respontServiceJsonArray = new JSONArray(strJson);

                        for (int i = 0; i < respontServiceJsonArray.length(); i++) {
                            JSONObject jsonObject = respontServiceJsonArray.getJSONObject(i);
                            status = jsonObject.getBoolean("status");
                            str_json_data = jsonObject.getString("data_user");
                            message = jsonObject.getString("message");
                        }//for
                        Log.d("checkLogin","status ==> "+status+" message ==>"+message);
                        if (status == true){
                            Log.d("checkLogin","json data string ==> "+str_json_data);
                            Toast.makeText(MainActivity.this,"login สำเร็จ",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, Main_student_layout.class);
                            intent.putExtra("str_json_data", str_json_data);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT).show();
                        }

                    }catch (Exception e){
                        Log.d("checkLogin", "catch ==> " + e.toString());
                    }




                }

            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateUserActivity.class);
                intent.putExtra("User", user_input.getText().toString());
                startActivity(intent);
            }
        });


    }
}
