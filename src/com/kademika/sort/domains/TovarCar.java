package com.kademika.sort.domains;

import com.kademika.sort.use.Kategory;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by Админ on 11.07.2014.
 */
public class TovarCar<T> implements Serializable {
    protected int kolModel;
    protected int cost;
    protected int godVipuska;
    protected int zarobotok;
    protected int countOfSelling;
    protected Kategory kategoryi;
    protected String str;
    protected String typeOfCusova;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStr() {
        return str;
    }

    public Kategory getKategoryi() {
        return kategoryi;
    }

    public void setKategoryi(Kategory kategoryi) {
        Random f = new Random();
        int f1 = f.nextInt(4);
        Kategory[] k = kategoryi.values();
        this.kategoryi = k[f1];
    }
    public <T>TovarCar(){
    }


    public int getCountOfSelling() {
        return countOfSelling;
    }

    public void setCountOfSelling(int countOfSelling) {
        this.countOfSelling = countOfSelling;
    }

    public int getZarobotok() {
        return zarobotok;
    }

    public void setZarobotok(int zarobotok) {
        this.zarobotok = zarobotok;
    }

    public int getKolModel() {
        return kolModel;
    }

    public void setKolModel(int kolModel) {
        this.kolModel = kolModel;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
