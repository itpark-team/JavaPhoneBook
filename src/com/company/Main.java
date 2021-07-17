package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static class Record {
        public String PhoneNumber;
        public String PersonName;
        public String Description;

        public Record(String phoneNumber, String personName, String description) {
            PhoneNumber = phoneNumber;
            PersonName = personName;
            Description = description;
        }
    }

    public static Record[] createArray(int length) {
        return new Record[length];
    }

    public static Record getEmptyRecord() {
        return new Record("", "", "");
    }

    public static void clearArray(Record[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = getEmptyRecord();
        }
    }

    public static void setElement(Record[] array, int index, Record value) throws Exception {
        if (index < 0 || index > array.length - 1) {
            throw new Exception("Выход за границы массивы");
        }

        array[index] = value;
    }

    public static Record getElement(Record[] array, int index) throws Exception {
        if (index < 0 || index > array.length - 1) {
            throw new Exception("Выход за границы массивы");
        }

        return array[index];
    }

    public static void PrintSingleRecord(Record value) {
        System.out.printf("tel:%s name:%s descr:%s", value.PhoneNumber, value.PersonName, value.Description);
    }

    public static void PrintAllRecordsAsTable(Record[] array) {
        if(array==null){
            System.out.println("list is empty");
            System.out.println("-------");
            return;
        }

        System.out.printf("%-4s%-14%-12s%s\n", "#", "tel", "name", "description");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%-4s%-14%-12s%s\n", i, array[i].PhoneNumber, array[i].PersonName, array[i].Description);
        }
        System.out.println("-------");
    }

    public static void SeedArray(Record[] array) {

        Random random = new Random();

        String[] tels = new String[]{"+79991112233", "+79991112244", "+79991112255", "+79991112266", "+79991112277", "+79991112288", "+79991112299", "+79991112200",};

        String[] names = new String[]{"ivan", "victor", "bolvan", "petr", "pavel"};

        String[] desrs = new String[]{"ne zvonit", "dolgen deneg", "one love", "cool man"};

        for (int i = 0; i < array.length; i++) {

            String tel = tels[random.nextInt(tels.length)];
            String name = names[random.nextInt(names.length)];
            String descr = desrs[random.nextInt(desrs.length)];

            array[i] = new Record(tel, name, descr);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int action = -1;
        boolean isRun = true;
        Record[] array = null;

        while (isRun){


            System.out.println("Меню:");
            System.out.println("1. Создать записную книжку");
            System.out.println("2. Обнулить записную книжку");
            System.out.println("3. Заполнить массив случайными значениями");
            System.out.println("5. Добавить элемент в конец массива");
            System.out.println("6. Добавить элемент в указанный индекс");
            System.out.println("7. Удалить элемент по указанному индексу");
            System.out.println("0. Выход");
        }
    }
}
