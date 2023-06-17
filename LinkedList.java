public class LinkedList<T> {
    private Node<T> head; // Головной узел списка
    private int size; // Размер списка

    private static class Node<T> {
        private T data; // Данные узла
        private Node<T> next; // Ссылка на следующий узел

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null; // Инициализация пустого списка
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0; // Проверка, пуст ли список
    }

    public int size() {
        return size; // Получение размера списка
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (isEmpty()) {
            head = newNode; // Если список пуст, новый узел становится головным
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // Добавление нового узла в конец списка
        }

        size++;
    }

    public void remove(T data) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        if (head.data.equals(data)) {
            head = head.next; // Удаление головного узла, если он содержит искомые данные
            size--;
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;

        while (current != null && !current.data.equals(data)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            throw new IllegalArgumentException("Element not found in the list");
        }

        previous.next = current.next; // Удаление узла из середины или конца списка
        size--;
    }

    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true; // Проверка, содержится ли указанный элемент в списке
            }
            current = current.next;
        }
        return false;
    }
}