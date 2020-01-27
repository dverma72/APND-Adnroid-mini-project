package com.example.firstproject;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class youtube extends YouTubeBaseActivity {
    private static final String TAG ="MainActivity";
    Toolbar toolbar;
Button play ,play1,play2;
YouTubePlayerView youTubePlayerView,youTubePlayerView1,youTubePlayerView2;
YouTubePlayer.OnInitializedListener InitListener2,InitListener1,InitListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_youtube);
        Log.d(TAG,"onCreate Starting");
        play =findViewById(R.id.play);
        youTubePlayerView  =findViewById(R.id.view);

//            Toolbar toolbar=findViewById(R.id.toolbar);
//            toolbar.setTitle("Youtube_demo");
//            toolbar.setTitleTextColor(getResources().getColor(R.color.white));
      InitListener = new YouTubePlayer.OnInitializedListener(){
          @Override
          public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
              Log.d(TAG,"onClick :Done initialize.");
              List<String> videolist= new ArrayList<>();
              videolist.add("FWVUM5hgMx8");
              videolist.add("UwsrzCVZAb8");
              videolist.add("PoBePPh5Iko");
              videolist.add("TArgRV6NO8k");
             // youTubePlayer.loadVideos(videolist);
              youTubePlayer.loadVideo("UwsrzCVZAb8");
             // youTubePlayer.loadPlaylist();
          }

          @Override
          public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
              Log.d(TAG,"onClick :Failed to initialize.");
          }
      };
      play.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              youtube.super.onPause();
              youTubePlayerView.initialize(YoutubeConfig.getApiKey(),InitListener);
          }
      });



        //////////////for song

        play1 =findViewById(R.id.play1);
        youTubePlayerView1  =findViewById(R.id.view1);

        InitListener1 = new YouTubePlayer.OnInitializedListener(){
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG,"onClick :Done initialize.");
                List<String> videolist= new ArrayList<>();
                videolist.add("TArgRV6NO8k");
                videolist.add("FWVUM5hgMx8");
                videolist.add("UwsrzCVZAb8");
                videolist.add("PoBePPh5Iko");
                youTubePlayer.loadVideos(videolist);
//                youTubePlayer.loadVideo("TArgRV6NO8k");
                // youTubePlayer.loadPlaylist();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG,"onClick :Failed to initialize.");
            }
        };
        play1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youtube.super.onPause();
                youTubePlayerView1.initialize(YoutubeConfig.getApiKey(),InitListener1);
            }
        });


        //////////////for Play List

        play2 =findViewById(R.id.play2);
        youTubePlayerView2  =findViewById(R.id.view2);

        InitListener2 = new YouTubePlayer.OnInitializedListener(){
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG,"onClick :Done initialize.");
                List<String> videolist= new ArrayList<>();
                videolist.add("TArgRV6NO8k");
                videolist.add("FWVUM5hgMx8");
                videolist.add("UwsrzCVZAb8");
                videolist.add("PoBePPh5Iko");
//                youTubePlayer.loadVideos(videolist);
//                youTubePlayer.loadVideo("TArgRV6NO8k");
                 youTubePlayer.loadPlaylist("PLOcMSsuppV4q38HhyXXRPxFpwbX_04jf3");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG,"onClick :Failed to initialize.");
            }
        };
        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youtube.super.onPause();
                youTubePlayerView2.initialize(YoutubeConfig.getApiKey(),InitListener2);
            }
        });


    }
}
