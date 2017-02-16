package CW_2.HW_2;

import java.util.function.Consumer;

public class Node<T> {
    private Node<T> next;
    private T elem;

    public Node(T elem, Node<T> next) {
        this.next = next;
        this.elem = elem;
    }

    public void reverseNode(Consumer<T> consumer) {
        consumer.accept(elem);
        if (next != null) {
            next.reverseNode(consumer);
        }
    }

    public static void main(String[] args) {
        Node<Integer> head = null;
        head = new Node(1, head);
        head = new Node(2, head);
        head = new Node(3, head);
        head = new Node(4, head);
        head = new Node(5, head);

        head.reverseNode(System.out::println);

    }
}
