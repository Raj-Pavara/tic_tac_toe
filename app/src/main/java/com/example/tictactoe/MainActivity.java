package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //Initialization of Array and variable.
    TextView cell[][] = new TextView[3][3];
    EditText player1,player2;
    TextView Exit,Reset,Undo;

    //variables for custom toast.
    View custom_toast_view;
    Toast t;
    TextView tv;

    int diagonal_1[] = new int[2];  //diagonal_1[0] indicate number of X in first diagonal and diagonal_1[1] indicate number of O in first diagonal
    int diagonal_2[] = new int[2];  //diagonal_2[0] indicate number of X in second diagonal and diagonal_2[1] indicate number of O in second diagonals

    int Count; // it is indicate that how many cells are filled

    int Row[][] = new int[3][2];   //Row[i][0] indicate number of X in ith row and Row[i][1] indicate number of O in ith row
    int Col[][] = new int[3][2];    //Col[i][0] indicate number of X in ith col and Col[i][1] indicate number of O in ith col

    char color_player1 = 'G';  //indicate color of textview of player 1  'G' stands for green and 'R' stands for red.

    int I,J;   //I indicate row of cell and J indicate colume of cell

    int undo_count[][] = new int[9][2];   //this array is used for indicate order of cell fill undo_count[i][0] indicate row number and undo_count[i][1] indicate col number

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        store_View();

        set_onclick();


    }


