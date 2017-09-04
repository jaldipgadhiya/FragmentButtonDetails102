package com.android.acadgild.fragmentbuttondetails102;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//import com.acadgild.fragments.apis.Data;


/**
 * Created by Jal on 02-08-2017.
 */
public class DetailsFragment extends Fragment {
    //Method to create new instance of DetailsFragment
    public static DetailsFragment newInstance(String index) {
        DetailsFragment f = new DetailsFragment();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putString("index", index);
        f.setArguments(args);

        return f;
    }

    public String getShownText() {
        return getArguments().getString("index");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Set Values to the textview on details fragment.
        TextView text = new TextView(getActivity());
        text.setText(getArguments().getString("index"));
        return text;
    }
}