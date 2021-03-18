package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static String TITLE = "com.example.myapplication.TITLE";
    public static String LOGO = "com.example.myapplication.LOGO";
    public static String LOCALIMG = "com.example.myapplication.LOCALIMG";
    public static String LOCALSTR = "com.example.myapplication.LOCALSTR";
    public static String VISITIMG = "com.example.myapplication.VISITIMG";
    public static String VISITSTR = "com.example.myapplication.VISITSTR";
    public static String HISTORY = "com.example.myapplication.HISTORY";
    public static String CITY = "com.example.myapplication.CITY";
    public static String STADIUMCAPACITY = "com.example.myapplication.STADIUMCAPACITY";
    public static String STADIUMNAME = "com.example.myapplication.STADIUMNAME";
    public static String STADIUMPLAYING = "com.example.myapplication.STADIUMPLAYING";



    private CardView cardV1;
    private CardView cardV2;
    private CardView cardV3;
    private CardView cardV4;
    private CardView cardV5;
    private CardView cardV6;
    private CardView cardV7;
    private CardView cardV8;
    private CardView cardV9;
    private CardView cardV10;
    private CardView cardV11;
    private CardView cardV12;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hocks

        cardV1 = (CardView) findViewById(R.id.cardV1);
        cardV2 = (CardView) findViewById(R.id.cardV2);
        cardV3 = (CardView) findViewById(R.id.cardV3);
        cardV4 = (CardView) findViewById(R.id.cardV4);
        cardV5 = (CardView) findViewById(R.id.cardV5);
        cardV6 = (CardView) findViewById(R.id.cardV6);
        cardV7 = (CardView) findViewById(R.id.cardV7);
        cardV8 = (CardView) findViewById(R.id.cardV8);
        cardV9 = (CardView) findViewById(R.id.cardV9);
        cardV10 = (CardView) findViewById(R.id.cardV10);
        cardV11 = (CardView) findViewById(R.id.cardV11);
        cardV12 = (CardView) findViewById(R.id.cardV12);
//Bayern
        cardV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //nombre EquipoWebSITe
                String teamName = getResources().getString(R.string.bayern);
                //LocalImage
                int imageTeam = R.drawable.bcn;
                String stadiumPlaying =getResources().getString(R.string.bcnStadium);
                //VisitImage
                int imageTeam2= R.drawable.bayern;
                String localTeam = getResources().getString(R.string.bcn);
                String visitorTeam = getResources().getString(R.string.bayern);
                String history = getResources().getString(R.string.bayernHistory);
                String cityTeam = getResources().getString(R.string.cityBayern);
                String stadium = getResources().getString(R.string.bayernStadium);
                String capacity = getResources().getString(R.string.bayernCapacity);




                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                intent.putExtra(TITLE, teamName);
                //Primero pasamos la constante y luego nuestra variable, que es donde tengo almacenada la imagen
                intent.putExtra(LOGO, imageTeam2);
                intent.putExtra(LOCALIMG, imageTeam);
                intent.putExtra(VISITIMG, imageTeam2);
                intent.putExtra(LOCALSTR, localTeam);
                intent.putExtra(VISITSTR, visitorTeam);
                intent.putExtra(HISTORY, history);
                intent.putExtra(CITY, cityTeam);
                intent.putExtra(STADIUMNAME, stadium);
                intent.putExtra(STADIUMCAPACITY,capacity);
                intent.putExtra(STADIUMPLAYING, stadiumPlaying);

                startActivity(intent);



            }
        });
