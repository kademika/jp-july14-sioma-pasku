package com.kademika.sort.use;

import java.io.Serializable;

/**
 * Created by Админ on 11.07.2014.
 */
public class Pokupatel implements Serializable {
    //private NameWhoPay name;
    private String[] name={"Elena","Olga","Mihail","Denis","Petia","Valera","Grisha"};
    private int vozrast;
    private int payment;
    private String nameOfBuyer;

    public void setNameOfBuyer(String nameOfBuyer) {
        this.nameOfBuyer = nameOfBuyer;
    }
    public String getNameOfBuyer() {
        return nameOfBuyer;
    }

    public int getVozrast() {
        return vozrast;
    }

    public void setVozrast(int vozrast) {
        this.vozrast = vozrast;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getName(int i) {
        return  name[i];

    }


}
