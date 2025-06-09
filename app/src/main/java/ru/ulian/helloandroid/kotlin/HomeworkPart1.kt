package ru.ulian.helloandroid.kotlin

import androidx.collection.emptyLongSet

fun main()
{
    // 8 баллов из 10
    task1()
    task2()
    task3()
    task4()
    task5()
    task6()
    task7()
    task8()
    task9()
    task10()
    task11()
}

/**
 * В переменной celsius хранится целое число — температура воздуха.
 * Выведите в консоль:
 * «Freezing», если celsius ≤ 0;
 * «Cool», если 1 ≤ celsius ≤ 15;
 * «Warm», если 16 ≤ celsius ≤ 25;
 * «Hot», если celsius > 25
 */
fun task1()
{
    val celsius = 30
    val returnMsg = when
    {
        celsius <= 0 -> "Freezing"
        celsius <= 15 -> "Cool"
        celsius <= 25 -> "Warm"
        celsius > 25 -> "Hot"
        else -> "Unknown"
    }

    println(returnMsg)
}


/**
 * Пассажир сообщает свой возраст в переменной age.
 * Определите стоимость билета по тарифам и выведите найденную стоимость:
 * до 7 лет (включительно) — 0 ₽,
 * 8–17 лет — 15 ₽,
 * 18–60 лет — 30 ₽,
 * старше 60 лет — 20 ₽.
 */
fun task2()
{
    val age = 15
    val ticketCost = when
    {
        age <= 7 -> 0
        age <= 17 -> 15
        age <= 60 -> 30
        else -> 20
    }

    println(ticketCost)
}

/**
 * В переменной month дан номер месяца (1–12)
 * Напечатайте название времени года на английском: «Winter», «Spring», «Summer»
 * или «Autumn».
 */
fun task3()
{
    val month = 5
    val currSeason = when(month)
    {
        1 -> "Winter"
        2 -> "Winter"
        3 -> "Spring"
        4 -> "Spring"
        5 -> "Spring"
        6 -> "Summer"
        7 -> "Summer"
        8 -> "Summer"
        9 -> "Autumn"
        10 -> "Autumn"
        11 -> "Autumn"
        12 -> "Winter"
        else -> "Unknown"
    }
    println(currSeason)
}

/**
 * В переменной ch хранится одна заглавная латинская буква (A – Z). Выведите строку
 * «YES», если эта буква относится к гласным (A, E, I, O, U, Y), и «NO» в противном
 * случае.
 */
fun task4()
{
    val ch = 'H'
    val glasn = listOf('A', 'E', 'I', 'O', 'U', 'Y')

    println(when(ch)
    {
        in glasn -> "YES"
        else -> "NO"
    }
    )
}

/**
 * Пользователь вводит число n (1–9).
 * Выведите в одной строке через пробел значения n × 1, n × 2, …, n × 10.
 */
fun task5()
{
    val n = 8

    for(number in 1..10)
    {
        print("${n*number} ")
    }
}

/**
 * В коде объявлен массив cities из пяти названий городов.
 * Выведите их по одному на строке в обратном порядке (последний → первый).
 */
fun task6()
{
    val cities = arrayOf("Москва", "Санкт-Петербург", "Самара", "Сочи", "Волгоград")

    for (city in cities.reversed())
    {
        print("$city ")
    }
}

/**
 * Вводится произвольная строка text.
 * Посчитайте и выведите количество русских гласных букв
 * («аоиеёэыуюя», регистр неважен).
 */
fun task7()
{
    println()
    val text = readln()
    val glasn = listOf('а', 'о', 'у', 'э', 'ы', 'я', 'ё', 'е', 'и', 'ю')
    var numOfGlasn = 0

    for(symbol: Char in text)
    {
        if (symbol in glasn)
        {
            numOfGlasn++
        }
    }

    println(numOfGlasn)
}

/**
 * Есть изменяемый список целых чисел numbers: MutableList<Int>. Последний
 * элемент списка равен 0. Определите наименьшее значение среди всех элементов,
 * стоящих до этого нуля, и запишите результат в переменную minValue: Int.
 */
fun task8()
{
    var numbers: MutableList<Int> = mutableListOf(92,21,56,72,45,7,23,879,12,0)
    val minValue: Int = numbers.subList(0, numbers.lastIndex - 1).min()
    println(minValue)
}

/**
 * Дан список целых чисел data: List<Int>.
 * Просматривайте элементы по порядку, накапливая их сумму в переменной total:
 * Int, до тех пор, пока total не станет больше 1000. По завершении работы
 * программы в total должно находиться получившееся итоговое значение.
 */
fun task9()
{
    val data: List<Int> = listOf(53,54,234,87,23,65,256,98,432,43,67,32)
    var total = 0
    var index = 0
    do
    {
        total += data[index]
        index++
    } while (total < 1000)

    println(total)
}

/**
 * Задано натуральное число k: Int. Найдите наименьшую степень двойки 2^m,
 * которая не меньше k, и сохраните это значение в переменной closestPower: Int.
 * Число m выводить или сохранять не требуется.
 */
fun task10()
{
    val k:Int = 10
    var closestPower: Int = 0

    for (m in 1..100)
    {
        closestPower = Math.pow(2.0, m.toDouble()).toInt()
        if ( closestPower >= k)
        {
            println(closestPower)
            return
        }
    }
}

/**
 * В коде уже объявлена переменная middleName: String? = null.
 * Напечатайте строку вида «Количество символов = X»,
 * где X — длина middleName, если значение не null,
 * или 0, если переменная равна null.
 */
fun task11()
{
    val middleName: String? = "ffdsffsdfds"
    val numOfSym = middleName?.length ?: 0

    println("Количество символов = ${numOfSym}")
}