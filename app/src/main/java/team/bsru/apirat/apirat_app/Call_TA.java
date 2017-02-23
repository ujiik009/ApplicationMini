package team.bsru.apirat.apirat_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Call_TA extends AppCompatActivity {
    private String json_data_ta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call__t);
        json_data_ta = getIntent().getStringExtra("data_ta");
        Toast.makeText(Call_TA.this,json_data_ta,Toast.LENGTH_LONG).show();
    }
}
