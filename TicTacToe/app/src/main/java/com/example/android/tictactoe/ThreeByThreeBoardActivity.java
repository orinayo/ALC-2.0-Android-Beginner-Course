package com.example.android.tictactoe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * TicTacToe activity created by Orinayo on 22/03/2018.
 */

public class ThreeByThreeBoardActivity extends AppCompatActivity {

    ArrayList<Button> buttons = new ArrayList<>();
    TextView gameStatus;
    private String selectedCharacter = "";
    private String playerMode = "";
    private String currentPlayer = "";
    private String playerOne = "";
    private String playerTwo = "";
    private String playerAI = "";
    private String playerOneCharacter = "";
    private String playerTwoCharacter = "";
    private Button boxOne, boxTwo, boxThree, boxFour, boxFive, boxSix, boxSeven, boxEight, boxNine;
    private int moves = 0;
    private int xScore = 0;
    private int oScore = 0;
    private int drawScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_by_three_board);
        // Get extra data passed from MainActivity
        Bundle extras = getIntent().getExtras();
        //Check that extra data is not null then pass values
        if (extras != null) {
            playerMode = extras.getString("playerMode");
            selectedCharacter = extras.getString("playerCharacter");
        }

        //Find board buttons
        boxOne = (Button) findViewById(R.id.boxOne);
        boxTwo = (Button) findViewById(R.id.boxTwo);
        boxThree = (Button) findViewById(R.id.boxThree);
        boxFour = (Button) findViewById(R.id.boxFour);
        boxFive = (Button) findViewById(R.id.boxFive);
        boxSix = (Button) findViewById(R.id.boxSix);
        boxSeven = (Button) findViewById(R.id.boxSeven);
        boxEight = (Button) findViewById(R.id.boxEight);
        boxNine = (Button) findViewById(R.id.boxNine);

        //Add board buttons to ArrayList buttons
        buttons.add(boxOne);
        buttons.add(boxTwo);
        buttons.add(boxThree);
        buttons.add(boxFour);
        buttons.add(boxFive);
        buttons.add(boxSix);
        buttons.add(boxSeven);
        buttons.add(boxEight);
        buttons.add(boxNine);

        gameStatus = (TextView) findViewById(R.id.gameStatus);
        gameStatus.setText("");

        //Set players characters, names and the first player
        setPlayersCharacter(selectedCharacter);
        setPlayersNames(playerMode);
        currentPlayer = playerOne;

        //Find buttons that reset board and game
        Button resetBoard = (Button) findViewById(R.id.resetBoard);
        Button resetGame = (Button) findViewById(R.id.resetGame);

        //Click listener that resets board content
        resetBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int blackColor = getResources().getColor(R.color.black);
                boxOne.setText("");
                boxTwo.setText("");
                boxThree.setText("");
                boxFour.setText("");
                boxFive.setText("");
                boxSix.setText("");
                boxSeven.setText("");
                boxEight.setText("");
                boxNine.setText("");
                boxOne.setTextColor(blackColor);
                boxTwo.setTextColor(blackColor);
                boxThree.setTextColor(blackColor);
                boxFour.setTextColor(blackColor);
                boxFive.setTextColor(blackColor);
                boxSix.setTextColor(blackColor);
                boxSeven.setTextColor(blackColor);
                boxEight.setTextColor(blackColor);
                boxNine.setTextColor(blackColor);
                gameStatus.setText("");
                buttons.clear();
                buttons.add(boxOne);
                buttons.add(boxTwo);
                buttons.add(boxThree);
                buttons.add(boxFour);
                buttons.add(boxFive);
                buttons.add(boxSix);
                buttons.add(boxSeven);
                buttons.add(boxEight);
                buttons.add(boxNine);
                moves = 0;
                for (Button button : buttons) {
                    button.setClickable(true);
                }
                setPlayersCharacter(selectedCharacter);
                setPlayersNames(playerMode);
                currentPlayer = playerOne;
            }
        });

        //Click listener that resets board content and score
        resetGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int blackColor = getResources().getColor(R.color.black);
                boxOne.setText("");
                boxTwo.setText("");
                boxThree.setText("");
                boxFour.setText("");
                boxFive.setText("");
                boxSix.setText("");
                boxSeven.setText("");
                boxEight.setText("");
                boxNine.setText("");
                boxOne.setTextColor(blackColor);
                boxTwo.setTextColor(blackColor);
                boxThree.setTextColor(blackColor);
                boxFour.setTextColor(blackColor);
                boxFive.setTextColor(blackColor);
                boxSix.setTextColor(blackColor);
                boxSeven.setTextColor(blackColor);
                boxEight.setTextColor(blackColor);
                boxNine.setTextColor(blackColor);
                gameStatus.setText("");
                buttons.clear();
                buttons.add(boxOne);
                buttons.add(boxTwo);
                buttons.add(boxThree);
                buttons.add(boxFour);
                buttons.add(boxFive);
                buttons.add(boxSix);
                buttons.add(boxSeven);
                buttons.add(boxEight);
                buttons.add(boxNine);
                moves = 0;
                xScore = 0;
                oScore = 0;
                drawScore = 0;
                displayForXScore(xScore);
                displayForOScore(oScore);
                displayForDrawScore(drawScore);
                for (Button button : buttons) {
                    button.setClickable(true);
                }
                setPlayersCharacter(selectedCharacter);
                setPlayersNames(playerMode);
                currentPlayer = playerOne;
            }
        });
    }

    //This method is called when a board button is clicked
    public void buttonPress(View button) {
        //Switch case statement checks which board button was pressed
        switch (button.getId()) {
            case R.id.boxOne:
                makeAMove(boxOne);
                break;
            case R.id.boxTwo:
                makeAMove(boxTwo);
                break;
            case R.id.boxThree:
                makeAMove(boxThree);
                break;
            case R.id.boxFour:
                makeAMove(boxFour);
                break;
            case R.id.boxFive:
                makeAMove(boxFive);
                break;
            case R.id.boxSix:
                makeAMove(boxSix);
                break;
            case R.id.boxSeven:
                makeAMove(boxSeven);
                break;
            case R.id.boxEight:
                makeAMove(boxEight);
                break;
            case R.id.boxNine:
                makeAMove(boxNine);
                break;
        }
    }

    //This method sets player character on the board
    public void makeAMove(Button button) {
        if (currentPlayer.equals(playerOne)) {
            button.setText(playerOneCharacter);
            button.setClickable(false);
            buttons.remove(button);
            moves += 1;
            checkGameProgress(playerOneCharacter, currentPlayer);
        } else if (currentPlayer.equals(playerTwo)) {
            button.setText(playerTwoCharacter);
            button.setClickable(false);
            buttons.remove(button);
            moves += 1;
            checkGameProgress(playerTwoCharacter, currentPlayer);
        }
    }

    //This method places a character for the AI on the board by random
    public void aiMove(ArrayList<Button> buttons) {
        int randomButton = (int) Math.round(Math.random() * buttons.size());
        Button button;
        //If else statement to prevent value of randomButton being greater than the ArrayList buttons' size
        if (randomButton == 0) {
            button = buttons.get(randomButton);
        } else {
            button = buttons.get(randomButton - 1);
        }
        if (gameStatus.getText().toString().matches("")) {
            button.setText(playerTwoCharacter);
            button.setClickable(false);
            buttons.remove(button);
            moves += 1;
            checkGameProgress(playerTwoCharacter, currentPlayer);
        }
    }

    //This method removes the clickable attribute from all board buttons when a game is concluded
    public void gameOver() {
        for (Button button : buttons) {
            button.setClickable(false);
        }
    }

    /**
     * This method checks if the game has a winner or is a tie.
     * @param player making a move
     * @param playerCharacter of the player.
     */
    public void checkGameProgress(String playerCharacter, String player) {
        //Get grid content
        String boxOneText = boxOne.getText().toString();
        String boxTwoText = boxTwo.getText().toString();
        String boxThreeText = boxThree.getText().toString();
        String boxFourText = boxFour.getText().toString();
        String boxFiveText = boxFive.getText().toString();
        String boxSixText = boxSix.getText().toString();
        String boxSevenText = boxSeven.getText().toString();
        String boxEightText = boxEight.getText().toString();
        String boxNineText = boxNine.getText().toString();

        //String that displays the win or draw message
        String playerWins;

        if (playerCharacter.equals(boxOneText) && playerCharacter.equals(boxTwoText) && playerCharacter.equals(boxThreeText)) {
            makeCharactersGreen(boxOne, boxTwo, boxThree);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxOneText) && playerCharacter.equals(boxFourText) && playerCharacter.equals(boxSevenText)) {
            makeCharactersGreen(boxOne, boxFour, boxSeven);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxOneText) && playerCharacter.equals(boxFiveText) && playerCharacter.equals(boxNineText)) {
            makeCharactersGreen(boxOne, boxFive, boxNine);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxTwoText) && playerCharacter.equals(boxFiveText) && playerCharacter.equals(boxEightText)) {
            makeCharactersGreen(boxTwo, boxFive, boxEight);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxThreeText) && playerCharacter.equals(boxSixText) && playerCharacter.equals(boxNineText)) {
            makeCharactersGreen(boxThree, boxSix, boxNine);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxThreeText) && playerCharacter.equals(boxFiveText) && playerCharacter.equals(boxSevenText)) {
            makeCharactersGreen(boxThree, boxFive, boxSeven);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxFourText) && playerCharacter.equals(boxFiveText) && playerCharacter.equals(boxSixText)) {
            makeCharactersGreen(boxFour, boxFive, boxSix);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxSevenText) && playerCharacter.equals(boxEightText) && playerCharacter.equals(boxNineText)) {
            makeCharactersGreen(boxSeven, boxEight, boxNine);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (moves == 9) {
            playerWins = getString(R.string.draw_game);
            gameStatus.setText(playerWins);
            gameOver();
            drawScore += 1;
            displayForDrawScore(drawScore);
        }

        setCurrentPlayer(player);

    }

    //This method sets the players characters
    public void setPlayersCharacter(String selectedCharacter) {
        if ("X".equals(selectedCharacter)) {
            playerOneCharacter = selectedCharacter;
            playerTwoCharacter = "O";
        } else if ("O".equals(selectedCharacter)) {
            playerOneCharacter = selectedCharacter;
            playerTwoCharacter = "X";
        }
    }

    //This method sets the players names
    public void setPlayersNames(String playerMode) {
        if ("COM".equals(playerMode)) {
            playerAI = playerMode;
            playerOne = "P1";
        } else if ("P2".equals(playerMode)) {
            playerOne = "P1";
            playerTwo = playerMode;
        }
    }

    //This method switches turns between players
    public void setCurrentPlayer(String playerName) {
        switch (playerName) {

            case "P1":
                if ("COM".equals(playerAI)) {
                    currentPlayer = playerAI;
                    aiMove(buttons);
                    break;
                } else if ("P2".equals(playerTwo)) {
                    currentPlayer = playerTwo;
                    break;
                }

            case "P2":
            case "COM":
                currentPlayer = playerOne;
                break;
        }
    }

    //This method sets the text color of the winning combination to green
    public void makeCharactersGreen (Button buttonOne, Button buttonTwo, Button buttonThree) {
        //Get green color
        int greenColor = getResources().getColor(R.color.green_background);
        buttonOne.setTextColor(greenColor);
        buttonTwo.setTextColor(greenColor);
        buttonThree.setTextColor(greenColor);
    }

    //This method increases the players score when the player wins
    public void setPlayerScore(String playerCharacter) {
        if ("X".equals(playerCharacter)) {
            xScore += 1;
            displayForXScore(xScore);
        } else if ("O".equals(selectedCharacter)) {
            oScore += 1;
            playerTwoCharacter = "X";
            displayForOScore(oScore);
        }

    }

    //This method displays the score for the player using the X character
    public void displayForXScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.x_score);
        scoreView.setText(String.valueOf(score));
    }

    //This method displays the score for the player using the O character
    public void displayForOScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.o_score);
        scoreView.setText(String.valueOf(score));
    }

    //This method displays the score for how many games have been a tie
    public void displayForDrawScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.draw_score);
        scoreView.setText(String.valueOf(score));
    }

}
