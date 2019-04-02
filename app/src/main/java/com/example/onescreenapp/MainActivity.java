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

        showPoints(1, teamAScore);
        showPoints(2, teamBScore);
    }

    public void add3ToTeamA(View view) {
        teamAScore = teamAScore + 3;
        showPoints(1, teamAScore);
    }

    public void add2ToTeamA(View view) {
        teamAScore = teamAScore + 2;
        showPoints(1, teamAScore);
    }

    public void addFreeThrowToTeamA(View view) {
        teamAScore = teamAScore + randomizer();
        showPoints(1, teamAScore);
    }

    public void add3ToTeamB(View view) {
        teamBScore = teamBScore + 3;
        showPoints(2, teamBScore);
    }

    public void add2ToTeamB(View view) {
        teamBScore = teamBScore + 2;
        showPoints(2, teamBScore);
    }

    public void addFreeThrowToTeamB(View view) {
        int numbefore = teamBScore;
        teamBScore = teamBScore + randomizer();
        int numAfter = teamBScore;
        int randomNum = numAfter - numbefore;
        if(randomNum >= 0 && randomNum <= 3) {
            showPoints(2, teamBScore);
        }
    }

    public void resetScore(View view) {
        teamAScore = 0;
        showPoints(1, teamAScore);
        teamBScore = 0;
        showPoints(2, teamBScore);
    }

    private void showPoints(int flag, int points) {
        TextView teamScore = findViewById(R.id.TeamAScore);
        if (flag == 1) {
            teamScore = findViewById(R.id.TeamAScore);
        } else if (flag == 2) {
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