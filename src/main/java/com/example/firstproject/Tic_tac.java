package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Tic_tac extends AppCompatActivity {
    Boolean gameactive=true;

    //0-x
    //1-o

TextView status ,player1_name,player2_name,player1_score,player2_score;
    int activeplayer=0;
    int[] gameState={2,2,2,2,2,2,2,2,2,2};
    //State meaning
    //0-x
    //1-o
    //2-null
String player2,player1;
    int [][] winpositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int remaining_term=9;
int score1=0,score2=0 ;
    private void gamerest(View view) {
        gameactive =true;
        activeplayer=0;
         remaining_term=9;
        for(int i=0; i<gameState.length;i++ ){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        status =findViewById(R.id.status);
        status.setText("Tap to Play");
    }
    public void playertap (final View view){

        if(remaining_term==0){
            gameactive = false;
            status.setText("Tap to Play");
            gamerest(view);
//            remaining_term--;
        }else{
        status =findViewById(R.id.status);
        ImageView img =(ImageView)view;
        int tappedimage=Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            gamerest(view);
        }
        if(gameState[tappedimage]==2){
            gameState[tappedimage]=activeplayer;
            img.setTranslationX(-1000f);
            if(activeplayer==0){
                img.setImageResource(R.drawable.x);
                activeplayer=1;
                remaining_term--;
                status.setText(player2+"'s turn - Tap to replay");
            } else if ((activeplayer==1)){
                img.setImageResource(R.drawable.o);
                activeplayer=0;
                remaining_term--;
                status.setText(player1+"'s turn - Tap to replay");
            }else{
                gamerest(view);
            }
            img.animate().translationXBy(1000f).setDuration(300);
            for(int[] WinPosition: winpositions ){
                if(gameState[WinPosition[0]]==gameState[WinPosition[1]]&&
                        gameState[WinPosition[1]]==gameState[WinPosition[2]]&&
                            gameState[WinPosition[0]]!=2){
                    //SomeBody has win! - find who
                        String winnerstr;
                            if(gameState[WinPosition[0]]==0){
                                winnerstr=player1+" has won";
                                status.setText(winnerstr);
                                gameactive=false;
                                LinearLayout layout = new LinearLayout(this);
                                layout.setOrientation(LinearLayout.VERTICAL);
                                layout.setPadding(20,20,20,300);
                                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                                ad.setTitle("Congratulations");
                                ImageView img_win = new ImageView(this);
                                img_win.setImageResource(R.drawable.win);


                                TextView text =new TextView(this);
                                text.setText(player1);
                                text.setGravity(Gravity.CENTER);
                                text.setTextSize(50);

                                layout.addView(img_win);
                                layout.addView(text);

                                ad.setView(layout);
                                ad.setPositiveButton("Play Again :)", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        score1=score1+1;
                                        player1_score.setText(""+score1);
                                        gamerest(view);
                                    }
                                }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(Tic_tac.this,"Thank you "+ player1+" for playing Tic Tac toe Visit Again ::)",Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(Tic_tac.this,home.class);
                                        startActivity(intent);

                                    }
                                });
//                                ad.setView(img_win);
//                                ad.setView(text);
                                ad.create();
                                ad.show();


//                                if(!gameactive){
//                                    gamerest(view);
//
//                                }
                            }else{
                                winnerstr=player2+" has Won";
                                status.setText(winnerstr);
                                gameactive=false;
                                LinearLayout layout = new LinearLayout(this);
                                layout.setOrientation(LinearLayout.VERTICAL);
                                layout.setPadding(20,20,20,50);
                                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                                ad.setTitle("Congratulations");
                                ImageView img_win = new ImageView(this);
                                img_win.setImageResource(R.drawable.win);
                                img_win.setMaxWidth(50);
                                img_win.setMaxHeight(50);
                                TextView text =new TextView(this);
                                text.setText(player2);
                                text.setGravity(Gravity.CENTER);
                                text.setTextSize(50);
                                layout.addView(img_win);
                                layout.addView(text);
                                ad.setView(layout);
                               ad.setPositiveButton("Play Again :)", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        score2=score2+1;
                                        player2_score.setText(""+score2);
                                        gamerest(view);
                                    }
                                }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(Tic_tac.this,"Thank you "+ player2+" for playing Tic Tac toe Visit Again ::)",Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(Tic_tac.this,home.class);
                                        startActivity(intent);

                                    }
                                });
                                ad.create();
                                ad.show();

                            }


                }
            }


        }

        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac);
        player1_name=findViewById(R.id.player1_name);
        player2_name=findViewById(R.id.player2_name);
        player1_score=findViewById(R.id.player1_score);
        player2_score=findViewById(R.id.player2_score);

//        player1_score.setText(score1);
//        player2_score.setText(score2);

        // Retrieving the value using its keys
// the file name must be same in both saving
// and retrieving the data
//        SharedPreferences sd = getSharedPreferences("game_data", Context.MODE_PRIVATE);

// The value will be default as empty string
// because for the very first time
// when the app is opened,
// there is nothing to show
        player1= getIntent().getStringExtra("player1");
        player2= getIntent().getStringExtra("player2");
//        player1 = sd.getString("player1", "");
//        player2 = sd.getString("player2", "");

// We can then use the data
        player1_name.setText(player1);
        player2_name.setText(player2);

    }

}
