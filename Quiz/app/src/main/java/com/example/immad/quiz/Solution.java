package com.example.immad.quiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Solution extends AppCompatActivity {

    static ArrayList<Integer> Answers;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_solution);
        ButterKnife.bind(this);

        Answers = getIntent().getIntegerArrayListExtra("Answer");

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    public static ArrayList<Integer> getAnswer() {
        return Answers;
    }
}
