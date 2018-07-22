package com.example.immad.quiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Solution extends AppCompatActivity {

    Question q = new Question();
    int[] Answers = new int[q.Question.length];

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_solution);
        ButterKnife.bind(this);

        Bundle extras = this.getIntent().getExtras();
        Answers = extras.getIntArray("Answer");

        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    public int[] getAnswer() {
        return Answers;
    }
}
