package com.example.immad.quiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    Question qAndA = new Question();

    int ques, score, ans, nextC;

    public int[] Answers = new int[qAndA.Question.length];


    String q_nos = "Question: " + 1 + " out of " + qAndA.Question.length;

    @BindView(R.id.q_numbers)
    TextView q_no;

    @BindView(R.id.question)
    TextView questions;

    @BindView(R.id.optionA)
    RadioButton opA;

    @BindView(R.id.optionB)
    RadioButton opB;

    @BindView(R.id.optionC)
    RadioButton opC;

    @BindView(R.id.optionD)
    RadioButton opD;

    @BindView(R.id.options)
    RadioGroup optionsGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        q_no.setText(q_nos);
        questions = findViewById(R.id.question);
        questions.setText(qAndA.Question[0]);
        opA.setText(qAndA.optA[0]);
        opB.setText(qAndA.optB[0]);
        opC.setText(qAndA.optC[0]);
        opD.setText(qAndA.optD[0]);

        ques = 0;
        score = 0;
        ans = 0;
        nextC = 0;
    }

    public void goNext() {
        ques++;
        if (ques >= qAndA.Question.length) {
            ques = qAndA.Question.length - 1;
        }

        q_nos = "Question: " + (ques + 1) + " out of " + qAndA.Question.length;
        q_no.setText(q_nos);
        questions.setText(qAndA.Question[ques]);
        opA.setText(qAndA.optA[ques]);
        opB.setText(qAndA.optB[ques]);
        opC.setText(qAndA.optC[ques]);
        opD.setText(qAndA.optD[ques]);
    }

    public void checkScore() {
        if (qAndA.Answer[ques] == ans) {
            score++;
            ans = 0;
        }
    }

    public void clickNext(View view) {
        nextC++;

        int selectedId = optionsGroup.getCheckedRadioButtonId();

        switch (selectedId) {
            case R.id.optionA:
                ans = 1;
                break;
            case R.id.optionB:
                ans = 2;
                break;
            case R.id.optionC:
                ans = 3;
                break;
            case R.id.optionD:
                ans = 4;
                break;
            default: ans = 0;
        }
        Answers[ques] = ans;
        if (nextC <= qAndA.Question.length) {
            checkScore();
        }
        if (ques < qAndA.Question.length - 2) {
            optionsGroup.clearCheck();
            goNext();
        } else if (ques == qAndA.Question.length - 2) {
            Button button = findViewById(R.id.next);
            button.setVisibility(View.INVISIBLE);
            button = findViewById(R.id.submit);
            button.setVisibility(View.VISIBLE);
            optionsGroup.clearCheck();
            goNext();
        }
    }

    public void clickSubmit(View view) {
        clickNext(view);

        Context context = getApplicationContext();
        CharSequence text = "Scored " + score + " out of " + qAndA.Question.length;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Button submit = findViewById(R.id.submit);
        submit.setVisibility(View.INVISIBLE);

        Button ans = findViewById(R.id.b_solution);
        ans.setVisibility(View.VISIBLE);
    }

    public void clickSolutions(View view) {

        Intent solutions = new Intent(MainActivity.this, Solution.class);
        solutions.putExtra("Answer", Answers);
        startActivity(solutions);
    }
}