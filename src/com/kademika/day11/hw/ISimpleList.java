package com.kademika.day11.hw;

import java.util.Iterator;

/**
 * Created by Админ on 30.07.2014.
 */
public interface ISimpleList<T> {
    public void add(T object);

    public boolean contains(T object);

    public void remove(T object);

    public int size();

    public Iterator<T> iterator();
}
