package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class ordermedicine extends AppCompatActivity {

  ImageView selectdate;
    Button order;
    EditText datefrom,dateto, timeto,timefrom, address ,medicine_name,quantity;
    private int mYear, mMonth, mDay, mHour, mMinute;
//    TextInputLayout lay_med_name,lay__qua,lay_date,lay_from,lay_to,lay_address;
//    LinearLayout from ,to;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordermedicine);

        medicine_name= findViewById(R.id.med_name);
        quantity = findViewById(R.id.quatity);
        datefrom = findViewById(R.id.datefrom);
        dateto = findViewById(R.id.dateto);
        timeto = findViewById(R.id.timeto);
        timefrom = findViewById(R.id.timefrom);
       selectdate =findViewById(R.id.date_img);
        order = findViewById(R.id.order);
        address = findViewById(R.id.address);
//       lay_med_name= findViewById(R.id.lay_med_name);
//       lay__qua=findViewById(R.id.lay_med_name);
//       lay_date=findViewById(R.id.lay_date);
//       lay_from=findViewById(R.id.lay_from);
//       lay_to=findViewById(R.id.lay_to);
//       lay_address=findViewById(R.id.lay_adre);

//        from = findViewById(R.id.from);
//        to = findViewById(R.id.to);

//Getting Current Date


        datefrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(ordermedicine.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        datefrom.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        dateto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(ordermedicine.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateto.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        timefrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(ordermedicine.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String in =(hourOfDay+":"+minute).toString();

                      int  h=hourOfDay;
                       int m=minute;
                        if(h<0||h>23||m<0||m>59)
                            timefrom.setText("Invalid Input");
                        else
                        if (h<12)
                            timefrom.setText(h+":"+m+" AM");
                        else
                        if(h==12)
                            timefrom.setText(h+":"+m+" PM");
                        else
                            timefrom.setText((h-12)+":"+m+" PM");


                    }
                }, mHour, mMinute, false);

                timePickerDialog.show();


            }
        });

        timeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(ordermedicine.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String in =(hourOfDay+":"+minute).toString();

                        int  h=hourOfDay;
                        int m=minute;
                        if(h<0||h>23||m<0||m>59)
                            timeto.setText("Invalid Input");
                        else
                        if (h<12)
                            timeto.setText(h+":"+m+" AM");
                        else
                        if(h==12)
                            timeto.setText(h+":"+m+" PM");
                        else
                            timeto.setText((h-12)+":"+m+" PM");

                    }
                }, mHour, mMinute, false);

                timePickerDialog.show();


            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (medicine_name.getText().toString().trim().equals("")) {
                    medicine_name.setError("Please Enter Medicine Name");

                }
                else if (quantity.getText().toString().trim().equals("")) {
                    quantity.setError("Please Enter quantity of medicine");
                }
                else if (datefrom.getText().toString().trim().equals("")) {
                    datefrom.setError("Please select date");
                }
                else if (dateto.getText().toString().trim().equals("")) {
                    dateto.setError("Please select date");
                } else if (timefrom.getText().toString().trim().equals("")) {
                    timefrom.setError("Please select time duration You are available");
                } else if (timeto.getText().toString().trim().equals("")) {
                   timeto.setError("Please select time duration You are available");
                } else if (address.getText().toString().equals("")) {
                    address.setError("Please Enter Your address");

                } else {
                    Toast.makeText(ordermedicine.this, "Order Placed Successfully", Toast.LENGTH_LONG).show();

                    Intent intent =new Intent(ordermedicine.this,home.class);
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
