package com.company;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class FileConstructor {

    private static LinkedList<Mark> unsatisfact = new LinkedList<>();

    static File createFile() throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя файла:");
        File output = new File(String.format("%s.bin", in.nextLine()));
        output.createNewFile();
        System.out.println(String.format("\"Файл с названием %s существует\" %b", output.getName(), output.exists()));
        return output;
    }

    static void fileOutput(File output) throws IOException {
        Scanner in = new Scanner(System.in);

        DataOutputStream out = new DataOutputStream(new FileOutputStream(output));

        System.out.println("Введите дисциплины  через ';'");
        String[] works = in.nextLine().split(";");

        for (String work : works) {
            System.out.println("Введите информацию зачете " + work + " в следующем виде:\nНомер зачетной книжки\nШифр группы" +
                    "\nДата получения оценки\nОценка\nФамилия преподавателя");
            int number = in.nextInt();
            in.nextLine();
            String cipher = in.nextLine();
            int date = in.nextInt();
            in.nextLine();
            int mark = in.nextInt();
            String teachersurname = in.nextLine();

            Mark syl = new Mark(number,cipher, work, date, mark, teachersurname);

            out.writeInt(syl.getNumber());
            out.writeUTF(syl.getCipher());
            out.writeUTF(syl.getDiscipline());
            out.writeInt(syl.getDate());
            out.writeInt(syl.getMark());
            out.writeUTF(syl.getTechersurname());
            out.flush();
        }
        out.close();
    }

    static void fileInput(File input) throws IOException {
        DataInputStream inp = new DataInputStream(new FileInputStream(input));
        LinkedList<Mark> marks = new LinkedList<>();

        //Считывание информации о зачетах и создание их в списке
        while (true) {
            try {
                Mark S = new Mark(inp.readInt(), inp.readUTF(), inp.readUTF(), inp.readInt(), inp.readInt(), inp.readUTF());
                marks.add(S);
            } catch (EOFException e) {
                inp.close();
                break;
            }
        }

        // //Выбор тех студентов, у которые получили неуд, и занесение их в новый список
        for (Mark mark : marks) {
            if (mark.getMark() == 2)
                unsatisfact.add(mark);
        }
    }

    static File makeNewTestsFile(File source) throws IOException {
        //Создание нового файла для хранения нового, отсортированного списка
        File destination = new File(source.getName().replace(".bin", "") + "_Sorted.bin");
        destination.createNewFile();

        //Создание потоков для чтения и записи
        RandomAccessFile rStream = new RandomAccessFile(source, "r");
        RandomAccessFile wStream = new RandomAccessFile(destination, "rw");
        int number, date, mark;
        String cipher, discipline, teachersurname;

        while (true) {
            try {
                //Считывание информации о тесте из файла
                number = rStream.readInt();
                cipher = rStream.readLine();
                discipline = rStream.readLine();
                date = rStream.readInt();
                mark = rStream.readInt();
                teachersurname = rStream.readUTF();

                //Если такой тест находится в списке отсортированных тестов, записываем его в файл
                for (Mark original : unsatisfact) {
                    if (original.getNumber() == number && original.getCipher() == cipher &&
                            original.getDiscipline() == discipline && original.getDate() == date &&
                            original.getMark() == mark && original.getTechersurname().equals(teachersurname)) {
                        wStream.writeInt(number);
                        wStream.writeUTF(String.format("%-20s", cipher));
                        wStream.writeUTF(String.format("%-20s", discipline));
                        wStream.writeInt(date);
                        wStream.writeInt(mark);
                        wStream.writeUTF(String.format("%-20s", teachersurname)); //Форматирование сроки пробелами справа так,
                        //чтобы она занимала 20 символов
                    }
                }
            } catch (EOFException e) {
                rStream.close();
                wStream.close();
                break;
            }

        }
        return destination;
    }

    static void changeMark(File subject) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите новую оценку:");
        int n = in.nextInt();
        int m = 1;

        if (n < 0) {
            throw new IOException("A number can't be less than zero!");
        }
        else {
            RandomAccessFile rwStream = new RandomAccessFile(subject, "rw");
            while (true) {
                try {
                    rwStream.readInt();//С помощью чтения реализовано передвижение по файлу
                    rwStream.readUTF();
                    rwStream.readInt();
                    rwStream.readInt();
                    rwStream.writeInt(n);
                    rwStream.readUTF();

                    if(m==n){
                        rwStream.writeUTF("changed by user");
                    }
                    else {
                        rwStream.readUTF();
                    }
                    rwStream.readUTF();
                    m+=1;
                } catch (EOFException e) {
                    rwStream.close();
                    break;
                }
            }
        }
    }
}
