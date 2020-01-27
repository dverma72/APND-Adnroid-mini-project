package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.chrisbanes.photoview.PhotoView;
import com.google.android.material.snackbar.Snackbar;

public class SingleViewActivity extends AppCompatActivity {
//    private ScaleGestureDetector mScaleGestureDetector;
//    private float mScaleFactor = 1.0f;
//    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view);

        // Get intent data
        Intent i = getIntent();

        // Selected image id
    final      int position = i.getExtras().getInt("id");

      final   ImageAdapter imageAdapter = new ImageAdapter(this);
//ViewPager viewPager =findViewById(R.id.viewpage);
       final PhotoView imageView = findViewById(R.id.SingleView);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);
        Button left =findViewById(R.id.left);
        Button right =findViewById(R.id.right);
        final int[] demoid = {position};
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(demoid[0] !=0){
                    imageView.setImageResource(imageAdapter.mThumbIds[demoid[0] -1]);
                    demoid[0] = demoid[0] -1;

                }
                else {
                    Snackbar.make(v, "Click of Right Button", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(demoid[0] <imageAdapter.mThumbIds.length-1){
                    imageView.setImageResource(imageAdapter.mThumbIds[demoid[0] +1]);
                    demoid[0] = demoid[0] +1;

                }
                else {
                    Snackbar.make(v, "Click of left Button", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

    }
}





//
//
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        return mScaleGestureDetector.onTouchEvent(event);
//
//    }
//
//    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
//        @Override
//        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
//            mScaleFactor *= scaleGestureDetector.getScaleFactor();
//            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 5.0f));
//
//            mImageView.setScaleX(mScaleFactor);
//            mImageView.setScaleY(mScaleFactor);
//            return true;
//        }
