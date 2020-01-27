package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class registration extends AppCompatActivity {
EditText etname,etmobile,etemail,etaddress;
Button btnsubmit;
RadioGroup rggender;
RadioButton rbmale,rbfemale;
    String gender=" ";
 String   emailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etname=findViewById(R.id.etname);
        etaddress=findViewById(R.id.etaddress);
        etemail=findViewById(R.id.etemail);
        etmobile=findViewById(R.id.etmobile);
        btnsubmit=findViewById(R.id.btnsubmit);
        rbmale=findViewById(R.id.rbmale);
        rbfemale=findViewById(R.id.rbfemale);
rggender=findViewById(R.id.gender);

        if(rbmale.isSelected()){
             gender="Male";
        }
        if(rbfemale.isSelected()){
            gender="Female";
        }
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etname.getText().toString().trim().equals("")) {
                    Toast.makeText(registration.this, "Plz enter your name", Toast.LENGTH_SHORT).show();

                } else if(etemail.getText().toString().trim().matches(emailPattern)) {

                    Toast.makeText(registration.this, "My name is:  " + etname.getText() + "  My mobile no is"
                            + etmobile.getText() + "   My email is " + etemail.getText() + "   I live in "
                            + etaddress.getText() + "  and I am " + gender, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), login.class);
                    startActivity(intent);
                }
                    else{

                        Toast.makeText(registration.this, "Plz enter valid Email id", Toast.LENGTH_SHORT).show();
                    }
                
            }
        });

    }
}
