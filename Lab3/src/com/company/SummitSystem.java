<<<<<<< HEAD
package com.company;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class SummitSystem {
    

    public static void main(String[] args) {
        LinkedList<Leader> users = new LinkedList<Leader>();
        Leader currentUser = null;
        Leader tempUser;
        int numMenu;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1. Добавить пользователя");
            System.out.println("2. Войти");
            System.out.println("3. Найти возможные варианты");
            System.out.println("Выберите номер");
            numMenu = in.nextInt();
            in.nextLine();
            switch (numMenu) {
                case 1: // append user
                    System.out.println("Введите имя, логин и пароль через enter");
                    String name, login, password;
                    name = in.nextLine();
                    login = in.nextLine();
                    password = in.nextLine();
                    addUser(name, login, password,users);
                    System.out.println("Пользователь успешно зарегистрирован");
                    break;
                case 2: // login
                    System.out.println("Введите логин и пароль для входа в систему");
                    login = in.nextLine();
                    password = in.nextLine();
                    try {
                        tempUser = findUser(login, password,users);
                    }
                    catch (RuntimeException e) {
                        System.out.println("Неверные имя или пароль");
                        break;
                    }

                    currentUser = new Leader(tempUser.getName(), login, password);
                    System.out.println("Вход успешно выполнен!");

                    break;
                case 3: // get requests
                    System.out.println(processRequests(currentUser,users).toString());
                    break;
            }

        }
    }

    public static void addUser(String name, String login, String password,LinkedList<Leader> users){
        Leader tempUser;
        tempUser = new Leader(name, login, password);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество предлагаемых встреч");
        int Requestsum = in.nextInt();
        in.nextLine();
        String country;
        int to, end,month;
        for (int i = 0; i < Requestsum; i++) {
            System.out.println("Введите страну, месяц, с какого дня, до какого дня");
            country=in.nextLine();
            month = in.nextInt();
            to = in.nextInt();
            end = in.nextInt();
            in.nextLine();
            tempUser.addRequest(country,month,to, end);
        }
        users.add(tempUser);
    }

    // used to login
    public static Leader findUser(String login, String password,LinkedList<Leader> users){
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
                var isGoodstarttime = tempRequest.getStarDay() >= temp.getStarDay();
                var isGoodendtime = tempRequest.getEndDay() <= temp.getEndDay();
                if (isGoodendtime && isGoodstarttime){
                    goodRequests.add(tempRequest);
                }
            }
        }
        return goodRequests;
    }

    public static LinkedList<Request> processRequests(Leader currentUser,LinkedList<Leader> users){
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
}
=======
package com.company;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class SummitSystem {
    

    public static void main(String[] args) {
        LinkedList<Leader> users = new LinkedList<Leader>();
        Leader currentUser = null;
        Leader tempUser;
        int numMenu;
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("1. Добавить пользователя");
            System.out.println("2. Войти");
            System.out.println("3. Найти возможные варианты");
            System.out.println("Выберите номер");
            numMenu = in.nextInt();
            in.nextLine();
            switch (numMenu) {
                case 1: // append user
                    System.out.println("Введите имя, логин и пароль через enter");
                    String name, login, password;
                    name = in.nextLine();
                    login = in.nextLine();
                    password = in.nextLine();
                    addUser(name, login, password,users);
                    System.out.println("Пользователь успешно зарегистрирован");
                    break;
                case 2: // login
                    System.out.println("Введите логин и пароль для входа в систему");
                    login = in.nextLine();
                    password = in.nextLine();
                    try {
                        tempUser = findUser(login, password,users);
                    }
                    catch (RuntimeException e) {
                        System.out.println("Неверные имя или пароль");
                        break;
                    }

                    currentUser = new Leader(tempUser.getName(), login, password);
                    System.out.println("Вход успешно выполнен!");

                    break;
                case 3: // get requests
                    System.out.println(processRequests(currentUser,users).toString());
                    break;
            }

        }
    }

    public static void addUser(String name, String login, String password,LinkedList<Leader> users){
        Leader tempUser;
        tempUser = new Leader(name, login, password);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество предлагаемых встреч");
        int Requestsum = in.nextInt();
        in.nextLine();
        String country;
        int to, end,month;
        for (int i = 0; i < Requestsum; i++) {
            System.out.println("Введите страну, месяц, с какого дня, до какого дня");
            country=in.nextLine();
            month = in.nextInt();
            to = in.nextInt();
            end = in.nextInt();
            in.nextLine();
            tempUser.addRequest(country,month,to, end);
        }
        users.add(tempUser);
    }

    // used to login
    public static Leader findUser(String login, String password,LinkedList<Leader> users){
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
                var isGoodstarttime = tempRequest.getStarDay() >= temp.getStarDay();
                var isGoodendtime = tempRequest.getEndDay() <= temp.getEndDay();
                if (isGoodendtime && isGoodstarttime){
                    goodRequests.add(tempRequest);
                }
            }
        }
        return goodRequests;
    }

    public static LinkedList<Request> processRequests(Leader currentUser,LinkedList<Leader> users){
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
}
>>>>>>> 247c0125a030a34cd0e38e0c049d39f2062e6c08
