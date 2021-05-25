package com.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU
 *
 * @author monkjavaer
 * @date 2021/5/25
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    /**
     * 缓存容量
     */
    private int capacity;

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    public LRUCache(int capacity) {
        super(capacity, DEFAULT_LOAD_FACTOR, true);
        this.capacity = capacity;
    }

    /**
     * 如果map中的数据量大于设定的最大容量，返回true，再新加入对象时删除最老的数据
     *
     * @param eldest 最老的数据项
     * @return true则移除最老的数据
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当 LinkedHashMap 中的数据量大于指定的缓存个数的时候，自动移除最老的数据
        return size() > capacity;
    }
}
