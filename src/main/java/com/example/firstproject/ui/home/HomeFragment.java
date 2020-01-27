package com.example.firstproject.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.firstproject.R;
import com.example.firstproject.gallery;
import com.example.firstproject.gridview;
import com.example.firstproject.home;
import com.example.firstproject.youtube;

public class HomeFragment extends Fragment {
    Button homecare, ordermedicine;
    private AppBarConfiguration mAppBarConfiguration;
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text);
        Toolbar toolbar = root.findViewById(R.id.toolbar);
        DrawerLayout drawer = root.findViewById(R.id.drawer_layout);

        homecare=root.findViewById(R.id.home_care);
        ordermedicine=root.findViewById(R.id.order_medicine);

        homecare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Fill Requierd Details",Toast.LENGTH_LONG).show();
                Intent gallery =new Intent(getActivity(), com.example.firstproject.homecare.class);
                startActivity(gallery);

            }
        });
        ordermedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Fill Requierd Details",Toast.LENGTH_LONG).show();
                Intent gallery =new Intent(getActivity(), com.example.firstproject.ordermedicine.class);
                startActivity(gallery);
            }
        });

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}

