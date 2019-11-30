package com.company;
import java.util.LinkedList;

public class Leader extends User {

        private LinkedList<Request> requests = new LinkedList<Request>();

        Leader(String name, String login, String password){
            super(name, login, password);
        }

        public void addRequest(String country, int month, int from, int to){
            requests.add(new Request(country, month, from, to));
        }

        public LinkedList<Request> getRequests() {
            return requests;
        }
}
