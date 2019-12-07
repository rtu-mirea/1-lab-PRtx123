package com.company;

import java.io.File;
import java.io.IOException;

public class Task2 {

    public static void main(String[] args) {
        try {
            File newFile = FileConstructor.createFile();
            FileConstructor.fileOutput(newFile);
            FileConstructor.fileInput(newFile);
            File nextFile = FileConstructor.makeNewTestsFile(newFile);
            FileConstructor.changeMark(nextFile);
        } catch (
                IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
