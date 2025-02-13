package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class First2Fragment extends Fragment {

    public First2Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 프래그먼트 레이아웃 연결
        View view = inflater.inflate(R.layout.fragment_first2, container, false);

        // UI 요소 연결
        EditText editStart = view.findViewById(R.id.editStart);
        EditText editDestination = view.findViewById(R.id.editDestination);
        EditText editDistance = view.findViewById(R.id.editDistance);
        RadioGroup radioGroupIncline = view.findViewById(R.id.radioGroupIncline);
        Button btnSearchRoute = view.findViewById(R.id.btnSearchRoute);

        // 버튼 클릭 이벤트
        btnSearchRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String startLocation = editStart.getText().toString();
                String destination = editDestination.getText().toString();
                String distance = editDistance.getText().toString();

                // 경사도 선택 확인
                int selectedInclineId = radioGroupIncline.getCheckedRadioButtonId();
                String incline = "미선택";
                if (selectedInclineId != -1) {
                    RadioButton selectedButton = view.findViewById(selectedInclineId);
                    incline = selectedButton.getText().toString();
                }

                // 결과 표시 (Toast 메시지)
                Toast.makeText(
                        getActivity(),
                        "출발지: " + startLocation + "\n도착지: " + destination +
                                "\n거리: " + distance + " km\n경사도: " + incline,
                        Toast.LENGTH_LONG
                ).show();
            }
        });

        return view;
    }
}
