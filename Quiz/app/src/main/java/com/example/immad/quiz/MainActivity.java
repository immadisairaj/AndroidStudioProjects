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

    public String[] Question = {
            "According to data on language released as part of Census 2011, which is the most spoken language in India?",
            "Who has been sworn-in as the first-ever visually impaired judge of Pakistan?",
            "Who has broken the legendary Sriram Singh’s four-decade-old 800m National record at the 58th National Inter State Senior Athletics Championships 2018?",
            "Which flagship programme of Ministry of Shipping got ‘Gold Award’ in infrastructure sector in 52nd Skoch Summit 2018?",
            "To detect cervical cancer, a new technique “Liquid Based Cytology (LBC)” has launched in which state?",
            "India has committed to increase its grant to $15 million to the Global Environment Facility (GEF). Who is the representative of India in the GEF Council?",
            "Which state government has announced a new scheme ‘Kanya Van Samruddhi Yojana’?",
            "Which committee has been constituted by the Maharashtra Government to study issues related to floating solar power plant at Ujani dam?",
            "The 2018 Kabir Mahotsav has started in which state to mark the 500th death anniversary of mystic poet and saint Kabir Das?",
            "The Raja Lakhamagouda dam is located in which state?"
    };

    public String[] optA = {
            "Marathi",
            "Yawar Ali",
            "Sangram Singh",
            "Sagarmela",
            "Tamil Nadu",
            "M S Mehta",
            "Punjab",
            "Puneet Mehta committee",
            "Madhya Pradesh",
            "Kerala"
    };

    public String[] optB = {
            "Bengali",
            "Sana Afzal",
            "Jinson Johnson",
            "Sagarmala",
            "Karnataka",
            "Chandra Shekhar",
            "Mizoram",
            "Satish Chavan committee",
            "Rajasthan",
            "Karnataka"
    };

    public String[] optC = {
            "Telugu",
            "Yousaf Saleem",
            "Arka Bhattacharya",
            "Sagarmatha",
            "Haryana",
            "Aparna Subramani",
            "Madhya Pradesh",
            "Akshita Patil committee",
            "Uttar Pradesh",
            "Tamil Nadu"
    };

    public String[] optD = {
            "Hindi",
            "Zubair Sabir",
            "Mohammad Afsal",
            "Sagarmatka",
            "Punjab",
            "Rama Choudhary",
            "Maharashtra",
            "Nidhi Patel committee",
            "Gujarat",
            "Andhra Pradesh"
    };

    public int[] Answer = {
            4, 3, 2, 2, 1, 3, 4, 2, 3, 2
    };

    public int[] Answers = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

    int ques, score, ans, nextC;

    String q_nos = "Question: " + 1 + " out of " + Question.length;

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
        questions.setText(Question[0]);
        opA.setText(optA[0]);
        opB.setText(optB[0]);
        opC.setText(optC[0]);
        opD.setText(optD[0]);

        ques = 0;
        score = 0;
        ans = 0;
        nextC = 0;
    }

    public void goNext() {
        ques++;
        if (ques >= Question.length) {
            ques = Question.length - 1;
        }

        q_nos = "Question: " + (ques + 1) + " out of " + Question.length;
        q_no.setText(q_nos);
        questions.setText(Question[ques]);
        opA.setText(optA[ques]);
        opB.setText(optB[ques]);
        opC.setText(optC[ques]);
        opD.setText(optD[ques]);
    }

    public void checkScore() {
        if (Answer[ques] == ans) {
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
        }
        Answers[ques] = ans;
        if (nextC <= Question.length) {
            checkScore();
        }
        if (ques < Question.length - 2) {
            optionsGroup.clearCheck();
            goNext();
        } else if (ques == Question.length - 2) {
            Button button = findViewById(R.id.next);
            button.setVisibility(view.INVISIBLE);
            button = findViewById(R.id.submit);
            button.setVisibility(view.VISIBLE);
            optionsGroup.clearCheck();
            goNext();
        }
    }

    public void clickSubmit(View view) {
        clickNext(view);

        Context context = getApplicationContext();
        CharSequence text = "Scored " + score + " out of " + Question.length;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Intent solutions = new Intent(MainActivity.this, Solution.class);
        startActivity(solutions);
    }

    public int[] getAnswer() { return Answer; }
    public int[] getAnswers() { return Answers; }
    public String[] getOptionsA() { return optA; }
    public String[] getOptionsB() { return optB; }
    public String[] getOptionsC() { return optC; }
    public String[] getOptionsD() { return optD; }
}