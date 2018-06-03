package com.example.orinayo.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int reboundTeamA = 0;
    int reboundTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given rebound for Team A.
     */
    public void displayReboundForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_rebound);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given rebound for Team B.
     */
    public void displayReboundForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_rebound);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * This method displays 3 points when the +3 points button is clicked.
     */
    public void addThreePointsForTeamA (View view) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    /**
     * This method displays 3 points when the +3 points button is clicked.
     */
    public void addThreePointsForTeamB (View view) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    /**
     * This method displays 2 points when the +2 points button is clicked.
     */
    public void addTwoPointsForTeamA (View view) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * This method displays 2 points when the +2 points button is clicked.
     */
    public void addTwoPointsForTeamB (View view) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    /**
     * This method displays 1 point when the free throw button is clicked.
     */
    public void addOnePointForTeamA (View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * This method displays 1 point when the free throw button is clicked.
     */
    public void addOnePointForTeamB (View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * This method displays 1 rebound when the rebound button is clicked.
     */
    public void addReboundForTeamA (View view) {
        reboundTeamA = reboundTeamA + 1;
        displayReboundForTeamA(reboundTeamA);
    }

    /**
     * This method displays 1 rebound when the rebound button is clicked.
     */
    public void addReboundForTeamB (View view) {
        reboundTeamB = reboundTeamB + 1;
        displayReboundForTeamB(reboundTeamB);
    }

    /**
     * This method changes both scores to zero when the reset button is clicked.
     */
    public void reset (View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        reboundTeamA = 0;
        reboundTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayReboundForTeamA(reboundTeamA);
        displayReboundForTeamB(reboundTeamB);
    }
}
