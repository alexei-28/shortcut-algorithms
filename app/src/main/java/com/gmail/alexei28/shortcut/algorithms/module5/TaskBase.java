package com.gmail.alexei28.shortcut.algorithms.module5;

/*
    Only for sorted array.
    Base implementation of binary search:
    1. Iterative
    2. Recursive

    1. Классический бинарный поиск:
        - работает только на отсортированных массивах;
        - сложность O(log n) — на каждом шаге размер поиска уменьшается вдвое;
        - базовый шаблон с left, right, mid и корректное вычисление середины в каждом языке.
    2. Пять основных паттернов:
        - точный поиск — найти индекс элемента или вернуть -1;
        - первое/последнее вхождение — найти крайнее вхождение в массиве с дубликатами;
        - место вставки — найти позицию для вставки элемента с сохранением порядка;
        - бинарный поиск по ответу — искать значение ответа в диапазоне, а не элемент в массиве;
        - повёрнутый массив — поиск в массиве, где одна половина всегда отсортирована.
*/
public class TaskBase {
    /*
        Base implementation (iterative) of binary search.
        Найти индекс элемента в отсортированном массиве или вернуть -1

        Сложность:
        - Временная: O(log n) — на каждом шаге размер поиска уменьшается вдвое
        - Пространственная: O(1) — используем только несколько переменных
    */
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // (left + right) / 2 математически это же самое что и left + (right - left) / 2
            int mid = left + (right - left) / 2;  // Защита от переполнения int

            if (arr[mid] == target) {
                return mid;  // Найдено
            } else if (arr[mid] < target) {
                left = mid + 1;  // Ищем в правой половине
            } else {
                right = mid - 1;  // Ищем в левой половине
            }
        }

        return -1;  // Не найдено
    }

    /*
        Recursive implementation of binary search.
        Найти индекс элемента в отсортированном массиве или вернуть -1
        Отличия от итеративной версии:
        - Пространственная сложность: O(log n) из-за стека вызовов (в итеративной версии O(1))
        - Читаемость: некоторым рекурсивная версия кажется более естественной
        - Практичность: для собеседований предпочтительнее итеративная версия — она эффективнее и проще отлаживать
    */
    public int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;  // Защита от переполнения int
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }
}
