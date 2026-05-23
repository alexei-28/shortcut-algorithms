## Упражнения к модулю 3: HashMap и HashSet

### Модуль 3
- Теория: https://shortcut.education/page120230176.html
- Практика: https://shortcut.education/page121777796.html#!/tab/1958567581-2
  
Упражнения для закрепления материала о HashMap и HashSet

### Уровень 2: HashSet
На этом уровне вы потренируетесь применять HashSet для решения задач на уникальность и принадлежность.

#### Задание 3: Intersection of Two Arrays [Easy]
Паттерн: Детектор повторов (HashSet для отслеживания увиденных элементов)
Пример из лекции: Проверка наличия дубликатов в массиве

Дан два массива, найдите их пересечение (элементы, которые есть в обоих массивах).

Источник: https://leetcode.com/problems/intersection-of-two-arrays/

Пример:
```
Вход: nums1 = [1, 2, 2, 1], nums2 = [2, 2]
Выход: [2]
Вход: nums1 = [4, 9, 5], nums2 = [9, 4, 9, 8, 4]
Выход: [9, 4] (порядок не важен)
```

Требования:
- Временная сложность: O(n + m), где n и m — длины массивов
- Каждый элемент в результате должен быть уникальным

Решение:

Solution: [Task3.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module3/Task3.java)

Tests: [Task3Test.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module3/Task3Test.java)