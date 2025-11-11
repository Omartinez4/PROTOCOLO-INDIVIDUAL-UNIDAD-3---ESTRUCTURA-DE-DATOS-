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

public class StackManual<T> {
    private Node<T> head;
    private int size;

    public StackManual() {
        head = null;
        size = 0;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException("La pila está vacía");
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException("La pila está vacía");
        return head.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean contains(T value) {
        Node<T> current = head;
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

