package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Queue;

public class volleydemo extends AppCompatActivity {

    String url;
    TextView txtvolley ;
    Button parse;
   private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volleydemo);
        txtvolley = findViewById(R.id.txtvolley);
        parse = findViewById(R.id.parse);

        parse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                jsonparse();
            }
        });


    }


    private void jsonparse(){
//        url = "http://api.myjson.com/bins/kp9wz";
//        url = "https://jsonplaceholder.typicode.com/posts";
        url = "https://raw.githubusercontent.com/dverma72/Api/master/Json_dummy_api.json";
         queue = Volley.newRequestQueue(volleydemo.this);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("Respone ", "Responce: "+response);

                try {
                    Toast.makeText(volleydemo.this,"Value is showing from the server",Toast.LENGTH_SHORT).show();
                    JSONArray jsonArray =response.getJSONArray(String.valueOf("employees"));
                    txtvolley.setText("");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject employee =jsonArray.getJSONObject(i);
                        String Name =employee.getString("firstname");
                        int age =employee.getInt("age");
                        String mail =employee.getString("mail");

                        txtvolley.append("Name = "+String.valueOf(Name)+", Age = " +String.valueOf(age)+" \n"+ " Email = "+mail+" \n\n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
txtvolley.setText(e.toString());
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error",error.toString());
                Toast.makeText(volleydemo.this,"toast"+error,Toast.LENGTH_SHORT).show();
            }
        });
            queue.add(request);
    }
}
