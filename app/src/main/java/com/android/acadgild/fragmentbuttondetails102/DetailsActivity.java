package com.android.acadgild.fragmentbuttondetails102;


import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Jal on 02-08-2017.
 */
public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

             // create fragment
            DetailsFragment details = new DetailsFragment();

            //Set Fragment Arguments to show contents
            details.setArguments(getIntent().getExtras());
            //Begin Fragment Transaction
            getFragmentManager().beginTransaction()
                    .add(android.R.id.content, details).commit();

    }
}