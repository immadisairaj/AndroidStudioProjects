package com.example.immad.quiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Solution extends AppCompatActivity {

    @BindView(R.id.rv_solutions)
    RecyclerView solutions;

    Question q;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_solution);
        ButterKnife.bind(this);

        RecyclerView.Adapter solutionsAdapter = new SolutionsAdapter(q.Answers,
                q.Answer,
                q.optA,
                q.optB,
                q.optC,
                q.optD);
        solutions.setAdapter(solutionsAdapter);
    }
}
