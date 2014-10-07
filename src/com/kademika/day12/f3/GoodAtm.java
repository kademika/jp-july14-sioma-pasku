package com.kademika.day12.f3;

/**
 * Created by Админ on 25.07.2014.
 */
public class GoodAtm implements Atm {
    private int money;
    public GoodAtm(int money){
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    @Override
    public void checkBalance(long ac) {
        if(ac==1111) {
            System.out.println("sir, your balance are " + getMoney() + "$");
        }else{
            System.out.println("mam, your balance are " + getMoney()/2 + "$");
        }
    }

    @Override
    public void withdrawMoney(long acount, int ac) {
        if(ac==1111) {
            System.out.println("sir, you are withdrawing " + ac + "$"+" Your remain are "+(money-=ac));
        }else{
            System.out.println("mam, you are withdrawing " + ac + "$"+" Your remain are "+((money-=ac)/2));
        }
    }
}
