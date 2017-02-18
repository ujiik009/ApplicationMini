package team.bsru.apirat.apirat_app;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import okhttp3.OkHttpClient;

/**
 * Created by ikool009 on 18/2/2560.
 */

public class ClassCreateUser extends AsyncTask<String,Void,String> {
    private Context context;
    private String strCode,bookCode, userString,passString;
    private ProgressDialog progressDialog;
    public ClassCreateUser(Context context, String strCode, String bookCode, String userString, String passString) {
        this.context = context;
        this.strCode = strCode;
        this.bookCode = bookCode;
        this.userString = userString;
        this.passString = passString;
    }


    @Override
    protected String doInBackground(String... strings) {
        try {


        } catch (Exception e) {

        }
        return null;
    }
}//Main Class
