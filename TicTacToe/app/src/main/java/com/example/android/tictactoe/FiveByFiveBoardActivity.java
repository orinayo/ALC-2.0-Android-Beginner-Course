package com.example.android.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * TicTacToe activity created by Orinayo on 22/03/2018.
 */

public class FiveByFiveBoardActivity extends AppCompatActivity {

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
    private Button boxOne, boxTwo, boxThree, boxFour, boxFive, boxSix, boxSeven, boxEight, boxNine, boxTen, boxEleven,
    boxTwelve, boxThirteen, boxFourteen, boxFifteen, boxSixteen, boxSeventeen, boxEighteen, boxNineteen, boxTwenty,
    boxTwentyOne, boxTwentyTwo, boxTwentyThree, boxTwentyFour, boxTwentyFive;
    private int moves = 0;
    private int xScore = 0;
    private int oScore = 0;
    private int drawScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_by_five_board);
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
        boxTen = (Button) findViewById(R.id.boxTen);
        boxEleven = (Button) findViewById(R.id.boxEleven);
        boxTwelve = (Button) findViewById(R.id.boxTwelve);
        boxThirteen = (Button) findViewById(R.id.boxThirteen);
        boxFourteen = (Button) findViewById(R.id.boxFourteen);
        boxFifteen = (Button) findViewById(R.id.boxFifteen);
        boxSixteen = (Button) findViewById(R.id.boxSixteen);
        boxSeventeen = (Button) findViewById(R.id.boxSeventeen);
        boxEighteen = (Button) findViewById(R.id.boxEighteen);
        boxNineteen = (Button) findViewById(R.id.boxNineteen);
        boxTwenty = (Button) findViewById(R.id.boxTwenty);
        boxTwentyOne = (Button) findViewById(R.id.boxTwentyOne);
        boxTwentyTwo = (Button) findViewById(R.id.boxTwentyTwo);
        boxTwentyThree = (Button) findViewById(R.id.boxTwentyThree);
        boxTwentyFour = (Button) findViewById(R.id.boxTwentyFour);
        boxTwentyFive = (Button) findViewById(R.id.boxTwentyFive);

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
        buttons.add(boxTen);
        buttons.add(boxEleven);
        buttons.add(boxTwelve);
        buttons.add(boxThirteen);
        buttons.add(boxFourteen);
        buttons.add(boxFifteen);
        buttons.add(boxSixteen);
        buttons.add(boxSeventeen);
        buttons.add(boxEighteen);
        buttons.add(boxNineteen);
        buttons.add(boxTwenty);
        buttons.add(boxTwentyOne);
        buttons.add(boxTwentyTwo);
        buttons.add(boxTwentyThree);
        buttons.add(boxTwentyFour);
        buttons.add(boxTwentyFive);

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
                boxTen.setText("");
                boxEleven.setText("");
                boxTwelve.setText("");
                boxThirteen.setText("");
                boxFourteen.setText("");
                boxFifteen.setText("");
                boxSixteen.setText("");
                boxSeventeen.setText("");
                boxEighteen.setText("");
                boxNineteen.setText("");
                boxTwenty.setText("");
                boxTwentyOne.setText("");
                boxTwentyTwo.setText("");
                boxTwentyThree.setText("");
                boxTwentyFour.setText("");
                boxTwentyFive.setText("");

                boxOne.setTextColor(blackColor);
                boxTwo.setTextColor(blackColor);
                boxThree.setTextColor(blackColor);
                boxFour.setTextColor(blackColor);
                boxFive.setTextColor(blackColor);
                boxSix.setTextColor(blackColor);
                boxSeven.setTextColor(blackColor);
                boxEight.setTextColor(blackColor);
                boxNine.setTextColor(blackColor);
                boxTen.setTextColor(blackColor);
                boxEleven.setTextColor(blackColor);
                boxTwelve.setTextColor(blackColor);
                boxThirteen.setTextColor(blackColor);
                boxFourteen.setTextColor(blackColor);
                boxFifteen.setTextColor(blackColor);
                boxSixteen.setTextColor(blackColor);
                boxSeventeen.setTextColor(blackColor);
                boxEighteen.setTextColor(blackColor);
                boxNineteen.setTextColor(blackColor);
                boxTwenty.setTextColor(blackColor);
                boxTwentyOne.setTextColor(blackColor);
                boxTwentyTwo.setTextColor(blackColor);
                boxTwentyThree.setTextColor(blackColor);
                boxTwentyFour.setTextColor(blackColor);
                boxTwentyFive.setTextColor(blackColor);
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
                buttons.add(boxTen);
                buttons.add(boxEleven);
                buttons.add(boxTwelve);
                buttons.add(boxThirteen);
                buttons.add(boxFourteen);
                buttons.add(boxFifteen);
                buttons.add(boxSixteen);
                buttons.add(boxSeventeen);
                buttons.add(boxEighteen);
                buttons.add(boxNineteen);
                buttons.add(boxTwenty);
                buttons.add(boxTwentyOne);
                buttons.add(boxTwentyTwo);
                buttons.add(boxTwentyThree);
                buttons.add(boxTwentyFour);
                buttons.add(boxTwentyFive);
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
                boxTen.setText("");
                boxEleven.setText("");
                boxTwelve.setText("");
                boxThirteen.setText("");
                boxFourteen.setText("");
                boxFifteen.setText("");
                boxSixteen.setText("");
                boxSeventeen.setText("");
                boxEighteen.setText("");
                boxNineteen.setText("");
                boxTwenty.setText("");
                boxTwentyOne.setText("");
                boxTwentyTwo.setText("");
                boxTwentyThree.setText("");
                boxTwentyFour.setText("");
                boxTwentyFive.setText("");

                boxOne.setTextColor(blackColor);
                boxTwo.setTextColor(blackColor);
                boxThree.setTextColor(blackColor);
                boxFour.setTextColor(blackColor);
                boxFive.setTextColor(blackColor);
                boxSix.setTextColor(blackColor);
                boxSeven.setTextColor(blackColor);
                boxEight.setTextColor(blackColor);
                boxNine.setTextColor(blackColor);
                boxTen.setTextColor(blackColor);
                boxEleven.setTextColor(blackColor);
                boxTwelve.setTextColor(blackColor);
                boxThirteen.setTextColor(blackColor);
                boxFourteen.setTextColor(blackColor);
                boxFifteen.setTextColor(blackColor);
                boxSixteen.setTextColor(blackColor);
                boxSeventeen.setTextColor(blackColor);
                boxEighteen.setTextColor(blackColor);
                boxNineteen.setTextColor(blackColor);
                boxTwenty.setTextColor(blackColor);
                boxTwentyOne.setTextColor(blackColor);
                boxTwentyTwo.setTextColor(blackColor);
                boxTwentyThree.setTextColor(blackColor);
                boxTwentyFour.setTextColor(blackColor);
                boxTwentyFive.setTextColor(blackColor);
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
                buttons.add(boxTen);
                buttons.add(boxEleven);
                buttons.add(boxTwelve);
                buttons.add(boxThirteen);
                buttons.add(boxFourteen);
                buttons.add(boxFifteen);
                buttons.add(boxSixteen);
                buttons.add(boxSeventeen);
                buttons.add(boxEighteen);
                buttons.add(boxNineteen);
                buttons.add(boxTwenty);
                buttons.add(boxTwentyOne);
                buttons.add(boxTwentyTwo);
                buttons.add(boxTwentyThree);
                buttons.add(boxTwentyFour);
                buttons.add(boxTwentyFive);
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
            case R.id.boxTen:
                makeAMove(boxTen);
                break;
            case R.id.boxEleven:
                makeAMove(boxEleven);
                break;
            case R.id.boxTwelve:
                makeAMove(boxTwelve);
                break;
            case R.id.boxThirteen:
                makeAMove(boxThirteen);
                break;
            case R.id.boxFourteen:
                makeAMove(boxFourteen);
                break;
            case R.id.boxFifteen:
                makeAMove(boxFifteen);
                break;
            case R.id.boxSixteen:
                makeAMove(boxSixteen);
                break;
            case R.id.boxSeventeen:
                makeAMove(boxSeventeen);
                break;
            case R.id.boxEighteen:
                makeAMove(boxEighteen);
                break;
            case R.id.boxNineteen:
                makeAMove(boxNineteen);
                break;
            case R.id.boxTwenty:
                makeAMove(boxTwenty);
                break;
            case R.id.boxTwentyOne:
                makeAMove(boxTwentyOne);
                break;
            case R.id.boxTwentyTwo:
                makeAMove(boxTwentyTwo);
                break;
            case R.id.boxTwentyThree:
                makeAMove(boxTwentyThree);
                break;
            case R.id.boxTwentyFour:
                makeAMove(boxTwentyFour);
                break;
            case R.id.boxTwentyFive:
                makeAMove(boxTwentyFive);
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
        String boxTenText = boxTen.getText().toString();
        String boxElevenText = boxEleven.getText().toString();
        String boxTwelveText = boxTwelve.getText().toString();
        String boxThirteenText = boxThirteen.getText().toString();
        String boxFourteenText = boxFourteen.getText().toString();
        String boxFifteenText = boxFifteen.getText().toString();
        String boxSixteenText = boxSixteen.getText().toString();
        String boxSeventeenText = boxSeventeen.getText().toString();
        String boxEighteenText = boxEighteen.getText().toString();
        String boxNineteenText = boxNineteen.getText().toString();
        String boxTwentyText = boxTwenty.getText().toString();
        String boxTwentyOneText = boxTwentyOne.getText().toString();
        String boxTwentyTwoText = boxTwentyTwo.getText().toString();
        String boxTwentyThreeText = boxTwentyThree.getText().toString();
        String boxTwentyFourText = boxTwentyFour.getText().toString();
        String boxTwentyFiveText = boxTwentyFive.getText().toString();

        //String that displays the win or draw message
        String playerWins;

        if (playerCharacter.equals(boxOneText) && playerCharacter.equals(boxTwoText) && playerCharacter.equals(boxThreeText)
                && playerCharacter.equals(boxFourText) && playerCharacter.equals(boxFiveText)) {
            makeCharactersGreen(boxOne, boxTwo, boxThree, boxFour, boxFive);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxOneText) && playerCharacter.equals(boxSixText) && playerCharacter.equals(boxElevenText)
                && playerCharacter.equals(boxSixteenText) && playerCharacter.equals(boxTwentyOneText)) {
            makeCharactersGreen(boxOne, boxSix, boxEleven, boxSixteen, boxTwentyOne);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxOneText) && playerCharacter.equals(boxSevenText) && playerCharacter.equals(boxThirteenText)
                && playerCharacter.equals(boxNineteenText) && playerCharacter.equals(boxTwentyFiveText)) {
            makeCharactersGreen(boxOne, boxSeven, boxThirteen, boxNineteen, boxTwentyFive);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxTwoText) && playerCharacter.equals(boxSevenText) && playerCharacter.equals(boxTwelveText)
                && playerCharacter.equals(boxSeventeenText) && playerCharacter.equals(boxTwentyTwoText)) {
            makeCharactersGreen(boxTwo, boxSeven, boxTwelve, boxSeventeen, boxTwentyTwo);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxThreeText) && playerCharacter.equals(boxEightText) && playerCharacter.equals(boxThirteenText)
                && playerCharacter.equals(boxEighteenText) && playerCharacter.equals(boxTwentyThreeText)) {
            makeCharactersGreen(boxThree, boxEight, boxThirteen, boxEighteen, boxTwentyThree);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxFourText) && playerCharacter.equals(boxNineText) && playerCharacter.equals(boxFourteenText)
                && playerCharacter.equals(boxNineteenText) && playerCharacter.equals(boxTwentyFourText)) {
            makeCharactersGreen(boxFour, boxNine, boxFourteen, boxNineteen, boxTwentyFour);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxFiveText) && playerCharacter.equals(boxNineText) && playerCharacter.equals(boxThirteenText)
                && playerCharacter.equals(boxSeventeenText) && playerCharacter.equals(boxTwentyOneText)) {
            makeCharactersGreen(boxFive, boxNine, boxThirteen, boxSeventeen, boxTwentyOne);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxFiveText) && playerCharacter.equals(boxTenText) && playerCharacter.equals(boxFifteenText)
                && playerCharacter.equals(boxTwentyText) && playerCharacter.equals(boxTwentyFiveText)) {
            makeCharactersGreen(boxFive, boxTen, boxFifteen, boxTwenty, boxTwentyFive);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxSixText) && playerCharacter.equals(boxSevenText) && playerCharacter.equals(boxEightText)
                && playerCharacter.equals(boxNineText) && playerCharacter.equals(boxTenText)) {
            makeCharactersGreen(boxSix, boxSeven, boxEight, boxNine, boxTen);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxElevenText) && playerCharacter.equals(boxTwelveText) && playerCharacter.equals(boxThirteenText)
                && playerCharacter.equals(boxFourteenText) && playerCharacter.equals(boxFifteenText)) {
            makeCharactersGreen(boxEleven, boxTwelve, boxThirteen, boxFourteen, boxFifteen);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxSixteenText) && playerCharacter.equals(boxSeventeenText) && playerCharacter.equals(boxEighteenText)
                && playerCharacter.equals(boxNineteenText) && playerCharacter.equals(boxTwentyText)) {
            makeCharactersGreen(boxSixteen, boxSeventeen, boxEighteen, boxNineteen, boxTwenty);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        } else if (playerCharacter.equals(boxTwentyOneText) && playerCharacter.equals(boxTwentyTwoText) && playerCharacter.equals(boxTwentyThreeText)
                && playerCharacter.equals(boxTwentyFourText) && playerCharacter.equals(boxTwentyFiveText)) {
            makeCharactersGreen(boxTwentyOne, boxTwentyTwo, boxTwentyThree, boxTwentyFour, boxTwentyFive);
            playerWins = getString(R.string.player_wins, player);
            gameStatus.setText(playerWins);
            setPlayerScore(playerCharacter);
            gameOver();
        }else if (moves == 25) {
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
    public void makeCharactersGreen (Button buttonOne, Button buttonTwo, Button buttonThree, Button buttonFour, Button buttonFive) {
        //Get green color
        int greenColor = getResources().getColor(R.color.green_background);
        buttonOne.setTextColor(greenColor);
        buttonTwo.setTextColor(greenColor);
        buttonThree.setTextColor(greenColor);
        buttonFour.setTextColor(greenColor);
        buttonFive.setTextColor(greenColor);
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
