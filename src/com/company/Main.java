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

    public static Record getFillRecord() {
        Scanner input = new Scanner(System.in);

        System.out.print("input phone number: ");
        String tel = input.nextLine();

        System.out.print("input name: ");
        String name = input.nextLine();

        System.out.print("input description: ");
        String descr = input.nextLine();

        return new Record(tel, name, descr);
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
            throw new Exception("Выход за границы массива");
        }

        return array[index];
    }

    public static void printSingleRecord(Record value) {
        System.out.printf("tel:%s name:%s descr:%s\n", value.PhoneNumber, value.PersonName, value.Description);
    }

    public static void printAllRecordsAsTable(Record[] array) {
        if (array == null) {
            System.out.println("list is empty");
            System.out.println("-------");
            return;
        }

        System.out.printf("%-4s%-14s%-12s%s\n", "#", "tel", "name", "description");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%-4s%-14s%-12s%s\n", i, array[i].PhoneNumber, array[i].PersonName, array[i].Description);
        }
        System.out.println("-------");
    }

    public static void seedArray(Record[] array) {

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

    public static void printRecordsByPhoneNumber(Record[] array, String partOfPhoneNumber) {
        System.out.printf("%-4s%-14s%-12s%s\n", "#", "tel", "name", "description");
        for (int i = 0; i < array.length; i++) {
            if (array[i].PhoneNumber.contains(partOfPhoneNumber))
                System.out.printf("%-4s%-14s%-12s%s\n", i, array[i].PhoneNumber, array[i].PersonName, array[i].Description);
        }
        System.out.println("-------");
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        int action = -1;
        boolean isRun = true;
        Record[] array = null;

        while (isRun) {
            printAllRecordsAsTable(array);

            System.out.println("Меню:");
            System.out.println("1. Создать и обнулить записную книжку");
            System.out.println("2. Заполнить записную книжку случайными данными");
            System.out.println("3. Вывести человека по индексу");
            System.out.println("4. Задать новые данные человека по индексу");
            System.out.println("5. Поиск по части номера телефона");
            System.out.println("0. Выход");

            System.out.print("Введите номер пункта меню: ");
            action = input.nextInt();

            switch (action) {
                case 1: {
                    System.out.print("Введите количество людей в запискной книжке: ");
                    int count = input.nextInt();

                    array = createArray(count);

                    clearArray(array);
                }
                break;

                case 2: {
                    seedArray(array);
                }
                break;

                case 3: {
                    System.out.print("Введите индекс человека: ");
                    int index = input.nextInt();

                    printSingleRecord(getElement(array, index));
                }
                break;

                case 4: {
                    System.out.print("Введите индекс человека: ");
                    int index = input.nextInt();

                    Record record = getFillRecord();

                    setElement(array, index, record);
                }
                break;

                case 5: {
                    System.out.print("Введите часть номера телефона: ");
                    input.nextLine();
                    String partOfPhoneNumber = input.nextLine();

                    printRecordsByPhoneNumber(array, partOfPhoneNumber);
                }
                break;

                case 0: {
                    isRun = false;
                }
                break;

                default: {
                    System.out.println("Ошибка. Такой команды не существует");
                }
                break;
            }
        }
    }
}
