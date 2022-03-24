package com.endava.internship.collections;

public class Main {
    public static void main(String[] args) {
        MyHashSet<String> stringSet = new MyHashSet();
        stringSet.add("string1");
        stringSet.add("string2");
        stringSet.add("string3");
        for(String val : stringSet) {
            System.out.println(val);
        }
        stringSet.remove("string2");
        System.out.println("\nremoving string2\n");
        for(String str : stringSet) {
            System.out.println(str);
        }




    }
}
