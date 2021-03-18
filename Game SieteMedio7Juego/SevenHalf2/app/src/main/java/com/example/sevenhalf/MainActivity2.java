package com.example.sevenhalf;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    //Definimos nombre del fichero SharedPreferences
    public static String FILE_SHARED_NAME = "MySharedFile";

    ObjectAnimator objectAnimatorFuntion;
    Button buttonPlay;
    int numeroCard;
    Integer actualImg;
    private int contadorCardsDadas;
    private int CANTIDAD_CARD = 35;
    private int contadorBank = 1;
    private int contadorGlobalBank = 0;
    private int contadorGlobalYou = 0;
    private ArrayList<Integer> arrayCardsRandom;
    private ImageView imageCartasMazo;
    private ImageView imageCardMove;
    private ImageView imageCard1;
    private ImageView imageCard2;
    private ImageView imageCard3;
    private ImageView imageCard4;
    private ImageView imageCard5;
    private ImageView imageCard6;
    private ImageView imageCard7;
    private ImageView imageCard8;
    private ImageView imageCard9;
    private ImageView imageCard01;
    private ImageView imageCard02;
    private ImageView imageCard03;
    private ImageView imageCard04;
    private ImageView imageCard05;
    private ImageView imageCard06;
    private ImageView imageCard07;
    private ImageView imageCard08;
    private ImageView imageCard09;
    TextView textYouHaveWon;
    TextView textBankWinner;
    Button buttonOneMore;
    Button buttonStop;
    Button buttonPlayAgain;
    TextView textViewYouScore;
    TextView textViewBankScore;
    TextView youTotalScoreTextView;
    TextView bankTotalScoreTextView;
    private Double bankScoreSum = 0.0;
    private Double youScoreSum = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        buttonPlay = findViewById(R.id.buttonPlay);
        buttonOneMore = findViewById(R.id.buttonOneMore);
        buttonStop = findViewById(R.id.buttonStop);
        arrayCardsRandom = new ArrayList<>();
        imageCardMove = findViewById(R.id.imageCardMove);
        imageCartasMazo = findViewById(R.id.imageMazoCartas);
        imageCard1 = findViewById(R.id.imageCard1);
        imageCard2 = findViewById(R.id.imageCard2);
        imageCard3 = findViewById(R.id.imageCard3);
        imageCard4 = findViewById(R.id.imageCard4);
        imageCard5 = findViewById(R.id.imageCard5);
        imageCard6 = findViewById(R.id.imageCard6);
        imageCard7 = findViewById(R.id.imageCard7);
        imageCard8 = findViewById(R.id.imageCard8);
        imageCard9 = findViewById(R.id.imageCard9);
        imageCard01 = findViewById(R.id.imageCard01);
        imageCard02 = findViewById(R.id.imageCard02);
        imageCard03 = findViewById(R.id.imageCard03);
        imageCard04 = findViewById(R.id.imageCard04);
        imageCard05 = findViewById(R.id.imageCard05);
        imageCard06 = findViewById(R.id.imageCard06);
        imageCard07 = findViewById(R.id.imageCard07);
        imageCard08 = findViewById(R.id.imageCard08);
        imageCard09 = findViewById(R.id.imageCard09);
        textViewBankScore = findViewById(R.id.textAddScoreBank);
        textViewYouScore = findViewById(R.id.textAddScoreYou);
        youTotalScoreTextView = findViewById(R.id.textTotalScoreYou);
        bankTotalScoreTextView = findViewById(R.id.textTotalScoreBank);
        buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
        textYouHaveWon = findViewById(R.id.texYouHaveWon);
        textBankWinner = findViewById(R.id.bankWinner);

        buttonPlayAgain.setEnabled(false);

        //Ordenos los numeros randoms de todas las cartas
        //asi de esta manera solamente tengo que tener un contador que a partir del la carta que alla salido
        //se mueva a la siguiente posicion

        int index = 0;
        while (index <= CANTIDAD_CARD) {
            int random = new Random().nextInt((CANTIDAD_CARD) + 1);
            boolean repetido = false;
            while (!repetido) {
                for (int i = 0; i < index; i++) {
                    if (random == arrayCardsRandom.get(i)) {
                        repetido = true;
                        break;
                    }
                }
                if (!repetido) {
                    arrayCardsRandom.add(random);
                    index++;
                }
            }
        }


        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tengo el numero de la carta

                numeroCard = arrayCardsRandom.get(contadorCardsDadas);
                //tengo la imagen de la carta
                actualImg = CardsGameFuction(numeroCard);
                //inserto la imagen en la carta uno
                imageCard1.setImageResource(actualImg);
                //imageCard1.setImageResource(CardsGameFuction(numeroCard));
                //youScoreSum = Double.valueOf(cardsValueFunction(arrayCardsRandom.get(contadorCardsDadas)));
                youScoreSum = Double.valueOf(mapCardsValue(actualImg));

                textViewYouScore.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textViewYouScore.setText(String.valueOf(youScoreSum));
                    }
                }, 2000);


                function(imageCardMove, "x", imageCard1.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard1.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard1, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard1, "alpha", 0f, 1f, 2000, 500);
                contadorCardsDadas++;

                function(buttonPlay, "alpha", 1f, 0f, 0, 100);

                //Boton OneMore
                function(buttonOneMore, "alpha", 0f, 1f, 500, 1000);
                function(buttonOneMore, "translationX", -1000f, -10f, 0, 2000);
                //Boton Stop
                function(buttonStop, "alpha", 0f, 1f, 500, 1000);
                function(buttonStop, "translationX", 1000f, 10f, 0, 2000);
                buttonPlay.setEnabled(false);

            }
        });

        read();

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while (bankScoreSum < 7) {
                    restartImgMove();
                    stopBankFunction();

                    //Boton OneMore
                    function(buttonOneMore, "alpha", 0f, 1f, 500, 1000);
                    function(buttonOneMore, "translationX", -1000f, -10f, 0, 2000);
                    //Boton Stop
                    function(buttonStop, "alpha", 0f, 1f, 500, 1000);
                    function(buttonStop, "translationX", 1000f, 10f, 0, 2000);

                }
                comprobacionGanadorBank();


            }
        });
        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity2.class);

                startActivity(intent);
            }
        });


        buttonOneMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (youScoreSum < 7.5) {
                    restartImgMove();
                    oneMoreFuction();
                }
                function(buttonOneMore, "alpha", 1f, 0f, 500, 1000);
                function(buttonOneMore, "translationX", -10f, -1000f, 0, 2000);
                //Boton Stop
                function(buttonStop, "alpha", 1f, 0f, 500, 1000);
                function(buttonStop, "translationX", 10f, 1000f, 0, 2000);

                comprobacionGanadorYou();


            }
        });


    }

    //Fuctions
    public void function(Object objectForAll, String propertyName, float value, int startDelay, int duration) {
        objectAnimatorFuntion = ObjectAnimator.ofFloat(objectForAll, propertyName, value);
        objectAnimatorFuntion.setStartDelay(startDelay);
        objectAnimatorFuntion.setDuration(duration);
        objectAnimatorFuntion.start();
    }


    public void function(Object objectForAll, String propertyName, float valueA, float valueB, int startDelay, int duration) {
        objectAnimatorFuntion = ObjectAnimator.ofFloat(objectForAll, propertyName, valueA, valueB);
        objectAnimatorFuntion.setStartDelay(startDelay);
        objectAnimatorFuntion.setDuration(duration);
        objectAnimatorFuntion.start();
    }

    public void comprobacionGanadorBank() {
        if (bankScoreSum > 7.5) {
            //Boton OneMore
            function(buttonOneMore, "alpha", 1f, 0f, 500, 1000);
            function(buttonOneMore, "translationX", -10f, -1000f, 0, 2000);
            //Boton Stop
            function(buttonStop, "alpha", 1f, 0f, 500, 1000);
            function(buttonStop, "translationX", 10f, 1000f, 0, 2000);

            buttonPlayAgain.setEnabled(true);
            function(buttonPlayAgain, "alpha", 0f, 1f, 2000, 1000);
            function(textYouHaveWon, "alpha", 0, 1, 1000, 1000);
            function(textYouHaveWon, "scaleX", 1, 1, 1000, 1000);
            function(textYouHaveWon, "scaleY", 1, 1, 1000, 1000);
            youWinner();
        }
        if (bankScoreSum == 7.5) {
            //Boton OneMore
            function(buttonOneMore, "alpha", 1f, 0f, 500, 1000);
            function(buttonOneMore, "translationX", -10f, -1000f, 0, 2000);
            //Boton Stop

            function(buttonStop, "alpha", 1f, 0f, 500, 1000);
            function(buttonStop, "translationX", 10f, 1000f, 0, 2000);

            buttonPlayAgain.setEnabled(true);
            function(buttonPlayAgain, "alpha", 0f, 1f, 2000, 1000);
            function(textBankWinner, "alpha", 0, 1, 1000, 1000);
            function(textBankWinner, "scaleX", 1, 1, 1000, 1000);
            function(textBankWinner, "scaleY", 1, 1, 1000, 1000);
            bankWinner();
        }

        if (bankScoreSum <= 7 && bankScoreSum >= youScoreSum) {
            //Boton OneMore
            function(buttonOneMore, "alpha", 1f, 0f, 500, 1000);
            function(buttonOneMore, "translationX", -10f, -1000f, 0, 2000);
            //Boton Stop
            function(buttonStop, "alpha", 1f, 0f, 500, 1000);
            function(buttonStop, "translationX", 10f, 1000f, 0, 2000);

            buttonPlayAgain.setEnabled(true);
            function(buttonPlayAgain, "alpha", 0f, 1f, 2000, 1000);
            function(textBankWinner, "alpha", 0, 1, 1000, 1000);
            function(textBankWinner, "scaleX", 1, 1, 1000, 1000);
            function(textBankWinner, "scaleY", 1, 1, 1000, 1000);
            bankWinner();


        }
    }


    public void comprobacionGanadorYou() {
        if (youScoreSum > 7.5) {
            //Boton OneMore
            function(buttonOneMore, "alpha", 1f, 0f, 500, 1000);
            function(buttonOneMore, "translationX", -10f, -1000f, 0, 2000);
            //Boton Stop
            function(buttonStop, "alpha", 1f, 0f, 500, 1000);
            function(buttonStop, "translationX", 10f, 1000f, 0, 2000);

            buttonPlayAgain.setEnabled(true);
            function(buttonPlayAgain, "alpha", 0f, 1f, 2000, 1000);
            function(textBankWinner, "alpha", 0, 1, 1000, 1000);
            function(textBankWinner, "scaleX", 1, 1, 1000, 1000);
            function(textBankWinner, "scaleY", 1, 1, 1000, 1000);
            bankWinner();
        }

        if (youScoreSum == 7.5) {
            //Boton OneMore
            function(buttonOneMore, "alpha", 1f, 0f, 500, 1000);
            function(buttonOneMore, "translationX", -10f, -1000f, 0, 2000);
            //Boton Stop
            function(buttonStop, "alpha", 1f, 0f, 500, 1000);
            function(buttonStop, "translationX", 10f, 1000f, 0, 2000);

            buttonPlayAgain.setEnabled(true);
            function(buttonPlayAgain, "alpha", 0f, 1f, 2000, 1000);
            function(textYouHaveWon, "alpha", 0, 1, 1000, 1000);
            function(textYouHaveWon, "scaleX", 1, 1, 1000, 1000);
            function(textYouHaveWon, "scaleY", 1, 1, 1000, 1000);
            youWinner();
        }
    }

    public int CardsGameFuction(int cardNumero) {
        ArrayList<Integer> arrayCards = new ArrayList<>();
        //Clubs
        arrayCards.add(R.drawable.clubs01);
        arrayCards.add(R.drawable.clubs02);
        arrayCards.add(R.drawable.clubs03);
        arrayCards.add(R.drawable.clubs04);
        arrayCards.add(R.drawable.clubs05);
        arrayCards.add(R.drawable.clubs06);
        arrayCards.add(R.drawable.clubs07);
        arrayCards.add(R.drawable.clubs08);
        arrayCards.add(R.drawable.clubs09);
        arrayCards.add(R.drawable.clubs10);
        arrayCards.add(R.drawable.clubs11);
        arrayCards.add(R.drawable.clubs12);
        //Cups
        arrayCards.add(R.drawable.cups01);
        arrayCards.add(R.drawable.cups02);
        arrayCards.add(R.drawable.cups03);
        arrayCards.add(R.drawable.cups04);
        arrayCards.add(R.drawable.cups05);
        arrayCards.add(R.drawable.cups06);
        arrayCards.add(R.drawable.cups07);
        arrayCards.add(R.drawable.cups08);
        arrayCards.add(R.drawable.cups09);
        arrayCards.add(R.drawable.cups10);
        arrayCards.add(R.drawable.cups11);
        arrayCards.add(R.drawable.cups12);
        //Golds
        arrayCards.add(R.drawable.golds01);
        arrayCards.add(R.drawable.golds02);
        arrayCards.add(R.drawable.golds03);
        arrayCards.add(R.drawable.golds04);
        arrayCards.add(R.drawable.golds05);
        arrayCards.add(R.drawable.golds06);
        arrayCards.add(R.drawable.golds07);
        arrayCards.add(R.drawable.golds08);
        arrayCards.add(R.drawable.golds09);
        arrayCards.add(R.drawable.golds10);
        arrayCards.add(R.drawable.golds11);
        arrayCards.add(R.drawable.golds12);

        return arrayCards.get(cardNumero);
    }



    public float mapCardsValue(int key) {
        Map<Integer, Float> mapCards = new HashMap<Integer, Float>();
        mapCards.put(R.drawable.clubs01, 1.0f);
        mapCards.put(R.drawable.clubs02, 2.0f);
        mapCards.put(R.drawable.clubs03, 3.0f);
        mapCards.put(R.drawable.clubs04, 4.0f);
        mapCards.put(R.drawable.clubs05, 5.0f);
        mapCards.put(R.drawable.clubs06, 6.0f);
        mapCards.put(R.drawable.clubs07, 7.0f);
        mapCards.put(R.drawable.clubs08, 0.5f);
        mapCards.put(R.drawable.clubs09, 0.5f);
        mapCards.put(R.drawable.clubs10, 0.5f);
        mapCards.put(R.drawable.clubs11, 0.5f);
        mapCards.put(R.drawable.clubs12, 0.5f);
        //Cups
        mapCards.put(R.drawable.cups01, 1.0f);
        mapCards.put(R.drawable.cups02, 2.0f);
        mapCards.put(R.drawable.cups03, 3.0f);
        mapCards.put(R.drawable.cups04, 4.0f);
        mapCards.put(R.drawable.cups05, 5.0f);
        mapCards.put(R.drawable.cups06, 6.0f);
        mapCards.put(R.drawable.cups07, 7.0f);
        mapCards.put(R.drawable.cups08, 0.5f);
        mapCards.put(R.drawable.cups09, 0.5f);
        mapCards.put(R.drawable.cups10, 0.5f);
        mapCards.put(R.drawable.cups11, 0.5f);
        mapCards.put(R.drawable.cups12, 0.5f);
        //Golds
        mapCards.put(R.drawable.golds01, 1.0f);
        mapCards.put(R.drawable.golds02, 2.0f);
        mapCards.put(R.drawable.golds03, 3.0f);
        mapCards.put(R.drawable.golds04, 4.0f);
        mapCards.put(R.drawable.golds05, 5.0f);
        mapCards.put(R.drawable.golds06, 6.0f);
        mapCards.put(R.drawable.golds07, 7.0f);
        mapCards.put(R.drawable.golds08, 0.5f);
        mapCards.put(R.drawable.golds09, 0.5f);
        mapCards.put(R.drawable.golds10, 0.5f);
        mapCards.put(R.drawable.golds11, 0.5f);
        mapCards.put(R.drawable.golds12, 0.5f);
        return mapCards.get(key);
    }


    public void oneMoreFuction() {
        numeroCard = arrayCardsRandom.get(contadorCardsDadas);
        actualImg = CardsGameFuction(numeroCard);
        switch (contadorCardsDadas) {
            case 1:
                imageCard2.setImageResource(actualImg);

                //  restartImgMove();

                function(imageCardMove, "x", imageCard2.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard2.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard2, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard2, "alpha", 0f, 1f, 2000, 500);
                break;
            case 2:
                // restartImgMove();
                imageCard3.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard3.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard3.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard3, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard3, "alpha", 0f, 1f, 2000, 500);
                restartImgMove();
                break;
            case 3:
                imageCard4.setImageResource(actualImg);
                //  restartImgMove();
                function(imageCardMove, "x", imageCard4.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard4.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard4, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard4, "alpha", 0f, 1f, 2000, 500);

                break;
            case 4:
                imageCard5.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard5.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard5.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard5, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard5, "alpha", 0f, 1f, 2000, 500);

                break;
            case 5:
                imageCard6.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard6.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard6.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard6, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard6, "alpha", 0f, 1f, 2000, 500);

                break;
            case 6:
                imageCard7.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard7.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard7.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard7, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard7, "alpha", 0f, 1f, 2000, 500);

                break;
            case 7:
                imageCard8.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard8.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard8.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard8, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard8, "alpha", 0f, 1f, 2000, 500);

                break;
            case 8:
                imageCard9.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard9.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard9.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard9, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard9, "alpha", 0f, 1f, 2000, 500);

                break;
        }
       /* numeroCard = arrayCardsRandom.get(contadorCardsDadas);
        actualImg = CardsGameFuction(numeroCard);*/
        youScoreSum = youScoreSum + Double.valueOf(mapCardsValue(actualImg));
