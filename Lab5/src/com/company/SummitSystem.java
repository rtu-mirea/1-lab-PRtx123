package com.company;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class SummitSystem {
    static LinkedList<Leader> users = new LinkedList<Leader>();
    static Leader currentUser;

    public static boolean signIn(String login, String password){
        Leader tempUser;
        try {
            tempUser = findUser(login, password);
        }
        catch (RuntimeException e) {
            return false;
        }

        currentUser = new Leader(tempUser.getName(), login, password);
        System.out.println("Вход успешно выполнен!");
        return true;
    }

    public static void addUser(Leader tempUser){
        users.add(tempUser);
    }

    // used to login
    public static Leader findUser(String login, String password){
        Leader tempUser;
        Iterator<Leader> iter = users.iterator();
        while (iter.hasNext()){
            tempUser = iter.next();
            if (tempUser.enter(login, password)){
                return tempUser;
            }
        }
        throw new RuntimeException();
    }

    public static LinkedList<Request> checked(Request temp, LinkedList<Request> usersRequests){
        var goodRequests = new LinkedList<Request>();
        var iter = usersRequests.iterator();
        Request tempRequest;
        while (iter.hasNext()){
            tempRequest = iter.next();
            if (temp.getMonth() == tempRequest.getMonth() && temp.getCountry() == tempRequest.getCountry()){
                var isGoodStime = tempRequest.getStarDay() >= temp.getStarDay();
                var isGoodEtime = tempRequest.getEndDay() <= temp.getEndDay();
                if (isGoodEtime && isGoodStime){
                    goodRequests.add(tempRequest);
                }
            }
        }
        return goodRequests;
    }

    public static LinkedList<Request> processRequests(){
        Leader tempUser;
        var tempRequests = new LinkedList<Request>();
        var currentRequests = new LinkedList<Request>();
        var usersRequests = new LinkedList<Request>();
        currentRequests = currentUser.getRequests();
        var iter = users.iterator();
        while (iter.hasNext()){
            tempUser = iter.next();
            usersRequests = tempUser.getRequests();

            for (int i = 0; i < currentRequests.size(); i++){
                tempRequests.addAll(checked(currentRequests.get(i), usersRequests));
            }

        }
        return tempRequests;
    }

    public static void loadUsers(String fileName) throws IOException {
        var file = new SerializableFile(fileName);
        users = file.readCollection();
    }

    public static LinkedList<Leader> getUsers() {
        return users;
    }
}