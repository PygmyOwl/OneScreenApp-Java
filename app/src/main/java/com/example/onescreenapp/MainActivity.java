package com.example.onescreenapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int teamAScore;
    int teamBScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add3ToTeamA(View view) {
        addAndShowPoints(1, 3);
    }

    public void add2ToTeamA(View view) {
        addAndShowPoints(1, 2);
    }

    public void addFreeThrowToTeamA(View view) {
        addAndShowPoints(1, randomizer());
    }

    public void add3ToTeamB(View view) {
        addAndShowPoints(2, 3);
    }

    public void add2ToTeamB(View view) {
        addAndShowPoints(2, 2);
    }

    public void addFreeThrowToTeamB(View view) {
        addAndShowPoints(2, randomizer());
    }

    public void resetScore(View view) {
        teamAScore = 0;
        addAndShowPoints(1, teamAScore);
        teamBScore = 0;
        addAndShowPoints(2, teamBScore);
    }

    private void addAndShowPoints(int flag, int value) {
        TextView teamScore = findViewById(R.id.TeamAScore);
        int points = 0;
        if (flag == 1) {
            teamAScore += value;
            points = teamAScore;
            teamScore = findViewById(R.id.TeamAScore);
        } else if (flag == 2) {
            teamBScore += value;
            points = teamBScore;
            teamScore = findViewById(R.id.TeamBScore);
        }
        String scoreInString = ("" + points);
        teamScore.setText(scoreInString);
    }

    private int randomizer() {
        Random randomizer = new Random();
        return randomizer.nextInt(4);
    }
}