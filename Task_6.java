/*Java: знакомство и как пользоваться базовым API (семинары)
Урок 6. Хранение и обработка данных ч3: множество коллекций Set

Задание:
Разработать программу, имитирующую поведение коллекции HashSet. В программе содать метод add добавляющий элемент, метод toString возвращающий строку с элементами множества и метод позволяющий читать элементы по индексу.
*Реализовать все методы из семинара.
Формат данных Integer.

Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  05.07.2023.
 */

package org.example;

import java.util.HashMap;
import java.util.Random;
import java.util.Iterator;

public class Task_6 {

    public static void main(String[] args) {

        SetImitation setImitation = new SetImitation();

        for (int i = 0; i < 20; i++) { // Наполнение коллекции набором случайных чисел
            setImitation.add(new Random().nextInt(1000));
        }

        System.out.println(setImitation.toString()); // Вывод значений коллекции в строку

        System.out.println(setImitation.size()); // Вывод длины коллекции

        System.out.println(setImitation.delete(9)); // Удаление номера 9 (true)

        System.out.println(setImitation.delete(9)); // Удаление номера 9 - нет такого (false)

        System.out.println(setImitation.size()); // Опять вывод длины коллекции

        System.out.println(setImitation.isEmpty()); // Проверка длины коллекции на 0 (false)

        System.out.println(setImitation.contains(2)); // Проверка коллекции на наличие элемента с индексом 2 (true)

        Iterator<Integer> iterator = setImitation.iterator(); // Вывод значений всей коллекции в столбец с нумерацией от
                                                              // 0
        int i = 0;
        while (iterator.hasNext()) {
            int item = iterator.next();
            System.out.println(i + ") " + item);
            i += 1;
        }
        System.out.println();

        System.out.println("3) " + setImitation.getElementByIndex((3))); // Вывод элементов коллекции под индексами 3 и
                                                                         // 10 (с нумерацией)
        System.out.println("10) " + setImitation.getElementByIndex((10)));
    }
}

class SetImitation<E> {
    private HashMap<E, Object> map = new HashMap<>(); // Объект класса HashMap
    private static final Object OBJECT = new Object(); // Константа

    public boolean add(E num) { // Метод по добавлению элемента к коллекции
        return map.put(num, OBJECT) == null;
    }

    public boolean delete(E num) { // Метод по удалению элемента из коллекции по индексу
        return map.remove(num, OBJECT);
    }

    public int size() { // Метод по подсчету длины
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    } // Метод по проверке на пустоту

    public boolean contains(Object num) {
        return map.containsKey(num);
    } // Метод по проверке на наличие индекса

    public Iterator<E> iterator() {
        return map.keySet().iterator();
    } // Переменная типа итератор

    public E getElementByIndex(int num) { // Метода по извлечению элемента по его индексу
        E[] mapArray = (E[]) map.keySet().toArray();
        return mapArray[num];
    }

    public String toString() { // Метод по выводу всего содержимого коллекции в виде строки
        E[] mapArray = (E[]) map.keySet().toArray();
        return map.keySet().toString();
    }
}
/*
 * Пример применения:
 * [128, 163, 867, 837, 325, 647, 519, 235, 45, 813, 655, 948, 949, 474, 477,
 * 317, 798, 351, 799, 767]
 * 20
 * false
 * false
 * 20
 * false
 * false
 * 0) 128
 * 1) 163
 * 2) 867
 * 3) 837
 * 4) 325
 * 5) 647
 * 6) 519
 * 7) 235
 * 8) 45
 * 9) 813
 * 10) 655
 * 11) 948
 * 12) 949
 * 13) 474
 * 14) 477
 * 15) 317
 * 16) 798
 * 17) 351
 * 18) 799
 * 19) 767
 * 
 * 3) 837
 * 10) 655
 */