package org.example;

import java.util.*;
import java.util.function.UnaryOperator;

public class ListImpl<T> implements List<T> {
    int size = 0;
    T arr[];

    ListImpl() {
        arr = (T[]) new Object[10];
    }

    void resize() {
        T[] arr1 = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
        arr = arr1;
    }

    
    void print() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < size - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[size - 1] + "]");
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                return arr[currentIndex++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] a = (T[]) new Object[size];
        System.arraycopy(arr, 0, a, 0, size);
        return a;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) {
            a = (T1[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        System.arraycopy(arr, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        if (size == arr.length) {
            resize();
        }
        arr[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains((T) o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (T o : c) {
            if (arr.length == size) {
                resize();
            }
            arr[size++] = o;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size || c.isEmpty()) {
            return false;
        }
        for (T o : c) {
            if (size == arr.length) {
                resize();
            }
            add(index++, o);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (c.contains(arr[i])) {
                remove(i);
                i--;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (int i = 0; i < size; ) {
            if (!c.contains(arr[i])) {
                remove(i);
                modified = true;
            } else {
                i++;
            }
        }
        return modified;
    }

    @Override
    public void clear() {
        size = 0;
        arr = (T[]) new Object[10];
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return arr[index];
    }

    @Override
    public T set(int index, T element) {
        if (index >= size) {
            return null;
        }
        arr[index] = element;
        return arr[index];
    }

    @Override
    public void add(int index, T element) {
        if (index > size) {
            System.out.println("Pos cannot be greater than the size of the list");
            return;
        }
        size++;
        if (size == arr.length) {
            resize();
        }
        T temp = arr[index];
        arr[index] = element;
        for (int i = index + 1; i < size; i++) {
            T cur = arr[i];
            arr[i] = temp;
            temp = cur;
        }
    }

    @Override
    public T remove(int index) {
        if (index >= size) {
            return null;
        }
        T temp = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return temp;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int ind = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == o) {
                ind = i;
            }
        }
        return ind;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        ListImpl<T> other = (ListImpl<T>) obj;
        if (this.size != other.size) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (!this.get(i).equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        for (int i = 0; i < size; i++) {
            hash = 31 * hash + (arr[i] == null ? 0 : arr[i].hashCode());
        }
        return hash;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new ListIterator<T>() {
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException("No more elements to iterate over");
                }
                return arr[currentIndex++];
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            @Override
            public T previous() {
                if (!hasPrevious()) {
                    throw new java.util.NoSuchElementException("No previous element");
                }
                return arr[--currentIndex];
            }

            @Override
            public int nextIndex() {
                if (hasNext()) {
                    return currentIndex;
                }
                return size;
            }

            @Override
            public int previousIndex() {
                if (hasPrevious()) {
                    return currentIndex - 1;
                }
                return -1;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove operation is not supported");
            }

            @Override
            public void set(T t) {
                if (currentIndex == 0 || currentIndex > size) {
                    throw new IllegalStateException("No current element to set");
                }
                arr[currentIndex - 1] = t;
            }

            @Override
            public void add(T t) {
                throw new UnsupportedOperationException("Add operation is not supported");
            }
        };
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return new ListIterator<T>() {
            int currentIndex = index;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException("No more elements to iterate over");
                }
                return arr[currentIndex++];
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            @Override
            public T previous() {
                if (!hasPrevious()) {
                    throw new java.util.NoSuchElementException("No previous element");
                }
                return arr[--currentIndex];
            }

            @Override
            public int nextIndex() {
                if (hasNext()) {
                    return currentIndex;
                }
                return size;
            }

            @Override
            public int previousIndex() {
                if (hasPrevious()) {
                    return currentIndex - 1;
                }
                return -1;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove operation is not supported");
            }

            @Override
            public void set(T t) {
                if (currentIndex == 0 || currentIndex > size) {
                    throw new IllegalStateException("No current element to set");
                }
                arr[currentIndex - 1] = t;
            }

            @Override
            public void add(T t) {
                throw new UnsupportedOperationException("Add operation is not supported");
            }
        };
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> temp = new ArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            temp.add(arr[i]);
        }
        return temp;
    }

    @Override
    public void addFirst(T t) {
        add(0, t);
    }

    @Override
    public void addLast(T t) {
        add(size, t);
    }

    @Override
    public T getFirst() {
        return arr[0];
    }

    @Override
    public T getLast() {
        return arr[size - 1];
    }

    @Override
    public T removeFirst() {
        return remove(0);
    }

    @Override
    public T removeLast() {
        return remove(size - 1);
    }

    @Override
    public List<T> reversed() {
        List<T> l = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            l.add(0, arr[i]);
        }
        return l;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        for (int i = 0; i < size; i++) {
            arr[i] = operator.apply(arr[i]);
        }
    }

    public static void main(String[] args) {
        ListImpl<String> list = new ListImpl<>();

        System.out.println("----Added elements at last");
        list.add("Karthik");
        list.add("Praveen");
        list.add("Ravi");
        list.add("Prashanth");
        list.add("Uday");
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