//Atletico
        cardV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stadiumPlaying =getResources().getString(R.string.atleticoStadium);

                //nombre EquipoWebSITe
                String teamName = getResources().getString(R.string.atleticoName);
                //LocalImage
                int imageTeam = R.drawable.atletico;
                //VisitImage
                int imageTeam2= R.drawable.madrid;
                String localTeam = getResources().getString(R.string.atleticoName);
                String visitorTeam = getResources().getString(R.string.madridName);
                String history = getResources().getString(R.string.atleticoHistory);
                String cityTeam = getResources().getString(R.string.cityAtletico);
                String stadium = getResources().getString(R.string.atleticoStadium);
                String capacity = getResources().getString(R.string.atleticoCapacity);



                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                intent.putExtra(TITLE, teamName);
                //Primero pasamos la constante y luego nuestra variable, que es donde tengo almacenada la imagen
                intent.putExtra(LOGO, imageTeam2);
                intent.putExtra(LOCALIMG, imageTeam);
                intent.putExtra(VISITIMG, imageTeam2);
                intent.putExtra(LOCALSTR, localTeam);
                intent.putExtra(VISITSTR, visitorTeam);
                intent.putExtra(HISTORY, history);
                intent.putExtra(CITY, cityTeam);
                intent.putExtra(STADIUMNAME, stadium);
                intent.putExtra(STADIUMCAPACITY,capacity);
                intent.putExtra(STADIUMPLAYING, stadiumPlaying);
                intent.putExtra(STADIUMPLAYING, stadiumPlaying);
                startActivity(intent);



            }
        });

//Madrid
        cardV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Equipo que juega de Local y nombre
                String stadiumPlaying =getResources().getString(R.string.atleticoStadium);

                int imageTeam = R.drawable.atletico;
                String localTeam = getResources().getString(R.string.atleticoName);
                //Equipo que juega de Visitante
                int imageTeam2= R.drawable.madrid;
                String visitorTeam = getResources().getString(R.string.madridName);

                //EquipoWeb
                int logo= R.drawable.madrid;
                String teamName = getResources().getString(R.string.madridName);
                String history = getResources().getString(R.string.madridHistory);
                String cityTeam = getResources().getString(R.string.madridCity);
                String stadium = getResources().getString(R.string.madridStadium);
                String capacity = getResources().getString(R.string.madridCapacity);



                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                intent.putExtra(TITLE, teamName);
                //Primero pasamos la constante y luego nuestra variable, que es donde tengo almacenada la imagen
                intent.putExtra(LOGO, logo);
                intent.putExtra(LOCALIMG, imageTeam);
                intent.putExtra(VISITIMG, imageTeam2);
                intent.putExtra(LOCALSTR, localTeam);
                intent.putExtra(VISITSTR, visitorTeam);
                intent.putExtra(HISTORY, history);
                intent.putExtra(CITY, cityTeam);
                intent.putExtra(STADIUMNAME, stadium);
                intent.putExtra(STADIUMCAPACITY,capacity);
                intent.putExtra(STADIUMPLAYING, stadiumPlaying);
                startActivity(intent);



            }
        });


 //Psg
        cardV4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stadiumPlaying =getResources().getString(R.string.psgStadium);
                //Equipo que juega de Local y nombre

                int imageTeam = R.drawable.psg;
                String localTeam = getResources().getString(R.string.psg);
                //Equipo que juega de Visitante
                int imageTeam2= R.drawable.marsella;
                String visitorTeam = getResources().getString(R.string.marsella);

                //EquipoWeb Local
                int logo= R.drawable.psg;
                String teamName = getResources().getString(R.string.psg);
                String history = getResources().getString(R.string.psgHistory);
                String cityTeam = getResources().getString(R.string.psgCity);
                String stadium = getResources().getString(R.string.psgStadium);
                String capacity = getResources().getString(R.string.psgCapacity);



                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                intent.putExtra(TITLE, teamName);
                //Primero pasamos la constante y luego nuestra variable, que es donde tengo almacenada la imagen
                intent.putExtra(LOGO, logo);
                intent.putExtra(LOCALIMG, imageTeam);
                intent.putExtra(VISITIMG, imageTeam2);
                intent.putExtra(LOCALSTR, localTeam);
                intent.putExtra(VISITSTR, visitorTeam);
                intent.putExtra(HISTORY, history);
                intent.putExtra(CITY, cityTeam);
                intent.putExtra(STADIUMNAME, stadium);
                intent.putExtra(STADIUMCAPACITY,capacity);
                intent.putExtra(STADIUMPLAYING, stadiumPlaying);
                startActivity(intent);
            }
        });



