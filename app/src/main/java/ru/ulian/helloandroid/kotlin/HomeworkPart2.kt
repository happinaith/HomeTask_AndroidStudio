package ru.ulian.helloandroid.kotlin

import kotlin.math.abs

fun main()
{
    task12()
    task13()
    task14()
    task15()
    task16()
    task17()
    task18()
    task19()
    task20()
    task21()
    task22()
}

/*
Напишите функцию welcomeBot(id: String), которая выводит строку
Beep! Unit <id> online
 */
fun task12()
{
    fun welcomeBot(id: String)
    {
        return println("Beep! Unit <$id> online")
    }

    welcomeBot("1")
}

/*
Создайте функцию orderPaint(color: String = "silver", layers: Int = 1), печатающую
строку
Painting robot in <color> (layers: <layers>).
Если аргументы не переданы — используются значения по умолчанию.
Если layers ≤ 0, функция должна вывести сообщение об ошибке "Invalid number of
layers"
 */

fun task13()
{
    fun orderPaint(color: String = "silver", layers: Int = 1)
    {
        if (layers <= 0)
        {
            println("Invalid number of layers")
        }
        else
        {
            println("Painting robot in <$color> (layers: <$layers>)")
        }
    }

    orderPaint("red", -1)
}

/*
Объявите компактную функцию triple(x: Int): Int = x * 3.
Затем реализуйте функцию sumOfTriples(n: Int): Int, которая для каждого i из
диапазона 1..n вызывает triple(i) и выводит полученную сумму
 */

fun task14()
{
    fun triple(x: Int): Int = x * 3
    fun sumOfTriples(n: Int): Int
    {
        var sum = 0
        for (i: Int in 1..n)
        {
            sum += triple(i)
        }
        return sum
    }
    println(sumOfTriples(10))
}

/*
Объявите переменную boost: (Int) -> Int, которая для чётных аргументов
возвращает их куб, для нечётных — квадрат; если модуль результата превышает
1_000_000, вместо числа выводится сообщение об ошибке "Out of range";
продемонстрируйте работу, вызвав boost(4) и выведя полученный результат
 */
fun task15()
{
    val boost: (Int) -> Int = {num -> if (abs(num) > 1_000_000) error("Out of range") else if(num%2 == 0) num*num*num else num*num}
    return println(boost(4))
}

/*
Реализуйте функцию combine(a: Int, b: Int, operation: (Int, Int) -> Int): Int, которая
применяет переданную в параметре operation функцию к значениям a и b, если оба
числа положительные, иначе возвращает результат применения функции operation
к их модулям, и выведите результат
 */
fun task16()
{
    fun combine(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        if(a > 0 && b > 0)
        {
            return operation(a,b)
        }
        else
        {
            return operation(abs(a), abs(b))
        }
    }

    println(combine(5, -3, {a,b -> a+b}))
}
/*
Создайте функцию wrapInHashes(text: String): String, добавляющую по одному
символу # в начало и конец строки. Передайте её как ссылку ::wrapInHashes вторым
аргументом в функцию secureText, которая должна вызвать полученную функцию и
вывести преобразованный текст
 */
fun task17()
{
    fun wrapInHashes(text: String): String
    {
        return "#$text#"
    }

    fun secureText(str: String, func: (String) -> String): String
    {
        return func(str)
    }

    println(secureText("hello", ::wrapInHashes))
}

/*
В коде объявлен список drones, например listOf("AX23X", "BT77", "QX90X"),
отфильтруйте элементы, оставив только те, что оканчиваются символом 'X' и при
этом содержат не менее пяти символов, затем преобразуйте их в нижний регистр и
выведите получившийся список
 */
fun task18()
{
    val drones = listOf("AX23X", "BT77", "QX90X", "S7OX")
    println(drones.filter {it.endsWith('X') && it.length >= 5}.map { it.lowercase() })
}

/*
Напишите функцию computeFibonacci(n: Int?): Int?, которая возвращает n-е число
Фибоначчи, если n не равен null и неотрицательно, при этом для значений n от 0 до
1 возвращается n, а для остальных — рекурсивно вычисляется сумма двух
предыдущих чисел; если n меньше 0 или равно null, функция должна вернуть null,
выведите результаты для нескольких значений n, включая null и отрицательные
числа
 */
fun task19()
{
    fun computeFibonnacci(n: Int?): Int?
    {
        if(n == null || n < 0 )
        {
            return null
        }
        else if(n == 0 || n == 1)
        {
            return n
        }
        else
        {
            return computeFibonnacci(n - 1)?.let { computeFibonnacci(n-2)?.plus(it) }
        }
    }

    print("Chisla fibbonacci: 10 - ${computeFibonnacci(10)}, 15 - ${computeFibonnacci(15)}, 34 - ${computeFibonnacci(34)}, -5 - ${computeFibonnacci(-5)}, null - ${computeFibonnacci(null)}")
}

/*
Создайте функцию findMinCharge(levels: List<Int>?): Int?, которая возвращает
минимальный уровень заряда батарей из переданного списка, при этом функция
должна игнорировать все отрицательные значения и возвращать null, если список
равен null, пустой или не содержит ни одного положительного значения; выведите
результат для примера с положительными, отрицательными и нулевыми
значениями
 */
fun task20()
{
    fun findMinCharge(levels: List<Int>?):Int?
    {
        if (levels.isNullOrEmpty() == true || levels.all {it < 0})
        {
            return null
        }
        else
        {
            return levels.filter { it >= 0 }.min()
        }
    }
    println(" ")
    print("1 - ${findMinCharge(listOf(54,32,89,36,3,8,11))}, 2 - ${findMinCharge(listOf(54,32,89,36,-3,8,11))}, 3 - ${findMinCharge(listOf())}")
}

/*
Реализуйте функцию sumValid(values: List<Int?>): Int, которая суммирует все
элементы списка, игнорируя значения null и те, что меньше нуля, и выводит
итоговое значение суммы только положительных чисел
 */
fun task21()
{
    fun sumValid(values: List<Int?>): Int
    {
        var sum = 0
        for (i: Int in values.mapNotNull { it }.filter { it >= 0 })
        {
            sum += i
        }
        return sum
    }
    println(sumValid(listOf(12,434,67,null,434,87,32,0,-1)))
}

/*
Напишите функцию adjustSignals(signals: List<Int>, adjust: (Int) -> Int = { it * 2 }):
List<Int>, которая применяет к каждому элементу списка signals функцию adjust (по
умолчанию — удвоение), исключая из обработки отрицательные значения, и
возвращает новый список преобразованных положительных чисел; проверьте
работу функции как с преобразованием по умолчанию, так и с передачей лямбды,
умножающей элемент на 10
 */
fun task22()
{
    fun adjustSignals(signals: List<Int>, adjust: (Int) -> Int = { it * 2 }): List<Int> {
        return signals.filter { it >= 0 }.map(adjust)
    }
    println(
        "default - ${adjustSignals(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))}," +
            "lambda - ${adjustSignals(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), { a -> a * 10 })}"
    )
}
