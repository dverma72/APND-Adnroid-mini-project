package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
Button btnlogin ,btnregister;
EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
username=findViewById(R.id.etuser);
password=findViewById(R.id.etpass);
btnregister=findViewById(R.id.btnregister);

btnlogin=findViewById(R.id.btnlogin);
        SharedPreferences sd =this.getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor edit =sd.edit();
//edit.clear();
       password.setText(sd.getString("password",null));
        username.setText(sd.getString("username",null));
        Boolean status=sd.getBoolean("status", false);

if(status==true){
    intent();
}



        btnlogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (username.getText().toString().trim().equals("")) {
            username.setError("Please enter your Username");
        } else if(password.getText().toString().trim().equals("123")) {
            intent();
            SharedPreferences sd =getSharedPreferences("Login", MODE_PRIVATE);
            SharedPreferences.Editor edit =sd.edit();
            edit.putString("username",username.getText().toString());
            edit.putString("passwor",password.getText().toString());

//            Boolean login =true;
            edit.putBoolean("status", true);
            edit.commit();

        }
            else{
password.setError("Plz Enter password as 123 ");
        }
    }
});
btnregister.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        Intent register =new Intent(getApplicationContext(),registration.class);
        startActivity(register);
    }
});

    }

    private void intent(){

        Toast.makeText(login.this, "Welcome " + username.getText(), Toast.LENGTH_SHORT).show();
        Intent home = new Intent(getApplicationContext(), home.class);
        home.putExtra("user_name",username.getText().toString());
        startActivity(home);

    }

}
