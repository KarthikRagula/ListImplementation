package org.example;

import java.util.*;

public class ListImplTestWithMethodCalls extends ListImpl {
    public static void main(String args[]) {
        ListImpl<String> list = new ListImpl<>();

        System.out.println("----Added elements at last");
        list.add("Karthik");
        list.add("Praveen");
        list.add("Ravi");
        list.add("Prashanth");
        list.add("Uday");
        list.print();

        list.sort(null);
        list.print();
        list.sort(Comparator.reverseOrder());
        list.print();

        System.out.println("----Added elements by index");
        list.add(0, "Krishna");
        list.add(2, "Roopa");
        list.print();

        System.out.println("----Remove elements by index");
        list.remove(0);
        list.print();

        System.out.println("----Removed elements by Element");
        list.remove("Roopa");
        list.print();

        System.out.println("----Size of the list");
        System.out.println(list.size());
        System.out.println();

        System.out.println("----index of the element");
        list.print();
        System.out.println("Index of Karthik -> " + list.indexOf("Karthik"));
        System.out.println("Index of Uday -> " + list.indexOf("Uday"));
        System.out.println();

        System.out.println("----last index of the element");
        list.add("Karthik");
        list.add("Uday");
        list.print();
        System.out.println("Index of Karthik -> " + list.lastIndexOf("Karthik"));
        System.out.println("Index of Uday -> " + list.lastIndexOf("Uday"));
        System.out.println();

        System.out.println("----list contains the element or not");
        System.out.println(list.contains("Karthik"));
        System.out.println(list.contains("Abhi"));
        System.out.println();

        System.out.println("----isEmpty or not");
        System.out.println(list.isEmpty());
        System.out.println();

        System.out.println("----get the element by index");
        list.print();
        System.out.println("At 2 " + list.get(2));
        System.out.println("At 4 " + list.get(4));

        System.out.println("----updating the element value using set");
        System.out.print("Before");
        list.print();
        list.set(0, "Praveen");
        list.set(2, "Karthik");
        System.out.print("After");
        list.print();

        System.out.println("----to array");
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("----to array using data type");
        String[] a = new String[5];
        System.out.println(Arrays.toString(list.toArray(a)));

        System.out.println("----sublist");
        System.out.println("3 to 5 " + list.subList(3, 5));

        System.out.println("----contains all");
        list.print();
        List<String> list1 = new ArrayList<>();
        list1.add("Karthik");
        System.out.println(list.containsAll(list1));

        System.out.println("----removeAll");
        list.print();
        System.out.println(list.removeAll(list1));
        list.print();

        System.out.println("----retain all");
        list1.add("Praveen");
        System.out.println(list.retainAll(list1));
        list.print();

        System.out.println("----addAll");
        list1.add("Ravi");
        list1.add("Prashanth");
        list1.add("Uday");
        list.addAll(list1);
        list.print();

        System.out.println("----addAll at index");
        list.print();
        list.addAll(3, list1);
        list.print();

        System.out.println("----iterator");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("----list iterator");

        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println("Next: " + listIterator.next());
        }
        while (listIterator.hasPrevious()) {
            System.out.println("Previous: " + listIterator.previous());
        }

        System.out.println("----listiterator using index");
        ListImpl<String> customArray = new ListImpl<>();
        customArray.add("A");
        customArray.add("B");
        customArray.add("C");
        ListIterator<String> listIt = customArray.listIterator(1);
        while (listIt.hasNext()) {
            System.out.println("Next: " + listIt.next());
        }
        while (listIt.hasPrevious()) {
            System.out.println("Previous: " + listIt.previous());
        }
        System.out.println("----clear");
        list.clear();
        list.print();
    }
}
