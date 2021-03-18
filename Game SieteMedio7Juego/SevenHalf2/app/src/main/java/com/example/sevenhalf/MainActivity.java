package com.example.sevenhalf;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    public static String FILE_SHARED_NAME ="MySharedFile";
    LottieAnimationView lottieAnimationView;
    ObjectAnimator objectAnimatorFuntion;
    ObjectAnimator objectAnimator2;
    ObjectAnimator objectAnimator3;
    ObjectAnimator objectAnimator4;
    ObjectAnimator objectAnimator5;
    ObjectAnimator objectAnimator6;
    ObjectAnimator objectAnimator7;
    ObjectAnimator objectAnimator8;
    ObjectAnimator objectAnimator9;
    ImageView imageViewLogo;
    Button buttonOnePlayer;
    Button buttonTwoPlayers;
    TextView textView;
    Button buttonResumeGame;
    Button buttonNewGame;

    //LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lottieAnimationView = findViewById(R.id.animationView);
        imageViewLogo = findViewById(R.id.imageAnimacionPrincipal);
        buttonOnePlayer = findViewById(R.id.button1Player);
        buttonTwoPlayers = findViewById(R.id.button2players);
        buttonNewGame = findViewById(R.id.buttonNewGame);
        buttonResumeGame=findViewById(R.id.buttonResumeGame);


        function(lottieAnimationView, "alpha", 1f,0f, 2000,2000);
        function(lottieAnimationView, "rotation", 0,360, 1500,2000);
        //function(lottieAnimationView, "scale", 0,5, 2000, 00);
        function(lottieAnimationView, "scaleX", 1,5,2500,3000);
        function(lottieAnimationView, "scaleY", 1,5, 2500, 3000);

        function(imageViewLogo, "alpha", 0f, 1f, 3000,2000);
        function(imageViewLogo, "scaleX", 1,6,4000,4000);
        function(imageViewLogo, "scaleY", 1,6, 4000, 4000);
        function(imageViewLogo, "rotation", 0,360, 4000,3000);
        function(buttonOnePlayer, "alpha", 0f,1f, 5000, 2000);
        function(buttonOnePlayer, "translationX", -1000f,0f, 5000, 3000);
        function(buttonTwoPlayers, "alpha", 0f,1f, 5000, 2000);
        function(buttonTwoPlayers, "translationX", 1000f,0f, 5000, 3000);

        buttonResumeGame.setEnabled(false);
        buttonNewGame.setEnabled(false);


        buttonOnePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function(buttonOnePlayer, "alpha", 1f, 0f, 500, 1000);
                function(buttonOnePlayer, "translationX", 0, -1000f, 500, 1000);
                //Boton Stop
                function(buttonTwoPlayers, "alpha", 1f, 0f, 500, 1000);
                function(buttonTwoPlayers, "translationX", 0f, 1000f, 500, 1000);

                if (read()){
                    buttonResumeGame.setEnabled(true);
                    buttonNewGame.setEnabled(true);
                    function(buttonResumeGame, "alpha", 0f,1f, 1500, 1000);
                    function(buttonResumeGame, "translationX", -1000f,0f, 1500, 1000);
                    function(buttonNewGame, "alpha", 0f,1f, 1500, 1000);
                    function(buttonNewGame, "translationX", 1000f,0f, 1500, 1000);
                }else{
                    Intent intent  =new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                }
            }
        });

        buttonNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences(FILE_SHARED_NAME, MODE_PRIVATE);
                SharedPreferences.Editor sharedPreferences1 = sharedPreferences.edit();
                sharedPreferences1.clear();
                sharedPreferences1.commit();
                Intent intent  =new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        buttonResumeGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  =new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

buttonTwoPlayers.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "This option it's no availeble right now", Toast.LENGTH_SHORT).show();
    }
});

    }

    public void function(Object imageView, String propertyName, float valueA, float valueB, int startDelay, int duration) {
        objectAnimatorFuntion = ObjectAnimator.ofFloat(imageView, propertyName, valueA, valueB);
        objectAnimatorFuntion.setStartDelay(startDelay);
        objectAnimatorFuntion.setDuration(duration);
        objectAnimatorFuntion.start();
    }
    public boolean read(){
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_SHARED_NAME, MODE_PRIVATE);
        int  contadorGlobalBank = sharedPreferences.getInt("Bank", 0);
        int   contadorGlobalYou = sharedPreferences.getInt("You", 0);
        if (contadorGlobalBank!=0 || contadorGlobalYou!=0){
            return true;
        }
        return false;


    }




}