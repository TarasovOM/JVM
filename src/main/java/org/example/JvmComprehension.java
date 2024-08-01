package org.example;

public class JvmComprehension {

    public static void main(String[] args) {
        int i = 1;                      // 1 При вызове Main создается фрейм в стеке, сюда помещается int i = 1.
                                         //   В Metaspase помещаются данные о классе class JvmComprehension
        Object o = new Object();        // 2 В стек помещается ссылка "о" на объект Object, который в куче.
        Integer ii = 2;                 // 3 ссылка ii помещается в фрейм main, объект Integer - в кучу.
        printAll(o, i, ii);             // 4 Создается новый кадр в стеке. Сюда передается ссылки на объект "о" и "ii", копируется примитив "i".
                                        // т.е. примитивы будут и в фрейме main и фрейме printAll.

        System.out.println("finished"); // 7 Создается новый фрейм.
    }                                   // метод заверщился.Фрейм очищается. Сборщик мусора удаляет объекты.

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 Создаем ссылку(хранится в фрейме printAll) на объект Integer(хранится в куче)
        System.out.println(o.toString() + i + ii);  // 6 Создается новый кадр в стеке, куда передаются ссылки "o","ii", i копируется и помещается в новый кадр
                                                     //После завершения метода фрейм очищается. Ссылка uselessVar удалается. Объект Integer удаляется сборщиком мусора.
    }
}