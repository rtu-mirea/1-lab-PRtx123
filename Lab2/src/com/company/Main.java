package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x=0;
        String s="";
        //r.setText("Всем привет! Я приложение, написанное на Java. Можете меня починить?");
            int num = 0;
            while (num != 4) {
                System.out.println("Выберите задание:");
                System.out.println("1. Задание 1");
                System.out.println("2. Задание 2");
                System.out.println("3. Задание 3");
                System.out.println("4. Выход");
                num = in.nextInt();
                switch (num) {
                    case 1:
                        zadanie1();
                        break;
                    case 2:
                        zadanie2();
                        break;
                    case 3:
                        zadanie3();
                        break;
                    case 4:
                        break;
                }

            }
        }


    public static void zadanie1(){
        System.out.println("Введите текст, состоящий из предложений, оканчивающихся на .!?");
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        Zadanie1 r=new Zadanie1();
        r.setText(s);
        System.out.println("Текст, разделённый на абзацы:");
        for(String tm:r.prt()){
            System.out.println(tm);
        }

        System.out.println("Выберите абзац, количество подстрок 'ам' в котором хотите посчитать:");
        int pr=0;
        pr = in.nextInt();
        if(pr>r.paragraphscount()){ System.out.println("В тексте нет такого абзаца!"); }
        else{System.out.println("Количество слов с подстрокой 'ам' = "+ r.understringcount(pr)); }

        System.out.println("Текст, разделённый на абзацы, с каждым первым и последним словом прописными буквами:");
        for(String temp:r.toUpper()) {
            System.out.println(temp);
        }

        System.out.println("Выберите предложение в котором хотите подсчитать количество слов");
        int rp=0;
        rp = in.nextInt();
        System.out.println(r.stringcount(rp));

    }

    public static void zadanie2(){
        System.out.println("Введите текст, состоящий из предложений, оканчивающихся на .!?");
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        Zadanie2 t=new Zadanie2();
        t.setText(s);

        System.out.println("Текст, разделённый на абзацы:");
        System.out.println(t.paragpaphbuffer()+"\n");

        System.out.println("Текст, разделённый на абзацы, с каждым первым и последним словом прописными буквами:");
        System.out.println(t.toUpper2()+"\n");

        System.out.println("Добавить в текст текст вида: Количество предложений в тексте = укажите их число.");
        System.out.println(t.add()+"\n");

    }

    public static void zadanie3(){
        Scanner in = new Scanner(System.in);
        Zadanie3 f=new Zadanie3();
        System.out.println("Введите строку, состоящую из цифр ");
        String s = in.nextLine();
        if(f.match(s)==true){
            System.out.println("Строка состоит из 2 одинаковых цифр.");
        }
        else{
            System.out.println("Строка не состоит из 2 одинаковых цифр.");
        }

        f.setText("Пример текста 11 с двумя одинаковыми цифрами 22 23");
        System.out.println("Исходный текст : "+f.getText());
        System.out.println("Текст с заменой двух одинаковых цифр на '*': "+f.replacement());


    }

}
