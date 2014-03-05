package org.aselims.testapp.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.aselims.testapp.app.MainActivity;
import org.aselims.testapp.app.R;
import org.aselims.testapp.helpers.PlaceData;

import java.util.ArrayList;

/**
 * Created by aselims on 03/03/14.
 */
public class FetchingTask extends AsyncTask<String, Void, String> {

    private ProgressDialog progDialog;
    private Context context;
    private MainActivity activity;
    private static final String debugTag = "FetchingTask";

    public FetchingTask(MainActivity activity) {
        super();
        this.activity = activity;
        this.context = this.activity.getApplicationContext();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progDialog = ProgressDialog.show(this.activity, "Search", this.context.getResources().getString(R.string.loading_data) , true, false);
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            Log.d(debugTag, "Background:" + Thread.currentThread().getName());
            String result = Downloader.downloadFromServer(strings);
            return result;
        } catch (Exception e) {
            return new String();
        }

    }



    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        ArrayList<PlaceData> placeData= new ArrayList<PlaceData>();

        progDialog.dismiss();
        if(s.length() == 0)
            this.activity.alert("cant fetch any data!");
    }
}
