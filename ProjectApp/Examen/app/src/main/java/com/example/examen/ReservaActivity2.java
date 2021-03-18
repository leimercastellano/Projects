package com.example.examen;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class ReservaActivity2 extends AppCompatActivity {
    private Switch aSwitch;
    private RadioGroup radioGroup1;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    DatePickerDialog picker;
    private EditText textDate1;
    private EditText textDate2;
    private EditText textNom;
    private EditText textApellido;
    private EditText nroPersonas;
    private Button button;
/*    private Spinner spinner;
    private ArrayList<SpinnerClass> spinnerClassArrayList;
    private SpinnerAdapter spinnerAdapter;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva2);
        //hocks
        aSwitch = findViewById(R.id.switch2);
        radioGroup1 = findViewById(R.id.radioGrupo1);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        textDate1 = (EditText) findViewById(R.id.editTextDate1);
        textDate2 = (EditText) findViewById(R.id.editTextDate2);
        textNom = findViewById(R.id.EditTextname);
        textApellido = findViewById(R.id.EditTextApellido);
        nroPersonas = findViewById(R.id.EditTextInt);
        button = findViewById(R.id.button);
      /*  spinner = findViewById(R.id.spinner);


        spinnerClassArrayList = new ArrayList<>();
        spinnerClassArrayList.add(new SpinnerClass("Refugi Josep Maria Blanc", R.drawable.foto1));
        spinnerClassArrayList.add(new SpinnerClass("Refugi Cap de Llauset", R.drawable.foto2));
        spinnerClassArrayList.add(new SpinnerClass("Refugi Ventosa i Clavell", R.drawable.foto3));
        spinnerClassArrayList.add(new SpinnerClass("Refugi Amitges", R.drawable.foto4));
        spinnerClassArrayList.add(new SpinnerClass("Refugi Josep Maria Montfort", R.drawable.foto5));

        spinnerAdapter = new SpinnerAdapter(ReservaActivity2.this, spinnerClassArrayList);
        spinner.setAdapter(spinnerAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Recuperamos los datos
                SpinnerClass selectedItem = (SpinnerClass) parent.getItemAtPosition(position);
                String selectedDavidBowie = selectedItem.getTextSpinner();
                Toast.makeText(ReservaActivity2.this,"Nothing Selected", Toast.LENGTH_SHORT ).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            Toast.makeText(ReservaActivity2.this,"Nothing Selected", Toast.LENGTH_SHORT ).show();
            }
        });
*/

        textDate1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);


                //DatePickerDialog
                //DatePickerDialog.onDateSetListener();

                picker = new DatePickerDialog(ReservaActivity2.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                //Mostrar la data seleccionada
                                textDate1.setText(dayOfMonth + "/" + month + "/" + year);
                            }
                        }, year, month, day);
                picker.show();

            }
        });


        textDate2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);


                //DatePickerDialog
                //DatePickerDialog.onDateSetListener();

                picker = new DatePickerDialog(ReservaActivity2.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                //Mostrar la data seleccionada
                                textDate2.setText(dayOfMonth + "/" + month + "/" + year);
                            }
                        }, year, month, day);
                picker.show();

            }
        });


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    radioButton4.setChecked(false);
                    Toast.makeText(ReservaActivity2.this, "enable", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ReservaActivity2.this, "disable", Toast.LENGTH_SHORT).show();
                }

                for (int i = 0; i < 3; i++) {
                    ((RadioButton) radioGroup1.getChildAt(i)).setEnabled(isChecked);
                }

            }
        });
        for (int i = 0; i < 3; i++) {
            ((RadioButton) radioGroup1.getChildAt(i)).setEnabled(false);
        }
        radioButton4.setChecked(true);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textNom == null && textApellido == null && textDate1 == null && textDate2 == null && nroPersonas == null) {

                    Toast.makeText(ReservaActivity2.this, "Faltan Campos por rellenar", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}