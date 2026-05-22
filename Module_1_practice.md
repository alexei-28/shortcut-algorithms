## Практика 1: определение сложности алгоритмов

### Модуль 1
- Теория: https://shortcut.education/page116982046.html
- Практика: https://shortcut.education/page117566226.html

Упражнения для закрепления материала о временной и пространственной сложности.
### Рекомендации по выполнению:

1. Начните с определения параметра n — от чего зависит сложность?
2. Посчитайте количество операций в каждом цикле
3. Определите вложенность — сколько циклов и как они связаны
4. Примените правила упрощения — отбросьте константы и меньшие слагаемые
5. Проверьте свой ответ — зависит ли сложность от размера входных данных?

### Уровень 1: Определение параметра n

В этом уровне нужно определить, что такое n в данном коде. Это важный первый шаг перед оценкой сложности.
Варианты ответов:

- Длина массива
- Размер квадратной матрицы (количество строк = количеству столбцов)
- Значение входного параметра
- Константа (не зависит от входных данных)

####  Вопрос 1: Что такое n в этом коде?

```java
public int getFirstElement(int[] arr) {
    return arr.length > 0 ? arr[0] : null;
}
```
#### Ответ: Длина массива
Пояснение: Параметр n — это размер входных данных. В данном случае функция работает с массивом arr, поэтому n = len(arr).

#### Вопрос 2: Что такое n в этом коде?
```java
public int findSum(int[] arr) {
    int total = 0;
    for (int num : arr) {
        total += num;
    }
    return total;
}
```
#### Ответ: Длина массива/списка arr
Пояснение: Мы проходим по всем элементам массива arr один раз, поэтому n = len(arr).

#### Вопрос 3: Что такое n в этом коде?
```java
public void printSquareMatrix(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println(matrix[i][j]);
        }
    }
}
```
#### Ответ: Количество строк в матрице (или размер квадратной матрицы)

Пояснение: Переменная n явно определена как len(matrix) — количество строк. Это квадратная матрица nxn, где количество строк равно количеству столбцов.

#### Вопрос 4: Что такое n в этом коде?
```java
public void printAllElements(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i]);
    }
}
```
#### Ответ: Длина массива/списка arr

Пояснение: Мы проходим по всем элементам массива arr один раз, используя индекс. Поэтому n = len(arr).

#### Вопрос 5: Что такое n в этом коде?
```java
public boolean isEven(int n) {
    return n % 2 == 0;
}
```
#### Ответ: Значение переменной n

Пояснение: В данном случае n — это входной параметр функции, само число, с которым работаем. Это не размер структуры данных.

#### Вопрос 6: Что такое n в этом коде?
```java
public int[] findSumAndMax(int[] arr) {
    int total = 0;
    int maximum = arr[0];
    
    for (int num : arr) {
        total += num;
        if (num > maximum) {
            maximum = num;
        }
    }
    
    return new int[]{total, maximum};
}
```
#### Ответ: Длина массива/списка arr

Пояснение: Мы проходим по массиву arr один раз, выполняя несколько операций для каждого элемента. Поэтому n = len(arr).

#### Вопрос 7: Что такое n в этом коде?
```java
public void processMatrixAndArray(int[][] matrix, int[] arr) {
    int rows = matrix.length;  // берём количество строк из матрицы
    
    for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i] + " " + rows);
    }
}
```
#### Ответ: Длина массива/списка arr

Пояснение: Несмотря на то, что у нас есть матрица matrix и мы берём из неё параметр rows, цикл выполняется len(arr) раз.
Переменная rows используется только внутри цикла как константа, не влияющая на количество итераций. Поэтому n = len(arr).

#### Вопрос 8: Что такое n в этом коде?
```java
public void stringOperations(String s) {
    for (int i = 0; i < s.length(); i++) {
        System.out.println(s.charAt(i));
    }
    
    for (char c : s.toCharArray()) {
        System.out.p    rintln(c);
    }
}
```
#### Ответ: Длина строки s

Пояснение: Оба цикла проходят по строке s. 
Несмотря на то, что мы проходим по строке два раза, n остаётся одним и тем же — длиной строки len(s).

