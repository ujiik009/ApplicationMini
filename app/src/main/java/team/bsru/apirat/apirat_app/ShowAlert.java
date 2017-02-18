package team.bsru.apirat.apirat_app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.AlteredCharSequence;

/**
 * Created by ikool009 on 17/2/2560.
 */

public class ShowAlert {
    //Explicit
    private Context context;

    public ShowAlert(Context context) {
        this.context = context;
    }

    public void ShowDialog(String title,String massage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setTitle(title);
        builder.setMessage(massage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();

    }
}// main class
