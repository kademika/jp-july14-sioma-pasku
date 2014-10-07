package com.kademika.day11.hw;

import com.kademika.day11.f7.Characters;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by Админ on 20.07.2014.
 */
public class Louncher {
    public static void main(String[] args) {
//       System.out.println(new File("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\hw\\main.txt").length());
        ListBaseOnFile simpleList = new ListBaseOnFile(new File("C:\\Users\\Админ\\Dropbox\\jb-midgardabc\\jc-paskuSam\\src\\com\\kademika\\day11\\hw\\main.txt"));
//        simpleList.add("hjkhj");
////
//        simpleList.add("Veronjha");
//        simpleList.add("asdjhggj");
//        simpleList.add(new Object());
//        simpleList.add(new Object());
//        System.out.println(simpleList.contains("Verona"));
//        System.out.println(simpleList.contains("Verona"));
//        simpleList.remove("Object");
//        simpleList.remove("asdjhggj");
//        simpleList.remove("Verona");
//        System.out.println(simpleList.contains("Object"));
        for(Iterator<String> o = simpleList.iterator(); o.hasNext();){
            System.out.println((o.next()));
        }
//        System.out.println(simpleList.size());
//        simpleList.deleteElementFromList("Verona");
//        System.out.println("fdg".getClass().getSimpleName()+" "+String.class.getSimpleName());
//        System.out.println(Arrays.toString(".".getBytes(StandardCharsets.UTF_8)));
    }
}
