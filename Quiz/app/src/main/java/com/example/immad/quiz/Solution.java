package com.example.immad.quiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

class Solution extends AppCompatActivity {

    private RecyclerView.Adapter solutionsAdapter;

    @BindView(R.id.rv_solutions)
    RecyclerView solutions;

    MainActivity main;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_solution);
        ButterKnife.bind(this);

        solutionsAdapter = new SolutionsAdapter(main.getAnswers(),
                                                main.getAnswer(),
                                                main.getOptionsA(),
                                                main.getOptionsB(),
                                                main.getOptionsC(),
                                                main.getOptionsD());
        solutions.setAdapter(solutionsAdapter);
    }
}
