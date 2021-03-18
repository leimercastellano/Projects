package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Calendar;

public class SingUpActivity extends AppCompatActivity {
    DatePickerDialog picker;
    private EditText textDate;
    private TextInputEditText textInputEditText;
    private Spinner spinnerClass;
    private ArrayList<Cards> mCards;
    private CardsAdapter mAdapter;
    private Switch switchNewsletter;
    private TextView textViewAlready;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
//hook
        spinnerClass = findViewById(R.id.spinnerClass);
        switchNewsletter = (Switch) findViewById(R.id.switch1);

        switchNewsletter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchNewsletter != null) {
                    switchNewsletter.setOnCheckedChangeListener(new
                                                                        CompoundButton.OnCheckedChangeListener() {
                                                                            @Override
                                                                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                                                if (isChecked) {
                                                                                    Toast.makeText(SingUpActivity.this, "" + isChecked,
                                                                                            Toast.LENGTH_SHORT).show();
                                                                                } else {
                                                                                    Toast.makeText(SingUpActivity.this, "" + isChecked,
                                                                                            Toast.LENGTH_SHORT).show();
                                                                                }
                                                                            }
                                                                        });
                }

            }
        });

        textViewAlready = findViewById(R.id.already);

        textViewAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingUpActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });





        textInputEditText = findViewById(R.id.textDate);
        //textDate = (EditText) findViewById(R.id.textDateClick);
        textInputEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //select current date

                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
//instaniar datePicker dialog
                //DatepickerDialog.onDateSetLiserner

                picker = new DatePickerDialog(SingUpActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                //mostrar data
                                textInputEditText.setText(dayOfMonth + "/" + month + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        //Spinner Class

        mCards = new ArrayList<>();
        mCards.add(new Cards("American Express", R.drawable.americanexpress));
        mCards.add(new Cards("Master Card", R.drawable.master));
        mCards.add(new Cards("Ebay", R.drawable.ebay));
        mCards.add(new Cards("Bank Transfer", R.drawable.banktransfer));
        mCards.add(new Cards("Google Wallet", R.drawable.googlewallet));
        mCards.add(new Cards("Visa", R.drawable.visa));
        mCards.add(new Cards("Hsbc", R.drawable.hsbc));

        mAdapter = new CardsAdapter(this, mCards);
        spinnerClass.setAdapter(mAdapter);

        spinnerClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Cards selectedItem = (Cards) parent.getItemAtPosition(position);
                String selectedCards = selectedItem.getCardName();
                Toast.makeText(SingUpActivity.this, selectedCards, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//Toast
                Toast.makeText(SingUpActivity.this, "Nothing Selected", Toast.LENGTH_SHORT).show();
            }
        });


        //funciona
        //textDate = (EditText) findViewById(R.id.textDateClick);

    /*    textDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //select current date

                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
//instaniar datePicker dialog
                //DatepickerDialog.onDateSetLiserner

                picker = new DatePickerDialog(SingUpActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                //mostrar data
                            textDate.setText(dayOfMonth + "/" +month +"/"+year );
                            }
                        },year, month, day);
                picker.show();
            }
        });*/

    }
}
