package com.kademika.day10.junit;

/**
 * Created by Семен on 26.06.2014.
 */
public class CatNotHungreException extends  RuntimeException{
    public CatNotHungreException(String masg) {
        super(masg);
    }
}
