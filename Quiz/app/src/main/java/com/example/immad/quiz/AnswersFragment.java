package com.example.immad.quiz;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AnswersFragment extends Fragment {

    Solution solution = new Solution();

    @BindView(R.id.rv_answers)
    RecyclerView solutions;

    Question q;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_answers, container, false);

        ButterKnife.bind(this, view);

        int[] Answers = solution.getAnswer();

        q = new Question();

        AnswerAdapter answerAdapter = new AnswerAdapter(Answers,
                q.Answer,
                q.optA,
                q.optB,
                q.optC,
                q.optD);
        solutions.setAdapter(answerAdapter);

        return view;
    }
}
