package com.example.examen;

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
    public static int SPLASH_SCREEM =4000;
    private ImageView imageView1;
    private ImageView imageView2;
    private TextView textView1;
    private TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hocks
        imageView1 = (ImageView) findViewById(R.id.imageCentral);
        imageView2=(ImageView) findViewById(R.id.imageSecundary);
        textView1 =(TextView) findViewById(R.id.textTitle);
        textView2 =(TextView) findViewById(R.id.textSubtitle);

        Runnable r = new Runnable() {
            @Override
            public void run() {
                Intent intent =new Intent(MainActivity.this, DashboardActivity.class);
                //Pair
                Pair[] pairs = new Pair[4];
                pairs [0] = new Pair<View, String>(imageView1, "imageapp1");
                pairs [1] = new Pair<View, String>(imageView2, "imageapp2");
                pairs [2] = new Pair<View, String>(textView1, "textapp1");
                pairs [3] = new Pair<View, String>(textView2, "textapp2");

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