//Marseille
        cardV5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stadiumPlaying =getResources().getString(R.string.psgStadium);
                //Equipo que juega de Local y nombre
                int imageTeam = R.drawable.psg;
                String localTeam = getResources().getString(R.string.psg);
                //Equipo que juega de Visitante
                int imageTeam2 = R.drawable.marsella;
                String visitorTeam = getResources().getString(R.string.marsella);

                //EquipoWeb Local
                int logo = R.drawable.marsella;
                String teamName = getResources().getString(R.string.marsella);
                String history = getResources().getString(R.string.marsellaHistory);
                String cityTeam = getResources().getString(R.string.marsellaeCity);
                String stadium = getResources().getString(R.string.marsellaStadium);
                String capacity = getResources().getString(R.string.marsellaCapacity);


                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                intent.putExtra(TITLE, teamName);
                //Primero pasamos la constante y luego nuestra variable, que es donde tengo almacenada la imagen
                intent.putExtra(LOGO, logo);
                intent.putExtra(LOCALIMG, imageTeam);
                intent.putExtra(VISITIMG, imageTeam2);
                intent.putExtra(LOCALSTR, localTeam);
                intent.putExtra(VISITSTR, visitorTeam);
                intent.putExtra(HISTORY, history);
                intent.putExtra(CITY, cityTeam);
                intent.putExtra(STADIUMNAME, stadium);
                intent.putExtra(STADIUMCAPACITY, capacity);
                intent.putExtra(STADIUMPLAYING, stadiumPlaying);
                startActivity(intent);
            }
        });

//chelsea
        cardV6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stadiumPlaying =getResources().getString(R.string.chelseaStadium);
                //Equipo que juega de Local y nombre
                int imageTeam = R.drawable.chelsea;
                String localTeam = getResources().getString(R.string.chelsea);
                //Equipo que juega de Visitante
                int imageTeam2 = R.drawable.liverpool;
                String visitorTeam = getResources().getString(R.string.liverpol);

                //EquipoWeb Local
                int logo = R.drawable.chelsea;
                String teamName = getResources().getString(R.string.chelsea);
                String history = getResources().getString(R.string.chelseaHistory);
                String cityTeam = getResources().getString(R.string.chelseaCity);
                String stadium = getResources().getString(R.string.chelseaStadium);
                String capacity = getResources().getString(R.string.chelsea);


                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                intent.putExtra(TITLE, teamName);
                //Primero pasamos la constante y luego nuestra variable, que es donde tengo almacenada la imagen
                intent.putExtra(LOGO, logo);
                intent.putExtra(LOCALIMG, imageTeam);
                intent.putExtra(VISITIMG, imageTeam2);
                intent.putExtra(LOCALSTR, localTeam);
                intent.putExtra(VISITSTR, visitorTeam);
                intent.putExtra(HISTORY, history);
                intent.putExtra(CITY, cityTeam);
                intent.putExtra(STADIUMNAME, stadium);
                intent.putExtra(STADIUMCAPACITY, capacity);
                intent.putExtra(STADIUMPLAYING, stadiumPlaying);
                startActivity(intent);
            }
        });




