package team.bsru.apirat.apirat_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // Explicit

    private Button singinButton,createButton;
    private EditText user_input, pass_input;

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

                    showAlert.ShowDialog("Have Space","Try again");
                }else{
                    showAlert.ShowDialog("Welcome",user_input.getText().toString());
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
