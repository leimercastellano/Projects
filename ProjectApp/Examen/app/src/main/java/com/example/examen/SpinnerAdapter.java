package com.example.examen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SpinnerAdapter  extends ArrayAdapter<SpinnerClass> {

public SpinnerAdapter (Context context, ArrayList<SpinnerClass> spinnerClassesList){
    super(context, 0, spinnerClassesList);
}

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return init(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return init(position, convertView, parent);
    }

    //Para no repetir codigo entonces creamos un metodo que devuelve una view
    //y que recibe los mismos parametros
    public View init(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_row, parent, false
            );
            //Tenemos que recuperar la dada seleccionada
            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView = convertView.findViewById(R.id.textView);
           SpinnerClass currentItem = getItem(position);
            if (currentItem != null) {
                imageView.setImageResource(currentItem.getImageSpinner());
                textView.setText(currentItem.getTextSpinner());
            }
        }
        return convertView;
    }
}