//Barcelona
                cardV7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String stadiumPlaying =getResources().getString(R.string.bcnStadium);
                        String teamName = getResources().getString(R.string.bcn);
                        int imageTeam = R.drawable.bcn;
                        int imageTeam2 = R.drawable.bayern;
                        String visitorTeam = getResources().getString(R.string.bayern);
                        String history = getResources().getString(R.string.bcnHistory);
                        String cityTeam = getResources().getString(R.string.bcnCity);
                        String stadium = getResources().getString(R.string.bcnStadium);
                        String capacity = getResources().getString(R.string.bcnCapaity);


                        Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                        intent.putExtra(TITLE, teamName);
                        //Primero pasamos la constante y luego nuestra variable, que es donde tengo almacenada la imagen
                        intent.putExtra(LOGO, imageTeam);
                        intent.putExtra(LOCALIMG, imageTeam);
                        intent.putExtra(VISITIMG, imageTeam2);
                        intent.putExtra(LOCALSTR, teamName);
                        intent.putExtra(VISITSTR, visitorTeam);
                        intent.putExtra(HISTORY, history);
                        intent.putExtra(CITY, cityTeam);
                        intent.putExtra(STADIUMNAME, stadium);
                        intent.putExtra(STADIUMCAPACITY, capacity);
                        intent.putExtra(STADIUMPLAYING, stadiumPlaying);

                        startActivity(intent);

                    }
                });

                //liverpool
        cardV8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stadiumPlaying =getResources().getString(R.string.chelseaStadium);
                //Equipo que juega de Local y nombre
                int imageTeam = R.drawable.chelsea;
                String localTeam = getResources().getString(R.string.chelsea);
                //Equipo que juega de Visitante
                int imageTeam2 = R.drawable.liverpool;
                String visitorTeam = getResources().getString(R.string.liverpol);

                //EquipoWeb Local
                int logo = R.drawable.marsella;
                String teamName = getResources().getString(R.string.liverpol);
                String history = getResources().getString(R.string.liveHistory);
                String cityTeam = getResources().getString(R.string.liveCity);
                String stadium = getResources().getString(R.string.liveStadium);
                String capacity = getResources().getString(R.string.liveCapacity);


                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                intent.putExtra(TITLE, teamName);
                //Primero pasamos la constante y luego nuestra variable, que es donde tengo almacenada la imagen
                intent.putExtra(LOGO, logo);
                intent.putExtra(LOCALIMG, imageTeam);
                intent.putExtra(VISITIMG, imageTeam2);
                intent.putExtra(LOCALSTR, localTeam);
                intent.putExtra(VISITSTR, visitorTeam);
                intent.putExtra(HISTORY, history);
                intent.putExtra(CITY, cityTeam);
                intent.putExtra(STADIUMNAME, stadium);
                intent.putExtra(STADIUMCAPACITY, capacity);
                intent.putExtra(STADIUMPLAYING, stadiumPlaying);
                startActivity(intent);
            }
        });
