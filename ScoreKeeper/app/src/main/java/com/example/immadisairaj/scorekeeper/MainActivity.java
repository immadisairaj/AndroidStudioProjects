package com.example.immadisairaj.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreA = 0, scoreB = 0;

    TextView textTeamA, textTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTeamA = findViewById(R.id.score_a);
        textTeamA.setText("" + scoreA);
        textTeamB = findViewById(R.id.score_b);
        textTeamB.setText("" + scoreB);
    }

    public void touchA(View v) {
        scoreA += 6;
        textTeamA.setText("" + scoreA);
    }

    public void fixedA(View v) {
        scoreA += 3;
        textTeamA.setText("" + scoreA);
    }

    public void safetyA(View v) {
        scoreA += 2;
        textTeamA.setText("" + scoreA);
    }

    public void exA(View v) {
        scoreA += 1;
        textTeamA.setText("" + scoreA);
    }

    public void touchB(View v) {
        scoreB += 6;
        textTeamB.setText("" + scoreB);
    }

    public void fixedB(View v) {
        scoreB += 3;
        textTeamB.setText("" + scoreB);
    }

    public void safetyB(View v) {
        scoreB += 2;
        textTeamB.setText("" + scoreB);
    }

    public void exB(View v) {
        scoreB += 1;
        textTeamB.setText("" + scoreB);
    }

    public void reset(View v) {
        scoreA = 0;
        textTeamA.setText("" + scoreA);
        scoreB = 0;
        textTeamB.setText("" + scoreB);
    }
}
