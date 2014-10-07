package com.kademika.sort.action;

import com.kademika.sort.domains.Audi;
import com.kademika.sort.domains.Bmw;
import com.kademika.sort.domains.Mosckvich;
import com.kademika.sort.domains.TovarCar;
import com.kademika.sort.use.Kategory;

/**
 * Created by Админ on 11.07.2014.
 */
public class Sklad {
    public void createKatalog() {

        TovarCar<Bmw> b = new TovarCar<Bmw>();
        b.setName("Bmw_X7");
        b.setCost(70000);
        b.setKolModel(9);
        b.setKategoryi(Kategory.CUPE);
        Action.addToShop(Action.getCar(),b);

        b = new TovarCar<Bmw>();
        b.setName("Bmw_X6");
        b.setCost(75000);
        b.setKolModel(10);
        b.setKategoryi(Kategory.JEEP);
        Action.addToShop(Action.getCar(),b);
        b = new TovarCar<Bmw>();
        b.setName("Bmw_X5");
        b.setCost(73000);
        b.setKolModel(8);
        b.setKategoryi(Kategory.PIKAP);
        Action.addToShop(Action.getCar(),b);
        b = new TovarCar<Bmw>();
        b.setName("Bmw_M6");
        b.setCost(75999);
        b.setKolModel(11);
        b.setKategoryi(Kategory.SEDAN);
        Action.addToShop(Action.getCar(),b);
        TovarCar<Audi> a = new TovarCar<Audi>();
        a.setName("Audi_A6");
        a.setCost(70000);
        a.setKolModel(6);
        a.setKategoryi(Kategory.CUPE);
        Action.addToShop(Action.getCar(),a);
        a = new TovarCar<Audi>();
        a.setName("Audi_A12");
        a.setCost(73000);
        a.setKolModel(8);
        a.setKategoryi(Kategory.PIKAP);
        Action.addToShop(Action.getCar(),a);
        a = new TovarCar<Audi>();
        a.setName("Audi_M6");
        a.setCost(75999);
        a.setKolModel(11);
        a.setKategoryi(Kategory.SEDAN);
        Action.addToShop(Action.getCar(),a);
        TovarCar<Mosckvich>m = new TovarCar<Mosckvich>();
        m.setCost(12000);
        m.setName("Mosckvich_412");
        m.setKolModel(12);
        m.setKategoryi(Kategory.CUPE);
        Action.addToShop(Action.getCar(),m);
        m = new TovarCar<Mosckvich>();
        m.setCost(9000);
        m.setName("Mosckvich_612");
        m.setKolModel(8);
        m.setKategoryi(Kategory.PIKAP);
        Action.addToShop(Action.getCar(),m);
        m = new TovarCar<Mosckvich>();
        m.setCost(10000);
        m.setName("Mosckvich_5");
        m.setKolModel(11);
        m.setKategoryi(Kategory.SEDAN);
        Action.addToShop(Action.getCar(),m);
    }
}
