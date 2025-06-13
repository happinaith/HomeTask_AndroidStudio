package ru.ulian.helloandroid.kotlin

fun main()
{
    task23()
    task24()
    task25()
    task26()
    task27()
    task28()
    task29()
    task30()
    task31()
    task32()
    task33()
    task34()
}

/*
1
Создайте класс Robot с неизменяемыми свойствами model (строка), manufacturer
(строка) и year (целое). Переопределите toString() так, чтобы метод возвращал
строку вида «Model X200 (2023) — Robotics Corp». Создайте два разных робота и
выведите их представление
 */
class Robot(val model:String, val manufacturer:String, val year:Int )
{
    override fun toString(): String = "Model $model ($year) - $manufacturer"
}

fun task23()
{
    val first = Robot("X7H3", "Broken Ceilin Initiative", 2030)
    val second = Robot("H34F9", "Nice Ceiling Initiative", 2034)
    println(first)
    println(second)
}

/*
2
Создайте класс Drone с первичным конструктором, принимающим только serial:
String. Добавьте вторичный конструктор, который помимо serial принимает range:
Int (максимальная дальность полёта в км). Во втором конструкторе вызовите
первый через this(serial) и инициализируйте свойство range. Продемонстрируйте
использование обеих форм конструкторов, выводя информацию о дронах
 */
class Drone(val serial:String)
{
    var range: Int = 100
    constructor(serial: String, range: Int): this(serial)
    {
        this.range = range
    }
    override fun toString() = "Drone $serial - $range range"
}


fun task24()
{
    val dr1 = Drone("1X903")
    val dr2 = Drone("8HC02J", 500)
    println(dr1)
    println(dr2)
}

/*
3
Определите класс Sensor, описывающий датчик со свойствами type (строка) и units
(строка). В блоке init автоматически присваивайте каждому созданному датчику
уникальный sensorId в формате “S-<номер>”, где номер увеличивается в companion
object. Создайте несколько сенсоров разных типов и выведите их sensorId
*/

class Sensor(val type:String, val units:String)
{
    var sensorId: String = "S-<$counter>"

    init
    {
        counter++
    }
    companion object
    {
        private var counter = 1
    }

    override fun toString() = sensorId
}


fun task25()
{
    val sens1 = Sensor("movement", "movement-1")
    val sens2 = Sensor("FireDetect", "Fire-1")
    println(sens1)
    println(sens2)
}

/*
4
Создайте класс Cylinder с параметрами radius и height. Для radius объявите сеттер,
который игнорирует попытку присвоить отрицательное значение. Добавьте
вычисляемое свойство volume (только геттер), считающее объём цилиндра по
формуле π · r² · h. Создайте цилиндр, попробуйте изменить radius на отрицательное
число, затем на положительное и в обоих случаях выведите volume
 */
class Cylinder(radius:Double, val height:Double)
{
    var radius = radius
        set(value)
        {
            if (value >= 0) field = value
        }

    val volume: Double
        get() = Math.PI * (radius*radius) * height
}

fun task26()
{
    val cyl1 = Cylinder(22.0,10.0)
    println("volume before change - ${cyl1.volume}")
    cyl1.radius = -10.0
    println("volume after change - ${cyl1.volume}")
}

/*
5
Определите открытый класс Instrument с виртуальной функцией play(): String,
возвращающей «…». Создайте подкласс Guitar, переопределив метод так, чтобы он
возвращал «Strum!». Создайте экземпляр Guitar и выведите результат вызова play()
 */

open class Instrument
{
    open fun play(): String
    {
        return "..."
    }
}

class Guitar : Instrument()
{
    override fun play(): String {
        return "Strum!"
    }
}

fun task27()
{
    val guit = Guitar()
    println(guit.play())
}

/*
6
Объявите интерфейс Flyable с функцией fly(distance: Int): String. Реализуйте
интерфейс в классе Plane, принимающем model (строка). Метод должен
возвращать строку вида «Boeing 737 flew 850 km». Покажите работу метода на
примере
 */

