package com.kademika.day10.generics.basic.wildCards;

import com.kademika.day10.generics.basic.box.MyBox;
import com.kademika.day10.generics.domains.Apple;
import com.kademika.day10.generics.domains.Banana;
import com.kademika.day10.generics.domains.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Семен on 25.06.2014.
 */
public class DemoBox {
    public static void  main(String[] args){
        FruitBox<Fruit> fruit = new FruitBox<Fruit>();
        fruit.setFruits(new Banana());
        fruit.setFruits(new Banana());
//        fruit.setFruits(new Apple());
//        fruit.setFruits(new Apple());
//        fruit.setFruits(new Banana());
//        fruit.setFruits(new Apple());
//        fruit.setFruits(new Banana());
//        fruit.setFruits(new Apple());

        for(Fruit e : fruit.getFruits()){

        }
       fruit.sortFruits();
        List<Fruit> fruit1 = new ArrayList<Fruit>();
        fruit1.add(new Banana());
        fruit1.add(new Banana());
//        fruit1.add(new Apple());
//        fruit1.add(new Apple());
        sortSomeFruits(fruit1);// have a mistake, cann`t added to list unknown fruit

}
    public static void  sortSomeFruits(List<? extends Fruit> fruit){
       for(int i  = 0; i < fruit.size();i++) {
         if(fruit.get(i).getName().equals("Apple")){

         }
           else{
//             fruit.add(fruit.size(),fruit.get(i));
             fruit.remove(fruit.get(i));
         }
       }
    }
}
