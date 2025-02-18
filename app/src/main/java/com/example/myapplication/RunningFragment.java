package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RunningFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    public RunningFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_running, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 지도 초기화
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.mapView);
        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            getChildFragmentManager().beginTransaction()
                    .replace(R.id.mapView, mapFragment)
                    .commit();
        }
        mapFragment.getMapAsync(this);

        // 시작 버튼 클릭 이벤트 처리
        view.findViewById(R.id.startButton).setOnClickListener(v -> {
            // 시작 버튼 클릭 시 팝업창으로 이동
            Intent intent = new Intent(requireContext(), popup.class);
            startActivity(intent);
        });

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // 지도에 마커 추가 (예: 서울)
        LatLng seoul = new LatLng(37.5665, 126.9780);
        mMap.addMarker(new MarkerOptions().position(seoul).title("서울"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seoul, 15));
    }
}

