package edu.sdsu.cs.datastructures;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

import static java.util.Comparator.naturalOrder;

public class HeapPriQueue<E> implements IPriorityQueue<E> {
    private PriorityQueue<E> storageQueue;
    private Comparator gauge;

    public HeapPriQueue() {
        storageQueue = new PriorityQueue<>();
        gauge = comparator();
    }

    public HeapPriQueue(Comparator gauge) {
        storageQueue = new PriorityQueue<>();
        this.gauge = gauge;
    }

//    wat is going on
    @Override
    @SuppressWarnings("unchecked")
    public Comparator<E> comparator() {
        return (Comparator<E>)Comparator.naturalOrder();
    }

    @Override
    public void enqueue(E item) {
        storageQueue.offer(item);
    }

    @Override
    public E poll() {
        return storageQueue.poll();
    }

    @Override
    public E peek() {
        return storageQueue.peek();
    }

    @Override
    public int size() {
        return storageQueue.size();
    }

    @Override
    public void clear() {
        storageQueue.clear();
    }

    @Override
    public boolean isEmpty() {
        return storageQueue.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return storageQueue.iterator();
    }
}
