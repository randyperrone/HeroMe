package com.example.randy.herome.MainActivity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.example.randy.herome.Fragmant.MainFragmant;
import com.example.randy.herome.Fragmant.PickPowerFragmant;
import com.example.randy.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragmant.OnFragmentInteractionListener, PickPowerFragmant.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manage = getSupportFragmentManager();
        Fragment fragment = manage.findFragmentById(R.id.fragmant_container);

        if(fragment == null){
            fragment = new MainFragmant();
            manage.beginTransaction().add(R.id.fragmant_container, fragment).commit();
        }

    }
    public void loadPickPowerScreen(){

        PickPowerFragmant fragment = new PickPowerFragmant();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragmant_container, fragment).addToBackStack(null).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
