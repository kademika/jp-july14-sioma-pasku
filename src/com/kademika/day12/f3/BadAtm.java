package com.kademika.day12.f3;

import com.kademika.day10.generics.domains.Banana;
import javafx.scene.effect.Reflection;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Админ on 25.07.2014.
 */
public class BadAtm implements Atm {
    private volatile int money;
    private ReentrantLock accountL;
    private int husbandWithdraw=0;
    private int wifedWithdraw=0;

    public BadAtm(int money) {
        accountL = new ReentrantLock();
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public void checkBalance(long ac) {
        if (ac == 1111) {

            System.out.print("sir, your balance are " + getMoney() + "$");
            System.err.println("sir withdrawed near "+husbandWithdraw+"$");
        } else {

            System.out.print("mam, your balance are " + getMoney() / 2 + "$");
            System.err.println("mam withdrawed near "+wifedWithdraw+"$");
        }
    }

    @Override
    public void withdrawMoney(long acount, int ac) {
        accountL.lock();
try{
        if (alowWithdraw(acount, ac)) {
            setMoney(getMoney()-ac);
            System.out.println("you withraw " + ac);
        } else {
            System.err.println("Sorry, you don`t withraw "+ac+"$");

        }}finally {
    accountL.unlock();
        }
    }

    private boolean alowWithdraw(long acount, int ac) {
        boolean alow = false;
        if (acount == 1111 && getMoney() > ac && getMoney()>0) {
            husbandWithdraw+=ac;
            alow = true;
        } else if (acount == 2222 && (getMoney() / 2) > ac && getMoney()>0) {
            alow = true;
            wifedWithdraw+=ac;
        }
        return alow;
    }
}
