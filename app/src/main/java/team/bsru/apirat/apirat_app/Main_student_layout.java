package team.bsru.apirat.apirat_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Main_student_layout extends AppCompatActivity {
    private String str_json;
    private ImageButton exitImageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student_layout);

        str_json = getIntent().getStringExtra("str_json_data").toString();

        // bind widget
        exitImageButton = (ImageButton) findViewById(R.id.btn_exit);


        // button controller
        exitImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}
