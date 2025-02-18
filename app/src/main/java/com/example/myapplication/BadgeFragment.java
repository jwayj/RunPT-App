package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;

public class BadgeFragment extends Fragment {

    public BadgeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_badge, container, false);

        // 제목 설정
        TextView badgeTitle = view.findViewById(R.id.badge_title);
        badgeTitle.setText("내 배지");

        // 배지 아이템 설정
        ImageView badgeImage1 = view.findViewById(R.id.badge_image_1);
        TextView badgeText1 = view.findViewById(R.id.badge_text_1);

        badgeImage1.setImageResource(R.drawable.badgeex);
        badgeText1.setText("1km");

        ImageView badgeImage2 = view.findViewById(R.id.badge_image_1);
        TextView badgeText2 = view.findViewById(R.id.badge_text_1);

        badgeImage2.setImageResource(R.drawable.badgeex);
        badgeText2.setText("1km");

        ImageView badgeImage3 = view.findViewById(R.id.badge_image_1);
        TextView badgeText3 = view.findViewById(R.id.badge_text_1);

        badgeImage3.setImageResource(R.drawable.badgeex);
        badgeText3.setText("1km");

        ImageView badgeImage4 = view.findViewById(R.id.badge_image_1);
        TextView badgeText4 = view.findViewById(R.id.badge_text_1);

        badgeImage4.setImageResource(R.drawable.badgeex);
        badgeText4.setText("1km");

        ImageView badgeImage5 = view.findViewById(R.id.badge_image_1);
        TextView badgeText5 = view.findViewById(R.id.badge_text_1);

        badgeImage5.setImageResource(R.drawable.badgeex);
        badgeText5.setText("1km");

        ImageView badgeImage6 = view.findViewById(R.id.badge_image_1);
        TextView badgeText6 = view.findViewById(R.id.badge_text_1);

        badgeImage6.setImageResource(R.drawable.badgeex);
        badgeText6.setText("1km");

        ImageView badgeImage7 = view.findViewById(R.id.badge_image_1);
        TextView badgeText7 = view.findViewById(R.id.badge_text_1);

        badgeImage7.setImageResource(R.drawable.badgeex);
        badgeText7.setText("1km");

        ImageView badgeImage8 = view.findViewById(R.id.badge_image_1);
        TextView badgeText8 = view.findViewById(R.id.badge_text_1);

        badgeImage8.setImageResource(R.drawable.badgeex);
        badgeText8.setText("1km");

        ImageView badgeImage9 = view.findViewById(R.id.badge_image_1);
        TextView badgeText9 = view.findViewById(R.id.badge_text_1);

        badgeImage9.setImageResource(R.drawable.badgeex);
        badgeText9.setText("1km");

        ImageView badgeImage10 = view.findViewById(R.id.badge_image_1);
        TextView badgeText10 = view.findViewById(R.id.badge_text_1);

        badgeImage10.setImageResource(R.drawable.badgeex);
        badgeText10.setText("1km");

        ImageView badgeImage11 = view.findViewById(R.id.badge_image_1);
        TextView badgeText11 = view.findViewById(R.id.badge_text_1);

        badgeImage11.setImageResource(R.drawable.badgeex);
        badgeText11.setText("1km");

        ImageView badgeImage12 = view.findViewById(R.id.badge_image_1);
        TextView badgeText12 = view.findViewById(R.id.badge_text_1);

        badgeImage12.setImageResource(R.drawable.badgeex);
        badgeText12.setText("1km");



        return view;
    }
}
