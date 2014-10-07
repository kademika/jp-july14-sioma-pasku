package com.kademika.day10.generics.basic.wildCards;

import com.kademika.day10.generics.domains.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Семен on 25.06.2014.
 */
public class FruitBox<T extends Fruit> {
    private List<T> fruits;

    public FruitBox(){
        fruits = new ArrayList<T>();
    }
    public List<T> getFruits() {
        return new ArrayList(fruits);
    }

    public void setFruits(T fruits) {
       this.fruits.add(fruits);
    }
    public void sortFruits(){
        int g= fruits.size();
       for(int i=0;i<=(fruits.size()/2);i++) {
           if (getFruits().get(i).getName().equals("Banana")){
           }
           else{
while(!getFruits().get(i).getName().equals("Banana")) {
    fruits.add(fruits.size(), getFruits().get(i));
    fruits.remove(getFruits().get(i));

}
           }
       }
    }
}
