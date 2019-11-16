package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zadanie3 {
    private String Text;

    public  Zadanie3(){
        this.Text="Text";
    }

    public String getText(){
        return Text;
    }
    public void setText(String Text){
        this.Text=Text;
    }

    public String replacement(){
        Text=Text.replaceAll("(\\d)\\1{1}", "*");
        return Text;

    }
    public boolean match(String f){
        Pattern p=Pattern.compile("^(\\d)\\1{1}$");
        Matcher m = p.matcher(f);
        return m.find();
    }

}
