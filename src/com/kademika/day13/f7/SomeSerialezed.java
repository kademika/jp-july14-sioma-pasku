package com.kademika.day13.f7;

import java.io.*;

/**
 * Created by Админ on 01.09.2014.
 */
public class SomeSerialezed {
    public static void main(String[] args) throws Exception {
//        wr(new File("data.txt"));
try(ObjectInputStream oi = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("data.txt"))));){
    System.out.println(((Person)oi.readObject()).getName());
}
    }
    public static void wr(File file) throws IOException {
        try(ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));){
          os.writeObject(new Person("Kolia"));
          os.writeObject(new Person("Vasia"));
          os.writeObject(new Person("Elena1"));
        }
    }
    static class Person implements Serializable{
        private String name;
 Person(String name){
    this.name= name;
}
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
