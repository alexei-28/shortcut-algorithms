package com.gmail.alexei28.shortcut.algorithms.module3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*
    Задание 3: Intersection of Two Arrays [Easy]
    Паттерн: Детектор повторов (HashSet для отслеживания увиденных элементов)
    Пример из лекции: Проверка наличия дубликатов в массиве
    Дан два массива, найдите их пересечение (элементы, которые есть в обоих массивах).
    Источник: https://leetcode.com/problems/intersection-of-two-arrays/

    Пример:
    Вход: nums1 = [1, 2, 2, 1], nums2 = [2, 2]
    Выход: [2]

    Вход: nums1 = [4, 9, 5], nums2 = [9, 4, 9, 8, 4]
    Выход: [9, 4] (порядок не важен)

    Требования:
    - Временная сложность: O(n + m), где n и m — длины массивов
    - Каждый элемент в результате должен быть уникальным

    Решение:
    Временная сложность (Time Complexity): O(N + M)
    Алгоритм состоит из трех последовательных циклов:
    1. Первый цикл (nums1): Проходит по всем элементам nums1 и добавляет их в hashSet. Добавление в HashSet в среднем занимает $O(1)$.
       Итого: $O(N)$.
    2. Второй цикл (nums2): Проходит по всем элементам nums2 и проверяет их наличие в hashSet. Поиск и добавление в resultHashSet
      занимают в среднем $O(1)$. Итого: $O(M)$.
    3.Третий цикл (конвертация): Переносит элементы из resultHashSet в финальный массив. В худшем случае (если массивы одинаковые)
      размер хэш-сета равен min(N, M).
      Итого: O((N, M)).Суммируем: O(N) + O(M) + O(min(N, M)), что в нотации «О-большое» упрощается до O(N + M).

    Пространственная сложность (Space Complexity): O(N + M).
    Дополнительная память расходуется на две структуры данных:
    1. hashSet: В худшем случае, если все элементы в nums1 уникальны, он займет O(N) памяти.
    2. resultHashSet: В худшем случае (если все элементы обоих массивов пересекаются и уникальны) он займет O(min(N, M)) памяти.

    Суммарная дополнительная память: O(N + min(N, M)), что эквивалентно O(N).
    Важное уточнение: Если под пространственной сложностью подразумевать всю выделяемую память, включая возвращаемый массив result,
    то на него уйдет еще до O(min(N, M)) памяти. В таком случае общая оценка записывается как O(N + M) (или O(N), если считать
    только вспомогательные структуры без учета выходного массива).
*/
public class Task3 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> resultHashSet = new HashSet<>();
        for (int i : nums1) {
            hashSet.add(i);
        }

        for (int item : nums2) {
            if (hashSet.contains(item)) {
                resultHashSet.add(item);
            }
        }
        int index = 0;
        int[] result = new int[resultHashSet.size()];
        for (Integer integer : resultHashSet) {
            result[index] = integer;
            index++;
        }
        return result;
    }
}
