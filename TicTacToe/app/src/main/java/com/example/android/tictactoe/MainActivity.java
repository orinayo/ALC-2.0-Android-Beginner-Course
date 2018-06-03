package com.example.android.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button singlePlayer, multiPlayer, xCharacter, oCharacter, threeByThreeGrid, fiveByFiveGrid, beginButton;
    boolean singlePlayerMode, multiPlayerMode, xCharacterChosenByPOne, oCharacterChosenByPOne,
            threeByThreeGridMode, fiveByFiveGridMode;
    TextView playerOne, playerTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the button that selects single player mode
        singlePlayer = (Button) findViewById(R.id.singlePlayer);
        // Find the button that selects multiplayer mode
        multiPlayer = (Button) findViewById(R.id.multiPlayer);
        // Find the button that selects X character
        xCharacter = (Button) findViewById(R.id.xCharacter);
        // Find the button that selects O character
        oCharacter = (Button) findViewById(R.id.oCharacter);
        // Find the button that selects 3x3 grid
        threeByThreeGrid = (Button) findViewById(R.id.threeGrids);
        // Find the button that selects 5x5 mode
        fiveByFiveGrid = (Button) findViewById(R.id.fiveGrids);
        // Find the textview that displays player X
        playerOne = (TextView) findViewById(R.id.player1);
        // Find the textview that displays player O
        playerTwo = (TextView) findViewById(R.id.player2);
        // Find the button that begins the game
        beginButton = (Button) findViewById(R.id.beginButton);
        // Set click listener on all buttons
        singlePlayer.setOnClickListener(this);
        multiPlayer.setOnClickListener(this);
        xCharacter.setOnClickListener(this);
        oCharacter.setOnClickListener(this);
        threeByThreeGrid.setOnClickListener(this);
        fiveByFiveGrid.setOnClickListener(this);
        beginButton.setOnClickListener(this);

    }

    // Clear selected options on MainActivity's lifecycle restart
    @Override
    public void onRestart() {
        super.onRestart();
        setContentView(R.layout.activity_main);


        singlePlayer = (Button) findViewById(R.id.singlePlayer);
        multiPlayer = (Button) findViewById(R.id.multiPlayer);
        xCharacter = (Button) findViewById(R.id.xCharacter);
        oCharacter = (Button) findViewById(R.id.oCharacter);
        threeByThreeGrid = (Button) findViewById(R.id.threeGrids);
        fiveByFiveGrid = (Button) findViewById(R.id.fiveGrids);
        playerOne = (TextView) findViewById(R.id.player1);
        playerTwo = (TextView) findViewById(R.id.player2);
        beginButton = (Button) findViewById(R.id.beginButton);
        singlePlayer.setOnClickListener(this);
        multiPlayer.setOnClickListener(this);
        xCharacter.setOnClickListener(this);
        oCharacter.setOnClickListener(this);
        threeByThreeGrid.setOnClickListener(this);
        fiveByFiveGrid.setOnClickListener(this);
        beginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Switch case statement checks which button was pressed
        switch (v.getId()) {
            case R.id.singlePlayer:
                singlePlayer.setBackground(getDrawable(R.drawable.begin_button));
                multiPlayer.setBackground(getDrawable(R.drawable.round_button));
                singlePlayerMode = true;
                multiPlayerMode = false;
                if (playerTwo.getText().toString().equals("2")) {
                    playerTwo.setText(R.string.player_computer);
                } else if (playerOne.getText().toString().equals("2")) {
                    playerOne.setText(R.string.player_computer);
                }
                break;
            case R.id.multiPlayer:
                multiPlayer.setBackground(getDrawable(R.drawable.begin_button));
                singlePlayer.setBackground(getDrawable(R.drawable.round_button));
                multiPlayerMode = true;
                singlePlayerMode = false;
                if (playerTwo.getText().toString().equals("C")) {
                    playerTwo.setText(R.string.player_two);
                } else if (playerOne.getText().toString().equals("C")) {
                    playerOne.setText(R.string.player_two);
                }
                break;
            case R.id.xCharacter:
                if (singlePlayerMode) {
                    playerOne.setVisibility(View.VISIBLE);
                    playerOne.setText(R.string.player_one);
                    xCharacterChosenByPOne = true;
                    oCharacterChosenByPOne = false;
                    playerTwo.setVisibility(View.VISIBLE);
                    playerTwo.setText(R.string.player_computer);
                } else if (multiPlayerMode) {
                    playerOne.setVisibility(View.VISIBLE);
                    playerOne.setText(R.string.player_one);
                    xCharacterChosenByPOne = true;
                    oCharacterChosenByPOne = false;
                    playerTwo.setVisibility(View.VISIBLE);
                    playerTwo.setText(R.string.player_two);
                } else {
                    Toast.makeText(getApplicationContext(), R.string.select_player_mode, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.oCharacter:
                if (singlePlayerMode) {
                    playerTwo.setVisibility(View.VISIBLE);
                    playerTwo.setText(R.string.player_one);
                    oCharacterChosenByPOne = true;
                    xCharacterChosenByPOne = false;
                    playerOne.setVisibility(View.VISIBLE);
                    playerOne.setText(R.string.player_computer);
                } else if (multiPlayerMode) {
                    playerTwo.setVisibility(View.VISIBLE);
                    playerTwo.setText(R.string.player_one);
                    oCharacterChosenByPOne = true;
                    xCharacterChosenByPOne = false;
                    playerOne.setVisibility(View.VISIBLE);
                    playerOne.setText(R.string.player_two);
                } else {
                    Toast.makeText(getApplicationContext(), R.string.select_player_mode, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.threeGrids:
                threeByThreeGrid.setBackground(getDrawable(R.drawable.begin_button));
                fiveByFiveGrid.setBackground(getDrawable(R.drawable.round_button));
                threeByThreeGridMode = true;
                fiveByFiveGridMode = false;
                break;
            case R.id.fiveGrids:
                fiveByFiveGrid.setBackground(getDrawable(R.drawable.begin_button));
                threeByThreeGrid.setBackground(getDrawable(R.drawable.round_button));
                fiveByFiveGridMode = true;
                threeByThreeGridMode = false;
                break;
            case R.id.beginButton:
                if (threeByThreeGridMode) {
                    Intent threeByThreeBoard = new Intent(MainActivity.this, ThreeByThreeBoardActivity.class);

                    //pass players data to ThreeByThreeBoardActivity
                    if (singlePlayerMode) {
                        threeByThreeBoard.putExtra("playerMode", "COM");
                    } else if (multiPlayerMode) {
                        threeByThreeBoard.putExtra("playerMode", "P2");
                    }

                    if (xCharacterChosenByPOne) {
                        threeByThreeBoard.putExtra("playerCharacter", "X");
                    } else if (oCharacterChosenByPOne) {
                        threeByThreeBoard.putExtra("playerCharacter", "O");
                    }

                    startActivity(threeByThreeBoard);
                } else if (fiveByFiveGridMode) {
                    Intent fiveByFiveBoard = new Intent(MainActivity.this, FiveByFiveBoardActivity.class);

                    //pass players data to FiveByFiveBoardBoardActivity
                    if (singlePlayerMode) {
                        fiveByFiveBoard.putExtra("playerMode", "COM");
                    } else if (multiPlayerMode) {
                        fiveByFiveBoard.putExtra("playerMode", "P2");
                    }

                    if (xCharacterChosenByPOne) {
                        fiveByFiveBoard.putExtra("playerCharacter", "X");
                    } else if (oCharacterChosenByPOne) {
                        fiveByFiveBoard.putExtra("playerCharacter", "O");
                    }

                    startActivity(fiveByFiveBoard);
                }
                break;

        }

    }
}
