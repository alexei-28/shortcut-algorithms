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


#### Задание 4: Find All Disappeared Numbers in an Array [Easy]
Паттерн: Удаление дубликатов (HashSet для работы с уникальными элементами)
Пример из лекции: Убрать дубликаты из массива, оставить только уникальные

Дан массив из n чисел, где каждое число от 1 до n. Найдите все числа, которых нет в массиве.

Источник: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Пример:
```
Вход: [4, 3, 2, 7, 8, 2, 3, 1]
Выход: [5, 6] (числа от 1 до 8, отсутствуют 5 и 6)
```

Требования:
- Временная сложность: O(n)
- Массив может содержать дубликаты

Решение:

Solution: [Task4.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module3/Task4.java)

Tests: [Task4Test.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module3/Task4Test.java)

#### Задание 5: Jewels and Stones [Easy]
Паттерн: Проверка принадлежности (HashSet для хранения драгоценностей)
Пример из лекции: Проверка наличия дубликатов
Задача встречается на собеседованиях в Яндекс

Даны строки: jewels — с типами драгоценных камней, и stone — с камнями, которые у вас есть. 
Узнайте, сколько из имеющихся у вас камней драгоценные.

Источник: https://leetcode.com/problems/jewels-and-stones/description/

Примеры:
```
Вход: jewels = "aA", stones = "aAAbbbb"
Выход: 3
Вход: jewels = "z", stones = "ZZ"
Выход: 0
```

Требования:
- Временная сложность: O(m + n), где m — длина jewels, n — длина stones
- Пространственная сложность: O(1) (алфавит фиксированного размера)


Решение:

Solution: [Task5.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module3/Task5.java)

Tests: [Task5Test.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module3/Task5Test.java)


### Уровень 3: HashMap
На этом уровне мы предлагаем вам решить популярные задачи на подсчёт частот, поиск пар и хранение индексов с использованием HashMap.

#### Задание 6: Count Elements with Maximum Frequency [Easy]
Паттерн: Частотный анализ (HashMap для подсчёта частот)
Пример из лекции:Подсчитать, сколько раз каждое слово встречается в тексте

Подсчитайте общее количество элементов, которые имеют максимальную частоту в массиве.

Источник: https://leetcode.com/problems/count-elements-with-maximum-frequency/

Пример:
```
Вход: [1, 2, 2, 3, 3, 3]
Выход: 2 (число 3 встречается 3 раза — это максимальная частота, только одно число имеет такую частоту)
Вход: [1, 2, 2, 3, 3]
Выход: 4 (числа 2 и 3 встречаются по 2 раза — это максимальная частота, всего 4 элемента)
```

Требования:
- Временная сложность: O(n), где n — количество элементов

Решение:

Solution: [Task6.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module3/Task6.java)

Tests: [Task6Test.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module3/Task6Test.java)


### Задание 7: Two Sum [Easy]
Паттерн: Хранение индексов (HashMap для хранения позиций элементов)
Пример из лекции: Найти все индексы вхождения каждого слова в тексте
Задача встречается на собеседованиях в ВК и Яндекс

Дан массив целых чисел и целевое значение. Найдите два числа, которые в сумме дают целевое значение. Такая пара гарантированно существует.

Источник: https://leetcode.com/problems/two-sum/

Пример:
```
Вход: [2, 7, 11, 15], target = 9
Выход: [0, 1] (потому что 2 + 7 = 9)
```

Требования:
- Временная сложность: O (n)
- Верните индексы двух чисел

Решение:

Solution: [Task7.java](./app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module3/Task7.java)

Tests: [Task7Test.java](./app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module3/Task7Test.java)


### Задание 8: Valid Anagram [Easy]
    Паттерн: Частотный анализ (HashMap для сравнения частот)
    Пример из лекции:Проверить, являются ли две строки анаграммами
    Проверьте, являются ли две строки анаграммами.

    Источник: https://leetcode.com/problems/valid-anagram/
    
    Примеры:
    ```
    is_anagram("anagram", "nagaram") → True
    is_anagram("rat", "cat") → False
    ```
    Требования:
    - Временная сложность: O(n)

Решение:

Solution: [Task8.java](app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module3/hashmap/Task8.java)

Tests: [Task8Test.java](app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module3/hashmap/Task8Test.java)



### Задание 9: First Unique Character [Easy]
Паттерн: Частотный анализ (HashMap для подсчёта частот + два прохода)
Пример из лекции: Проверить, являются ли две строки анаграммами
Задача встречается на собеседованиях в Яндекс

Найдите первый неповторяющийся символ в строке.

Источник: https://leetcode.com/problems/first-unique-character-in-a-string/
    
Примеры:
```
first_unique("leetcode") → 0 (индекс 'l')
first_unique("loveleetcode") → 2 (индекс 'v')
first_unique("aabb") → -1 (нет уникальных)
```

Требования:
- Временная сложность: O(n)

Верните индекс первого символа, который встречается только один раз


Решение:

Solution: [Task9.java](app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module3/hashmap/Task9.java)

Tests: [Task89Test.java](app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module3/hashmap/Task9Test.java)


