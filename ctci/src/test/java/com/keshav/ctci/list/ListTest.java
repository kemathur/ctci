package com.keshav.ctci.list;


import org.junit.Test;

public class ListTest {

    @Test
    public void testArrayList() {
        int n = 50;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i<n; i++)
            list.add(i);

        System.out.println(list.size());
        assert (list.size() == n);
        System.out.println(list.get(3));
        assert (list.get(3) == 3);
        list.set(3, 5);
        System.out.println(list.get(3));
        assert (list.get(3) == 5);
        System.out.println(list);
        assert (list.get(-1) == null);
        assert (list.get(51) == null);
    }
}
