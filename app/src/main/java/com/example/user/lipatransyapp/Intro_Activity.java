package com.example.user.lipatransyapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Intro_Activity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout mainLayout;
    private Button btnNext;
    private ViewPagerAdapter viewPagerAdapter;
    private int[] layouts;
    private LinearLayout llmain;
    private TextView[] position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        viewPager = (ViewPager) findViewById(R.id.vpPager);
        mainLayout = (LinearLayout) findViewById(R.id.llMain);

        btnNext = (Button) findViewById(R.id.btnNext);


        layouts = new int[]{
                R.layout.screen1,
                R.layout.screen2

        };




        viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int current = getItem(+1);
                if (current < layouts.length) {
                    // move to next screen
                    viewPager.setCurrentItem(current);
                } else {
                    startMainScreen();
                }
            }
        });


    }


    private void startMainScreen() {
        Intent intent = new Intent(Intro_Activity.this, com.example.user.lipatransyapp.MainActivity.class);
        startActivity(intent);
        finish();

    }

    private int getItem(int i) {

        return viewPager.getCurrentItem() + i;
    }


    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {

//
            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                btnNext.setText("Start");
//                btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                btnNext.setText("Next");
//                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };


    public class ViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public ViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

}
