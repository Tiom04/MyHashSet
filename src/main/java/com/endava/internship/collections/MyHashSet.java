package com.endava.internship.collections;

import java.util.*;

public class MyHashSet<Student>
        extends AbstractSet<Student>
        implements Set<Student> {

    private HashMap<Student,Object> map;
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
    public Iterator<Student> iterator() {
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
    public boolean add(Student st) {
        return map.put(st, PRESENT)==null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o)==PRESENT;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean addAll(Collection<? extends Student> collection) {
        boolean modified = false;
        for (Student st : collection)
            if (add(st)) modified = true;
        return modified;
    }

    public boolean containsAll(Collection<?> collection) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        //Ignore this for homework
        throw new UnsupportedOperationException();
    }
}
