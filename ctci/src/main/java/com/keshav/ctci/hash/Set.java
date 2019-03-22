package com.keshav.ctci.hash;

public interface Set<T> {
    public boolean isPresent(T key);

    public void add(T key);

    public int size();
}