//        textViewYouScore.setText(String.valueOf(youScoreSum));
        textViewYouScore.postDelayed(new Runnable() {
            @Override
            public void run() {
                textViewYouScore.setText(String.valueOf(youScoreSum));
            }
        }, 2000);
        contadorCardsDadas++;
        if (youScoreSum < 7.5) {
            //Boton oneMore
            function(buttonOneMore, "alpha", 0f, 1f, 1500, 1000);
            function(buttonOneMore, "translationX", -1000f, -10f, 1500, 2000);
            //Boton Stop
            function(buttonStop, "alpha", 0f, 1f, 1500, 1000);
            function(buttonStop, "translationX", 1000f, 10f, 1500, 2000);
       /* youScoreSum = youScoreSum + Double.valueOf(cardsValueFunction(arrayCardsRandom.get(contadorCardsDadas)));
        textViewYouScore.setText(String.valueOf(youScoreSum));*/

        }
    }

    public void restartImgMove() {
        function(imageCardMove, "x", imageCartasMazo.getX(), 0, 0);
        function(imageCardMove, "y", imageCartasMazo.getY(), 0, 0);
        function(imageCardMove, "alpha", 0f, 1f, 0, 0);
    }

    public void stopBankFunction() {
        numeroCard = arrayCardsRandom.get(contadorCardsDadas);
        actualImg = CardsGameFuction(numeroCard);
        switch (contadorBank) {
            case 1:
                imageCard01.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard01.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard01.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard01, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard01, "alpha", 0f, 1f, 2000, 500);

            /*    imageCard01.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard01.getX(), 4000, 1000);
                function(imageCardMove, "y", imageCard01.getY(), 4000, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 4000, 1000);
                function(imageCard01, "rotationY", 180f, 0f, 4000, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 4000, 500);
                function(imageCard01, "alpha", 0f, 1f, 4000, 500);*/


                break;
            case 2:

                imageCard02.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard02.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard02.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard02, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard02, "alpha", 0f, 1f, 2000, 500);


             /*   function(imageCardMove, "x", imageCard02.getX(), 6000, 1000);
                function(imageCardMove, "y", imageCard02.getY(), 6000, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 6000, 1000);
                function(imageCard02, "rotationY", 180f, 0f, 6000, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 6000, 500);
                function(imageCard02, "alpha", 0f, 1f, 6000, 500);*/
                break;
            case 3:

                imageCard03.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard03.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard03.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard03, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard03, "alpha", 0f, 1f, 2000, 500);
               /* imageCard03.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard03.getX(), 7000, 1000);
                function(imageCardMove, "y", imageCard03.getY(), 7000, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 7000, 1000);
                function(imageCard03, "rotationY", 180f, 0f, 7000, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 7000, 500);
                function(imageCard03, "alpha", 0f, 1f, 7000, 500);*/

                break;
            case 4:

                imageCard04.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard04.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard04.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard04, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard04, "alpha", 0f, 1f, 2000, 500);
               /* function(imageCardMove, "x", imageCard04.getX(), 7000, 1000);
                function(imageCardMove, "y", imageCard04.getY(), 7000, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 7000, 1000);
                function(imageCard04, "rotationY", 180f, 0f, 7000, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 7000, 500);
                function(imageCard04, "alpha", 0f, 1f, 7000, 500);
*/
                break;
            case 5:
                imageCard05.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard05.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard05.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard05, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard05, "alpha", 0f, 1f, 2000, 500);

                break;
            case 6:
                imageCard06.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard06.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard06.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard06, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard06, "alpha", 0f, 1f, 2000, 500);

                break;
            case 7:
                imageCard07.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard07.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard07.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard07, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard07, "alpha", 0f, 1f, 2000, 500);

                break;
            case 8:
                imageCard08.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard08.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard08.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard08, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard08, "alpha", 0f, 1f, 2000, 500);
            case 9:
                imageCard09.setImageResource(actualImg);
                function(imageCardMove, "x", imageCard09.getX(), 500, 1000);
                function(imageCardMove, "y", imageCard09.getY(), 500, 1000);
                function(imageCardMove, "rotationY", 0f, -180f, 1500, 1000);
                function(imageCard09, "rotationY", 180f, 0f, 1500, 1000);
                function(imageCardMove, "alpha", 1f, 0f, 2000, 500);
                function(imageCard09, "alpha", 0f, 1f, 2000, 500);
                break;
        }
        bankScoreSum = bankScoreSum + Double.valueOf(mapCardsValue(actualImg));
        //textViewBankScore.setText(String.valueOf(bankScoreSum));
        textViewBankScore.postDelayed(new Runnable() {
            @Override
            public void run() {
                textViewBankScore.setText(String.valueOf(bankScoreSum));
            }
        }, 2000);
        contadorBank++;
        contadorCardsDadas++;

    }

    public void read() {
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_SHARED_NAME, MODE_PRIVATE);
        contadorGlobalBank = sharedPreferences.getInt("Bank", 0);
        contadorGlobalYou = sharedPreferences.getInt("You", 0);
        bankTotalScoreTextView.setText(String.valueOf(contadorGlobalBank));
        youTotalScoreTextView.setText(String.valueOf(contadorGlobalYou));
    }

    public void createSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_SHARED_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Bank", 0);
        editor.putInt("You", 0);
        editor.commit();
    }


    public void bankWinner() {
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_SHARED_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        contadorGlobalBank = contadorGlobalBank + 1;
        editor.putInt("Bank", contadorGlobalBank);
        editor.putInt("You", contadorGlobalYou);
        editor.commit();
    }

    public void youWinner() {
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_SHARED_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        contadorGlobalYou = contadorGlobalYou + 1;
        editor.putInt("Bank", contadorGlobalBank);
        editor.putInt("You", contadorGlobalYou);
        editor.commit();

    }


}