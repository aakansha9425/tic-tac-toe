package com.example.aakanshasingh.connect4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activeplayer=0;
    boolean activegame=true;
    int [] array={2,2,2,2,2,2,2,2,2};    // 2 means unplayed and have to tap on that square
    int [][] winposition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropIn(View view){     // for making the x and zero in the grid layout


        ImageView counter=(ImageView) view;    // to store the view of different square
        int tapsqr=Integer.parseInt(counter.getTag().toString());   // to store the array index

        if(array[tapsqr]==2&& activegame) {
            array[tapsqr]=activeplayer;
            counter.setTranslationY(-1000f);
            if (activeplayer == 0) {         //0 for zero
                counter.setImageResource(R.drawable.zero);
                activeplayer = 1;      // chance from 0 to 1 i.e zero to x
            } else if (activeplayer == 1) {
                counter.setImageResource(R.drawable.x);    // 1 for x
                activeplayer = 0;     // chance for 1 to 0 i.e x to zero
            }
            counter.animate().translationYBy(1000f).rotationY(1800).setDuration(10);
            for(int[] win :  winposition ) {
                if (array[win[0]] == array[win[1]]
                        &&
                        array[win[1]] == array[win[2]]
                        &&
                            array[win[0]] != 2 ) {
                    activegame=false;
                    System.out.println(array[win[2]]);
                    int winner=array[win[2]];


                   if(winner==0)
                    Toast.makeText(MainActivity.this,"ZERO HAS WON , X BETTER LUCK NEXT TIME!",Toast.LENGTH_SHORT).show();
                  else if(winner ==1)
                       Toast.makeText(MainActivity.this,"X HAS WON , ZERO BETTER LUCK NEXT TIME!!",Toast.LENGTH_SHORT).show();
                  /*else
                      Toast.makeText(MainActivity.this,"DRAW MATCH,BETTER LUCK NEXT TIME",Toast.LENGTH_LONG).show();*/
                  LinearLayout l1 = (LinearLayout)findViewById(R.id.linearLayout2);
                    l1.setVisibility(View.VISIBLE);
                }
                else {
                    boolean gameover = true;
                    for(int c : array){
                        if(c==2)
                            gameover=false;
                    }
                   if(gameover){

                        Toast.makeText(MainActivity.this,"DRAW MATCH,BETTER LUCK NEXT TIME",Toast.LENGTH_SHORT).show();
                        LinearLayout l1 = (LinearLayout)findViewById(R.id.linearLayout2);
                        l1.setVisibility(View.VISIBLE);

                    }
                }



            }
        }




    }
    public  void playagain(View view){
        LinearLayout l1 = (LinearLayout)findViewById(R.id.linearLayout2);
        l1.setVisibility(View.INVISIBLE);
        activegame=true;
        activeplayer=0;
        for(int i=0;i<array.length;i++){
            array[i]=2;
        }
        GridLayout g1=(GridLayout)findViewById(R.id.gridLayout);
        for(int i=0;i<g1.getChildCount();i++){
            ((ImageView)g1.getChildAt(i)).setImageResource(0);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


}
