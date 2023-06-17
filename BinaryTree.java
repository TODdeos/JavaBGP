public class BinaryTree<T> {
    private Node<T> root;

    private static class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTree() {
        root = null; // Инициализация пустого дерева
    }

    public void insert(T data) {
        root = insertRecursive(root, data); // Вставка элемента в дерево
    }

    private Node<T> insertRecursive(Node<T> currentNode, T data) {
        if (currentNode == null) {
            return new Node<>(data); // Создание нового узла, если достигнут конец или дерево пустое
        }

        if (data < currentNode.data) {
            currentNode.left = insertRecursive(currentNode.left, data); // Рекурсивное вставление элемента в левое поддерево
        } else if (data > currentNode.data) {
            currentNode.right = insertRecursive(currentNode.right, data); // Рекурсивное вставление элемента в правое поддерево
        }

        return currentNode;
    }

    public boolean search(T data) {
        return searchRecursive(root, data); // Поиск элемента в дереве
    }

    private boolean searchRecursive(Node<T> currentNode, T data) {
        if (currentNode == null) {
            return false; // Если достигнут конец дерева, элемент не найден
        }

        if (data == currentNode.data) {
            return true; // Если текущий узел содержит искомый элемент, возвращаем true
        } else if (data < currentNode.data) {
            return searchRecursive(currentNode.left, data); // Рекурсивный поиск элемента в левом поддереве
        } else {
            return searchRecursive(currentNode.right, data); // Рекурсивный поиск элемента в правом поддереве
        }
    }
}