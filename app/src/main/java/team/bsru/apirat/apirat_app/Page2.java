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
    private Button showLoad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        Toast.makeText(Page2.this,"Welcome",
                Toast.LENGTH_LONG).show();

        //bind View

        showLoad = (Button) findViewById(R.id.load);

        showLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowProgressDialog showProgressDialog = new ShowProgressDialog(Page2.this);
                showProgressDialog.ShowProgressAlert();

            }
        });


    }


}
