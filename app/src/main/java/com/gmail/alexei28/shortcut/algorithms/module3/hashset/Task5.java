package com.gmail.alexei28.shortcut.algorithms.module3.hashset;

import java.util.HashSet;

/*
    Задание 5: Jewels and Stones [Easy]
    Паттерн: Проверка принадлежности (HashSet для хранения драгоценностей)
    Пример из лекции: Проверка наличия дубликатов
    Задача встречается на собеседованиях в Яндекс

    Даны строки: jewels — с типами драгоценных камней, и stone — с камнями, которые у вас есть.
    Узнайте, сколько из имеющихся у вас камней драгоценные.
    Constraints:
     - 1 <= jewels.length, stones.length <= 50
     - jewels and stones consist of only English letters.
     - All the characters of jewels are unique.

    Источник: https://leetcode.com/problems/jewels-and-stones/description/

    Примеры:
    Вход: jewels = "aA", stones = "aAAbbbb"
    Выход: 3

    Вход: jewels = "z", stones = "ZZ"
    Выход: 0

    Требования:
    - Временная сложность: O(m + n), где m — длина jewels, n — длина stones
    - Пространственная сложность: O(1) (алфавит фиксированного размера)

    Решение:
    - Временная сложность (Time Complexity): O(J + S)
      Где J — длина строки jewels, а S — длина строки stones.
      - Первый цикл (заполнение HashSet): Проходит по всей строке jewels.
        Добавление элемента в HashSet в среднем занимает O(1). Итого: O(J).
      - Второй цикл (подсчет драгоценностей): Проходит по всей строке stones.
        Поиск элемента в HashSet через метод contains() в среднем занимает O(1). Итого: O(S).
      Так как эти операции выполняются последовательно, их сложности складываются: O(J) + O(S) = O(J + S).
      Это линейное время, что является самым оптимальным решением.

     - Пространственная сложность (Space Complexity): O(1) или O(J)
       Здесь есть важный нюанс, зависящий от контекста.
       1. Строгий теоретический взгляд: O(J)
          Мы выделяем память под HashSet, в который сохраняем уникальные символы из строки jewels.
          В худшем случае, если все символы в jewels уникальны, размер коллекции будет равен J.
       2. Практический взгляд с учетом ограничений задачи: O(1).
          Набор ограничен английским алфавитом (регистрозависимым).
          Максимальное количество уникальных элементов в HashSet никогда не превысит 52, независимо от того,
          насколько длинными будут строки jewels или stones (даже если в jewels будет 10,000 символов, уникальных из них будет максимум 52).
          Поскольку 52 — это фиксированное число (константа), затраты памяти не растут вместе с ростом входных данных.
          Поэтому на практике такая сложность считается константной — O(1).
*/
public class Task5 {

    public int numJewelsInStones(String jewels, String stones) {
        // Только из букв английского алфавита (строчных и прописных). Всего существует максимум 26 + 26 = 52 таких уникальных символа.
        HashSet<Character> set = HashSet.newHashSet(52);
        for (int index = 0; index < jewels.length();index++) {
            char current = jewels.charAt(index);
            set.add(current);
        }

        int result = 0;
        for (int index = 0; index < stones.length(); index++) {
            char current = stones.charAt(index);
            if  (set.contains(current)) {
                result++;
            }
        }
        return result;
    }
}