### Задание 10: Group Anagrams [Medium]
Паттерн: Группировка по ключу (HashMap для группировки элементов)
Пример из лекции: Сгруппировать слова по длине
Задача встречается на собеседованиях в Яндекс

Сгруппируйте слова-анаграммы вместе.

Источник: https://leetcode.com/problems/group-anagrams/

Пример:
```
Вход: ["eat", "tea", "tan", "ate", "nat", "bat"]
Выход: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]] (порядок не важен)
```

Требования:
- Временная сложность: O(n·k·log k), где n — количество слов, k — средняя длина слова

Подсказка
Отсортируйте символы в каждом слове и используйте отсортированную строку как ключ в HashMap. Все слова с одинаковым ключом — анаграммы.

Решение:

Solution: [Task10.java](app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module3/hashmap/Task10.java)

Tests: [Task10Test.java](app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module3/hashmap/Task10Test.java)


### Уровень 5: Продвинутый
Эти задачи имеют повышенную сложность (Medium/Hard). Рекомендуются для студентов, которые уверенно справляются с задачами уровней 1−3.

### Задание 11: Subarray Sum Equals K [Medium]
    Источник: https://leetcode.com/problems/subarray-sum-equals-k/

    Дан массив целых чисел и целевое значение k. Найдите общее количество подмассивов, сумма которых равна k.
    
    Пример:
    ```   
    Вход: nums = [1, 1, 1], k = 2
    Выход: 2 (подмассивы: [1,1] с индексами 0-1 и [1,1] с индексами 1-2)
    Вход: nums = [1, 2, 3], k = 3
    Выход: 2 (подмассивы: [1,2] и [3])
    ```

    Требования:
    - Временная сложность: O(n)
    
    Массив может содержать отрицательные числа


Решение:

Solution: [Task11.java](app/src/main/java/com/gmail/alexei28/shortcut/algorithms/module3/hashmap/Task11.java)

Tests: [Task11Test.java](app/src/test/java/com/gmail/alexei28/shortcut/algorithms/module3/hashmap/Task11Test.java)


### Задание 12: Insert Delete GetRandom O(1) [Medium]

Источник: https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

Реализуйте структуру данных, которая поддерживает следующие операции за O(1) среднее время:

- insert (val): вставить значение в структуру (если его ещё нет)
- remove (val): удалить значение из структуры (если оно есть)
- getRandom (): вернуть случайное значение из структуры (все значения равновероятны)

Пример:
```
insert(1)
insert(2)
insert(3)
getRandom() → возвращает 1, 2 или 3 с равной вероятностью
remove(2)
getRandom() → возвращает 1 или 3 с равной вероятностью (2 уже удалён)
```

Требования:
- Временная сложность: O(1) для всех операций в среднем 
- Допускаются дубликаты при вставке

### Задание 13: LRUCache [Medium]

Источник: https://leetcode.com/problems/lru-cache/description/
Задача встречается на собеседованиях в Яндекс

Реализуйте структуру данных LRUCache (Least Recently Used) с ограничением на количество элементов.

Операции:

- get (key): получить значение по ключу (если есть, иначе -1)
- put (key, value): вставить или обновить значение. Если количество элементов превышает лимит, удалить наименее недавно использованный элемент

- Пример:
```
cache = LRUCache(2)  // ёмкость 2

put(1, 1)       // cache = {1:1}
put(2, 2)       // cache = {1:1, 2:2}
get(1)         // возвращает 1, cache = {1:1, 2:2} (1 теперь используется недавно)
put(3, 3)       // удаляет ключ 2 (LRU), cache = {1:1, 3:3}
get(2)         // возвращает -1 (ключ 2 был удалён)
```

Требования:
- Временная сложность: O(1) для обеих операций
- Порядок важен: нужно отслеживать, какой элемент использовался давно

### Задание 14: Longest Consecutive Sequence [Medium]

Источник: https://leetcode.com/problems/longest-consecutive-sequence/

Дан несортированный массив целых чисел. Найдите длину самой длинной последовательности подряд идущих чисел.

Пример:
```
Вход: [100, 4, 200, 1, 3, 2]
Выход: 4 (последовательность: 1, 2, 3, 4)
Вход: [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
Выход: 9 (последовательность: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
```
Требования:
- Временная сложность: O(n)
- Пространственная сложность: O(n)

Подсказка
Используйте HashSet для хранения всех чисел массива. 
Для каждого числа проверяйте, есть ли num-1, num-2 и продолжайте последовательность в обе стороны.


### Задание 15: Contains Duplicate [Easy]

Источник: https://leetcode.com/problems/contains-duplicate/description/

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Explanation:
The element 1 occurs at the indices 0 and 3.

Example 2:
Input: nums = [1,2,3,4]
Output: false
Explanation:
All elements are distinct.

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true



### 26. Remove Duplicates from Sorted Array [Easy]

Source: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same.

Consider the number of unique elements in nums to be k. After removing duplicates, return the number of unique elements k.
The first k elements of nums should contain the unique numbers in sorted order. The remaining elements beyond index k - 1 can be ignored.

Custom Judge:

The judge will test your solution with the following code:

``` java
int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
assert nums[i] == expectedNums[i];
}
```

If all assertions pass, then your solution will be accepted.

Example 1:
```
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
```
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
```
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
```

Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
