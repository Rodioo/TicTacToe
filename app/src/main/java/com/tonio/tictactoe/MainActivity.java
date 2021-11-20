package com.tonio.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();
    Runnable runnable;

    private static int turn = 0;
    private static int xWins = 0;
    private static int oWins = 0;
    private String win = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView xWinsTV = findViewById(R.id.xWins);
        TextView oWinsTV = findViewById(R.id.oWins);
        String auxX = getResources().getString(R.string.xWins) + xWins;
        xWinsTV.setText(auxX);
        String auxO = getResources().getString(R.string.oWins) + oWins;
        oWinsTV.setText(auxO);
    }
    @Override
    protected void onResume() {

        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                handler.postDelayed(runnable, 1000);
                checkWin();
            }
        }, 1000);
        super.onResume();
    }
    public void clickTile(View v)
    {
        Button b = (Button) v;
        TextView turnTV = findViewById(R.id.turn);
        if(turn % 2 == 0)
        {
            b.setText("X");
            turnTV.setText(getResources().getString(R.string.oTurn));
        }
        else
        {
            b.setText("0");
            turnTV.setText(getResources().getString(R.string.xTurn));
        }
        b.setEnabled(false);
        turn++;


    }
    private void checkWin()
    {
        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);
        Button b4 = findViewById(R.id.button4);
        Button b5 = findViewById(R.id.button5);
        Button b6 = findViewById(R.id.button6);
        Button b7 = findViewById(R.id.button7);
        Button b8 = findViewById(R.id.button8);
        Button b9 = findViewById(R.id.button9);
        Button r = findViewById(R.id.reset);
        TextView turnTV = findViewById(R.id.turn);
        if(b1.getText() != "" && b1.getText() == b2.getText() && b2.getText() == b3.getText())
        {
            greenBtns(b1, b2, b3);
            disableBtns();
            win = b1.getText().toString();
            String aux = win + " won.";
            turnTV.setText(aux);
        }
        else if(b4.getText() != "" && b4.getText() == b5.getText() && b5.getText() == b6.getText())
        {
            greenBtns(b4, b5, b6);
            disableBtns();
            win = b4.getText().toString();
            String aux = win + " won.";
            turnTV.setText(aux);
        }
        else if(b7.getText() != "" && b7.getText() == b8.getText() && b8.getText() == b9.getText())
        {
            greenBtns(b7, b8, b9);
            disableBtns();
            win = b7.getText().toString();
            String aux = win + " won.";
            turnTV.setText(aux);
        }
        else if(b1.getText() != "" && b1.getText() == b4.getText() && b4.getText() == b7.getText())
        {
            greenBtns(b1, b4, b7);
            disableBtns();
            win = b1.getText().toString();
            String aux = win + " won.";
            turnTV.setText(aux);
        }
        else if(b2.getText() != "" && b2.getText() == b5.getText() && b5.getText() == b8.getText())
        {
            greenBtns(b2, b5, b8);
            disableBtns();
            win = b2.getText().toString();
            String aux = win + " won.";
            turnTV.setText(aux);
        }
        else if(b3.getText() != "" && b3.getText() == b6.getText() && b6.getText() == b9.getText())
        {
            greenBtns(b3, b6, b9);
            disableBtns();
            win = b3.getText().toString();
            String aux = win + " won.";
            turnTV.setText(aux);
        }

        else if(b1.getText() != "" && b1.getText() == b5.getText() && b5.getText() == b9.getText())
        {
            greenBtns(b1, b5, b9);
            disableBtns();
            win = b1.getText().toString();
            String aux = win + " won.";
            turnTV.setText(aux);
        }
        else if(b3.getText() != "" && b3.getText() == b5.getText() && b5.getText() == b7.getText())
        {
            greenBtns(b3, b5, b7);
            disableBtns();
            win = b3.getText().toString();
            String aux = win + " won.";
            turnTV.setText(aux);
        }
        else if(b1.getText() != "" && b2.getText() != "" && b3.getText() != "" &&
                b4.getText() != "" && b5.getText() != "" && b6.getText() != "" &&
                b7.getText() != "" && b8.getText() != "" && b9.getText() != "")
        {
            turnTV.setText(getResources().getString(R.string.tie));

        }

    }
    private void disableBtns()
    {
        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);
        Button b4 = findViewById(R.id.button4);
        Button b5 = findViewById(R.id.button5);
        Button b6 = findViewById(R.id.button6);
        Button b7 = findViewById(R.id.button7);
        Button b8 = findViewById(R.id.button8);
        Button b9 = findViewById(R.id.button9);
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);
    }
    private void resetGame()
    {
        turn = 0;
        win = "";
        TextView turnTV = findViewById(R.id.turn);
        turnTV.setText(getResources().getString(R.string.xTurn));
        if(turn > 0)
        {
            if(turn % 2 == 0)
                turnTV.setText(getResources().getString(R.string.oTurn));
            else
                turnTV.setText(getResources().getString(R.string.xTurn));
        }
        Button b1 = findViewById(R.id.button1);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);
        Button b4 = findViewById(R.id.button4);
        Button b5 = findViewById(R.id.button5);
        Button b6 = findViewById(R.id.button6);
        Button b7 = findViewById(R.id.button7);
        Button b8 = findViewById(R.id.button8);
        Button b9 = findViewById(R.id.button9);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);
        b7.setEnabled(true);
        b8.setEnabled(true);
        b9.setEnabled(true);
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        b1.setBackgroundColor(getResources().getColor(R.color.grey));
        b2.setBackgroundColor(getResources().getColor(R.color.grey));
        b3.setBackgroundColor(getResources().getColor(R.color.grey));
        b4.setBackgroundColor(getResources().getColor(R.color.grey));
        b5.setBackgroundColor(getResources().getColor(R.color.grey));
        b6.setBackgroundColor(getResources().getColor(R.color.grey));
        b7.setBackgroundColor(getResources().getColor(R.color.grey));
        b8.setBackgroundColor(getResources().getColor(R.color.grey));
        b9.setBackgroundColor(getResources().getColor(R.color.grey));
    }
    private void greenBtns(Button b1, Button b2, Button b3)
    {
        b1.setBackgroundColor(getResources().getColor(R.color.green));
        b2.setBackgroundColor(getResources().getColor(R.color.green));
        b3.setBackgroundColor(getResources().getColor(R.color.green));
    }
    public void addWin(View v)
    {
        TextView xWinsTV = findViewById(R.id.xWins);
        TextView oWinsTV = findViewById(R.id.oWins);
        if(win.equals("X"))
            xWins++;
        else if(win.equals("0"))
            oWins++;
        String auxX = getResources().getString(R.string.xWins) + xWins;
        xWinsTV.setText(auxX);
        String auxO = getResources().getString(R.string.oWins) + oWins;
        oWinsTV.setText(auxO);
        resetGame();
    }

}