interface Flyable
{
    fun fly(distance:Int): String
}

class Plane(val model:String): Flyable
{
    override fun fly(distance: Int): String
    {
        return "$model flew $distance km"
    }
}


fun task28()
{
    val plane1 = Plane("Boeing 800")
    println(plane1.fly(500))
}

/*
7
Создайте абстрактный класс Appliance с абстрактной функцией consumption(hours:
Int): Double, возвращающей потреблённую энергию. Реализуйте подкласс Heater,
принимающий power (кВт), где consumption возвращает power × hours. Создайте
обогреватель мощностью 1,5 кВт, вычислите расход за 4 часа и выведите результат
 */

abstract class Appliance
{
    abstract fun consumption(hours: Int): Double
}

class Heater(val power: Double): Appliance()
{
    override fun consumption(hours: Int): Double
    {
        return power * hours
    }
}

fun task29()
{
    val heater = Heater(1.5)
    println(heater.consumption(4))
}

/*
8
Напишите функцию-расширение String.isPalindrome(): Boolean, возвращающую true,
если строка читается одинаково слева направо и справа налево, игнорируя регистр
и пробелы. Продемонстрируйте работу функции на паре строк, например «A man a
plan a canal Panama» и «Hello world»
 */

fun String.isPalindrome():Boolean
{
    val withoutSpaces = lowercase().replace(" ", "")
    var reversedText = ""
    for (char in withoutSpaces.length - 1 downTo 0)
    {
        reversedText += withoutSpaces[char]
    }
    return withoutSpaces == reversedText
}

fun task30()
{
    println("A man a plan a canal Panama".isPalindrome())
    println("Hello world".isPalindrome())
}

/*
9
Создайте data-класс Laptop(model: String, price: Double, gaming: Boolean). Создайте
объект original и с помощью copy() получите discounted со сниженной ценой.
Используя деструктуризацию, получите поля второго экземпляра и выведите их
 */

data class Laptop(val model: String, val price: Double, val gaming: Boolean)


fun task31()
{
    val original = Laptop("MSI", 80000.0, true)
    val discounted = original.copy(price = 65000.0)

    val (model: String, price: Double, gaming: Boolean) = discounted
    println("$model - price: $price, gaming - $gaming")
}

/*
10
Используя Pair и Triple, сохраните информацию о химическом элементе (имя,
символ) и о планете (название, расстояние от Солнца в млн км, наличие колец).
Выведите сохранённые данные в человекочитаемом виде
 */

val chemicalElement = "Свинец" to "Pb"
val planet = Triple("Юпитер", 778.57, false)

fun task32()
{
    println("Элемент - ${chemicalElement.first} символ: ${chemicalElement.second}")
    println("Плаента - ${planet.first}, расстояние от Солнца - ${planet.second}, наличие колец - ${planet.third}")
}

/*
11
Определите enum class TrafficLight с константами RED(50 с), YELLOW(5 с) и GREEN(45
с). Добавьте свойство duration и метод next() — следующее состояние по циклу. В
main пройдите полный цикл дважды, каждый раз выводя состояние и его duration
 */

enum class TrafficLight(val duration: String)
{
    RED("50 c"),
    YELLOW("5 c"),
    GREEN("45 c");

    fun next() : TrafficLight = entries[(ordinal + 1 ) % entries.size]
}

fun task33()
{
    var light = TrafficLight.RED
    repeat(6)
    {
        println("$light - ${light.duration}")
        light = light.next()
    }
}

/*
12
Создайте объект-одиночку IdGenerator с приватным счётчиком и функцией nextId():
String, возвращающей значения вида «ID-1», «ID-2», … Вызовите nextId() трижды и
выведите результаты
 */

object IdGenerator
{
    private var counter = 0

    fun nextId(): String
    {
        counter++
        return "ID-$counter"
    }
}

fun task34()
{
    println(IdGenerator.nextId())
    println(IdGenerator.nextId())
    println(IdGenerator.nextId())
}
