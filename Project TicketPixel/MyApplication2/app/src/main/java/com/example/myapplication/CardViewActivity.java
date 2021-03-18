package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CardViewActivity extends AppCompatActivity {
    //Defino
    private TextView titleCardView;
    private ImageView imageTop;
    private ImageView localImg;
    private ImageView visitImg;
    private TextView textLocal;
    private TextView textVisitor;
    private TextView historytext;
    private TextView citytext;
    private TextView stadiumText;
    private TextView capacityText;
    private TextView stadiumPlaying;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        //hocks
//aqui lo pillo por el id
        titleCardView = (TextView) findViewById(R.id.titleCardView);
        imageTop = (ImageView) findViewById(R.id.imageTop);
        localImg = (ImageView) findViewById(R.id.local);
        visitImg = (ImageView) findViewById(R.id.visitor);
        textLocal = (TextView) findViewById(R.id.textLocal);
        textVisitor = (TextView) findViewById(R.id.textVisitor);
        historytext = (TextView) findViewById(R.id.textHistory);
        citytext = (TextView) findViewById(R.id.textCity);
        stadiumText = (TextView) findViewById(R.id.textStadium);
        capacityText = (TextView) findViewById(R.id.textCapacity);
        stadiumPlaying =(TextView) findViewById(R.id.stadiumPlaying);

//Recibo con el intent desde el mainActivity
        Intent i = getIntent();
        String title = i.getStringExtra(MainActivity.TITLE);
        String inTextLocal =i.getStringExtra(MainActivity.LOCALSTR);
        String inTextVisitor=i.getStringExtra(MainActivity.VISITSTR);
        String inHistoryText=i.getStringExtra(MainActivity.HISTORY);
        String inCityText=i.getStringExtra(MainActivity.CITY);
        String inStadiumNameText =i.getStringExtra(MainActivity.STADIUMNAME);
        String inStadiumCapacityText =i.getStringExtra(MainActivity.STADIUMCAPACITY);
        String inStadiumPlaying =i.getStringExtra(MainActivity.STADIUMPLAYING);


        //Recuperamos la imagen
        int imgTop = i.getIntExtra(MainActivity.LOGO, 0);
        int imglocal = i.getIntExtra(MainActivity.LOCALIMG, 0);
        int imgVisitor = i.getIntExtra(MainActivity.VISITIMG, 0);


        titleCardView.setText(title);
        imageTop.setImageResource(imgTop);
        localImg.setImageResource(imglocal);
        visitImg.setImageResource(imgVisitor);
        textLocal.setText(inTextLocal);
        textVisitor.setText(inTextVisitor);
        historytext.setText(inHistoryText);
        citytext.setText(inCityText);
       stadiumText.setText(inStadiumNameText);
      capacityText.setText(inStadiumCapacityText);
      stadiumPlaying.setText(inStadiumPlaying);

    }
}