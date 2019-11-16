package com.company;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Zadanie1 {
    private String Text = "";
    //static public final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    private String[] paragraphs;
    private String[] f;

    public  Zadanie1(){
        this.Text="Text";
    }

    public String getText(){
        return Text;
    }
    public void setText(String Text){
        this.Text=Text;
    }

    public String[] prt(){
        paragraphs = Text.split("(?<=[!.?])");
        return paragraphs;
    }

    public LinkedList<String> toUpper() {
        paragraphs = Text.split("(?<=[!.?])");
        String temp="";
        LinkedList<String> lst = new LinkedList<String>();
        for(int i=0;i<paragraphs.length;i++){
            temp = "";
            f=paragraphs[i].split(" ");
            if(i==0) {
                f[0] = f[0].toUpperCase();
            }
            else{
                f[1]=f[1].toUpperCase();
            }
            f[f.length-1]=f[f.length-1].toUpperCase();

            for(int j=0;j<f.length;j++){
                temp = temp.concat(f[j] + " ");
            }

            lst.add(temp);
        }
        return lst;
    }

        int understringcount(int a) {
            int scount = 0;
            paragraphs = Text.split("(?<=[!.?])");
            f = paragraphs[a].split("\\s");
            for (int j = 0; j < f.length - 1; j++) {
                boolean isContain = f[j].contains("ам");
                if (isContain == true) {
                    scount++;
                }
            }
            return scount;
        }

    String stringcount(int a){
        paragraphs = Text.split("(?<=[!.?])");
        int count=paragraphs[a].split(" ").length;
        if(a>0) {
            count=count-1;
        }
        String howmuchwords = "Количество слов в предложении = " + count;
        return howmuchwords;
    }

    int paragraphscount(){
        paragraphs = Text.split("(?<=[!.?])");
        int b=paragraphs.length;
        return b;
    }








}
