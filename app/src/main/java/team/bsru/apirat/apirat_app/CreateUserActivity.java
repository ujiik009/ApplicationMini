package team.bsru.apirat.apirat_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class CreateUserActivity extends AppCompatActivity {
    //val
    private EditText strcodeEditText,
            bookEditText,
            userEditText,
            passEditText,
            confEditText;
    private Button createUserButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                ShowAlert showAlert = new ShowAlert(CreateUserActivity.this);
                if (strcodeEditText.getText().toString().equals("") || bookEditText.getText().toString().equals("") || userEditText.getText().toString().equals("") || passEditText.getText().toString().equals("") || confEditText.getText().toString().equals("")) {
                    showAlert.ShowDialog("have space", "try again ");
                } else {
                    if (passEditText.getText().toString().equals(confEditText.getText().toString())) {


                        ClassCreateUser classCreateUser = new ClassCreateUser(CreateUserActivity.this);
                        classCreateUser.execute(myconstant.getServiceCreateUser() +
                                //sent value URL
                                "studentCode=" + strcodeEditText.getText() + "&" +
                                "username=" + userEditText.getText() + "&" +
                                "password=" + passEditText.getText() + "&" +
                                "BookCode=" + bookEditText.getText()
                        );
                    } else {

                        showAlert.ShowDialog("false", passEditText.getText() + "==>" + confEditText.getText());
                    }

                }


            }
        });

    }//main Method

}//main class
