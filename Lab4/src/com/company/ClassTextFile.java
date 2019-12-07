package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassTextFile {

    private String fileName;

    public ClassTextFile(){
        fileName = "";
    }
    public ClassTextFile(String name) throws IOException {
        if(new File(name).exists())
            fileName = name;
        else throw new IOException();
    }

    public Request input() throws IOException{
        var in = new Scanner(new File(fileName));
        return new Request(in.nextLine(), in.nextInt(), in.nextInt(), in.nextInt());
    }
}
