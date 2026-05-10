package com.gmail.alexei28.shortcut.algorithms.module2;

/*
    Задание 8: Поиск по значению в связном списке
    Добавьте в класс LinkedList из лекции метод find_index, который ищет узел с указанным значением и возвращает его индекс.
    Если значение не найдено, верните -1.
    Пример:
        Список: 1 → 2 → 3 → 4 → 5
        Вызов: find_index(3)
        Выход: 2 (индекс узла со значением 3)

        Список: 1 → 2 → 3 → 4 → 5
        Вызов: find_index(6)
        Выход: -1 (значение не найдено)

    Требования:
    - Временная сложность: O(n)
    - Пространственная сложность: O(1)

    Решение:
    1. Временная сложность (Time Complexity)
       Временная сложность оценивает, как время выполнения программы растет в зависимости
       от размера входных данных n — количество узлов в списке).
       - Лучший случай (Best Case): O(1)
         Если искомый элемент находится в самом первом узле (head), цикл выполнится всего один раз.
       - Худший случай (Worst Case): O(n)
         Если элемента нет в списке или он находится в самом конце, алгоритму придется проверить каждый из n узлов.
       - Средний случай (Average Case): O(n)
         В среднем нам придется пройти через половину списка (n/2 операций), что в нотации "О-большое"
         сокращается до линейной зависимости.
       - Итог: Временная сложность составляет O(n).
      2. Пространственная сложность (Space Complexity)
         Пространственная сложность оценивает количество дополнительной памяти, которую потребляет алгоритм.
         - В данном методе мы создаем только две переменные: current (ссылка на узел) и currentIndex (целое число).
         - Количество выделяемой памяти не зависит от того, насколько велик связный список.
           Мы не создаем копии списка, не используем рекурсию (которая заполняла бы стек вызовов) и не инициализируем массивы.
         - Итог: Пространственная сложность составляет O(1) (константная память).

 */
public class Task8 {
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

        public int findIndex(String value) {
            Node current = head;
            int currentIndex = 0;
            while (current != null) {
                if (current.data.equals(value)) {
                    return currentIndex;
                }
                currentIndex++;
                current = current.next;
            }
            return -1;
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
