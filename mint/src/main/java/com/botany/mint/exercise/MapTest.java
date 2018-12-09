package com.botany.mint.exercise;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.LongUnaryOperator;

public class MapTest {
    Map map = new HashMap();

    public static enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH};

    public static void applyStyle(Set<Style> styles) {}

    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<>();
        Set<Double> doubles = new HashSet<>();
        //Set<Number> numbers = union(integers, doubles);

        applyStyle(EnumSet.of(Style.BOLD, Style.ITALIC));

        List<String> stringList = new CopyOnWriteArrayList();

        Boolean.valueOf(true);
        BigInteger.valueOf(1); BigInteger.probablePrime(4, new Random());
        ThreadLocal<String> the;

        LongUnaryOperator
    }

    @Override
    public void finalize () {

    }
}
