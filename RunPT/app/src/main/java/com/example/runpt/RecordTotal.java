package com.example.runpt;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.data.AppDatabase;
import com.example.data.RecordData;
import com.example.data.RecordDataDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RecordTotal extends AppCompatActivity {

    private AppDatabase db;
    private RecordDataDao recordDataDao;
    private LinearLayout buttonContainer, paginationContainer;
    private List<RecordData> records;
    private int currentPage = 1;
    private final int pageSize = 3;        // 한 페이지에 표시할 버튼(레코드) 수
    private int totalPages = 1;
    private final int pagesPerGroup = 5;     // 한 그룹에 표시할 페이지 번호 수

    private PaginationController paginationController;

    @Override
    protected void onPause() {
        super.onPause();
        getSharedPreferences("app_prefs", MODE_PRIVATE)
                .edit()
                .putInt("currentPage", currentPage)
                .apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordtotal); // activity_main.xml에 buttonContainer, paginationContainer가 있어야 함

        buttonContainer = findViewById(R.id.buttonContainer);
        paginationContainer = findViewById(R.id.paginationContainer);

        // Room 데이터베이스 인스턴스 생성
        db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "my_database.db")
                .fallbackToDestructiveMigration()
                .build();
        recordDataDao = db.RecordDataDao();

        // 만약 savedInstanceState가 있으면 currentPage 복원
        if (savedInstanceState == null) {
            currentPage = getSharedPreferences("app_prefs", MODE_PRIVATE)
                    .getInt("currentPage", 1);
        } else {
            currentPage = savedInstanceState.getInt("currentPage", 1);
        }

        // 한 스레드 내에서 샘플 데이터 삽입 및 DB 조회 처리
        new Thread(new Runnable() {
            @Override
            public void run() {

                /*recordDataDao.deleteAllRecords();
                Log.d("DB_DELETE", "All records have been deleted.");

                // 먼저, DB에 저장된 레코드가 14개 미만인 경우 샘플 데이터 14개를 삽입
                List<RecordData> existingRecords = recordDataDao.getAllRecords();
                if (existingRecords.size() < 14) {
                    for (int i = 0; i < 31; i++) {
                        RecordData record = new RecordData();
                        record.time = 3700;         // 시간: 3700초
                        record.distance = 8.17;        // 거리: 6 km
                        // 페이스 계산: time / distance (초/킬로미터)
                        record.pace = record.time / (double) record.distance;
                        // 삽입 날짜는 현재 시간 (밀리초)
                        record.insertionDate = new Date().getTime();
                        long insertedId = recordDataDao.insertRecord(record);
                        Log.d("DB_SAMPLE", "Inserted record id: " + insertedId);
                    }
                }*/


                // 삽입 후 DB의 모든 레코드를 조회
                records = recordDataDao.getAllRecords();
                Log.d("DB", "Total records: " + records.size());

                // 총 페이지 수 계산
                totalPages = (records.size() + pageSize - 1) / pageSize;
                if (totalPages < 1) totalPages = 1;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 현재 페이지의 레코드를 표시
                        displayPage(currentPage);
                        // PaginationController를 생성하고 페이지 네비게이션 버튼을 표시
                        paginationController = new PaginationController(
                                RecordTotal.this,
                                paginationContainer,
                                currentPage,
                                totalPages,
                                pagesPerGroup,
                                new PaginationController.OnPageSelectedListener() {
                                    @Override
                                    public void onPageSelected(int page) {
                                        currentPage = page;
                                        displayPage(currentPage);
                                    }
                                }
                        );
                        paginationController.render();
                    }
                });
            }
        }).start();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // 현재 페이지 번호 저장
        outState.putInt("currentPage", currentPage);
    }

    // 현재 페이지에 해당하는 레코드들을 custom_button.xml을 이용해 동적으로 생성하여 buttonContainer에 추가
    private void displayPage(int page) {
        buttonContainer.removeAllViews();
        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, records.size());
        LayoutInflater inflater = LayoutInflater.from(this);

        // 날짜 포맷: "yyyy년 MM월 dd일 EEE"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 EEE", Locale.getDefault());

        for (int i = startIndex; i < endIndex; i++) {
            final RecordData record = records.get(i);
            // custom_button.xml을 인플레이트 (미리 분리해 둔 커스텀 버튼 레이아웃)
            View customButton = inflater.inflate(R.layout.custom_button, buttonContainer, false);

            // custom_button.xml 내부의 각 TextView 참조
            TextView tvDate = customButton.findViewById(R.id.tvDate);
            TextView tvTime = customButton.findViewById(R.id.tvTime);
            TextView tvDistance = customButton.findViewById(R.id.tvDistance);
            TextView tvPace = customButton.findViewById(R.id.tvPace);

            // 데이터 포맷팅
            String formattedDate = dateFormat.format(new Date(record.insertionDate));
            String formattedTime = Converter.secondsToHMS(record.time);
            String formattedDistance = record.distance + " km";
            String formattedPace = Converter.calculatePace(record.time, record.distance);

            // 각 TextView에 데이터 설정
            tvDate.setText(formattedDate);
            tvTime.setText(formattedTime);
            tvDistance.setText(formattedDistance);
            tvPace.setText(formattedPace);

            // 커스텀 버튼 클릭 시 SecondActivity로 record.id를 전달
            customButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("CustomButton", "Clicked record id: " + record.id);
                    Intent intent = new Intent(RecordTotal.this, RecordDetail.class);
                    intent.putExtra("record_id", record.id);
                    startActivity(intent);
                }
            });

            // 각 버튼에 margin 추가
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            int marginInDp = (int) (8 * getResources().getDisplayMetrics().density + 0.5f);
            params.setMargins(marginInDp, marginInDp, marginInDp, marginInDp);
            customButton.setLayoutParams(params);

            // 생성된 커스텀 버튼을 버튼 컨테이너에 추가
            buttonContainer.addView(customButton);
        }
    }
}
