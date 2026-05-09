package com.gmail.alexei28.shortcutalgorithms.module2;

/*
    Задание 7: Удалить k-й элемент односвязного списка
    Задача замечена на собеседованиях в ВК.
    Добавьте в класс LinkedList из лекции метод delete_at_index, который удаляет узел по указанному индексу k.

    Гарантируется, что указанный индекс существует в списке.
    Пример:
      Исходный список: 1 → 2 → 3 → 4 → 5
      Вызов: delete_at_index(2) (удалить узел с индексом 2)
      Результат: 1 → 2 → 4 → 5

    Требования:
     - Временная сложность: O(n)
     - Пространственная сложность: O(1)

    Решение:
    1. Временная сложность (Time Complexity)
       Временная сложность этого алгоритма — O(n), где n — количество элементов в списке.
       - Худший случай O(n): Если тебе нужно удалить последний элемент или индекс находится в конце списка,
         циклу while придется пройтись по всем узлам до конца.
       - Средний случай O(n): В среднем индекс будет находиться где-то посередине, что все равно дает линейную зависимость
         от количества элементов.
       - Лучший случай O(1): Если нужно удалить самый первый элемент (deleteIndex == 0), цикл выполнит условие на первой же итерации
         и завершится.
      2. Пространственная сложность (Space Complexity)
         Пространственная сложность — O(1) (константная).
         - Алгоритм in-place (выполняется на месте).
         - Создается только несколько вспомогательных переменных (current и currentIndex), которые занимают фиксированный
           объем памяти независимо от того, насколько велик твой список.
         - Новые узлы или структуры данных (массивы, списки) внутри метода не создаются.
*/
public class Task7 {

    public static void main(String[] args) {
        // Использование
        LinkedList library = new LinkedList();
        library.append("Война и мир");
        library.append("Преступление и наказание");
        library.printList();
    }

    private static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList {
        private Node head;

        public void append(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        public void deleteAtIndex(int deleteIndex) {
            Node current = head;
            int currentIndex = 0;
            while (current.next != null) {
                if (deleteIndex == 0 || (currentIndex == deleteIndex - 1)) {
                    if (deleteIndex == 0) {
                        head = current.next;
                    }
                    current.next = current.next.next;
                    break;
                }
                currentIndex++;
                current = current.next;
            }
        }

        void printList() {
            Node current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }
}

