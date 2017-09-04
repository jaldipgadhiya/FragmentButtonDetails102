package com.android.acadgild.fragmentbuttondetails102;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by Jal on 02-08-2017.
 */

public class ButtonsFragment extends Fragment {


    boolean mDualPane;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflating View
        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        Toast.makeText(getActivity(), "onCreateView ",
                Toast.LENGTH_LONG).show();


        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Buttons
         Button bt=(Button)getActivity().findViewById(R.id.button1);
        Button bt1=(Button)getActivity().findViewById(R.id.button2);
        Button bt2=(Button)getActivity().findViewById(R.id.button3);
        Button bt3=(Button)getActivity().findViewById(R.id.button4);

        View detailsFrame = getActivity().findViewById(R.id.details);

        //Checking if DuelPane view is active or not
        mDualPane = detailsFrame != null
                && detailsFrame.getVisibility() == View.VISIBLE;

        Toast.makeText(getActivity(), "mDualPane " + mDualPane,
                Toast.LENGTH_LONG).show();



        //Click Listner for Button1
        bt.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button bt=(Button)getActivity().findViewById(R.id.button1);
                Toast.makeText(getActivity().getApplicationContext(),"Clicked on Button "+ bt.getText().toString() ,Toast.LENGTH_LONG).show();
                //Calling Show details to show details screen as per Button1
                showDetails(bt.getText().toString());
            }
        });

        //Click Listner for Button2
        bt1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button bt1=(Button)getActivity().findViewById(R.id.button2);
                Toast.makeText(getActivity().getApplicationContext(),"Clicked on Button "+ bt1.getText().toString() ,Toast.LENGTH_LONG).show();
                //Calling Show details to show details screen as per Button2
                showDetails(bt1.getText().toString());
            }
        });

        //Click Listner for Button3
        bt2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button bt2=(Button)getActivity().findViewById(R.id.button3);
                Toast.makeText(getActivity().getApplicationContext(),"Clicked on Button "+ bt2.getText().toString() ,Toast.LENGTH_LONG).show();
                //Calling Show details to show details screen as per Button3
                showDetails(bt2.getText().toString());
            }
        });

        //Click Listner for Button4
        bt3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button bt3=(Button)getActivity().findViewById(R.id.button4);
                Toast.makeText(getActivity().getApplicationContext(),"Clicked on Button "+ bt3.getText().toString() ,Toast.LENGTH_LONG).show();
                //Calling Show details to show details screen as per Button4
                showDetails(bt3.getText().toString());
            }
        });


    }

    //Method to show details if dual pane then on detail fragment else on detail activity
    void showDetails(String text) {
        //Check if Dual Pane is true
        if (mDualPane) {
            //Create Object of DetailsFragment class
            DetailsFragment details = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);

            if (details == null || text != null) {

                details = DetailsFragment.newInstance(text);
                //Load Detail Fragment
                FragmentTransaction ft = getFragmentManager()
                        .beginTransaction();
                ft.replace(R.id.details, details);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
         //If not Dual Pane
        } else {
            //Create Intent to display details on DetailsActivity screen
            Intent intent = new Intent();
            intent.setClass(getActivity(), DetailsActivity.class);
            intent.putExtra("index", text);
            startActivity(intent);
        }
    }

}
