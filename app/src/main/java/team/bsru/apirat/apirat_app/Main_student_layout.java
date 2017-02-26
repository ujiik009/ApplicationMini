package team.bsru.apirat.apirat_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Main_student_layout extends AppCompatActivity {
    private String str_json;
    private ImageButton exitImageButton, showQRButton, callTAButton,show_profileButton,ViewListImageButton,overviewbtn;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student_layout);

        str_json = getIntent().getStringExtra("str_json_data").toString();

        // bind widget
        exitImageButton = (ImageButton) findViewById(R.id.btn_exit);
        showQRButton = (ImageButton) findViewById(R.id.btn_show_qr);
        callTAButton = (ImageButton) findViewById(R.id.btn_callAT);
        show_profileButton = (ImageButton) findViewById(R.id.show_profile);
        ViewListImageButton = (ImageButton) findViewById(R.id.showViewList);
        overviewbtn = (ImageButton) findViewById(R.id.btn_overview);
        // button controller
        exitImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Process.killProcess(Process.myPid());
                System.exit(1);
            }
        });
        overviewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_student_layout.this, ShowOverView.class);
                intent.putExtra("data_json",str_json);
                startActivity(intent);
            }
        });

        showQRButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_student_layout.this, show_QR.class);
                intent.putExtra("str_json_data", str_json);
                startActivity(intent);

            }
        });

        callTAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_student_layout.this, Call_TA.class);
                intent.putExtra("data_ta", getIntent().getStringExtra("data_TA").toString());
                startActivity(intent);
            }
        });

        show_profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_student_layout.this, show_profile.class);
                intent.putExtra("str_json_data", str_json);
                startActivity(intent);
            }
        });
        ViewListImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main_student_layout.this,ShowListView_in_classroom.class);
                intent.putExtra("json_data",str_json);
                startActivity(intent);
            }
        });
    }// Main Method
}//Main Class