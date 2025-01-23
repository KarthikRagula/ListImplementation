package org.example;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ComparatorImplTest {

    @Test
    void compare() {
        ComparatorImpl<Integer> comparator = new ComparatorImpl<>();
        Integer i1 = 25;
        Integer i2 = 30;
        Integer i3 = 25;
        assertTrue(comparator.compare(i1, i2) < 0);
        assertTrue(comparator.compare(i2, i1) > 0);
        assertEquals(0, comparator.compare(i1, i3));
    }

    @Test
    void reversed() {
        ComparatorImpl<Integer> comparator = new ComparatorImpl<>();
        Integer i1 = 25;
        Integer i2 = 30;
        assertTrue(comparator.reversed().compare(i1, i2) > 0);
        assertTrue(comparator.reversed().compare(i2, i1) < 0);
    }

    @Test
    void thenComparing() {
        ComparatorImpl<Integer> comparator = new ComparatorImpl<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
        Integer i1 = 25;
        Integer i2 = 30;
        Integer i3 = 25;
        Comparator<Integer> chainedComparator = comparator.thenComparing(a -> a % 10);
        assertEquals(0, chainedComparator.compare(i1, i3));
        assertTrue(chainedComparator.compare(i1, i2) > 0);
        assertTrue(chainedComparator.compare(i2, i3) < 0);
    }

    @Test
    void thenComparingInt() {
        ComparatorImpl<Integer> comparator = new ComparatorImpl<>();
        Integer i1 = 25;
        Integer i2 = 30;
        Integer i3 = 25;
        Comparator<Integer> lengthComparator = comparator.thenComparingInt(i -> i + 5);
        assertTrue(lengthComparator.compare(i1, i2) < 0);
        assertTrue(lengthComparator.compare(i3, i2) < 0);
        assertEquals(0, lengthComparator.compare(i1, i3));
    }

    @Test
    void thenComparingLong() {
        ComparatorImpl<Long> comparator = new ComparatorImpl<>() {
            @Override
            public int compare(Long o1, Long o2) {
                return 0;
            }
        };
        Long i1 = 25L;
        Long i2 = 30L;
        Comparator<Long> lengthComparator = comparator.thenComparingLong(i -> i % 10L);
        assertTrue(lengthComparator.compare(i1, i2) > 0);
        assertTrue(lengthComparator.compare(i2, i1) < 0);
        assertEquals(0, lengthComparator.compare(25L, 35L));
    }

    @Test
    void thenComparingDouble() {
        ComparatorImpl<Double> comparator = new ComparatorImpl<>() {
            public int compare(Double o1, Double o2) {
                return 0;
            }
        };
        Double i1 = 25.00;
        Double i2 = 30.00;
        Comparator<Double> lengthComparator = comparator.thenComparingDouble(i -> i % 10.0);
        assertTrue(lengthComparator.compare(i1, i2) > 0);
        assertTrue(lengthComparator.compare(i2, i1) < 0);
        assertEquals(0, lengthComparator.compare(25.00, 35.00));
    }
}
