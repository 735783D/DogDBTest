package com.example.dogdbtest;

public class dogs {

    int id, lifespan;
    String breed, special;
    double price;

    public dogs(int id, int lifespan, String breed, double price, boolean vaccinated, String special ) {
        this.id = id;
        this.lifespan = lifespan;
        this.breed = breed;
        this.special = special;
        this.price = price;
        this.vaccinated = vaccinated;
    }

    boolean vaccinated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
}
