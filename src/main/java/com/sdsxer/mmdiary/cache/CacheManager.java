package com.sdsxer.mmdiary.cache;

public interface CacheManager<K, V> {

    V put(K key, V value);

    V get(K key);

    void delete(K key);
}
