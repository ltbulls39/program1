package edu.sdsu.cs.datastructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class ArrayPriQueue<E extends Comparable<E>> implements IPriorityQueue<E> {
    private ArrayList<E> pq;
    private Comparator gauge;

    public ArrayPriQueue() {
        pq = new ArrayList<>();
        gauge = comparator();
    }

    public ArrayPriQueue(Comparator gauge) {
        pq = new ArrayList<>();
        this.gauge = gauge;
    }


    @Override
    public Comparator<E> comparator() {
        return Comparator.naturalOrder();
    }

    @Override
    public void enqueue(E item) {
        if (isEmpty()) {
            pq.add(item);
            return;
        }
        /**
         * Things to think about:
         *      -What if beginSearch returns a -1?
         */

        int indexToInsert = beginSearch(item);
        if (indexToInsert == -1)
            pq.add(0, item);
        else
            pq.add(indexToInsert, item);
    }

    private int beginSearch(E target) {
        int ret = binarySearch(target, 0, (pq.size() - 1));

        return ret; //FIXME
    }

    private int binarySearch(E target, int left, int right) {
        int mid = left + (right - left) / 2;
        if (right < left)   return mid;

        int result = pq.get(mid).compareTo(target);

        if (result <= 0)    return binarySearch(target, mid + 1, right);
        else                return binarySearch(target, left, mid - 1);

    }

    @Override
    public E poll() {
        if (!isEmpty())
            return pq.remove(0);

        return null;
    }

    @Override
    public E peek() {
        if (!isEmpty())
            return pq.get(0);

        return null;
    }

    @Override
    public int size() {
        return pq.size();
    }

    @Override
    public void clear() {
        pq.clear();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return pq.iterator();
    }

}
