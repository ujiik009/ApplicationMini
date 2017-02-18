package team.bsru.apirat.apirat_app;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by ikool009 on 18/2/2560.
 */

public class ShowProgressDialog {
    private Context context;

    public ShowProgressDialog(Context context) {
        this.context = context;
    }
    public void ShowProgressAlert() {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Download");
        progressDialog.setMessage("Loading");
        progressDialog.show();
    }
}/// mainClass
