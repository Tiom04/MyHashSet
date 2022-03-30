package com.endava.internship.collections;

import java.util.*;

public class MyHashSet<T>
        extends AbstractSet<T>
        implements Set<T> {

    private HashMap<T, Object> map;
    private static final Object PRESENT = new Object();

    public MyHashSet() {
        map = new HashMap<>();
    }

    public MyHashSet(int capacity) {
        map = new HashMap<>(capacity);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return map.keySet().toArray(new Object[map.size()]);
    }

    @Override
    public <T> T[] toArray(T[] a) {

        return map.keySet().toArray(a);
    }

    @Override
    public boolean add(T obj) {
        return map.put(obj, PRESENT) == null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        boolean modified = false;
        for (T obj : collection) {
            if (add(obj)) {
                modified = true;
            }
        }
        return modified;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object val : collection) {
            if (!map.containsKey(val)) {
                return false;
            }
        }
        return true;
    }

    public boolean retainAll(Collection<?> collection) {
        boolean modified = false;
        for (Object val : map.keySet()) {
            if (!collection.contains(val)) {
                map.remove(val);
                modified = true;
            }
        }
        return modified;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean modified = false;
        for (Object val : collection) {
            if (map.containsKey(val)) {
                map.remove(val);
                modified = true;
            }
        }
        return modified;
    }
}
