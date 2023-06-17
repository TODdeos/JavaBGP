import java.util.ArrayList;
import java.util.List;

public class MySet<T> {
    private List<T> elements; // Хранение элементов множества в списке

    public MySet() {
        elements = new ArrayList<>(); // Создание пустого списка при инициализации множества
    }

    public void add(T element) {
        if (!contains(element)) {
            elements.add(element); // Добавление элемента в множество, если его нет
        }
    }

    public void remove(T element) {
        elements.remove(element); // Удаление элемента из множества
    }

    public boolean contains(T element) {
        return elements.contains(element); // Проверка наличия элемента в множестве
    }

    public int size() {
        return elements.size(); // Получение размера множества (количество элементов)
    }

    public boolean isEmpty() {
        return elements.isEmpty(); // Проверка, пусто ли множество
    }

    public void clear() {
        elements.clear(); // Очистка множества (удаление всех элементов)
    }
}