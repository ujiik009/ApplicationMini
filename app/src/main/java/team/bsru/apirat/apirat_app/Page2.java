package team.bsru.apirat.apirat_app;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Page2 extends AppCompatActivity {
    private TextView h, i, s;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        Toast.makeText(Page2.this,"Welcome",
                Toast.LENGTH_LONG).show();

    }


}
