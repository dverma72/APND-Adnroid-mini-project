package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class game_start extends AppCompatActivity {
EditText play1,play2;
Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_start);
        play1 =findViewById( R.id.player1);
        play2 =findViewById( R.id.player2);
        submit =findViewById(R.id.letstart);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (play1.getText().toString().trim().equals("")) {
                    play1.setError("Please enter Player Name ");
                }else if(play2.getText().toString().trim().equals("")){
                    play2.setError("Please enter Player Name");
                }else{
                    // Storing data into SharedPreferences
//                    SharedPreferences sd=getSharedPreferences("game_data",MODE_PRIVATE);
//                    // Creating an Editor object
//                    // to edit(write to the file)
//                    SharedPreferences.Editor edit= sd.edit();
////                    sd.edit().remove("player1");
////                    sd.edit().remove("player2");
////                    edit.commit();
//                    edit.putString(play1.getText().toString(),"player1");
//                    edit.putString(play2.getText().toString(),"player2");
//                    edit.commit();

                    Intent go = new Intent(game_start.this,Tic_tac.class);
                    go.putExtra("player1",play1.getText().toString());
                    go.putExtra("player2",play2.getText().toString());
                    startActivity(go);
                }

            }
        });


    }
}
