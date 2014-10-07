package com.kademika.day12.f6;

/**
 * Created by Админ on 29.07.2014.
 */
public class SchoolSkateRing implements Skatelink {
    private Skate sc;
    public SchoolSkateRing(){
        sc = new Skate(2);
    }
    @Override
    public Skate gotSkate(Skater s) {
        if(sc.getCountOfSk()>0) {

            sc.setCountOfSk(1);
            System.out.println("Take the Skate " + s.getName());
        }
        else{
            try {
                synchronized (sc) {
                    sc.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return sc;
    }

    @Override
    public void returnSk(Skater s, Skate f) {
        synchronized (sc) {
            sc.notifyAll();
        }
        f.setCountOfSk(-1);
        System.out.println(s.getName()+" return the skate "+f.getClass().getSimpleName());
    }
}
