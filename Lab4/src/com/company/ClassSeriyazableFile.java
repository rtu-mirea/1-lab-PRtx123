package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassSeriyazableFile {

    private String fileName;
    private ArrayList<Request> requests = new ArrayList<Request>();

    public ClassSeriyazableFile(String fileName) throws IOException {
        var f = new File(fileName);
        f.createNewFile();
        this.fileName = fileName;

    }

    public void write(Request object) throws Exception{
        var out = new ObjectOutputStream(new FileOutputStream(fileName));
        out.writeObject(object);
        out.close();
    }

    public Request readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        Request request = (Request) in.readObject();
        in.close();
        return request;
    }

    public ArrayList<Request> makeList(int n)throws IOException{
        var out = new ObjectOutputStream(new FileOutputStream(fileName));
        var tempList = new ArrayList<Request>();
        var in = new Scanner(System.in);
        int x = in.nextInt();
        in.nextLine();

        for (int i = 0; i < x; i++){
            tempList.add(new Request(in.nextLine(), in.nextInt(), in.nextInt(), in.nextInt()));
            in.nextLine();
            out.writeObject(tempList.get(i));
        }

        out.close();
        return tempList;
    }

    public void readCollection() throws IOException {
        var in = new ObjectInputStream(new FileInputStream(fileName));
        var tempList = new ArrayList<Request>();
        try{
            while(true){
                tempList.add((Request) in.readObject());
            }
        }
        catch (IOException | ClassNotFoundException e){}
        this.requests = tempList;
    }

}
