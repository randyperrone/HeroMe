package com.example.randy.herome.Fragmant;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.randy.herome.MainActivity.MainActivity;
import com.example.randy.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragmant.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragmant#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragmant extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button turtleBtn;
    private Button lighningBtn;
    private Button flightBtn;
    private Button webBtn;
    private Button laserBtn;
    private Button superStrengthBtn;
    private Button showBackstoryBtn;

    private OnFragmentInteractionListener mListener;

    public PickPowerFragmant() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragmant.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragmant newInstance(String param1, String param2) {
        PickPowerFragmant fragment = new PickPowerFragmant();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pick_power_fragmant, container, false);

        turtleBtn = (Button)view.findViewById(R.id.turtlebtn);
        lighningBtn = (Button)view.findViewById(R.id.lightningtbtn);
        flightBtn = (Button)view.findViewById(R.id.flightbtn);
        webBtn = (Button)view.findViewById(R.id.webbtn);
        laserBtn = (Button)view.findViewById(R.id.laserbtn);
        superStrengthBtn = (Button)view.findViewById(R.id.superstrengthbtn);
        showBackstoryBtn = (Button)view.findViewById(R.id.showbackstorybtn);

        showBackstoryBtn.setEnabled(false);
        showBackstoryBtn.getBackground().setAlpha(128);

        showBackstoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadCharacterBioScreen();
            }
        });

        turtleBtn.setOnClickListener(this);
        lighningBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        webBtn.setOnClickListener(this);
        laserBtn.setOnClickListener(this);
        superStrengthBtn.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v) {
        showBackstoryBtn.setEnabled(true);
        showBackstoryBtn.getBackground().setAlpha(255);

        turtleBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power,0,0,0);
        lighningBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thors_hammer,0,0,0);
        flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_man_crest,0,0,0);
        webBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spider_web,0,0,0);
        laserBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision,0,0,0);
        superStrengthBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_strength,0,0,0);

        Button btn = (Button)v;
        int leftBtnImage = 0;

        if(btn == turtleBtn){
            leftBtnImage = R.drawable.turtle_power;
            setPower("Turtle Power", leftBtnImage);
        }
        else if(btn == lighningBtn){
            leftBtnImage = R.drawable.thors_hammer;
            setPower("Lightning", leftBtnImage);
        }
        else if(btn == flightBtn){
            leftBtnImage = R.drawable.super_man_crest;
            setPower("Flight", leftBtnImage);
        }
        else if(btn == webBtn){
            leftBtnImage = R.drawable.spider_web;
            setPower("Web Slinging", leftBtnImage);
        }
        else if(btn == laserBtn){
            leftBtnImage = R.drawable.laser_vision;
            setPower("Laser Vision", leftBtnImage);
        }
        else if(btn == superStrengthBtn){
            leftBtnImage = R.drawable.super_strength;
            setPower("Super Strength", leftBtnImage);
        }
        
        btn.setCompoundDrawablesWithIntrinsicBounds(leftBtnImage,0,R.drawable.item_selected,0);
    }

    private void setPower(String power, int image){
        MainActivity mainActivity = (MainActivity)getActivity();
        mainActivity.setPowerType(power, image);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
