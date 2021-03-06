1. Опишите процедуру инициализации полей класса и полей экземпляра класса. Когда инициализируются поля класса, а когда – поля экземпляров класса. Какие значения присваиваются полям по умолчанию? Где еще в классе полям могут быть присвоены начальные значения?

   - 1. Сначала для хранения объекта выделяется память.
     2. Далее Java-машина создает ссылку на этот объект (в нашем случае ссылка — это `Cat cat`).
     3. В завершение происходит инициализация переменных и вызов конструктора

   - > Статические Родителя
     >
     > Статические Ребенка
     >
     > Нестатические Родителя
     >
     > Конструктор Родителя
     >
     > Нестатические Ребенка
     >
     > Конструктор Ребенка

   <img src="C:\Users\isahe\IdeaProjects\img\Screenshot_1.png" alt="Screenshot_1" style="zoom:80%;" />

   - В блоках инициализации, собственно в полях, в конструкторе

2. Дайте определение перегрузке методов. Как вы думаете, чем удобна перегрузка методов? Укажите, какие методы могут перегружаться, и какими методами они могут быть перегружены? Можно ли перегрузить методы в базовом и производном классах? Можно ли private метод базового класса перегрузить public методов производного? Можно ли перегрузить конструкторы, и можно ли при перегрузке конструкторов менять атрибуты доступа у конструкторов?

   - Метод называется перегруженным, если существует несколько его версий с одним и тем же именем, но с разным списком параметров. Перегрузка реализует «раннее связывание», то есть версия вызываемого метода определяется на этапе компиляции. Перегрузка может ограничиваться одним классом. Методы с одинаковыми именами, но с различными списком параметров и возвращаемыми значениями могут находиться в разных классах одной цепочки наследования и также будут перегруженными. Если списки параметров идентичны, то имеет место механизм динамического полиморфизма — переопределение метода. При непосредственной передаче объекта в метод выбор производится в зависимости от типа ссылки на этапе компиляции.
   - ![Screenshot_2](C:\Users\isahe\IdeaProjects\img\Screenshot_2.png)
   - Можно перегрузить методы в базовом и производном классах
   - private метод базового класса можно перегрузить public методом производного, а вот переопределить нельзя:(
   - Можно перегрузить конструкторы, и можно при перегрузке конструкторов менять атрибуты доступа у конструкторов.

3. Объясните, что такое раннее и позднее связывание? Перегрузка – это раннее или позднее связывание? Объясните правила, которым следует компилятор при разрешении перегрузки; в том числе, если методы перегружаются примитивными типами, между которыми возможно неявное приведение или ссылочными типами, состоящими в иерархической связи.

   - Раннее связывание - это когда метод, который будет вызван, известен во время компиляции, например, вызов статического метода.

     Позднее связывание - это когда вызов метода может быть осуществлен только во время выполнения и у компилятора нет информации, чтобы проверить корректность такого вызова.

     Private, final и static методы используют статические привязки и связаны компилятором, в то время как виртуальные методы связываются во время выполнения на основе обрабатываемого объекта.

     При override мы не можем делать доступ недоступнее чем был, только свободнее или такой как есть

   - Перегрузка - раннее связывание

   - 1. Что следует иметь в виду: при перегрузке метода JVM сделает наименьшее усилие из возможных.

        #### `Вот порядок самого ленивого пути к исполнению:`

     - Первое — расширение (widening), как примитивных, так и ссылочных(типо из класса Dog в класс Animal или даже Object, а хули)

       <img src="C:\Users\isahe\IdeaProjects\img\Screenshot_3.png" alt="Screenshot_3" style="zoom:100;" />

       Помните, что `Integer` не может быть `Long` и `Float` и не может быть `Double`. Здесь нет наследования. Каждый из этих типов (`Integer`, `Long`, `Float`, и `Double`) — `Number` и `Object`.

     - Второе —  **boxing**, **unboxing**

       собственно из int в Integer а потом и в **Object** можно, лол, т.е. все примитивные типы могут преобразоваться во **wrapper**, а затем в **Object**

       Когда мы используем обёртку , есть два варианта: либо число может быть распаковано в примитивный тип, либо оно может быть расширено в `Object`. (Помните, что каждый класс в Java расширяет класс `Object`.) В этом случае JVM выбирает расширение типа `Double` в `Object`, потому что это требует меньше усилий, чем распаковка.

     - Третье — аргументы переменной длины (**varargs**)

       тут вообще пиздец, он будет считывать vararg только в самом крайнем случае, когда нельзя привести нихуя и ни к чему, кроме как к vararg
     
       даже **Object** из int найдет, ужс короче, ну еще реагирует на массивы, но опять же если есть **...Object**, то он и массив в себя прихватить может, так как массив - объект

4. Объясните, как вы понимаете, что такое неявная ссылка **this**? В каких методах эта ссылка присутствует, а в каких – нет, и почему?

   - `this` требуется для того, чтобы метод мог сослаться на вызвавший его объект, он неявно передается в каждый не **static** (передается, но использовать нельзя )метод неявно первым параметром
   - Как правило, применять `this` нужно в двух случаях:
     1. Когда у переменной экземпляра класса и переменной метода/конструктора одинаковые имена;
     2. Когда нужно вызвать конструктор одного типа (например, конструктор по умолчанию или параметризированный) из другого. Это еще называется явным вызовом конструктора.
   - во всех кроме статических, потому что это методы класса, а не объекта

5. Что такое финальные поля, какие поля можно объявить со спецификатором final? Где можно инициализировать финальные поля?

   - Модификатор final используется для определения констант в качестве члена класса, локальной переменной или параметра метода. Методы, объявленные как final, нельзя замещать в подклассах. Для классов, объявленных со спецификатором final, нельзя создавать подклассы. 
   - для ссылочных типов мы не можем изменить ссылку, для примитивных - значение
   - Значение по умолчанию константа получить не может в отличие от переменных класса. Константы могут быть объявлены в методах как локальные или как параметры метода. В обоих случаях значения таких констант изменять нельзя.
   - В конструкторе, В обычных блоках инициализации

6. Что такое статические поля, статические финальные поля и статические методы. К чему имеют доступ статические методы? Можно ли перегрузить и переопределить статические методы? Наследуются ли статические методы?

   - Поле данных, объявленное в классе как static, является общим для всех объектов класса и называется переменной класса. Может быть использовано без создания экземпляра класса. Если один объект изменит значение такого поля, то это изменение увидят все объекты. Для работы со статическими атрибутами используются статические методы, объявленные со спецификатором static. Нестатические методы могут обращаться к статическим полям и методам напрямую без всяких дополнительных условий. Статические методы не содержат указателя this на конкретный экземпляр, вызвавший метод. Статические методы реализуют парадигму «раннего связывания», жестко определяющую версию метода на этапе компиляции.
   - По причине недоступности указателя this статические поля и методы не могут обращаться к нестатическим полям и методам  напрямую, так как они не «знают», к какому объекту относятся, да и сам экземпляр класса может быть не создан.
   - Для статических методов принципы «позднего связывания» не используются. Динамический полиморфизм к статическим методам класса неприменим, так как обращение к статическому атрибуту или методу осуществляется по типу ссылки, а не по типу объекта, через который производится обращение. Версия вызываемого статического метода всегда определяется на этапе компиляции. При использовании ссылки для доступа к статическому члену компилятор при выборе метода учитывает тип ссылки, а не тип объекта, ей присвоенного. 
   - Статические методы в Java наследуются, но не могут быть переопределены.  Если вы объявляете тот же метод в подклассе, вы скрываете метод  суперкласса вместо его переопределения. Статические методы не являются  полиморфными
   - перегружать можно
   - статические методы наследуются

7.  Что такое логические и статические блоки инициализации? Сколько их может быть в классе, в каком порядке они могут быть размещены и в каком порядке вызываются?

   - Логическим блоком называется код, заключенный в фигурные скобки и не принадлежащий ни одному методу текущего класса

   - **Свойства**

   - Instance Initialization Blocks run every time a new instance is created.

   - The Instance Initialization Block is invoked after the parent class constructor is invoked (i.e. after super () constructor call)

   - Вызываются по порядку написания

   - Логический блок может быть объявлен со спецификатором static. В этом случае он вызывается только один раз в жизненном цикле приложения при создании объекта или при обращении к статическому методу (полю) данного класса

   - ```java
    // Parent Class 
     class B 
     { 
       B() 
       { 
         System.out.println("B-Constructor Called"); 
       } 
      
       { 
         System.out.println("B-IIB block"); 
       } 
      
     } 
      
     // Child class 
     class A extends B 
     { 
       A() 
       { 
         super(); 
         System.out.println("A-Constructor Called"); 
       } 
       { 
         System.out.println("A-IIB block"); 
       } 
        
       // main function 
       public static void main(String[] args) 
       { 
         A a = new A(); 
       } 
     } 
     ```
   
     Output:

     ​	I. Instance Initialization Block of super class
    ​	II. Constructors of super class
     ​	III. Instance Initialization Blocks of the class
     ​	IV. Constructors of the class
   
8.  Что представляют собой методы с переменным числом параметров, как передаются параметры в такие методы и что представляет собой такой параметр в методе? Как осуществляется выбор подходящего метода, при использовании перегрузки для методов с переменным числом параметров?

   - ```java
     int compare(int[]several_arr... args){}
     ```

   - Набор объектов, переданный в такой метод, преобразуется в массив с типом и именем, которые указаны в качестве параметров метода.

   - Недопустимый способ: 

     ```java
     void methodName(Integer ... args) { }
     void methodName(Integer[ ] args) { }
     ```

   - Да, можно. Но, при условии, что выполняются следующие правила:

     - объявление аргументов (параметров) переменной длины может следовать после объявления обычных аргументов;
     - аргументы переменной длины должны указываться в методе только один раз;
     - не допускается смешанная очередность следования обычных аргументов с аргументами переменной длины.

   - как и обычно в  [3 вопросе](#Вот-порядок-самого-ленивого-пути-к-исполнению ) ответ

   - без аргументов с **varargs** примитивами оно идет по возрастанию первого пункта из 3 вопроса

       If more than one member method is both accessible and applicable to a method invocation, it is necessary to choose one to provide the descriptor for the run-time method dispatch. The Java programming language uses the rule that the most specific method is chosen according to type promotion. The following rules define the direct supertype relation among the primitive types in this case:

     ![Screenshot_3](C:\Users\isahe\IdeaProjects\img\Screenshot_3.png)

   - Еще вот:

     There are 3 phases used in overload resolution: First phase performs overload resolution without permitting boxing or unboxing conversion, Second phase performs overload resolution while allowing boxing and unboxing and Third phase allows overloading to be combined with variable arity(var args) methods, boxing, and unboxing. If no applicable method is found during these phases, then ambiguity occurs.

9. Чем является класс **Object**? Перечислите известные вам методы класса Object, укажите их назначение.

   - родителем всех классов

   - Ссылочная переменная типа **Object** может указывать на объект любого другого класса, на любой массив, так как массивы реализуются как классы

     protected **Object clone()** — создает и возвращает копию вызывающего объекта; 

     **public boolean equals(Object ob)** — предназначен для использования и переопределения в подклассах с выполнением общих соглашений о сравнении содержимого двух объектов одного и того же типа;

     **public Class getClass()** — возвращает объект типа Class; 

     **protected void finalize()** — автоматически вызывается сборщиком мусора (garbage collection) перед уничтожением объекта; 

     **public int hashCode()** — вычисляет и возвращает хэш-код объекта (число, в общем случае вычисляемое на основе значений полей объекта); 

     **public String toString()** — возвращает представление объекта в виде строки

10.  Что такое хэш-значение? Объясните, почему два разных объекта могут сгенерировать одинаковые хэш-коды?

    - Если очень просто, то хеш-код — это число. На самом деле просто, не так  ли? Если более точно, то это битовая строка фиксированной длины,  полученная из массива произвольной длины
    - Хеш по определению не может не иметь потенциальных коллизий, т.к.  мощность множества хешей заведомо меньше мощности множества вариантов  того что хешируется.

11.  Что такое объект класса Class? Чем использование метода getClass() и последующего сравнения возвращенного значения с Type.class отличается от использования оператора instanceof?

    ![Screenshot_4](C:\Users\isahe\IdeaProjects\img\Screenshot_4.png)

    - `instanceof` проверяет, является ли ссылка на объект с левой стороны (LHS) экземпляром типа с правой стороны (RHS) ***или каким-либо подтипом*** .
    - `getClass() == тип.class` проверяет, идентичны ли типы.

    

12.  Укажите правила переопределения методов **equals(), hashCode() и toString().**

При переопределении метода equals() должны выполняться соглашения, предусмотренные спецификацией языка Java, а именно:

- Рефлексивность — объект равен самому себе; 

- Cимметричность— если x.equals(y) возвращает значение true, то и y.equals(x) всегда возвращает значение true;

- Транзитивность — если метод equals() возвращает значение true при сравнении объектов x и y, а также y и z, то и при сравнении x и z будет возвращено значение true; 

- Непротиворечивость — при многократном вызове метода для двух не подвергшихся изменению за это время объектов возвращаемое значение всегда должно быть одинаковым; 

- Ненулевая ссылка при сравнении с литералом null всегда возвращает значение false. При создании информационных классов также рекомендуется переопределять методы hashCode() и toString(), чтобы адаптировать их действия для создаваемого типа.

  

Метод **hashCode()** возвращает хэш-код объекта, вычисление которого управляется следующими соглашениями: 

- Все одинаковые по содержанию объекты одного типа должны иметь одинаковые хэш-коды;
- Различные по содержанию объекты одного типа могут иметь различные хэш-коды;
- Во время работы приложения значение хэш-кода объекта не изменяется, если объект не был изменен

Метод **toString()** следует переопределять таким образом, чтобы, кроме стандартной информации о пакете (опционально), в котором находится класс, и самого имени класса (опционально), он возвращал значения полей объекта, вызвавшего этот метод (т. е. всю полезную информацию объекта)