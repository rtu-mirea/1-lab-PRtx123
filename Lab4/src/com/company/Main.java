package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in  = new Scanner(System.in);
        //Упражнение 1
        try {
            //•	Создать файл в папке приложения с именем MyFile1.txt.
            File firstfile = new File("MyFile1.txt");
            firstfile.createNewFile();
            //•	Проверить появление файла в папке приложения.
            if (firstfile.exists()) {
                System.out.println("Путь к файлу: "+firstfile.getAbsolutePath());
            }
            else {
                System.out.println("Файла не существует");
            }

            //•	Создать файл с именем MyFile2.txt в корне определенного диска.
            File secondfile = new File("/MyFile2.txt");
           // secondfile.createNewFile();
            //•	Проверить появление файла в папке.
            System.out.println("Файл №2:");
            if (secondfile.exists())
                System.out.println(secondfile.getAbsolutePath());
            else
                System.out.println("Файла не существует");

            //•	Создать файл с именем MyFile3.txt в папке Имя диска\\Имя папки\\Имя файла.
            File thirdfile=new File("D:\\JavaLabTest","MyFile3.txt ");
            //thirdfile.createNewFile();
            if (thirdfile.exists()) {
                System.out.println("Путь к файлу: "+thirdfile.getAbsolutePath());
            }
            else {
                System.out.println("Файла не существует");
            }

            //•	Создать папку третьего уровня, например, Первая\\Вторая\\Третья
            File dir = new File("first\\second\\third");
            dir.mkdirs();
            if (dir.isDirectory()){
                System.out.println(dir.getAbsolutePath());
            }
            else System.out.println("папки не существует");

            //Упражнение 2
            //•	Проверить, что вызывающий объект содержит имя файла, а не папки и
            //отобразить имя файла, вызывающего объекта и его родительскую папку.
            if (firstfile.isFile()){
                System.out.println("Вызывающий объект является файлом" + '\n' +
                        "имя: " + thirdfile.getName() + '\n' +
                        "родительская папка: " + thirdfile.getParent());
            }
            else System.out.println("не файл");

            //•	Проверить, что вызывающий объект содержит имя папки
            if (dir.isDirectory()){
                System.out.println("Папка\n" +
                        "Имя: " + dir.getName());
            }
            else System.out.println("не папка");

            //•	Проверить, что в папке приложения существует файл с именем MyFile1.txt.
            //•	Отобразить полный путь к файлу или папке объекта.
            if (firstfile.exists())
                System.out.println("Файл " + firstfile.getName() + " существует в папке приложения");
            else
                System.out.println("Файл MyFile1.txt не существует в папке проекта");
            System.out.println("Полный путь файла " + firstfile.getName() + ": " + firstfile.getAbsolutePath());

            //•	Отобразить размер файла или папки объекта, указать единицу измерения.
            // Прокомментировать вид файла – папка или файл.
            if (firstfile.isFile())
                System.out.println(firstfile.getName() +" - Файл размером " + firstfile.length()+" байт");
            else if (firstfile.isDirectory())
                System.out.println(firstfile.getName() +" - Папка размером " + firstfile.length()+" байт");
            else System.out.println("Данный оъект не является ни папкой, ни файлом");

            //Упражнение 3

           // 1.	Добавить в папку приложения еще одну папку.
            File dir1=new File("folder");
            dir1.mkdir();
            //2.	Сформировать массив файлов, находящихся в папке приложения, используя метод list().
            // Отобразить содержимое массива.
            File dir2=new File("C:\\Users\\sidor\\IdeaProjects\\Lab4");
            String ext[]=dir2.list();
            for (String str: ext){
                System.out.println(str);
            }
            //3.	Сформировать массив файлов, находящихся в папке приложения, используя метод listFiles( ).
            // Отобразить содержимое массива. Определить количество папок, содержащихся в файле приложения.
            int count = 0;
            File ext2[] = dir2.listFiles();
            for(File file: ext2){
                System.out.println(file);
                if(file.isDirectory()) count++;
            }
            System.out.println("Количество папок " + count);
            //4.	Удалить папки и файлы созданные во всех трех упражнениях
            firstfile.delete();
            secondfile.delete();
            thirdfile.delete();
            dir.delete();
            dir = new File(dir.getParent());
            dir.delete();
            dir = new File(dir.getParent());
            dir.delete();
            dir1.delete();

        }
        catch (IOException e){
            System.out.println(e.toString());
        }


    }
}

