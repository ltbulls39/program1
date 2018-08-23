package edu.sdsu.cs.datastructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class UnorderedPriQueue<E extends Comparable<E>> implements IPriorityQueue<E> {
    public ArrayList<E> pq;
    Comparator gauge;

    public UnorderedPriQueue() {
        pq = new ArrayList<>();
        this.gauge = comparator();
    }

    public UnorderedPriQueue(Comparator gauge) {
        pq = new ArrayList<>();
        this.gauge = gauge;
    }


    @Override
    public Comparator comparator() {
        return Comparator.naturalOrder();
    }

    @Override
    public void enqueue(E item) {
        pq.add(item);
    }

    @Override
    public E poll() {
        if (isEmpty()) return null;
        return pq.remove(getPriorityIndex());
    }


    @Override
    public E peek() {
        if (isEmpty()) return null;
        return pq.get(getPriorityIndex());
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
        return pq.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return pq.iterator();
    }

    private int getPriorityIndex() {
        if (size() == 1) return 0;

        int priorityIndex = 0;
        E highestPriority = pq.get(priorityIndex);

        for (int i = 1; i < pq.size(); i++) {
            if (highestPriority.compareTo(pq.get(i)) < 0) {
                highestPriority = pq.get(i);
                priorityIndex = i;
            }
        }

        return priorityIndex;
    }

}
