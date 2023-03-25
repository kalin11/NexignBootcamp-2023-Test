package storages;


import java.util.Set;

public interface Storage<K, V> {
    boolean containsNumber(K key);

    V get(K key);

    void put(K key, V value);

    Set<K> keySet();
}
