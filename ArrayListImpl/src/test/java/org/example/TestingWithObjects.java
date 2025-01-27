package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class TestingWithObjects {

    Student st1;
    Student st2;
    Student st3;
    Student st4;
    Student st5;
    Department d1;
    Department d2;
    Department d3;
    Department d4;

    @BeforeEach
    public void setUp() {
        st1 = new Student("Karthik", 20);
        st2 = new Student("Prashanth", 25);
        st3 = new Student("Ravi", 30);
        st4 = new Student("Ravi", 30);
        st5 = new Student("Ravi", 30);

        d1 = new Department(1, "Backend");
        d2 = new Department(2, "Frontend");
        d3 = new Department(3, "Service");
        d4 = new Department(3, "Service");
    }

    @Test
    void testByOverridingEqualsAndHashCode() {
        ListImpl<Student> li = new ListImpl<>();
        li.add(st1);
        li.add(st2);
        li.add(st3);
        li.add(st5);

        assertTrue(li.contains(st4));
        assertTrue(li.get(2).equals(st4));
        assertEquals(li.get(2).hashCode(), st4.hashCode());
    }

    @Test
    void testWithOutOverridingEqualsAndHashCode() {
        ListImpl<Department> li = new ListImpl<>();


        li.add(d1);
        li.add(d2);
        li.add(d3);

        assertFalse(li.contains(d4));
        assertFalse(d3.equals(d4));
        assertNotEquals(d3.hashCode(), d4.hashCode());
    }

    @Test
    void testWithHashSetWithOverriding() {
        HashSet<Student> hash = new HashSet<>();
        hash.add(st3);
        hash.add(st4);
        assertEquals(1, hash.size());
        System.out.println(hash);
    }

    @Test
    void testWithHashSetWithOutOverriding() {
        HashSet<Department> hash = new HashSet<>();
        hash.add(d4);
        hash.add(d3);
        System.out.println(hash);
        assertEquals(2, hash.size());
    }

    @Test
    void testWithHashMapWithOverriding() {
        HashMap<Student, String> map = new HashMap<>();
        map.put(st1, "CSE");
        map.put(st3, "ECE");
        System.out.println(map);
        assertTrue(map.containsKey(st4));
        map.put(st5, "IT");
        System.out.println(map);
    }

    @Test
    void testWithHashMapWithOutOverriding() {
        HashMap<Department, Integer> map = new HashMap<>();
        map.put(d1, 5);
        map.put(d3, 10);
        System.out.println(map);
        assertFalse(map.containsKey(d4));
        map.put(d4, 100);
        System.out.println(map);
    }
}
