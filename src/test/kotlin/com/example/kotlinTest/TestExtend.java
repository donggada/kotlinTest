package com.example.kotlinTest;

import java.util.*;

abstract class TestExtend {

    public static void main(String[] args) {
        A a = new A();
        A b = new B();
        B nb = new B();

        a.a();
        b.a();

        nb.b(a);
        System.out.println(a.x);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        nb.c(list);
        System.out.println(list);

        System.out.println((int) ((float) 7 /3 * 1000));

        InstrumentedHashSet instrumentedHashSet = new InstrumentedHashSet();
        instrumentedHashSet.addAll(List.of("틱,", "탁탁", "펑"));
        System.out.println(instrumentedHashSet.getAddCount());
    }

}

class A {
    int x;

    public void a() {
        System.out.println("A");
    }
}

class B extends A {
    public void a() {
        System.out.println("AA");
    }

    public void b(A a) {
        a = new A();
        a.x = 1;
    }

    public void c(List<Integer> list) {
        list.add(2);
    }

}

class InstrumentedHashSet<E>  extends HashSet<E>{
    private int addCount = 0;

    public InstrumentedHashSet() {

    }

    public InstrumentedHashSet(int initCap, int loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
