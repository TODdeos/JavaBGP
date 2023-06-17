public class Stack<T> {
    private Node<T> top; // Вершина стека

    // Внутренний класс для узла стека
    private static class Node<T> {
        private T data; // Данные узла
        private Node<T> next; // Ссылка на следующий узел

        public Node(T data) {
            this.data = data;
        }
    }

    // Добавление элемента в стек
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
    }

    // Удаление элемента из стека
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    // Получение элемента на вершине стека без его удаления
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return top.data;
    }

    // Проверка, пуст ли стек
    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Верхний элемент стека: " + stack.peek());

        int poppedElement = stack.pop();
        System.out.println("Удаленный элемент: " + poppedElement);

        System.out.println("Стек пустой? " + stack.isEmpty());
    }
}

