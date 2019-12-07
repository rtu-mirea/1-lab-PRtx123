package com.company;

import java.io.Serializable;
import java.util.List;

public class Mark implements Serializable {
    private int number;
    private String cipher;
    private String discipline;
    private int date;
    private int mark;
    private String techersurname;

    Mark(int number,String cipher,String discipline,int date,int mark,String techersurname) {
        this.number=0;
        this.cipher=cipher;
        this.discipline=discipline;
        this.date=0;
        this.mark=0;
        this.techersurname=techersurname;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void setTechersurname(String techersurname) {
        this.techersurname = techersurname;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getCipher() {
        return cipher;
    }

    public String getDiscipline() {
        return discipline;
    }

    public int getDate() {
        return date;
    }

    public int getMark() {
        return mark;
    }

    public String getTechersurname() {
        return techersurname;
    }



    public boolean same (Mark b1, Mark b2) {
        if (b1.mark == b2.mark && b1.discipline==b2.discipline && b1.date == b2.date) {
            return true;
        }
        else {
            return false;
        }
    }
}
