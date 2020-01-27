package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class gallery extends AppCompatActivity {
    ImageView cat,dog,tiger,lion,giraff,flyingfish;
  int tophone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gallery);
        cat = findViewById(R.id.cat);
        dog=findViewById(R.id.dog);
        tiger=findViewById(R.id.tiger);
        lion=findViewById(R.id.lion);
        giraff=findViewById(R.id.giraff);
        flyingfish=findViewById(R.id.flyfish);

        dog.setImageResource(R.drawable.dog);
        tiger.setImageResource(R.drawable.tiger);
        cat.setImageResource(R.drawable.cat);
        flyingfish.setImageResource(R.drawable.flyingfish);
        lion.setImageResource(R.drawable.lion);
        giraff.setImageResource(R.drawable.giraff);

//        Window w =getWindow();
//        w.setTitle("Gallery");

        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tophone = R.drawable.cat;
                InputStream a = getResources().openRawResource(tophone);
                Bitmap bitmap = BitmapFactory.decodeStream(a);
                popup(bitmap);
            }
        });
        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tophone=R.drawable.dog;
                InputStream a = getResources().openRawResource(tophone);
                Bitmap bitmap = BitmapFactory.decodeStream(a);
                popup(bitmap);
            }
        });
        tiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tophone=R.drawable.tiger;
                InputStream a = getResources().openRawResource(tophone);
                Bitmap bitmap = BitmapFactory.decodeStream(a);
                popup(bitmap);
            }
        });
        lion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tophone=R.drawable.lion;
                InputStream a = getResources().openRawResource(tophone);
                Bitmap bitmap = BitmapFactory.decodeStream(a);
                popup(bitmap);
            }
        });
        giraff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tophone=R.drawable.giraff;
                InputStream a = getResources().openRawResource(tophone);
                Bitmap bitmap = BitmapFactory.decodeStream(a);
                popup(bitmap);
            }
        });
        flyingfish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tophone=R.drawable.flyingfish;
                InputStream a = getResources().openRawResource(tophone);
                Bitmap bitmap = BitmapFactory.decodeStream(a);
//                Intent intent = new Intent(gallery.this, viewimage.class);
//                intent.putExtra("name", "flyingfish");
//                startActivity(intent);
                popup(bitmap);
            }
        });


    }
private void popup (Bitmap imgview){
    AlertDialog.Builder alertdailog = new AlertDialog.Builder(this);
    alertdailog.setMessage("You have selected his image");
    ImageView img =new ImageView(this);
   img.setImageBitmap(imgview);
   alertdailog.setView(img);
   alertdailog.create();

   alertdailog.show();
}

}
