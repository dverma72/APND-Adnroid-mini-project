package com.example.firstproject.ui.send;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.firstproject.R;
import com.example.firstproject.home;
import com.example.firstproject.login;

import static android.content.Context.MODE_PRIVATE;

public class SendFragment extends Fragment {

    private SendViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
        final TextView textView = root.findViewById(R.id.text_send);
        sendViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        Toast.makeText(getActivity(), "Visit Again " , Toast.LENGTH_SHORT).show();
        Intent home = new Intent(getActivity(), com.example.firstproject.login.class);
        SharedPreferences sd =getActivity().getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor edit =sd.edit();
        edit.clear();
        edit.commit();
        startActivity(home);
        return root;
    }
}