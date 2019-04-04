package com.example.project;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.FloatingActionButton;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import java.util.Scanner;

/**
 * A simple {@link Fragment} subclass.
 */
public class Contact2Fragment extends Fragment implements OnMapReadyCallback {
    Scanner scanner = new Scanner(System.in);
    GoogleMap mMap;
    double lat, lng;

    public Contact2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_contact_map, container, false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng CCU = new LatLng(23.558581, 120.471984);//經緯度
        mMap.addMarker(new MarkerOptions().position(CCU).title("施工"));
        LatLng CCU2 = new LatLng(23.554112, 120.471760);//經緯度
        mMap.addMarker(new MarkerOptions().position(CCU2).title("施工"));
        LatLng CCU3 = new LatLng(23.555232, 120.471720);//經緯度
        mMap.addMarker(new MarkerOptions().position(CCU3).title("施工"));
        LatLng CCU4 = new LatLng(23.556255, 120.471698);//經緯度
        mMap.addMarker(new MarkerOptions().position(CCU4).title("施工"));
        LatLng CCU5 = new LatLng(23.560212, 120.445500);//經緯度
        mMap.addMarker(new MarkerOptions().position(CCU5).title("道路顛簸"));

        mMap.getUiSettings().setCompassEnabled(true);       // 左上角的指南針，要兩指旋轉才會出現

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CCU, 15));// 移動鏡頭,zoom放大地圖

        //點擊新增事件
       mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {

                MarkerOptions marker = new MarkerOptions().position(new LatLng(point.latitude, point.longitude)).title("");
                mMap.addMarker(marker);
            }
        });

    }
    
}
