package com.kademika.day10.generics.basic.number;

import com.kademika.day10.generics.domains.Fruit;
import net.sourceforge.stripes.util.ResolverUtil;
import net.sourceforge.stripes.vfs.VFS;
import org.objenesis.instantiator.sun.SunReflectionFactorySerializationInstantiator;
import org.reflections.Reflections;
import sun.reflect.Reflection;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Created by Семен on 26.06.2014.
 */
public class PrintNumber<E extends Number> {
    public static void main(String[] args) throws Exception {
       Class s = Reflection.getCallerClass();
        ClassLoader classLoader = Fruit.class.getClassLoader();
        Class[] c =Class.forName("java.lang.Number").getDeclaredClasses();
        for(Class innerClass: c)
        {
//            if(innerClass.getSuperclass().equals(Number.class))
//            {
//                System.out.println("Sub inner class: " + innerClass.getName());
//            }
System.out.println(innerClass);
        }


//        ClassLoader classLoader = PrintNumber.class.getClassLoader();

//        try {
//            Class aClass = classLoader.loadClass("com.kademika.day10.generics.domains");
//            for(Class hg : aClass.getClasses())
//            System.out.println("aClass.getName() = " +hg.getSimpleName() );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static <T> void cou(Class<? extends T> n)throws Exception {
//        T df = (T)n.;
        Class classes = n.asSubclass(Number.class);
//        int nd=0;
//       while(nd <10){
//           try{
//           ParameterizedType type = (ParameterizedType)n.getGenericSuperclass();
        System.out.println(classes);
//        nd++;}catch(ClassCastException e){}
//       }
//        for(Type type: n.getGenericSuperclass()){
//
//        }


    }}
