package com.example.firstproject.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.firstproject.R;
import com.example.firstproject.YoutubeConfig;
import com.example.firstproject.gridview;
import com.example.firstproject.ui.home.HomeViewModel;
import com.example.firstproject.youtube;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;



import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {
    Button gallery, abc, xyz,about,music ,btnvolleydemo;
    private HomeViewModel homeViewModel;
    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

//        slideshowViewModel =ViewModelProviders.of(this).get(SlideshowViewModel.class);

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
//        Log.d(TAG,"onCreate Starting");
        final TextView textView = root.findViewById(R.id.text_slideshow);
        gallery=root.findViewById(R.id.gallery);
        abc=root.findViewById(R.id.gridview);
        xyz=root.findViewById((R.id.xyz));
        music=root.findViewById((R.id.music));
        about=root.findViewById((R.id.aboutus)) ;
        btnvolleydemo=root.findViewById((R.id.btnvolleydemo)) ;

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery =new Intent(getActivity(), com.example.firstproject.gallery.class);
                startActivity(gallery);

            }
        });
        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"GridView",Toast.LENGTH_LONG).show();
                Intent gallery =new Intent(getActivity(), gridview.class);
                startActivity(gallery);
            }
        });
        xyz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Youtube",Toast.LENGTH_LONG).show();
                Intent youtube = new Intent(getActivity(), com.example.firstproject.youtube.class);
                startActivity(youtube);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Fill the Details",Toast.LENGTH_LONG).show();

                Intent game = new Intent(getActivity(), com.example.firstproject.game_start.class);
                startActivity(game);
            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Play Some Song",Toast.LENGTH_LONG).show();

                Intent game = new Intent(getActivity(), com.example.firstproject.music.class);
                startActivity(game);
            }
        });
        btnvolleydemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Volley ---Calling Json from server",Toast.LENGTH_LONG).show();

                Intent game = new Intent(getActivity(), com.example.firstproject.volleydemo.class);
                startActivity(game);
            }
        });

//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;


    }
}