package com.keshav.ctci.list;

//import java.util.List;


public interface List<T> {
    public void add(T data);
    public T get(int i);
    public int size();
    boolean isEmpty();
    boolean contains(T a);
}
