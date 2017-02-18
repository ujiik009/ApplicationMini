package team.bsru.apirat.apirat_app;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by ikool009 on 18/2/2560.
 */

public class ClassCreateUser extends AsyncTask<String, Void, String>{
    private Context context;
    private ProgressDialog progressDialog;

    public ClassCreateUser(Context context) {
        this.context = context;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "Checking",
                "Please Wait Few Minus ...");

    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[0]).build();
            Response response = okHttpClient.newCall(request).execute();
            Log.d("OKhttp", "res ==>" + response.body().string());
            return response.body().string();

        } catch (Exception e) {
            Log.d("OKhttp", "res ==>" + e.toString());
            return null;
        }

    }
}//Main Class