### Уровень 2: Базовые сложности
Определите временную сложность следующих алгоритмов.

Варианты ответов:

- O(1)
- O(log n)
- O(n)
- O(n log n)
- O(n²)
---

#### Вопрос 9
```java
public int getFirstElement(int[] arr) {
    return arr.length > 0 ? arr[0] : null;
}
```
#### Ответ: O(1) 
константная сложность, доступ к первому элементу не зависит от размера массива.

#### Вопрос 10
```java
public int findSum(int[] arr) {
    int total = 0;
    for (int num : arr) {
        total += num;
    }
    return total;
}
```
#### Ответ: O(n) 
проходим по всем элементам массива один раз.

#### Вопрос 11
```java
public void printAllPairs(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println(arr[i] + " " + arr[j]);
        }
    }
}
```
#### Ответ: O(n²)
два вложенных цикла, каждый выполняется n раз. Всего n·n = n² итераций.

#### Вопрос 12
```java
public void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```
#### Ответ: O(n²) 
классическая сортировка с вложенными циклами. Внешний цикл n раз, внутренний в среднем n/2 раз, но после отбрасывания константы получается O(n²).

#### Вопрос 13
```java
public int binarySearch(int[] sortedArr, int target) {
    int left = 0;
    int right = sortedArr.length - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (sortedArr[mid] == target) {
            return mid;
        } else if (sortedArr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    return -1;
}
```
#### Ответ: O(log n) — каждый шаг отсекаем половину диапазона. Логарифмическая сложность бинарного поиска.

#### Вопрос 14
```java
public boolean isEven(int n) {
    return n % 2 == 0;
}
```
#### Ответ: O(1) — одна арифметическая операция, не зависит от входных данных. 

#### Вопрос 15
```java
public Integer findMax(int[] arr) {
    if (arr.length == 0) {
        return null;
    }
    int maxVal = arr[0];
    for (int val : arr) {
        if (val > maxVal) {
            maxVal = val;
        }
    }
    return maxVal;
}
```
#### Ответ: O(n) 
проходим по всем элементам один раз, чтобы найти максимум.

#### Вопрос 16
```java
public void printSquareMatrix(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println(matrix[i][j]);
        }
    }
}
```
#### Ответ: O(n²) 
два вложенных цикла по n элементов каждый для квадратной матрицы nxn.

#### Вопрос 17
```java
public void sortAndPrint(int[] arr) {
    Arrays.sort(arr);
    for (int elem : arr) {
        System.out.println(elem);
    }
}
```
#### Ответ: O(n log n) 
сортировка O(n log n) + линейный проход O(n) = O(n log n). Правило упрощения: n log n больше n, поэтому оставляем n log n.

#### Вопрос 18
```java
public boolean containsValue(int[] arr, int value) {
    for (int elem : arr) {
        if (elem == value) {
            return true;
        }
    }
    return false;
}
```
#### Ответ: O(n) 
в худшем случае проходим все элементы, если искомое значение отсутствует или находится в конце.

#### Вопрос 19
```java
public int getMiddle(int[] arr) {
    int n = arr.length;
    return arr[n / 2];
}
```
#### Ответ: O(1)
прямой доступ по индексу, вычисление середины — константная операция.

#### Вопрос 20
```java
public int countDuplicates(int[] arr) {
    int count = 0;
    int n = arr.length;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (arr[i] == arr[j]) {
                count++;
            }
        }
    }
    return count;
}
```
#### Ответ: O(n²) 
два вложенных цикла по массиву. Хоть внутренний цикл короче (от i+1 до n), это примерно n·(n-1)/2 операций, что после упрощения даёт O (n²).

### Уровень 3: Упрощение выражений
Здесь нужно применить правила упрощения: отбросить константы и меньшие слагаемые.

Варианты ответов:
- O(1)
- O(log n)
- O(n)
- O(n log n)
- O(n²)
- O(n³)

