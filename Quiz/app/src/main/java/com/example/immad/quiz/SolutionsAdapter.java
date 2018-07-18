package com.example.immad.quiz;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

class SolutionsAdapter extends RecyclerView.Adapter<SolutionsAdapter.SolutionViewHolder> {

    private int[] Answers;
    private int[] Answer;
    private String[] optA;
    private String[] optB;
    private String[] optC;
    private String[] optD;

    SolutionsAdapter(int[] answers, int[] answer, String[] optionsA, String[] optionsB, String[] optionsC, String[] optionsD) {
        Answers = answers;
        Answer = answer;
        optA = optionsA;
        optB = optionsB;
        optC = optionsC;
        optD = optionsD;
    }

    @Override
    public int getItemCount() {
        return Answers.length;
    }

    @Override
    public void onBindViewHolder(@NonNull SolutionViewHolder solutionViewHolder, int i) {
        String qus = (i + 1) + " Question";
        String ans = "";
        String corr = "";

        switch (Answers[i]) {
            case -1:
                ans = "Not Attempted";
                break;
            case 1:
                ans = 1 + " " + optA[i];
                break;
            case 2:
                ans = 2 + " " + optB[i];
                break;
            case 3:
                ans = 3 + " " + optC[i];
                break;
            case 4:
                ans = 4 + " " + optD[i];
                break;
        }

        switch (Answer[i]) {
            case 1:
                corr = 1 + " " + optA[i];
                break;
            case 2:
                corr = 2 + " " + optB[i];
                break;
            case 3:
                corr = 3 + " " + optC[i];
                break;
            case 4:
                corr = 4 + " " + optD[i];
                break;
        }

        solutionViewHolder.question.setText(qus);
        solutionViewHolder.answered.setText(ans);
        solutionViewHolder.correct.setText(corr);

        if (Answer[i] == Answers[i])
            solutionViewHolder.answered.setTextColor(Color.GREEN);
        else
            solutionViewHolder.answered.setTextColor(Color.RED);
    }

    @NonNull
    @Override
    public SolutionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SolutionViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.relative, viewGroup, false));
    }


    class SolutionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_question)
        TextView question;

        @BindView(R.id.tv_answered)
        TextView answered;

        @BindView(R.id.tv_correct)
        TextView correct;

        SolutionViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

}
