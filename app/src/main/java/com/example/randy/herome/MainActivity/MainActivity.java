package com.example.randy.herome.MainActivity;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.example.randy.herome.Fragmant.CharacterBioFragment;
import com.example.randy.herome.Fragmant.MainFragmant;
import com.example.randy.herome.Fragmant.PickPowerFragmant;
import com.example.randy.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragmant.OnFragmentInteractionListener, PickPowerFragmant.OnFragmentInteractionListener, CharacterBioFragment.OnFragmentInteractionListener{

    private String gotPower;
    private int gotPowerImage;
    private String pickPower;
    private int pickPowerImage;

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

    public void loadCharacterBioScreen(){

        CharacterBioFragment fragment = new CharacterBioFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragmant_container, fragment).addToBackStack(null).commit();
    }

    public void setGotPower(String power, int image){
        gotPower = power;
        gotPowerImage = image;
    }

    public String getGotPower(){
        return gotPower;
    }

    public int getGotPowerImage(){
        return gotPowerImage;
    }

    public void setPowerType(String power, int image){
        pickPower = power;
        pickPowerImage = image;
    }

    public String getPowerType(){
        return pickPower;
    }

    public int getPickPowerImage(){
        return pickPowerImage;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
