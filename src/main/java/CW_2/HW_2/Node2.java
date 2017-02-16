package CW_2.HW_2;

import java.util.function.Consumer;

public class Node2<T> {
    private final T value;
    private final Node2<T> next;

    public Node2(T value, Node2<T> next) {
        this.value = value;
        this.next = next;
    }

    public void accept(Consumer<T> consumer) {
        consumer.accept(value);
        if (next != null) {
            next.accept(consumer);
        }
    }

    public static <T> Node2<T> reverseIteratively(Node2<T> node) {
        Node2<T> current = node;
        Node2<T> head = null;
        while(current != null) {
            head = new Node2<T>(current.value, head);
            current = current.next;
        }
        return head;
    }

    public static <T> Node2<T> reverseRecursively(Node2<T> node) {
        return reverseRecursivelyImpl(null, node);
    }

    private static <T> Node2<T> reverseRecursivelyImpl(Node2<T> head, Node2<T> node) {
        if (node == null) {
            return head;
        }
        return reverseRecursivelyImpl(new Node2<>(node.value, head), node.next);
    }

}