//    this function will store every View into variable and array.
    public void store_View(){
        cell[0][0] = (TextView)findViewById(R.id.cell00);
        cell[0][1] = (TextView)findViewById(R.id.cell01);
        cell[0][2] = (TextView)findViewById(R.id.cell02);
        cell[1][0] = (TextView)findViewById(R.id.cell10);
        cell[1][1] = (TextView)findViewById(R.id.cell11);
        cell[1][2] = (TextView)findViewById(R.id.cell12);
        cell[2][0] = (TextView)findViewById(R.id.cell20);
        cell[2][1] = (TextView)findViewById(R.id.cell21);
        cell[2][2] = (TextView)findViewById(R.id.cell22);

        player1 = (EditText) findViewById(R.id.player1);
        player2 = (EditText) findViewById(R.id.player2);

        Exit = (TextView)findViewById(R.id.exit);
        Reset = (TextView)findViewById(R.id.reset);
        Undo = (TextView)findViewById(R.id.Undo);

       custom_toast_view = getLayoutInflater().inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.viewgroup_customtoast));
        t = new Toast(getApplicationContext());
        tv= custom_toast_view.findViewById(R.id.textView_customtoast);
        t.setDuration(Toast.LENGTH_SHORT);

    }


    //this function will set onclick method for every cell and Button
    public void set_onclick(){

        cell[0][0].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        funz();
                        if(cell[0][0].getText().charAt(0) == ' '){
                            I=0;
                            J=0;
                            set_XO();
                            isFinish();
                        }
                        else{
                            toast("please enter your choice at another cell");
                        }
                    }
                }
        );

        cell[0][1].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        funz();
                        if(cell[0][1].getText().charAt(0) == ' '){
                            I=0;
                            J=1;
                            set_XO();
                            isFinish();
                        }
                        else{
                            toast("please enter your choice at another cell");
                        }
                    }
                }
        );

        cell[0][2].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        funz();
                        if(cell[0][2].getText().charAt(0) == ' '){
                            I=0;
                            J=2;
                            set_XO();
                            isFinish();
                        }
                        else{
                            toast("please enter your choice at another cell");
                        }
                    }
                }
        );

        cell[1][0].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        funz();
                        if(cell[1][0].getText().charAt(0) == ' '){
                            I=1;
                            J=0;
                            set_XO();
                            isFinish();
                        }
                        else{
                            toast("please enter your choice at another cell");
                        }
                    }
                }
        );

        cell[1][1].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        funz();
                        if(cell[1][1].getText().charAt(0) == ' '){
                            I=1;
                            J=1;
                            set_XO();
                            isFinish();
                        }
                        else{
                            toast("please enter your choice at another cell");
                        }
                    }
                }
        );

        cell[1][2].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        funz();
                        if(cell[1][2].getText().charAt(0) == ' '){
                            I=1;
                            J=2;
                            set_XO();
                            isFinish();
                        }
                        else{
                            toast("please enter your choice at another cell");
                        }
                    }
                }
        );

        cell[2][0].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        funz();
                        if(cell[2][0].getText().charAt(0) == ' '){
                            I=2;
                            J=0;
                            set_XO();
                            isFinish();
                        }
                        else{
                            toast("please enter your choice at another cell");
                        }
                    }
                }
        );

        cell[2][1].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        funz();
                        if(cell[2][1].getText().charAt(0) == ' '){
                            I=2;
                            J=1;
                            set_XO();
                            isFinish();
                        }
                        else{
                            toast("please enter your choice at another cell");
                        }
                    }
                }
        );

        cell[2][2].setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        funz();
                        if(cell[2][2].getText().charAt(0) == ' '){
                            I=2;
                            J=2;
                            set_XO();
                            isFinish();
                        }
                        else{
                            toast("please enter your choice at another cell");
                        }
                    }
                }
        );



        //code of Reset Button

        Reset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                cell[i][j].setText(" ");
                                cell[i][j].setTextColor(Color.parseColor("#000000"));
                            }
                            Row[i][0] = 0;
                            Col[i][0] = 0;
                            Row[i][1] = 0;
                            Col[i][1] = 0;
                        }
                        diagonal_1[0] = diagonal_1[1] = diagonal_2[0] = diagonal_2[1] = 0;
                        color_player1 = 'G';
                        player1.setBackgroundColor(Color.parseColor("#4CAF50"));
                        player2.setBackgroundColor(Color.parseColor("#F44336"));
                        Count = 0;

                    }
                }
        );



         //call for Exit button
        AlertDialog.Builder xyz = new AlertDialog.Builder(this);
        xyz.setMessage("Do you went to close this game");
        xyz.setCancelable(true);
        xyz.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      finish();
                    }
                });

        xyz.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog pyq = xyz.create();
        pyq.setTitle("close Game?");
        Exit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pyq.show();
                    }
                }
        );


        //set undo Button

        Undo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       if(Count != 0){
                           int lastrow = undo_count[Count - 1][0];
                           int lastcol = undo_count[Count - 1][1];
                           cell[lastrow][lastcol].setText(" ");
                           cell[lastrow][lastcol].setTextColor(Color.parseColor("#000000"));
                           Count--;
                           if(color_player1 == 'G'){
                               Row[lastrow][1]--;
                               Col[lastcol][1]--;
                               if(lastrow == lastcol){
                                   diagonal_1[1]--;
                               }
                               if(lastrow+lastcol == 2){
                                   diagonal_2[1]--;
                               }
                               color_player1 = 'R';
                               player1.setBackgroundColor(Color.parseColor("#F44336"));
                               player2.setBackgroundColor(Color.parseColor("#4CAF50"));
                           }
                           else{
                               Row[lastrow][0]--;
                               Col[lastcol][0]--;

                               if(lastrow == lastcol){
                                   diagonal_1[0]--;
                               }
                               if(lastrow+lastcol == 2){
                                   diagonal_2[0]--;
                               }
                               color_player1 = 'G';
                               player1.setBackgroundColor(Color.parseColor("#4CAF50"));
                               player2.setBackgroundColor(Color.parseColor("#F44336"));
                           }
                       }
                    }
                }
        );




    }


    //this method is set X or O at (I,J) cell
    public void set_XO() {
        if (color_player1 == 'G') {
            cell[I][J].setTextColor(Color.parseColor("#3F51B5"));
            cell[I][J].setText("X");      //player 1 = 'X  player2 = 'O'
            color_player1 = 'R';
            player1.setBackgroundColor(Color.parseColor("#F44336"));
            player2.setBackgroundColor(Color.parseColor("#4CAF50"));
        } else {
            cell[I][J].setTextColor(Color.parseColor("#FFEB3B"));
            cell[I][J].setText("O");
            color_player1 = 'G';
            player1.setBackgroundColor(Color.parseColor("#4CAF50"));
            player2.setBackgroundColor(Color.parseColor("#F44336"));
        }
           undo_count[Count][0] = I;
           undo_count[Count][1] = J;

    }

        //this method is check weathre any one was win or match was draw.

    public void isFinish(){
        if(cell[I][J].getText().toString().charAt(0) == 'X') {
            Row[I][0]++;
            Col[J][0]++;
            Count++;
            if(I == J){
                diagonal_1[0]++;
            }
            if (I+J == 2){
                diagonal_2[0]++;
            }
            if (Row[I][0] == 3 || Col[J][0] == 3 || diagonal_1[0] == 3 || diagonal_2[0] ==3) {
               toast(player1.getText()+" was win");
                Reset.callOnClick();
                return;
            }
        }
        else{
            Row[I][1]++;
            Col[J][1]++;
            Count++;
            if(I == J){
                diagonal_1[1]++;
            }
            if (I+J == 2){
                diagonal_2[1]++;
            }
               if(Row[I][1] == 3 || Col[J][1] == 3 || diagonal_1[1] == 3 || diagonal_2[1] ==3){
                   toast(player2.getText()+" was win");
                   Reset.callOnClick();
                   return;
                }
            }

        if(Count == 9){
            toast("game was draw");
            Reset.callOnClick();
        }

    }


    public void funz(){
        //this function is set player1 and player2 name when you touch on any cell by default if you can't enter player's name.
        if(player1.getText().toString().equals("")){
            player1.setText("Player1");
        }
        if(player2.getText().toString().equals("")){
            player2.setText("Player2");
        }
    }


    public void toast(String text){

    tv.setText(text);
    t.setView(custom_toast_view);
    t.show();
    }
}