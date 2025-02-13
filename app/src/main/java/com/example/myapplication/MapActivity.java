package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class MapActivity extends AppCompatActivity {

    private TextView startText, finishText, distanceText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // 지도 이미지 설정
        ImageView mapImageView = findViewById(R.id.mapImageView);
        mapImageView.setImageResource(R.drawable.map_background);  // map_background.png 파일 설정

        // 출발지, 도착지, 남은 거리 정보 표시
        startText = findViewById(R.id.startText);
        finishText = findViewById(R.id.finishText);
        distanceText = findViewById(R.id.distanceText);

        // 출발지, 도착지, 남은 거리 정보 표시
        startText.setText("출발지: AAA");
        finishText.setText("도착지: BBB");
        distanceText.setText("도착지까지 남은 거리: 10km");
    }
}
