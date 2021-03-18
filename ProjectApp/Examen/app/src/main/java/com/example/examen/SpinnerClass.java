package com.example.examen;

public class SpinnerClass {
    private String textSpinner;
    private int imageSpinner;

    public SpinnerClass(String textSpinner, int imageSpinner) {
        this.textSpinner = textSpinner;
        this.imageSpinner = imageSpinner;
    }

    public String getTextSpinner() {
        return textSpinner;
    }

    public void setTextSpinner(String textSpinner) {
        this.textSpinner = textSpinner;
    }

    public int getImageSpinner() {
        return imageSpinner;
    }

    public void setImageSpinner(int imageSpinner) {
        this.imageSpinner = imageSpinner;
    }
}
