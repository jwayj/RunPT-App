package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


public class Main extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println(savedInstanceState);
        if (savedInstanceState == null) {
            // 인텐트에서 openFragment 값을 확인
            String openFragment = getIntent().getStringExtra("openFragment");
            Fragment fragmentToShow;

            if ("running".equals(openFragment)) {
                fragmentToShow = new RunningFragment();
            } else {
                // 기본값으로 RunningFragment를 사용하거나 다른 프래그먼트를 선택할 수 있습니다.
                fragmentToShow = new RunningFragment();
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragmentToShow)
                    .commit();
        }

        setupBottomNavigation();
    }

    private void setupBottomNavigation() {
        ImageView challengeIcon = findViewById(R.id.ic_challenge_icon);
        ImageView runningIcon = findViewById(R.id.nav_running_icon);
        ImageView recordIcon = findViewById(R.id.nav_record_icon);
        ImageView mypageIcon = findViewById(R.id.nav_mypage_icon);

        View.OnClickListener navigationClickListener = v -> {
            Fragment selectedFragment = null;
            int id = v.getId();

            if (id == R.id.ic_challenge_icon) {
                selectedFragment = new BadgeFragment();
            } else if (id == R.id.nav_running_icon) {
                selectedFragment = new RunningFragment();
            } else if (id == R.id.nav_record_icon) {
                selectedFragment = new RecordFragment();
            } else if (id == R.id.nav_mypage_icon) {
                selectedFragment = new MyPageFragment();
            }

            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
            }
        };

        challengeIcon.setOnClickListener(navigationClickListener);
        runningIcon.setOnClickListener(navigationClickListener);
        recordIcon.setOnClickListener(navigationClickListener);
        mypageIcon.setOnClickListener(navigationClickListener);
    }
}




