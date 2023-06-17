public class Queue<T> {
    private Node<T> front; // указатель на начало очереди
    private Node<T> rear; // указатель на конец очереди
    private int size; // текущий размер очереди

    private static class Node<T> {
        private T data; // данные узла
        private Node<T> next; // ссылка на следующий узел

        public Node(T data) {
            this.data = data;
        }
    }

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            front = newNode; // Если очередь пустая, новый узел становится началом и концом очереди
            rear = newNode;
        } else {
            rear.next = newNode; // Связываем новый узел с текущим концом очереди
            rear = newNode; // Обновляем указатель на конец очереди
        }

        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty"); // Если очередь пустая, выбрасываем исключение
        }

        T data = front.data; // Получаем данные из начала очереди
        front = front.next; // Обновляем указатель на начало очереди
        size--;

        if (isEmpty()) {
            rear = null; // Если после удаления элемента очередь стала пустой, обновляем указатель на конец
        }

        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty"); // Если очередь пустая, выбрасываем исключение
        }

        return front.data; // Возвращаем данные из начала очереди
    }
}