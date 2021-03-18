package com.example.myapplication;

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

public class CardsAdapter extends ArrayAdapter<Cards> {
public CardsAdapter(Context context, ArrayList<Cards> cardsList){
    super(context, 0, cardsList);
}

    public CardsAdapter(@NonNull Context context, int resource) {
        super(context, resource);
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

    public View init(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if (convertView==null) {
             convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.spinner_row,
                    parent,
                     false
            );
        }
            ImageView imageView = convertView.findViewById(R.id.imageCard1);
            TextView textView = convertView.findViewById(R.id.textCard1);
            Cards curentCard =getItem(position);
            if (curentCard!=null){
                imageView.setImageResource(curentCard.getImgCard());
                textView.setText(curentCard.getCardName());
            } return convertView;

        }


}
