1. Объясните, что имеется в виду, когда говорится: Java-язык программирования и Java-платформа.
- Java как язык программирования является высокоуровневым, статически-типизированным и объектно-ориентированным.
Java как платформа — это программное обеспечение, представляющее собой рабочую среду для работы программ, написанных на Java (и не только). Она состоит из Java API и Java виртуальной машины (JVM). 

2. Поясните, как связаны имя java-файла и классы, которые в этом файле объявляются.
-  Имя файла совпадает с именем класса
3. Расшифруйте аббревиатуры JVM, JDK и JRE; покажите, где “они находятся” и что собой представляют.
- JVM (Java Virtual Machine) - виртуальная машина Java - основная часть исполняющей системы Java, так называемой Java Runtime Environment (JRE). Виртуальная машина Java исполняет байт-код Java, предварительно созданный из исходного текста Java-программы компилятором Java (javac). JVM обеспечивает платформо-независимый способ выполнения кода. Программисты могут писать код не задумываясь как и где он будет выполняться.

- JRE (Java Runtime Environment) - минимальная реализация виртуальной машины, необходимая для исполнения Java -приложений, без компилятора и других средств разработки. Состоит из виртуальной машины и библиотек Java классов.

- JDK (Java Development Kit) - комплект разработчика приложений на языке Java, включающий в себя компилятор, стандартные библиотеки классов Java, примеры, документацию, различные утилиты и исполнительную систему JRE. 
4. Объясните, как скомпилировать и запустить приложение из командной строки, а также зачем в переменных
среды окружения прописывать пути к установленному jdk.
- javac имя файла.java, далее java имя выходного файла. Чтобы в командной строке был javac и java
5. Перечислите атрибуты доступа, объясните их действие.
- private, public, protected, default
private запрещает доступ везде кроме класса

- private открывает доступ везде кроме класса

- default открывает доступ везде в этом пакете

- protected как default, только наследование в разных пакетах работает

6. Что такое пакеты в java-программе, что представляют собой пакеты на диске? Каково соглашение по
именованию пакетов? Как создать пакет?
- Пакетом называется объединение классов.

- Как правило, названия пакетов соответствуют физической структуре проекта, то есть организации каталогов, в которых находятся файлы с исходным кодом. А путь к файлам внутри проекта соответствует названию пакета этих файлов. 

- com.название домена

- создать папку внутри src

- Обеспечивает инкапсуляцию via default protected

- обеспечивает скрытие данных

7. Объясните, какие классы, интерфейсы, перечисления необходимо импортировать в вашу программу, как
это сделать. Влияет ли импорт пакета на импорт классов и др., лежащего в подпакетах? Какой пакет в Java
импортируется по умолчанию?
- import java.util.Scanner;

- Если импортируешь весь пакет, то все классы импортируются

- java.lang
8. Объясните различия между терминами “объект” и “ссылка на объект”.
- Обьект-это экземпляр класса, а ссылка- это переменная,которая позволяет обратиться к обьекту или классу,но в тоже время не является экземпляром класса.
9. Какие примитивные типы Java вы знаете, как создать переменные примитивных типов? Объясните

- boolean: хранит значение true или false

- byte: хранит целое число от -128 до 127 и занимает 1 байт

- short: хранит целое число от -32768 до 32767 и занимает 2 байта

- int: хранит целое число от -2147483648 до 2147483647 и занимает 4 байта

- long: хранит целое число от –9 223 372 036 854 775 808 до 9 223 372 036 854 775 807 и занимает 8 байт

- double: хранит число с плавающей точкой от ±4.9*10-324 до ±1.8*10308 и занимает 8 байт
В качестве разделителя целой и дробной части в дробных литералах используется точка.

- float: хранит число с плавающей точкой от -3.4*1038 до 3.4*1038 и занимает 4 байта. 
float x = 8.5F;

