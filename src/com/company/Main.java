package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {


    	int x=0;
    	String s="";
		int n;
		Scanner in = new Scanner(System.in);
		System.out.print("Введите длину массива: ");
		n  = in.nextInt();
		Array1 mas = new Array1(n);

		while (!"7".equals(s)){
			System.out.println("Меню :");
			System.out.println("1. Для заполнения массива вручную введите 1");
			System.out.println("2. Для заполнения массива рандомными числами введите 2");
			System.out.println("3. Для поиска количества чисел массива больше заданного введите 3");
			System.out.println("4. Для сортировки массива по возрастанию методом вставки нажмите 4");
			System.out.println("5. Для вывода массива на экран нажмите 5");
			System.out.println("6. Для вывода массива в обратном направлении на экран нажмите 6");
			System.out.println("7. Для выхода из приложения введите 7");
			s = in.next();


			try {
				x = Integer.parseInt(s);
			} catch (NumberFormatException e){
				System.out.println("Неверный ввод");
			}
			if(x>7||x<1){
				System.out.println("Неверный ввод");
			}
			switch (x){
				case 1:
					mas.consoleInput();
					break;
				case 2:
					mas.randInput();
					break;
				case 3:
					mas.Comparsion();
					break;
				case 4:

					System.out.println("Исходный массив:");
					mas.outArray();
					mas.insertionSort2();
					System.out.println("Отсортированный массив:");
					mas.outArray();

					break;
				case 5:
					mas.outArray();
					break;
				case 6:
					mas.reverseArray();
					break;

			}
		}
		System.out.println("До свидания!");


    }



}


