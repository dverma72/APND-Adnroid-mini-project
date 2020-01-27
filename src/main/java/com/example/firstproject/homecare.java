package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;

import android.app.DatePickerDialog;
//import android.app.FragmentTransaction;
import android.app.FragmentTransaction;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.firstproject.ui.home.HomeFragment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class homecare extends AppCompatActivity {
    ImageView selectdate, selecttime;

    Button submit;
    EditText date, time, address;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homecare);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        selectdate = findViewById(R.id.date_img);
        selecttime = findViewById(R.id.time_img);
        submit = findViewById(R.id.submit);
        address = findViewById(R.id.address);
//        Window w =getWindow();
//        w.setTitle("Request for Homecare");
//Getting Current Date


        selectdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(homecare.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        selecttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(homecare.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String in =(hourOfDay+":"+minute).toString();
                        int  h=hourOfDay;
                        int m=minute;
                        if(h<0||h>23||m<0||m>59)
                            time.setText("Invalid Input");
                        else
                        if (h<12)
                            time.setText(h+":"+m+" AM");
                        else
                        if(h==12)
                            time.setText(h+":"+m+" PM");
                        else
                            time.setText((h-12)+":"+m+" PM");

                    }
                }, mHour, mMinute, false);

                timePickerDialog.show();


            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (date.getText().toString().trim().equals("")) {
                    date.setError("Date is Required!");
                } else if (time.getText().toString().trim().equals("")) {
                    time.setError("Select Time");
                } else if (address.getText().toString().equals("")) {
                    address.setError("Enter Your Address");

                } else {
                    Toast.makeText(homecare.this, "Submitted successfully", Toast.LENGTH_LONG).show();

                    Intent intent =new Intent(homecare.this,home.class);
                    startActivity(intent);











//                    Fragment newFragment = new HomeFragment();
//                    // consider using Java coding conventions (upper first char class names!!!)
//                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
//                    // Replace whatever is in the fragment_container view with this fragment,
//                    // and add the transaction to the back stack
//
//                    transaction.replace(R.id.nav_home, newFragment);
//                    transaction.addToBackStack(null);
//
//                    // Commit the transaction
//                    transaction.commit();


                }

            }
        });

    }
}
