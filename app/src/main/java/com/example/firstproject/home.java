package com.example.firstproject;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.provider.Settings;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class home extends AppCompatActivity {
    TextView user_name;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Mail Us", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent=new Intent(Intent.ACTION_SEND);
                String[] recipients={"deepakverma0072@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Subject text here...");
                intent.putExtra(Intent.EXTRA_TEXT,"Body of the content here...");
                intent.putExtra(Intent.EXTRA_CC,"mailcc@gmail.com");
                intent.setType("text/html");
                intent.setPackage("com.google.android.gm");
                startActivity(Intent.createChooser(intent, "Send mail"));

            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        View v=navigationView.getHeaderView(0);
        user_name=v.findViewById(R.id.user_name);
        user_name.setText(getIntent().getStringExtra("user_name"));



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        Log.e("Tag","nav Value: "+navController);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);



        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_exit:
                finishAffinity();
                System.exit(0);

                Toast.makeText(this,"Exit",Toast.LENGTH_LONG).show();
                 break;
//                finish();
//                System.exit(0);
            case R.id.action_settings:
                Toast.makeText(this,"System Setting",Toast.LENGTH_LONG).show();
                Intent setting = new Intent(Settings.ACTION_SETTINGS);
                startActivity(setting);
                break;
            default:
                return super.onOptionsItemSelected(item);

        }

//        return super.onOptionsItemSelected(item);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();

    }
}
