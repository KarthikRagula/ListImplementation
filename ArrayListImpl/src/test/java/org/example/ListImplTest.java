package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.*;

class ListImplTest {
    @Test
    void size() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        assertEquals(2, li.size());
    }

    @Test
    void isEmpty() {
        ListImpl<Integer> li = new ListImpl<>();
        assertTrue(li.isEmpty());
        li.add(1);
        li.add(2);
        assertFalse(li.isEmpty());
    }

    @Test
    void contains() {
        ListImpl<String> li = new ListImpl<>();
        li.add("Karthik");
        li.add("Ragula");
        assertTrue(li.contains("Karthik"));
        assertFalse(li.contains("Ravi"));
    }

    @Test
    void toArray() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(10);
        li.add(20);
        li.add(30);
        Object[] a = {10, 20, 30};
        assertEquals(Arrays.toString(a), Arrays.toString(li.toArray()));
    }

    @Test
    void toArrayByDataType() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(10);
        li.add(20);
        li.add(30);
        Integer[] in = new Integer[4];
        Integer[] in2 = {10, 20, 30, null};
        assertEquals(Arrays.toString(in2), Arrays.toString(li.toArray(in)));
    }

    @Test
    void add() {
        ListImpl<String> li = new ListImpl<>();
        assertTrue(li.add("Karthik"));
    }

    @Test
    void equals() {
        ListImpl<String> li = new ListImpl<>();
        li.add("1");
        li.add("2");
        li.add("3");
        ListImpl<String> li2 = new ListImpl<>();
        li2.add("1");
        li2.add("2");
        li2.add("3");
        assertTrue(li.equals(li));
        assertFalse(li.equals(null));
    }

    @Test
    void remove() {
        ListImpl<String> li = new ListImpl<>();
        li.add("1");
        li.add("2");
        li.add("3");
        li.add("4");
        assertTrue(li.remove("2"));
        assertFalse(li.remove("5"));
    }

    @Test
    void containsAll() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(10);
        li.add(20);
        li.add(30);
        List<Integer> li2 = new ArrayList<>();
        li2.add(20);
        assertTrue(li.containsAll(li2));
        li2.add(40);
        assertFalse(li.containsAll(li2));
    }

    @Test
    void addAll() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(10);
        li.add(20);
        li.add(30);
        List<Integer> li2 = new ArrayList<>();
        assertFalse(li.addAll(li2));
        li2.add(20);
        assertTrue(li.addAll(li2));
    }

    @Test
    void addAllByIndex() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(10);
        li.add(20);
        li.add(30);
        List<Integer> li2 = new ArrayList<>();
        li2.add(1);
        assertFalse(li.addAll(-1, li2));
        assertFalse(li.addAll(4, li2));
        li2.add(20);
        assertTrue(li.addAll(2, li2));
    }

    @Test
    void removeAll() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(10);
        li.add(20);
        li.add(30);
        List<Integer> li2 = new ArrayList<>();
        assertFalse(li.removeAll(li2));
        li2.add(10);
        li2.add(1);
        assertTrue(li.removeAll(li2));
    }

    @Test
    void retainAll() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(10);
        li.add(20);
        li.add(30);
        List<Integer> li2 = new ArrayList<>();
        li2.add(20);
        List<Integer> li3 = new ArrayList<>();
        li3.add(10);
        li3.add(20);
        li3.add(30);
        assertTrue(li.retainAll(li2));
        assertFalse(li.retainAll(li3));
    }

    @Test
    void clear() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        li.add(3);
        li.clear();
        assertEquals(0, li.size());
    }

    @Test
    void get() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        li.add(3);
        assertEquals(2, li.get(1));
        assertNull(li.get(6));
    }

    @Test
    void set() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        li.add(3);
        assertEquals(6, li.set(2, 6));
        assertNull(li.set(10, 3));
    }

    @Test
    void addByIndex() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(1, 2);
        assertEquals(2, li.get(1));
    }

    @Test
    void removeByIndex() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        li.add(3);
        assertNull(li.remove(4));
        assertEquals(2, li.remove(1));
    }

    @Test
    void indexOf() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        li.add(3);
        assertEquals(1, li.indexOf(2));
        assertEquals(-1, li.indexOf(10));
    }

    @Test
    void lastIndexOf() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(2);
        li.add(3);
        assertEquals(3, li.lastIndexOf(2));
        assertEquals(-1, li.indexOf(10));
    }

    @Test
    void iterator() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        Iterator<Integer> iterator = li.iterator();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertTrue(iterator.hasNext());
        iterator.next();
        assertFalse(iterator.hasNext());
        Iterator<Integer> it = li.iterator();
        assertEquals(1, it.next());
        assertEquals(2, it.next());
    }

    @Test
    void listIterator() {
        ListImpl<String> list = new ListImpl<>();
        list.add("A");
        list.add("B");
        list.add("C");

        ListIterator<String> iterator = list.listIterator();

        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());

        assertThrows(NoSuchElementException.class, iterator::next);

        assertTrue(iterator.hasPrevious());
        assertEquals("C", iterator.previous());
        assertTrue(iterator.hasPrevious());
        assertEquals("B", iterator.previous());
        assertTrue(iterator.hasPrevious());
        assertEquals("A", iterator.previous());
        assertFalse(iterator.hasPrevious());

        assertThrows(NoSuchElementException.class, iterator::previous);

        assertEquals(0, iterator.nextIndex());
        assertEquals(-1, iterator.previousIndex());
        iterator.next();
        assertEquals(1, iterator.nextIndex());
        assertEquals(0, iterator.previousIndex());
        iterator.next();
        assertEquals(2, iterator.nextIndex());
        assertEquals(1, iterator.previousIndex());
        iterator.next();
        assertEquals(3, iterator.nextIndex());
        assertEquals(2, iterator.previousIndex());

        assertThrows(UnsupportedOperationException.class, iterator::remove);
        assertThrows(UnsupportedOperationException.class, () -> iterator.add("D"));

        iterator.set("Z");
        assertEquals("Z", list.get(2));
        assertThrows(IllegalStateException.class, () -> {
            ListIterator<String> emptyIterator = new ListImpl<String>().listIterator();
            emptyIterator.set("X");
        });
    }

    @Test
    void listIteratorByIndex() {
        ListImpl<String> list = new ListImpl<>();
        list.add("A");
        list.add("B");
        list.add("C");

        ListIterator<String> iterator = list.listIterator(1);

        assertTrue(iterator.hasNext());
        assertEquals("B", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());

        assertThrows(NoSuchElementException.class, iterator::next);

        assertTrue(iterator.hasPrevious());
        assertEquals("C", iterator.previous());
        assertTrue(iterator.hasPrevious());
        assertEquals("B", iterator.previous());
        assertTrue(iterator.hasPrevious());
        assertEquals("A", iterator.previous());
        assertFalse(iterator.hasPrevious());

        assertThrows(NoSuchElementException.class, iterator::previous);

        assertEquals(0, iterator.nextIndex());
        assertEquals(-1, iterator.previousIndex());
        iterator.next();
        assertEquals(1, iterator.nextIndex());
        assertEquals(0, iterator.previousIndex());
        iterator.next();
        assertEquals(2, iterator.nextIndex());
        assertEquals(1, iterator.previousIndex());
        iterator.next();
        assertEquals(3, iterator.nextIndex());
        assertEquals(2, iterator.previousIndex());

        assertThrows(UnsupportedOperationException.class, iterator::remove);
        assertThrows(UnsupportedOperationException.class, () -> iterator.add("D"));

        iterator.set("Z");
        assertEquals("Z", list.get(2));
        assertThrows(IllegalStateException.class, () -> {
            ListIterator<String> emptyIterator = new ListImpl<String>().listIterator();
            emptyIterator.set("X");
        });
    }

    @Test
    void subList() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(4);
        List<Integer> temp = new ArrayList<>();
        temp.add(3);
        temp.add(4);
        assertEquals(temp, li.subList(2, 4));
    }

    @Test
    void addFirst() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        li.add(3);
        li.addFirst(10);
        assertEquals(10, li.get(0));
    }

    @Test
    void addLast() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        li.add(3);
        li.addLast(10);
        assertEquals(10, li.get(li.size() - 1));
    }

    @Test
    void getFirst() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        li.add(3);
        assertEquals(1, li.getFirst());
    }

    @Test
    void getLast() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        li.add(3);
        assertEquals(3, li.getLast());
    }

    @Test
    void removeFirst() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        li.add(3);
        assertEquals(1, li.removeFirst());
    }

    @Test
    void removeLast() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        li.add(3);
        assertEquals(3, li.removeLast());
    }

    @Test
    void reversed() {
        ListImpl<Integer> li = new ListImpl<>();
        li.add(1);
        li.add(2);
        li.add(3);
        List<Integer> li2 = new ArrayList<>();
        li2.add(3);
        li2.add(2);
        li2.add(1);
        assertEquals(li2, li.reversed());
    }

    @Test
    void hashcode() {
        ListImpl<String> list1 = new ListImpl<>();
        list1.add("A");
        list1.add("B");

        ListImpl<String> list2 = new ListImpl<>();
        list2.add("A");
        list2.add("B");

        ListImpl<String> list3 = new ListImpl<>();
        list3.add("A");
        list3.add("C");

        assertEquals(list1.hashCode(), list2.hashCode());

        assertNotEquals(list1.hashCode(), list3.hashCode());

        ListImpl<String> list4 = new ListImpl<>();
        ListImpl<String> list5 = new ListImpl<>();
        assertEquals(list4.hashCode(), list5.hashCode());

        ListImpl<String> list6 = new ListImpl<>();
        list6.add(null);
        ListImpl<String> list7 = new ListImpl<>();
        list7.add(null);
        assertEquals(list6.hashCode(), list7.hashCode());
    }

    @Test
    void replaceAll() {
        ListImpl<Integer> list = new ListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);

        UnaryOperator<Integer> operator = x -> x * 2;
        list.replaceAll(operator);

        assertEquals(2, list.get(0));
        assertEquals(4, list.get(1));
        assertEquals(6, list.get(2));
    }

    @Test
    void sort() {
        ListImpl<Integer> list = new ListImpl<>();
        list.add(3);
        list.add(2);
        list.add(1);

        ListImpl<Integer> list2 = new ListImpl<>();
        list2.add(1);
        list2.add(2);
        list2.add(3);

        list.sort(null);
        assertTrue(list.equals(list2));

        list.sort(Comparator.reverseOrder());
        list2.clear();
        list2.add(3);
        list2.add(2);
        list2.add(1);
        assertTrue(list.equals(list2));
    }
}