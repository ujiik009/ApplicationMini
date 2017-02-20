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


public class CreateUserActivity extends AppCompatActivity {
    //val
    private EditText strcodeEditText,
            bookEditText,
            userEditText,
            passEditText,
            confEditText;
    private Button createUserButton;
    private boolean status;
    private String pathImg, massage;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        //bind View
        strcodeEditText = (EditText) findViewById(R.id.edStrCode);
        bookEditText = (EditText) findViewById(R.id.edBookCode);
        userEditText = (EditText) findViewById(R.id.edUser);
        passEditText = (EditText) findViewById(R.id.edPass);
        confEditText = (EditText) findViewById(R.id.edConfpass);
        createUserButton = (Button) findViewById(R.id.createButton);

        final Myconstant myconstant = new Myconstant();

        createUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createUserButton.setEnabled(false);
                ShowAlert showAlert = new ShowAlert(CreateUserActivity.this);
                if (strcodeEditText.getText().toString().equals("") || bookEditText.getText().toString().equals("") || userEditText.getText().toString().equals("") || passEditText.getText().toString().equals("") || confEditText.getText().toString().equals("")) {
                    showAlert.ShowDialog("have space", "try again ");
                } else {
                    if (passEditText.getText().toString().equals(confEditText.getText().toString())) {

                        try {
                            GetDatatoserver getDatatoserver = new GetDatatoserver(CreateUserActivity.this);
                            getDatatoserver.execute(myconstant.getServiceCreateUser() +
                                    //sent value URL
                                    "studentCode=" + strcodeEditText.getText() + "&" +
                                    "username=" + userEditText.getText() + "&" +
                                    "password=" + passEditText.getText() + "&" +
                                    "BookCode=" + bookEditText.getText() + "&" +
                                    "Domain=" + myconstant.getServerDomain()
                            );
                            String strJson = getDatatoserver.get();
                            JSONArray respontServiceJsonArray = new JSONArray(strJson);
                            for (int i = 0; i < respontServiceJsonArray.length(); i++) {
                                JSONObject jsonObject = respontServiceJsonArray.getJSONObject(i);
                                status = jsonObject.getBoolean("status");
                                pathImg = jsonObject.getString("pathQR");
                                massage = jsonObject.getString("massage");
                            }//for
                            if (status == true) {
                                Toast.makeText(CreateUserActivity.this, massage, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(CreateUserActivity.this, ShowQR.class);
                                intent.putExtra("pic", pathImg.toString());
                                startActivity(intent);
                                finish();

                            } else {
                                createUserButton.setEnabled(true);
                                Toast.makeText(CreateUserActivity.this, massage, Toast.LENGTH_LONG).show();
                            }
                            Log.d("resp", "array try join==>" + status);
                        } catch (Exception e) {
                            Log.d("resp", "array error join==>" + e.toString());
                        }
                    } else {
                        showAlert.ShowDialog("false", passEditText.getText() + "==>" + confEditText.getText());
                    }

                }


            }
        });

    }//main Method

}//main class
