package com.example.immad.quiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] Question = {
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

    String[] optA = {
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

    String[] optB = {
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

    String[] optC = {
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

    String[] optD = {
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

    int[] Answer = {
            4, 3, 2, 2, 1, 3, 4, 2, 3, 2
    };

    int ques, score, ans, nextC;

    String q_nos = "Question: " + 1 + " out of " + Question.length;

    TextView q_no, questions;

    RadioButton opA, opB, opC, opD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        q_no = findViewById(R.id.q_numbers);
        q_no.setText(q_nos);
        questions = findViewById(R.id.question);
        questions.setText(Question[0]);

        opA = findViewById(R.id.optionA);
        opA.setText(optA[0]);
        opB = findViewById(R.id.optionB);
        opB.setText(optB[0]);
        opC = findViewById(R.id.optionC);
        opC.setText(optC[0]);
        opD = findViewById(R.id.optionD);
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
        RadioGroup optionsGroup = findViewById(R.id.options);
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
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}