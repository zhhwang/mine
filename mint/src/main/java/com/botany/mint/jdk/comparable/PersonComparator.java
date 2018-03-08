package com.botany.mint.jdk.comparable;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * @author wangzh
 */
public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }

    @Override
    public Comparator<Person> reversed() {
        return Collections.reverseOrder(this);
    }

    @Override
    public Comparator<Person> thenComparing(Comparator<? super Person> other) {
        Objects.requireNonNull(other);
        return (Comparator<Person> & Serializable) (c1, c2) -> {
            int res = compare(c1, c2);
            return (res != 0) ? res : other.compare(c1, c2);
        };
    }

    @Override
    public <U> Comparator<Person> thenComparing(Function<? super Person, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return thenComparing(Comparator.comparing(keyExtractor, keyComparator));
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<Person> thenComparing(Function<? super Person, ? extends U> keyExtractor) {
        return thenComparing(Comparator.comparing(keyExtractor));
    }

    @Override
    public Comparator<Person> thenComparingInt(ToIntFunction<? super Person> keyExtractor) {
        return thenComparing(Comparator.comparingInt(keyExtractor));
    }

    @Override
    public Comparator<Person> thenComparingLong(ToLongFunction<? super Person> keyExtractor) {
        return thenComparing(Comparator.comparingLong(keyExtractor));
    }

    @Override
    public Comparator<Person> thenComparingDouble(ToDoubleFunction<? super Person> keyExtractor) {
        return thenComparing(Comparator.comparingDouble(keyExtractor));
    }
}
