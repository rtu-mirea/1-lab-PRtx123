package com.company;
import java.util.Scanner;

public class Array1 {
    private int n;
    private short arr[];

    public Array1(int n) throws Exception  {
        if (n <= 0) throw new Exception(new String("Количество элементов <=0 "));
        this.n = n;
        this.arr = new short[this.n];
    }

    void consoleInput(){
        System.out.println("Введите " + n + " чисел");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; ++ i)
        {
            arr[i] = in.nextShort();
        }
        //in.close();
    }

    void randInput() {
        for (int i = 0; i < n; i ++){
            arr[i] = (short) (Math.random() * 100);
        }
    }

    void insertionSort2()
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

    void outArray(){


        for(int i=0;i<arr.length;i++){

            System.out.println(arr[i]);
        }
    }

    void Comparsion(){
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

    void reverseArray(){
        for(int i=arr.length-1;i>=0;i--){
            System.out.println(arr[i]);
        }
    }


}
