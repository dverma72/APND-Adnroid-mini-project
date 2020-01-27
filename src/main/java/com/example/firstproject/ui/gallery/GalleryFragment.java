package com.example.firstproject.ui.gallery;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.firstproject.R;

import java.io.InputStream;

public class GalleryFragment extends Fragment {
   private ImageView cat,dog,tiger,lion,giraff,flyingfish;
    int tophone;
    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        cat = root.findViewById(R.id.cat);
        dog=root.findViewById(R.id.dog);
        tiger=root.findViewById(R.id.tiger);
        lion=root.findViewById(R.id.lion);
        giraff=root.findViewById(R.id.giraff);
        flyingfish=root.findViewById(R.id.flyfish);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        dog.setImageResource(R.drawable.dog);
        tiger.setImageResource(R.drawable.tiger);
        cat.setImageResource(R.drawable.cat);
        flyingfish.setImageResource(R.drawable.flyingfish);
        lion.setImageResource(R.drawable.lion);
        giraff.setImageResource(R.drawable.giraff);


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


        return root;
    }
    private void popup(Bitmap imgview) {
        AlertDialog.Builder alertdailog = new AlertDialog.Builder(getActivity());
        alertdailog.setMessage("You have selected his image");
        ImageView img =new ImageView(getActivity());
        img.setImageBitmap(imgview);
        alertdailog.setView(img);
        alertdailog.create();

        alertdailog.show();
    }
}