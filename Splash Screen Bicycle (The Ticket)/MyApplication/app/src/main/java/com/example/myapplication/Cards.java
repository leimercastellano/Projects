package com.example.myapplication;

import android.widget.ImageView;

public class Cards {
    private String CardName;
    private int imgCard;

    public Cards(String cardName, int imgCard) {
        CardName = cardName;
        this.imgCard = imgCard;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }

    public int getImgCard() {
        return imgCard;
    }

    public void setImgCard(int imgCard) {
        this.imgCard = imgCard;
    }
}