//schalke
        cardV9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stadiumPlaying =getResources().getString(R.string.schalkeeStadium);
                //Equipo que juega de Local y nombre
                int imageTeam = R.drawable.schalke;
                String localTeam = getResources().getString(R.string.schalke);
                //Equipo que juega de Visitante
                int imageTeam2 = R.drawable.juventus;
                String visitorTeam = getResources().getString(R.string.juve);

                //EquipoWeb Local
                int logo = R.drawable.schalke;
                String teamName = getResources().getString(R.string.schalke);
                String history = getResources().getString(R.string.schalkeeHistory);
                String cityTeam = getResources().getString(R.string.schalkeeCity);
                String stadium = getResources().getString(R.string.schalkeeStadium);
                String capacity = getResources().getString(R.string.schalkeeCapacity);


                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                intent.putExtra(TITLE, teamName);
                //Primero pasamos la constante y luego nuestra variable, que es donde tengo almacenada la imagen
                intent.putExtra(LOGO, logo);
                intent.putExtra(LOCALIMG, imageTeam);
                intent.putExtra(VISITIMG, imageTeam2);
                intent.putExtra(LOCALSTR, localTeam);
                intent.putExtra(VISITSTR, visitorTeam);
                intent.putExtra(HISTORY, history);
                intent.putExtra(CITY, cityTeam);
                intent.putExtra(STADIUMNAME, stadium);
                intent.putExtra(STADIUMCAPACITY, capacity);
                intent.putExtra(STADIUMPLAYING, stadiumPlaying);
                startActivity(intent);
            }
        });

        cardV10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stadiumPlaying =getResources().getString(R.string.schalkeeStadium);
                //Equipo que juega de Local y nombre
                int imageTeam = R.drawable.schalke;
                String localTeam = getResources().getString(R.string.schalke);
                //Equipo que juega de Visitante
                int imageTeam2 = R.drawable.juventus;
                String visitorTeam = getResources().getString(R.string.juve);

                //EquipoWeb Local
                int logo = R.drawable.juventus;
                String teamName = getResources().getString(R.string.juve);
                String history = getResources().getString(R.string.juveHistory);
                String cityTeam = getResources().getString(R.string.juveCity);
                String stadium = getResources().getString(R.string.juveStadium);
                String capacity = getResources().getString(R.string.juveCapacity);


                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                intent.putExtra(TITLE, teamName);
                //Primero pasamos la constante y luego nuestra variable, que es donde tengo almacenada la imagen
                intent.putExtra(LOGO, logo);
                intent.putExtra(LOCALIMG, imageTeam);
                intent.putExtra(VISITIMG, imageTeam2);
                intent.putExtra(LOCALSTR, localTeam);
                intent.putExtra(VISITSTR, visitorTeam);
                intent.putExtra(HISTORY, history);
                intent.putExtra(CITY, cityTeam);
                intent.putExtra(STADIUMNAME, stadium);
                intent.putExtra(STADIUMCAPACITY, capacity);
                intent.putExtra(STADIUMPLAYING, stadiumPlaying);
                startActivity(intent);
            }
        });

        cardV11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stadiumPlaying =getResources().getString(R.string.manchesterStadium);
                //Equipo que juega de Local y nombre
                int imageTeam = R.drawable.city;
                String localTeam = getResources().getString(R.string.manchester);
                //Equipo que juega de Visitante
                int imageTeam2 = R.drawable.valencia;
                String visitorTeam = getResources().getString(R.string.valencia);

                //EquipoWeb Local
                int logo = R.drawable.city;
                String teamName = getResources().getString(R.string.manchester);
                String history = getResources().getString(R.string.manchesterHistory);
                String cityTeam = getResources().getString(R.string.ManchesterCity);
                String stadium = getResources().getString(R.string.manchesterStadium);
                String capacity = getResources().getString(R.string.manchesterCapacity);


                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                intent.putExtra(TITLE, teamName);
                //Primero pasamos la constante y luego nuestra variable, que es donde tengo almacenada la imagen
                intent.putExtra(LOGO, logo);
                intent.putExtra(LOCALIMG, imageTeam);
                intent.putExtra(VISITIMG, imageTeam2);
                intent.putExtra(LOCALSTR, localTeam);
                intent.putExtra(VISITSTR, visitorTeam);
                intent.putExtra(HISTORY, history);
                intent.putExtra(CITY, cityTeam);
                intent.putExtra(STADIUMNAME, stadium);
                intent.putExtra(STADIUMCAPACITY, capacity);
                intent.putExtra(STADIUMPLAYING, stadiumPlaying);
                startActivity(intent);
            }
        });

        cardV12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stadiumPlaying =getResources().getString(R.string.manchesterStadium);
                //Equipo que juega de Local y nombre
                int imageTeam = R.drawable.city;
                String localTeam = getResources().getString(R.string.manchester);
                //Equipo que juega de Visitante
                int imageTeam2 = R.drawable.valencia;
                String visitorTeam = getResources().getString(R.string.valencia);

                //EquipoWeb Local
                int logo = R.drawable.valencia;
                String teamName = getResources().getString(R.string.valencia);
                String history = getResources().getString(R.string.valenciaHistory);
                String cityTeam = getResources().getString(R.string.valenciaeCity);
                String stadium = getResources().getString(R.string.valenciaStadium);
                String capacity = getResources().getString(R.string.valenciaCapacity);


                Intent intent = new Intent(MainActivity.this, CardViewActivity.class);
                intent.putExtra(TITLE, teamName);
                //Primero pasamos la constante y luego nuestra variable, que es donde tengo almacenada la imagen
                intent.putExtra(LOGO, logo);
                intent.putExtra(LOCALIMG, imageTeam);
                intent.putExtra(VISITIMG, imageTeam2);
                intent.putExtra(LOCALSTR, localTeam);
                intent.putExtra(VISITSTR, visitorTeam);
                intent.putExtra(HISTORY, history);
                intent.putExtra(CITY, cityTeam);
                intent.putExtra(STADIUMNAME, stadium);
                intent.putExtra(STADIUMCAPACITY, capacity);
                intent.putExtra(STADIUMPLAYING, stadiumPlaying);
                startActivity(intent);
            }
        });



    }

        }
