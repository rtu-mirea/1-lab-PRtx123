package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

    	int x=0;
    	String s="";
		Scanner in = new Scanner(System.in);
		System.out.print("Введите длину массива: ");
		int n= in.nextInt();
		short mas[] = new short[n];//создаем  массив размером n
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
			if(x>5||x<1){
				System.out.println("Неверный ввод");
			}
			switch (x){
				case 1:
					inpArray(mas);
					break;
				case 2:
					randomArr(mas);
					break;
				case 3:
					Zadanie2(mas);
					break;
				case 4:
					insertionSort2(mas);
					System.out.println("Отсортированный массив:");
					outArray(mas);
					break;
				case 5:
					outArray(mas);
					break;
				case 6:
					reverseArray(mas);
					break;

			}
		}
		System.out.println("До свидания!");


    }
	public static void inpArray(short arr[]){

		Scanner in = new Scanner(System.in);
		System.out.println("Заполните массив");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextShort();// заполняем массив с клавиатуры
		}
	}
	public static void Zadanie2(short arr[]){
    	int b=0;
		Scanner in = new Scanner(System.in);
		System.out.print("Введите число: ");
		int a = in.nextInt();
		for(int i = 0;i<arr.length;i++){
			if(arr[i]>a){
				b++;
			}
		}
		if(b==0){
			System.out.print("Нет чисел больше данного ");
		}
		System.out.println("Количетсво чисел больше заданного: "+b);

	}
	public static void randomArr(short arr[]){

		// create random object
		Random rand = new Random();
		for(int i=0;i<arr.length;i++){
			//arr[i]=rand.nextInt(10);
			arr[i] = (short) ( Math.random() * 100);
			System.out.println(arr[i]);
		}

	}
	public static void insertionSort2(short [] arr)
	{
		int i, j;
		short t;
		for (i = 0; i < arr.length; i++)
		{
			t = arr[i];
			for (j =i-1; j >=0 && arr[j] > t; j--) arr[j + 1] = arr[j];
			arr[j + 1] = t;
		}
	}
	public static void outArray(short arr[]){


		for(int i=0;i<arr.length;i++){

			System.out.println(arr[i]);
		}
	}
	public static void reverseArray(short arr[]){
    	for(int i=arr.length-1;i>=0;i--){
    		System.out.println(arr[i]);
		}
	}


}


