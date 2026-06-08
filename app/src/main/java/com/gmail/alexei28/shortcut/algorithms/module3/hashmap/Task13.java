package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

/*
Задание 13: LRUCache [Medium]

Источник: https://leetcode.com/problems/lru-cache/description/
Задача встречается на собеседованиях в Яндекс

Реализуйте структуру данных LRUCache (Least Recently Used) с ограничением на количество элементов.

Операции:
- get (key): получить значение по ключу (если есть, иначе -1)
- put (key, value): вставить или обновить значение. Если количество элементов превышает лимит,
  удалить наименее недавно использованный элемент

Пример:
cache = LRUCache(2)  // ёмкость 2

put(1, 1)      // cache = {1:1}
put(2, 2)      // cache = {1:1, 2:2}
get(1)         // возвращает 1, cache = {1:1, 2:2} (1 теперь используется недавно)
put(3, 3)      // удаляет ключ 2 (LRU), cache = {1:1, 3:3}
get(2)         // возвращает -1 (ключ 2 был удалён)

Требования:
- Временная сложность: O(1) для обеих операций
- Порядок важен: нужно отслеживать, какой элемент использовался давно

Подсказка
Используйте HashMap для быстрого доступа к узлам и двусвязный список (doubly linked list) для поддержания порядка использования.
При обращении к элементу перемещайте его в начало списка. При превышении лимита удаляйте последний элемент списка.

Решение:
1. Временная сложность (Time Complexity)
   Все шаги выполняются за фиксированное число шагов. Временная сложность: O(1) в среднем.
2. Пространственная сложность (Space Complexity)
   Пространственная сложность определяется количеством памяти, необходимым для хранения данных при максимальном заполнении кэша.
   Сложность: O(N), где N — емкость кэша (capacity)
*/

import java.util.HashMap;
import java.util.Map;

public class Task13 {

    // Definition of the Doubly Linked List Node
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public Task13(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Initialize dummy head and tail to completely avoid null checks
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        // Move the accessed node to the front (Most Recently Used)
        remove(node);
        insertToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value; // Update value
            remove(node);
            insertToHead(node);
        } else {
            // If at capacity, evict the least recently used element (at the tail)
            if (map.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

            // Create and insert the new node
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insertToHead(newNode);
        }
    }

    // Helper method: Remove a node from its current position in the DLL
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper method: Insert a node right after the dummy head (MRU position)
    private void insertToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}