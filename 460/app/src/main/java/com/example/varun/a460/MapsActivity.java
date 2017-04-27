package com.example.varun.a460;

import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.support.annotation.InterpolatorRes;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.ConnectivityManager;

import java.util.*;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    public static Context ctx;
    public static ConnectivityManager connectivityManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


         //WifiManager wifiManager = (WifiManager) ctx.getSystemService(Context.WIFI_SERVICE);

        //ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(ctx.CONNECTIVITY_SERVICE);
     //   connectivityManager = (ConnectivityManager) ctx.getSystemService(ctx.CONNECTIVITY_SERVICE);

        //NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        //wifiManager.startScan().on
       // Network [] network = connectivityManager.getAllNetworks();
        //networkInfo.isConnected();
    }

    public void createWifiManager(){
        WifiManager wifiManager = (WifiManager) ctx.getSystemService(ctx.WIFI_SERVICE);
    }

    /**Found on stack overflow**/
    public boolean isNetworkAvailable()
    {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo.isAvailable() && networkInfo.isConnected()){
            return true; //Ready to access
        }
        else {
            return true;
        }
    }

    /**General method**/
    public int getSignalStrength(WifiManager wifiManager, int numberOfLevels)
    {
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
       // int level =
        return WifiManager.calculateSignalLevel(wifiInfo.getRssi(), numberOfLevels);

    }

    /***Get current signal strength**/


    /**Stack overflow**/
    public List<Integer> getSignalStrengList(WifiManager wifiManager, int numberOfLevels){
        List<ScanResult> wifiList = wifiManager.getScanResults();
        List<Integer> SignalLevels = new ArrayList<Integer>(wifiList.size());
        Integer level;
        for(ScanResult result : wifiList) {
            level = ((Integer) WifiManager.calculateSignalLevel(result.level, numberOfLevels));
            SignalLevels.add(level);
        }

        return SignalLevels;

    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }



}