#### Вопрос 21
```java
public int mixedOperations(int[] arr) {
    Arrays.sort(arr);

    int count = 0;
    for (int elem : arr) {
        if (elem > 0) {
            count++;
        }
    }

    return count;
}
```
#### Ответ: O(n log n) 
сортировка O(n log n) + проход O(n) = O(n log n). Правило упрощения: отбрасываем меньшее слагаемое O(n), оставляем O(n log n)

#### Вопрос 22
```java
public int processWithConstants(int[] arr) {
    int sum1 = 0;
    int sum2 = 0;
    int sum3 = 0;
    
    for (int elem : arr) {
        sum1 += elem;
    }
    for (int elem : arr) {
        sum2 += elem;
    }
    for (int elem : arr) {
        sum3 += elem;
    }
    
    return sum1 + sum2 + sum3;
}
```
#### Ответ: O(n)
3*O(n) = O(n). Правило упрощения: отбрасываем константу 3. Три прохода последовательно дают линейную сложность.

#### Вопрос 23
```java
public void nestedWithLinear(int[] arr) {
    int n = arr.length;

    for (int elem : arr) {
        System.out.println(elem);
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            System.out.println(i + " " + j);
        }
    }
}
```
#### Ответ: O(n²)
O(n) + O(n²) = O(n²). Правило упрощения: квадратичный член доминирует над линейным, отбрасываем O(n).

#### Вопрос 24
```java
public int complexExpression(int[] arr) {
    int n = arr.length;
    int result = 0;

    for (int i = 0; i < n; i++) {
        result += arr[i];
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            result += i * j;
        }
    }

    for (int elem : arr) {
        System.out.println(elem);
    }

    return result;
}
```
#### Ответ: O(n²)
O(1) + O(n) + O(n²) + O(n) = O(n²). Правило упрощения: находим член с самым быстрым ростом (n²) и отбрасываем все остальные слагаемые и константы.

#### Вопрос 25
```java
public int[] sortAndMultiplePasses(int[] arr) {
    Arrays.sort(arr);
    
    int countPositive = 0;
    int countNegative = 0;
    int countZeros = 0;
    
    for (int x : arr) {
        if (x > 0) countPositive++;
        else if (x < 0) countNegative++;
        else countZeros++;
    }
    
    return new int[]{countPositive, countNegative, countZeros};
}
```
#### Ответ: O(n log n)
O(n log n) + 3*O (n) = O(n log n). Сортировка доминирует над линейными проходами. Правило упрощения: n log n больше n.

#### Вопрос 26
```java
public int halfMatrix(int[] arr) {
    int n = arr.length;
    int count = 0;
    
    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            count++;
        }
    }
    
    return count;
}
```
#### Ответ: O(n²) 
сумма арифметической прогрессии 1 + 2 + 3 + … + n = n*(n+1)/2. После упрощения (отбрасываем константу 0.5 и слагаемое n) получаем O(n²)

#### Вопрос 27
```java
public void halfOperations(int[] arr) {
    int n = arr.length;
    
    for (int i = 0; i < n / 2; i++) {
        System.out.println(arr[i]);
    }
    
    for (int i = 0; i < n / 2; i++) {
        for (int j = 0; j < n / 2; j++) {
            System.out.println(i + " " + j);
        }
    }
}
```
#### Ответ: O(n²)
первый цикл: O(n/2) = O (n) (отбрасываем константу 0.5). Вторые вложенные циклы: O(n/2) x O (n/2) = O(n²). Сумма: O(n) + O(n²) = O(n²).

#### Вопрос 28
```java
public List<int[]> findPairs(int[] arr, int target) {
    List<int[]> pairs = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] + arr[j] == target) {
                pairs.add(new int[]{arr[i], arr[j]});
            }
        }
    }

    return pairs;
}
```
#### Ответ: O(n²)
два вложенных цикла по массиву. Внутренний цикл короче внешнего (от i+1 до n), что даёт примерно n·(n-1)/2 операций. После упрощения: O(n²).

#### Вопрос 29
```java
public int threeNestedLoops(int[] arr) {
    int n = arr.length;
    int count = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                count++;
            }
        }
    }

    return count;
}
```
#### Ответ: O(n³)
три вложенных цикла, каждый выполняется n раз. Всего n·n·n = n³ итераций.