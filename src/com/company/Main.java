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
		int mas[] = new int[n];//создаем  массив размером n
		while (!"6".equals(s)){
			System.out.println("Меню :");
			System.out.println("1. Для заполнения массива вручную введите 1");
			System.out.println("2. Для заполнения массива рандомными числами введите 2");
			System.out.println("3. Для поиска количества чисел массива больше заданного введите 3");
			System.out.println("4. Для сортировки массива по возрастанию методом вставки нажмите 4");
			System.out.println("5. Для вывода массива на экран нажмите 5");
			System.out.println("6. Для выхода из приложения введите 6");
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
				case 5:
					outArray(mas);

			}
		}
		System.out.println("До свидания!");


    }
	public static void inpArray(int arr[]){

		Scanner in = new Scanner(System.in);
		System.out.println("Заполните массив");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = in.nextInt();// заполняем массив с клавиатуры
		}
	}
	public static void Zadanie2(int arr[]){
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
	public static void randomArr(int arr[]){

		// create random object
		Random rand = new Random();
		for(int i=0;i<arr.length;i++){
			arr[i]=rand.nextInt(100);
			System.out.println(arr[i]);
		}

	}
	public static void insertionSort2(int[] arr)
	{
		int i, j, t;
		for (i = 0; i < arr.length; i++)
		{
			t = arr[i];
			for (j =i-1; j >=0 && arr[j] > t; j--) arr[j + 1] = arr[j];
			arr[j + 1] = t;
		}
	}
	public static void outArray(int arr[]){


		for(int i=0;i<arr.length;i++){

			System.out.println(arr[i]);
		}
	}


}

