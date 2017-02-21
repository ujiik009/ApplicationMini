package team.bsru.apirat.apirat_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Showinfo_Activty extends AppCompatActivity {
    //            "number_student": "1",
//            "student_code": "5921148002",
//            "student_name": "นางสาวสุวิมล เชิงไกรยัง ",
//            "student_sec": "D7",
//            "book_code": "12345",
//            "address_QR": "http://tait.bsruteam.tk/Service_php_for_android/tempQRcode/59211480020638331b6ce35ed96ee82d8658ec005f.png"
    private TextView  number_studentTextView,student_codeTextView, student_nameTextView, student_secTextView, book_codeTextView, address_QRTextView;
    private String str_json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showinfo__activty);

        //bind Widget

        number_studentTextView = (TextView) findViewById(R.id.number_student);
        student_codeTextView = (TextView) findViewById(R.id.student_code);
        student_nameTextView = (TextView) findViewById(R.id.student_name);
        student_secTextView = (TextView) findViewById(R.id.student_sec);
        book_codeTextView = (TextView) findViewById(R.id.book_code);
        address_QRTextView = (TextView) findViewById(R.id.address_QR);

        str_json = getIntent().getStringExtra("str_json_data").toString();

        try {
            JSONObject data_obj = new JSONObject(str_json);

            String number_student = data_obj.getString("number_student");
            String student_code = data_obj.getString("student_code");
            String student_name = data_obj.getString("student_name");
            String student_sec = data_obj.getString("student_sec");
            String book_code = data_obj.getString("book_code");
            String address_QR = data_obj.getString("address_QR");

            Log.d("data", "Json student ==>" + student_name);

            number_studentTextView.setText(number_student);
            student_codeTextView.setText(student_code);
            student_nameTextView.setText(student_name);
            student_secTextView.setText(student_sec);
            book_codeTextView.setText(book_code);
            address_QRTextView.setText(address_QR);
        } catch (JSONException e) {
            Log.d("data", "Json error ==>" + e.toString());

        }


    }
}
