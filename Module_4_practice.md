## Упражнения к модулю 4: Стек и очередь

### Модуль 3
- Теория: https://web.shortcut.education/lms/algo/basics/lecture_04/stack_and_queue/
- Практика: https://web.shortcut.education/lms/algo/basics/lecture_04/stack_and_queue_practice/

Упражнения к лекции 4: Стек и очередь


### Базовые задачи
Задачи на основные операции со стеком и очередью: проверка вложенности, обработка последовательности и реализация структур данных.

#### Задание 1: Valid Parentheses [Easy]
Паттерн: Проверка вложенности Пример из лекции: Проверка скобок в строке Задача встречается на собеседованиях в VK, Яндекс

Проверьте, является ли строка со скобками (), [] и {} валидной. Строка валидна, если:

Каждая открывающая скобка имеет соответствующую закрывающую
Скобки правильно вложены

Источник: https://leetcode.com/problems/valid-parentheses/

Примеры:
```
Вход: "()"
Выход: true

Вход: "()[]{}"

Выход: true

Вход: "(]"

Выход: false

Вход: "([)]"

Выход: false

Вход: "{[]}"

Выход: true
```

Требования:

Временная сложность: O(n), где n — длина строки

Пространственная сложность: O(n) в худшем случае


Решение:

Solution: [Task1.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module4/Task1.java)

Tests: [Task1Test.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module4/Task1Test.java)
