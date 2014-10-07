package com.kademika.sort.domains;

/**
 * Created by Админ on 11.07.2014.
 */
public class TovarCarBox<T extends TovarCar> {
    TovarCar<T> car;
    public TovarCarBox(){
        car = new TovarCar<T>();
    }

    public TovarCar<T> getCar() {
        return car;
    }

    public void setCar(TovarCar<T> car) {
        this.car = car;
    }
}