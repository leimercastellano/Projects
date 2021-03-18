package com.example.examen02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static String TITLE = "com.example.examen02.TITLE";
    public static String TRAINER = "com.example.examen02.TRAINER";
    public static String DESCRIPTION = "com.example.examen02.DESCRIPTION";
    public static String KCAL = "com.example.examen02.KCAL";
    public static String DURATION = "com.example.examen02.DURATION";
    public static String ROOM = "com.example.examen02.ROOM";
    public static String DATE = "com.example.examen02.DATE";
    public static String TIME = "com.example.examen02.TIME";
    int myPosition;
    private ListView listView;
    List<Gym> listaGyms;

    Gym gymSpining = new Gym("Spinning", "Peter K", "10/10/2020", "10:00",
            R.drawable.spinning0, new int[]{R.drawable.spinning1, R.drawable.spinning2, R.drawable.spinning3, R.drawable.spinning4, R.drawable.spinning5,
    R.drawable.spinning6}, "This is the Description", "150","1" );

    Gym gymFitness = new Gym("Fitness", "Anna B", "12/10/2020", "09:00", R.drawable.fitness0,
            new int[]{R.drawable.fitness1, R.drawable.fitness2, R.drawable.fitness3, R.drawable.fitness4, R.drawable.fitness5, R.drawable.fitness6
            }, "This is the description", "190", "2h");

    Gym gymKombat = new Gym("Kombat", "Jhonny T", "15/11/2020", "11:00", R.drawable.kombat0,
            new int[]{R.drawable.kombat1, R.drawable.kombat2, R.drawable.kombat3}, "This is the description", "200", "1:30h");

    Gym gymSpartan = new Gym("Spartan", "Peter K", "13/10/2020", "11:00", R.drawable.spartan0,
            new int[]{R.drawable.spartan1, R.drawable.spartan2, R.drawable.spartan3, R.drawable.spartan4}, "description", "100", "1h");

    Gym gymZumba= new Gym("Zumba", "Anna K", "13/10/2020", "11:00", R.drawable.zumba0,
            new int[]{R.drawable.zumba0}, "description", "100", "1h");

/*

    private Integer[] imagesIds = {
            R.drawable.fitness0,
            R.drawable.kombat0,
            R.drawable.spartan0,
            R.drawable.spinning0,
            R.drawable.zumba0
    };

    private String[] imagesText = {
            "Fitness",
            "Kombat",
            "Spartan",
            "Spinning",
            "Zumba"
    };*/

    CustomAdapter customAdapter = new CustomAdapter();

  /*  Gym gymSpining = new Gym("Spinning", "Peter K", "10/10/2020", "10:00",
            R.drawable.spinning0, new int[6], "This is the Description", "150","1" );
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaGyms= new ArrayList<Gym>();
        listaGyms.add(gymFitness);
        listaGyms.add(gymKombat);
        listaGyms.add(gymSpartan);
        listaGyms.add(gymZumba);
        listaGyms.add(gymSpining);
        listaGyms.add(gymFitness);
        listaGyms.add(gymKombat);
        listaGyms.add(gymSpartan);
        listaGyms.add(gymZumba);
        listaGyms.add(gymSpining);



        listView = findViewById(R.id.listView);
        listView.setAdapter(customAdapter);
        registerForContextMenu(listView);


    }
    private class CustomAdapter extends BaseAdapter {
      /*  private Context context;
        private ArrayList<ClipData.Item> items;

        public CustomAdapter(Context context, ArrayList<ClipData.Item> items) {
            this.context = context;
            this.items = items;
        }
*/
        @Override
        public int getCount() {
            //Retornamos el tamano de vistas que tenemos
            return listaGyms.size();
        }

        @Override
        public Object getItem(int position) {
            //retornamos la posicion
            return position;
        }

        @Override
        public long getItemId(int position) {
            myPosition=position;
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view =getLayoutInflater().inflate(R.layout.data_row, null );
            TextView textTitle= view.findViewById(R.id.textViewTittle);
            TextView textTrainer= view.findViewById(R.id.textTrainer);
            TextView textData =view.findViewById(R.id.textdata);
            TextView textTime= view.findViewById(R.id.texttime);



            ImageView imageRow=view.findViewById(R.id.image);

            textTitle.setText(listaGyms.get(position).getClassType());
            textTrainer.setText(listaGyms.get(position).getTrainer());
            textData.setText(listaGyms.get(position).getDate());
            textTime.setText(listaGyms.get(position).getTime());

            imageRow.setImageResource(listaGyms.get(position).getImage0());



            return view;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case 1:
                rellenarBook(myPosition);
                Toast.makeText(this, "Reserve", Toast.LENGTH_SHORT).show();
                return true;
            case 2:
                Toast.makeText(this, "Info", Toast.LENGTH_SHORT).show();
                return true;
            case 3:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        /*Primer argumento es el numero si van juntos
         * el segundo es el id para hacer la referencia , el orden y el texto que se mostrara*/

        menu.setHeaderTitle("Choose an Option");

        menu.add(0, 1, 1, "Reserve");
        menu.add(0, 2, 2, "Info");
        menu.add(0, 3, 3, "Share");
    }

    public  void rellenarBook(int position){

                Intent intent = new Intent(MainActivity.this, BookActivity.class);
                intent.putExtra(TRAINER, listaGyms.get(position).getTrainer());
                intent.putExtra(DESCRIPTION, listaGyms.get(position).getDescription());
                intent.putExtra(KCAL, listaGyms.get(position).getkCal());
                intent.putExtra(DURATION, listaGyms.get(position).getDuration());
                intent.putExtra(ROOM, "No Assignet");
                intent.putExtra(DATE, listaGyms.get(position).getDate());
                intent.putExtra(TIME, listaGyms.get(position).getTime());

ArrayList <Integer> listaImagenes = new ArrayList<>();
        for (int i =0; i<listaGyms.get(position).getImages().length;i++){
            listaImagenes.add(listaGyms.get(position).getImages()[i]);
        }



                intent.putIntegerArrayListExtra("IMAGENES", listaImagenes);

        startActivity(intent);

    }


}