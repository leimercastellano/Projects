package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static int SPLASH_SCREEM =3000;
    private ImageView imageView;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hocks




        imageView = (ImageView) findViewById(R.id.imageViewLogo);
        textView =(TextView) findViewById(R.id.textTitle);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(MainActivity.this, DashboardActivity.class);
                //Pair
                Pair [] pairs = new Pair[2];
                pairs [0] = new Pair<View, String>(imageView, "imageapp");
                pairs [1] = new Pair<View, String>(textView, "textapp");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                            pairs);
                    startActivity(intent, options.toBundle());
                }

            }

        };
       // Handler h = new Handler(); esta deprecated, por eso tenemos que pasarle como argumento Looper.getMainLooper();
        Handler h = new Handler(Looper.getMainLooper());
        h.postDelayed(r,SPLASH_SCREEM );
    }
}

//ActivityOptions nos ayuda a transicionar metodos entre actividades