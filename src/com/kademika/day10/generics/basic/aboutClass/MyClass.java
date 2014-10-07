package com.kademika.day10.generics.basic.aboutClass;

import com.kademika.day10.generics.domains.Banana;
import com.kademika.day10.generics.domains.Fruit;

import java.io.IOException;
import java.lang.reflect.*;
import java.util.*;

/**
 * Created by Семен on 27.06.2014.
 */
public class MyClass<T> {

    private static Field[] fields;
    private static String name;
    private int length;
    private static Map<String,Object> map;
    private static String id1;
    public MyClass() {
    }

    public MyClass(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public static void printClassInfo(Class<? extends Class> cl) {


//    }
    }

    public static void printMethods(MyClass cl) {
        System.out.print(cl.getClass().getDeclaredMethods());
    }

    public static void printFields(MyClass cl) {
        System.out.print(cl.getClass().getFields());
    }

    public static <T> T initClass(Class<? extends T> tClass, Map<String, Object> gf) throws Exception {
        T g = (T) tClass.newInstance();
        for (Method method : g.getClass().getMethods()) {
            String bla = method.getName().substring(0,3);
            char df =  Character.toLowerCase(method.getName().charAt(3));
            if (bla.equals("set") ) {
                try {
                    method.invoke(g, gf.get(df + method.getName().substring(4)));
                }catch(IllegalArgumentException e){
                }
                }
        }

        return g;

    }

    public static <T>List initClass1(Class<? extends T> c, List<Object> list)throws Exception {
       List <T> fd = new ArrayList<>();
        Object[]o=new Array[list.size()];
        Constructor[] allConstructors = c.getDeclaredConstructors();
        for (Constructor ctor : allConstructors) {
            Class<?>[] pType  = ctor.getParameterTypes();
            for (int i = 0; i < pType.length; i++) {
                if (pType[i].equals(list.get(i).getClass())) {
                    o[i]=list.get(i);
                    fd.add((T) ctor.newInstance(o));
                }
            }
        }
        return fd;
    }

    public static void main(String[] args) throws Exception{
        map = new HashMap<>(5,2);
        map.put(name, "Baana Africa");
//        map.put(id1,"h");
        initClass(Banana.class,map);
        System.out.println(initClass(GDSGgfdg.class,map).getClass().getSimpleName());
    }

    public static void setPrivets(Object o, Map<String, Object> map) throws IllegalAccessException{
        Field[] flds = o.getClass().getDeclaredFields();
        for(Field f : flds){
            if(  Modifier.isPrivate(f.getModifiers())){
                        f.set(f.getName(),map.get(f.getName()));

            }
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
