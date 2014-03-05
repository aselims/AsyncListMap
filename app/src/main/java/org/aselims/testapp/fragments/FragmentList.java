package org.aselims.testapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import org.aselims.testapp.app.MainActivity;
import org.aselims.testapp.app.R;
import org.aselims.testapp.helpers.PlaceData;
import org.aselims.testapp.tasks.FetchingTask;

import java.util.ArrayList;

/**
 * Created by aselims on 03/03/14.
 */
public class FragmentList extends Fragment {

    private ArrayList<PlaceData> places;
    private ListView placesList;
    private Spinner placesSpinner;
    private Button goButton;

    final String LOG_TAG ="debugging";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        this.placesSpinner = (Spinner) rootView.findViewById(R.id.spinner);
        this. placesList = (ListView) rootView.findViewById(R.id.listView);
        this.goButton = (Button) rootView.findViewById(R.id.button);



        this.goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FetchingTask fetchingTask = new FetchingTask(MainActivity.this);
                try {
                    String place = placesSpinner.getSelectedItem().toString();
                    Log.d(LOG_TAG, place);
                    /* Todo
                     * fetch data and fill the list with the data from Asynctask */

                    fetchingTask.execute(place);

                 }


                catch (Exception e)
                {
                    /* Todo
                     * cancel task and alert no data to fetch */


                    fetchingTask.cancel(true);
                    MainActivity.alert("sorry!");
                }
            }
        });



        return rootView;

    }

    public void setPlacesList(ArrayList<PlaceData> places) {
        this.places = places;
        this.placesList.setAdapter(new TrackDataAdapter(this,this.imgFetcher,this.layoutInflator, this.tracks));
    }

}
