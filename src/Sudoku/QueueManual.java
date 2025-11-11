/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sudoku;

/**
 *
 * @author OCTAVIO MARTINEZ
 * @param <T>
 */


public class QueueManual<T> {
    private Node<T> front;
    private Node<T> back;
    private int size;

    public QueueManual() {
        front = back = null;
        size = 0;
    }

    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            front = back = newNode;
        } else {
            back.next = newNode;
            back = newNode;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) throw new EmptyQueueException("La cola está vacía");
        T value = front.value;
        front = front.next;
        if (front == null) back = null;
        size--;
        return value;
    }

    public T front() {
        if (isEmpty()) throw new EmptyQueueException("La cola está vacía");
        return front.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        front = back = null;
        size = 0;
    }

    public boolean contains(T value) {
        Node<T> current = front;
        while (current != null) {
            if (current.value == null) {
                if (value == null) return true;
            } else if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

