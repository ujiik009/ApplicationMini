package team.bsru.apirat.apirat_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class show_profile extends AppCompatActivity {
    private Toolbar sub_titleToolbar;
    private TextView full_name,student_code,book_codeTextView,num_user;
    private Button back_Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile);
        String data = getIntent().getStringExtra("str_json_data");

        // bindWidget
        sub_titleToolbar = (Toolbar) findViewById(R.id.sub_title);
        full_name = (TextView) findViewById(R.id.student_name);
        student_code = (TextView) findViewById(R.id.std_code);
        book_codeTextView = (TextView) findViewById(R.id.book_code);
        num_user = (TextView) findViewById(R.id.user_num);
        back_Button = (Button) findViewById(R.id.btn_back_profile);

        try {
            JSONObject jsonObject_data_user = new JSONObject(data);

            sub_titleToolbar.setTitle("หมู่เรียน "+jsonObject_data_user.getString("student_sec"));
            full_name.setText(jsonObject_data_user.getString("student_name"));
            student_code.setText(jsonObject_data_user.getString("student_code"));
            book_codeTextView.setText(jsonObject_data_user.getString("book_code"));
            num_user.setText(jsonObject_data_user.getString("number_student"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        back_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
