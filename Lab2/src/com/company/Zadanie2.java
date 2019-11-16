package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zadanie2 {
    private String Text;
    //static public final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    private String[] paragraphs;
    private String[] f;
    StringBuffer PRT=new StringBuffer();


    public  Zadanie2(){
                this.Text="Text";
    }

    public String getText(){
        return Text;
    }
    public void setText(String Text){
        this.Text=Text;
    }


    public StringBuffer paragpaphbuffer(){
        paragraphs = Text.split("(?<=[!.?])");
        for(int i=0;i<paragraphs.length;i++){
            PRT.append(paragraphs[i]+"\n");
        }
        return PRT;
    }

    public StringBuffer toUpper2() {
        paragraphs = Text.split("(?<=[!.?])");
        String temp="";
        PRT=new StringBuffer("");

        for(int i=0;i<paragraphs.length;i++){
            temp = "";
            f=paragraphs[i].split("\\s");
            if(i==0) {
                f[0] = f[0].toUpperCase();
            }
            else{
                f[1]=f[1].toUpperCase();
            }
            f[f.length-1]=f[f.length-1].toUpperCase();

            for(int j=0;j<f.length;j++){
                temp+=f[j]+" ";
            }
            PRT.append(temp+"\n");
        }
        return PRT;
    }

        public StringBuffer add(){
            String Pol=(" Количество предложений в тексте " + Text.split("(?<=[!.?])").length+".\n");
            PRT.append(Pol);
            return PRT;
        }


}
