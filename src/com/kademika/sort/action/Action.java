package com.kademika.sort.action;

/**
 * Created by Админ on 11.07.2014.
 */
import com.kademika.sort.domains.Audi;
import com.kademika.sort.domains.Bmw;
import com.kademika.sort.domains.Mosckvich;
import com.kademika.sort.domains.TovarCar;
import com.kademika.sort.use.Kategory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;




public class Action {
    private Pokupka p1;
    private int id = 0;
    private int summ = 0;
    private Sklad s;
    private   static List<TovarCar>car ;

    public Action() {
        car = new ArrayList<TovarCar>();
        p1 = new Pokupka();
        s = new Sklad();
        s.createKatalog();
    }


    public   static List<TovarCar> getCar() {

//		fiilingToTovar(car);

        return car;
    }

    public void setCar(List<TovarCar> car) {
        this.car = car;
    }

//    public <T>TovarCar getTovar(int i) {
//		return car.get(i);
//	}

    public static  void addToShop(List<TovarCar> car1,TovarCar car2) {
//		if (car1 instanceof Bmw) {
//			setCar(car[0], car1);
//
//		}
//		if (car1 instanceof Audi) {
//			setCar(car[1], car1);
//		}
//		if (car1 instanceof Mosckvich) {
//			setCar(car[2], car1);
//		}
        car1.add(car2);

    }

//	private static void setCar(TovarCar[] car, TovarCar car1) {
//		for (int i = 0; i < car.length; i++) {
//			if (car[i] == null) {
//				car[i] = car1;
//				return;
//			}
//		}
//	}

    private void fiilingToTovar(TovarCar[][] car) {
        car[0] = new Bmw[4];
        car[1] = new Audi[3];
        car[2] = new Mosckvich[3];
    }

    // ------------- information about goods
    public void CostOfCar() {
        for(int i =0; i < car.size(); i++){
            TovarCar car3 = car.get(i);
            System.out.println(car3.getClass().getSimpleName() + " " + car3.getKategoryi() + " from "
                    + car3.getCost() + "$. There are " + car3.getKolModel()
                    + " of things");
        }

    }


    // --------------to recieve the goods by kategory
    public List<TovarCar> giveTheGoods(Kategory kategoryi) {
        List<TovarCar> car = new ArrayList<TovarCar>();
        for (int i=0;i<getCar().size(); i++) {
            if (getCar().get(i).getKategoryi().equals(kategoryi)) {
                car.add(getCar().get(i));
            }
        }
        return car;
    }

//	private void fillCar(TovarCar car, TovarCar[] car1) {
//		for (int i = 0; i < car1.length; i++) {
//			if (car1[i] == null) {
//				car1[i] = car;
//				break;
//			}
//		}
//	}

    // -------------make a bye by the day from period of u
    public void CountBroughtOfPeriod(int u) {

        for (int g = 0; g < u; g++) {
            int g1 = 0;
            for (TovarCar car1 : getCar()) {
                g1 += p1.Sell(car1);
            }
            System.out.print(g1 + " ");
        }
        System.out.println();
    }

    public void ListOfSelling() {
        int d = 0, c = 0, v = 0;
        for (TovarCar car1 : getCar()) {
            Random r = new Random();
            int f1 = r.nextInt(getCar().size());
            while ((f1 + 1) < getCar().size()) {
                d++;
                System.out.println(d + " " + p1.Selling(getCar().get(f1)));
                v += getCar().get(f1).getZarobotok();
                c += getCar().get(f1).getCountOfSelling();

                f1++;
            }
        }

        System.out.print("Itogo: " + d + " pokupki by sum " + v
                + " with general count at " + c);
    }

    public void sell(TovarCar car, String name, int count) {
        id++;
        summ += count*car.getCost();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MMM/yyyy");
        System.out.println(id + " " + name + " "+ car.getName()+"  " + sdf.format(new Date())+" " + count
                + " car on cost" + car.getCost() + ". In general our profit are " + summ+"$");
    }
}
