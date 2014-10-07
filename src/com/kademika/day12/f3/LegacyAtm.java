package com.kademika.day12.f3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Created by Админ on 26.07.2014.
 */
public class LegacyAtm implements Atm {
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public LegacyAtm(int money){
        this.money =money;
    }
    @Override
    public void checkBalance(long ac) {
        System.out.println("your balance are "+getMoney());
    }

    @Override
    public synchronized void withdrawMoney(long acount, int ac) {
        if(getMoney()>0 && getMoney()>ac) {
            setMoney(getMoney() - ac);
            System.out.println("You withdrawed near " + ac + "$");
        }
            checkBalance(acount);
    }
    public void withdrawCash(long acount){
        int i=0;
        try(
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("How much do you want to withdraw?");
             i = Integer.parseInt(br.readLine());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        synchronized (this){
            if(getMoney()>0 && getMoney()>i) {
                withdrawMoney(acount,i);
            }else{
                System.out.println("Sorry, Atm doen`t have "+i+"$");
            }
        }
    }

}