- char: хранит одиночный символ в кодировке UTF-16 и занимает 2 байта, поэтому диапазон хранимых значений от 0 до 65535
процедуру, по которой переменные примитивных типов передаются в методы как параметры.
10. Каков размер примитивных типов, как размер примитивных типов зависит от разрядности платформы, что
такое преобразование (приведение) типов и зачем оно необходимо? Какие примитивные типы не приводятся
ни к какому другому типу.
- так как большинство систем 32 или 64 разрядные, то byte и short при вычислениях будут приведены к 32-битному int
- Сами типы от платформы никак не зависят, у них константный range
- boolean
11. Объясните, что такое явное и неявное приведение типов, приведите примеры, когда такое преобразование
имеет место.
- Имеет место, каждый раз когда производятся опрерации с разными типами, Это привидение одного типа к другому по определенным правилам
12. Что такое литералы в Java-программе, какую классификацию литералов вы знаете, как записываются
литералы различных видов и типов в Java-программе?
- Литералы — это константы, которые записаны по правилам языка Java. 

- 111 — десятичное (десятеричное) число. 056 — число 46 в восьмеричной форме. 0 х АВ — 171 в шестнадцатеричной форме

- Рассмотрим теперь литералы для чисел с плавающей точкой.

18.01

31.4е-1

0.314е1

- 'd','s'
-"String"
- true false
- null - ссылочный литерал
13. Как осуществляется работа с типами при вычислении арифметически выражений в Java?
- byte -> short -> int -> long

- int -> double

- short -> float -> double

- char -> int
14. Что такое классы-оболочки, для чего они предназначены? Объясните, что значит: объект класса оболочки
– константный объект.

Они предназначены для хранения в коллекциях или для передачи в массивы по ссылке

Это значит, что он не перезаписывает свое значение, а пересоздается каждый раз

То есть объявляя Integer somevar = 1; на самом деле, выполняется нечто вроде: Integer somevar = new Integer(1); далее, если мы захотим поменять значение somevar = 2 - то переменная somevar будет указывать уже на другой объект, а не перезатрет значение предыдущего. а предыдущий объект, будет собран сборщиком мусора, если на него более не имеется ссылок
15. Объясните разницу между примитивными и ссылочными типами данных. Поясните существующие различия,
    при передаче параметров примитивных и ссылочных типов в методы. Объясните, как константные объекты
    ведут себя при передаче в метод.
    
    - У ссылочных типов данных есть методы, у примитивных нет.
    - Ссылочные типы данных хранятся в куче, примитивные - в стеке(намного быстрее).
    - передача по ссылке(ссылочные) и по значению(примитивные) в методы.
    - Ссылочные можно использовать в коллекциях, примитивные нельзя.
    
    - константные объекты не изменяются так как значения их примитивных полей нельзя изменить, можно только пересоздать сами Wraper, что никак не повлияет на оригинальные wrapper вне функции, тоже самое со String, ведь он immutable


16. Поясните, что такое автоупаковка и автораспаковка.
- Автоупаковка и распаковка это функция преобразования примитивных типов в объектные и наоборот.

- Автоупаковка применяется компилятором  Java в следующих условиях:
Когда значение примитивного типа передается в метод в качестве параметра метода, который ожидает объект соответствующего класса-оболочки.
Когда значение примитивного типа присваивается переменной, соответствующего класса оболочки.

- Распаковка применяется компилятором Java в следующих условиях:
Когда объект передается в качестве параметра методу, который ожидает соответствующий примитивный тип.
Когда объект присваивается переменной соответствующего примитивного типа.
17. Перечислите известные вам арифметические, логические и битовые операторы, определите случаи их
употребления. Что такое приоритет оператора, как определить, в какой последовательности будут
выполняться операции в выражении, если несколько из них имеют одинаковый приоритет.
- Слева-направо
18. Укажите правила выполнения операций с плавающий точкой в Java (согласно стандарту IEEE754). Как
    определить, что результатом вычисления стала бесконечность или нечисло?
    isNaN(), isInfinite()
19. Что такое статический импорт, какие элементы можно импортировать при статическом импорте.

статический импорт - это импорт при помощи ключ слова static.
При объявлении статического импорта статические члены импортируются из классов, что позволяет им быть использованными без указания имени содержащего их класса.

20. Объясните работу операторов if, switch, while, do-while, for, for-each. Напишите корректные примеры
    работы этих операторов.
    на свою фантазию

    свич работает со строками и заменяет if-else if

21. Объясните работу оператора instance of
- показывает является ли объект наследником какого либо класса, либо же объектом класса который указан справа
- cat instance of Animal //true
- null instanceof smth // false