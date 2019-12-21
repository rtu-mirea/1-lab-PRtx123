package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class SerializableFile {
    private String fileName;

    public SerializableFile(String fileName) throws IOException {
        var f = new File(fileName);
        f.createNewFile();
        this.fileName = fileName;

    }

    public void write(LinkedList<Leader> users) throws Exception {
        var out = new ObjectOutputStream(new FileOutputStream(fileName));
        for (Leader leader: users){
            out.writeObject(leader);
        }
        out.close();
    }

    public Leader readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        Leader leader = (Leader) in.readObject();
        in.close();
        return leader;
    }


    public LinkedList<Leader> readCollection() throws IOException {
        var in = new ObjectInputStream(new FileInputStream(fileName));
        var tempList = new LinkedList<Leader>();
        try {
            while (true) {
                tempList.add((Leader) in.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
        }
        return tempList;
    }


}
