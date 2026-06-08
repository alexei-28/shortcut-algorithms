package com.gmail.alexei28.shortcut.algorithms.module3.hashmap;

/*
    Задание 12: Insert Delete GetRandom O(1) [Medium]
    Источник: https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

    Реализуйте структуру данных, которая поддерживает следующие операции за O(1) среднее время:
    - insert (val): вставить значение в структуру (если его ещё нет)
    - remove (val): удалить значение из структуры (если оно есть)
    - getRandom(): вернуть случайное значение из структуры (все значения равновероятны)

    Пример:
    insert(1)
    insert(2)
    insert(3)
    getRandom() → возвращает 1, 2 или 3 с равной вероятностью
    remove(2)
    getRandom() → возвращает 1 или 3 с равной вероятностью (2 уже удалён)

    Требования:
    - Временная сложность: O(1) для всех операций в среднем
    - Допускаются дубликаты при вставке

  Подсказка:
  Используйте комбинацию HashMap для хранения индексов и массива/списка для хранения значений.
  HashMap позволит проверять наличие и получать индекс за O (1), а массив обеспечит случайный доступ по индексу.

  Решение:
  1. Временная сложность (Time Complexity)
    Почти все операции здесь спроектированы так, чтобы работать за амортизированное O(1)

  2.Пространственная сложность (Space Complexity)
    Общая сложность: O(N).
*/

import java.util.*;

/**
 * Your Task12 object will be instantiated and called as such:
 * Task12 obj = new Task12();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
import java.util.*;

class Task12 {

    private List<Integer> nums;
    private Map<Integer, Set<Integer>> idxMap;
    private Random rand;

    /** Initialize your data structure here. */
    public Task12() {
        nums = new ArrayList<>();
        idxMap = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean notExists = !idxMap.containsKey(val);

        // If it doesn't exist, initialize the set of indices
        if (notExists) {
            idxMap.put(val, new LinkedHashSet<>());
        }

        // Add the current size of nums (which will be the new index) to the map
        idxMap.get(val).add(nums.size());
        // Append the value to the end of the arraylist
        nums.add(val);

        return notExists;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idxMap.containsKey(val) || idxMap.get(val).isEmpty()) {
            return false;
        }

        // 1. Get any index where 'val' is stored
        int removeIdx = idxMap.get(val).iterator().next();

        // Remove this index from val's set of indices
        idxMap.get(val).remove(removeIdx);

        // 2. Look at the last element in the arraylist
        int lastIdx = nums.size() - 1;
        int lastVal = nums.get(lastIdx);

        // 3. Swap the element to remove with the last element (if it's not already the last element)
        if (removeIdx < lastIdx) {
            // Overwrite the element at removeIdx with lastVal
            nums.set(removeIdx, lastVal);

            // Update the index map for lastVal: remove its old index (lastIdx), add its new index (removeIdx)
            idxMap.get(lastVal).remove(lastIdx);
            idxMap.get(lastVal).add(removeIdx);
        }

        // 4. Safely remove the last element from the arraylist
        nums.remove(lastIdx);

        // Clean up the map entry if the set becomes empty to save space / keep state accurate
        if (idxMap.get(val).isEmpty()) {
            idxMap.remove(val);
        }

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        // Uniformly picking a random index ensures the probability is proportional to frequency
        return nums.get(rand.nextInt(nums.size()));
    }
}
