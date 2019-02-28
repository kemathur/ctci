public class com.keshav.ctci.hash;

/*
*  Its an ordered Dictionary.
*  Helps return the keys with order.
*/
public class LinkedHashMap<K, V>{

    private HashMap<K,V> map;
    private LinkedList<KVPair<K, V>> list;

    public LinkedHashMap() {}

    public void put(K key, V value) {
        map.put(key, value);
        if (!map.isKeyPresent(key))
            list.add(key);
    }


    public V get(K key) {
        return map.get(key);
    }


}
