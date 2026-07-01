package com.gmail.alexei28.shortcut.algorithms.module3.slidingwindow;

/*
    Максимальная сумма подмассива фиксированной длины
    Представьте, что у вас есть массив чисел [1, 4, 2, 10, 23, 3, 1, 0, 20]
    и вам нужно найти максимальную сумму любого подмассива длины 4.

    Решение:
    Каждое следующее окно вычисляется за O(1) — мы просто вычитаем выходящий элемент и прибавляем входящий.
    Общая сложность O(n).

    Примечание по сложности:
    Обновление окна здесь занимает O(1) — одна операция вычитания и одна операция сложения.
    Это идеальный случай для паттерна скользящего окна, где мы можем поддерживать агрегированное значение (сумму) без пересчёта.
*/
public class Task1 {

    public int maxSumSubArray(int[] array, int subArrayLength) {
        int max = 0;
        int startIndex = 0;
        int endIndex = startIndex + subArrayLength;
        while (endIndex < array.length) {
            int sum = 0;
            for (int index = startIndex; index < endIndex;  index++) {
                sum = sum + array[index];
            }
            if (sum > max) {
                max = sum;
            }
            startIndex++;
            endIndex = startIndex + subArrayLength;
        }
        return max;
    }
}
