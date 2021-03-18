package com.example.examen02;

public class Gym {
    private String classType;
    private String trainer;
    private String date;
    private String time;
    private int image0;
    private int[] images;
    private String description;
    private String kCal;
    private String duration;

    public Gym(String classType, String trainer, String date, String time, int image0, int[] images, String description, String kCal, String duration) {
        this.classType = classType;
        this.trainer = trainer;
        this.date = date;
        this.time = time;
        this.image0 = image0;
        this.images = images;
        this.description = description;
        this.kCal = kCal;
        this.duration = duration;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage0() {
        return image0;
    }

    public void setImage0(int image0) {
        this.image0 = image0;
    }

    public int[] getImages() {
        return images;
    }

    public void setImages(int[] images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getkCal() {
        return kCal;
    }

    public void setkCal(String kCal) {
        this.kCal = kCal;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
