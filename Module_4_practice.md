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


#### Задание 2: Number of Recent Calls [Easy]
Задача встречается на собеседованиях в Яндекс

У вас есть очередь запросов, которые поступают в разные моменты времени. Для каждого запроса t посчитайте количество запросов в интервале [t - 3000, t].

Источник: https://leetcode.com/problems/number-of-recent-calls/

Пример:
```
ping(1)     → возвращает 1 (запросы: [1])
ping(100)   → возвращает 2 (запросы: [1, 100])
ping(3001)  → возвращает 3 (запросы: [1, 100, 3001])
ping(3002)  → возвращает 3 (запросы: [100, 3001, 3002])
```

Требования:

Временная сложность: O(1) (амортизированная) для каждого ping

Используйте очередь для хранения времён запросов

Подсказка:
Используйте очередь для хранения времён запросов. Для каждого ping добавьте текущее время в очередь и удалите все времена,
которые меньше t - 3000. Длина очереди будет ответом.


Решение:

Solution: [Task2.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module4/Task2.java)

Tests: [Task2Test.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module4/Task2Test.java)




#### Задание 3: Backspace String Compare [Easy]
Пример из лекции: Отмена действий (undo/redo)

Даны две строки, которые содержат символы и символ #, который означает удаление предыдущего символа (backspace).
Проверьте, равны ли эти две строки после применения всех backspace.

Источник: https://leetcode.com/problems/backspace-string-compare/

Примеры:
```
Вход: s = "ab#c", t = "ad#c"
Выход: true (обе становятся "ac")

Вход: s = "ab##", t = "c#d#"
Выход: true (обе становятся "")

Вход: s = "a#c", t = "b"
Выход: false ("c" != "b")
```

Требования:
Временная сложность: O(n + m), где n и m — длины строки

Подсказка:
Используйте стек для обработки каждой строки. При встрече символа # удаляйте верхний элемент стека (если он есть), 
иначе добавляйте символ в стек.

Решение:

Solution: [Task3.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module4/Task3.java)

Tests: [Task3Test.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module4/Task3Test.java)



#### Задание 4: Evaluate Reverse Polish Notation [Medium]

Пример из лекции: Обратная польская запись Задача встречается на собеседованиях в Яндекс

Вычислите значение выражения в обратной польской записи (RPN).

Операции: +, -, *, /

Источник: LeetCode 150

Примеры:

```
Вход: ["2","1","+","3","*"]
Выход: 9 ((2 + 1) * 3)

Вход: ["4","13","5","/","+"]

Выход: 6 (4 + (13 / 5))
```

Требования:

Временная сложность: O(n)
Деление между двумя целыми числами должно усекать в сторону нуля

Решение:

Solution: [Task4.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module4/Task4.java)

Tests: [Task4Test.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module4/Task4Test.java)


#### Задание 5: Implement Queue using Stacks [Easy]

Задача встречается на собеседованиях в Яндекс

Реализуйте очередь, используя только два стека.

Операции:

push(x) — добавить элемент в конец очереди
pop() — удалить элемент из начала очереди
peek() — получить элемент из начала очереди
empty() — проверить, пуста ли очередь

Источник: https://leetcode.com/problems/implement-queue-using-stacks/

Пример:

```
push(1)
push(2)
peek()   → возвращает 1
pop()    → возвращает 1
empty()  → возвращает false
```


Требования:

Временная сложность: O(1) (амортизированная) для всех операций
Используйте только операции стека (push, pop, peek, empty)

Подсказка:

Используйте два стека: один для добавления элементов (input stack), другой для удаления (output stack). 
При pop или peek, если output stack пуст, переместите все элементы из input stack в output stack.

Решение:

Solution: [MyQueue.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module4/MyQueue.java)

Tests: [MyQueueTest.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module4/MyQueueTest.java)


### Задание 6: Implement Stack using Queues [Easy]
Реализуйте стек, используя только одну очередь.

Операции:

push(x) — добавить элемент на вершину стека
pop() — удалить элемент с вершины стека
top() — получить элемент с вершины стека
empty() — проверить, пуст ли стек

Источник https://leetcode.com/problems/implement-stack-using-queues/description/

Пример:

```
push(1)
push(2)
top()    → возвращает 2
pop()    → возвращает 2
empty()  → возвращает false
```

Требования:

Временная сложность зависит от того, какую операцию делать «дорогой». В реализации из подсказки ниже дорогой становится push — O(n), 
а pop, top и empty — O(1). Есть и зеркальная реализация, где, наоборот, дорогой pop — O(n), а push — O(1).
В любом случае одна из операций стоит O(n), а остальные — O(1).
Используйте только операции очереди (push, pop, peek, empty)

Подсказка:

При добавлении элемента в стек, добавьте его в очередь, затем переместите все предыдущие элементы в конец очереди.
Так последний добавленный элемент будет первым при удалении.

Solution: [MyStack.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module4/MyStack.java)

Tests: [MyStackTest.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module4/MyStackTest.java)


### Задание 7: Simplify Path [Medium]
Упростите абсолютный путь файловой системы.

Специальные символы:

. — текущая директория (игнорируем)
.. — родительская директория (удаляем из стека)
/ — разделитель директорий

Источник https://leetcode.com/problems/simplify-path/

Примеры:

```
Вход: "/home/"
Выход: "/home"

Вход: "/../"
Выход: "/"

Вход: "/home//foo/"
Выход: "/home/foo"
```

Требования:

Временная сложность: O(n), где n — длина пути
Результирующий путь должен начинаться с /

Подсказка:

Разбейте путь по разделителю / и используйте стек. 
Добавляйте директории в стек, при встрече .. удаляйте последний элемент из стека (если стек не пустой).

Solution: [Task7.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module4/Task7.java)

Tests: [Task7Test.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module4/Task7Test.java)



### Задание 8: Min Stack [Medium]
Паттерн: Реализация структур данных

Реализуйте стек, который поддерживает операции push, pop, top и получение минимального элемента за O(1).

Источник: https://leetcode.com/problems/min-stack/

Операции:

push(val) — добавить элемент в стек
pop() — удалить элемент с вершины
top() — получить элемент с вершины
getMin() — получить минимальный элемент в стеке

Пример
```
push(-2)
push(0)
push(-3)
getMin()   → возвращает -3
pop()
top()      → возвращает 0
getMin()   → возвращает -2
```

Требования:

Временная сложность: O(1) для всех операций
Пространственная сложность: O(n)

Подсказка:

Используйте два стека: один для хранения всех элементов, другой для хранения минимумов. 
При добавлении элемента также добавляйте текущий минимум во второй стек.

Solution: [MinStack.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module4/MinStack.java)

Tests: [MinStackTest.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module4/MinStackTest.java)