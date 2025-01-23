package org.example;

import java.util.Comparator;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class ComparatorImpl<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.hashCode(), o2.hashCode());
    }

    @Override
    public Comparator<T> reversed() {
        return (o1, o2) -> compare(o2, o1);
    }

    @Override
    public Comparator<T> thenComparing(Comparator<? super T> other) {
        return (o1, o2) -> {
            int result = compare(o1, o2);
            if (result != 0) return result;
            return other.compare(o1, o2);
        };
    }

    @Override
    public Comparator<T> thenComparingInt(ToIntFunction<? super T> keyExtractor) {
        return (o1, o2) -> {
            int result = Integer.compare(keyExtractor.applyAsInt(o1), keyExtractor.applyAsInt(o2));
            if (result != 0) return result;
            return compare(o1, o2);
        };
    }

    @Override
    public Comparator<T> thenComparingLong(ToLongFunction<? super T> keyExtractor) {
        return (o1, o2) -> {
            int result = Long.compare(keyExtractor.applyAsLong(o1), keyExtractor.applyAsLong(o2));
            if (result != 0) return result;
            return compare(o1, o2);
        };
    }

    @Override
    public Comparator<T> thenComparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        return (o1, o2) -> {
            int result = Double.compare(keyExtractor.applyAsDouble(o1), keyExtractor.applyAsDouble(o2));
            if (result != 0) return result;
            return compare(o1, o2);
        };
    }
}
