package com.company.client;

import java.io.*;

public class Person2 {
    public static void main(String[] args) throws IOException {

        Client client = new Client();

        //send data to server
        client.sendMessage("Hello from the person 2");
        client.sendMessage("How are you?");
        client.sendMessage("I'm fine");
        client.sendMessage("Thank you");
        client.sendMessage("exit");

        System.out.println("Client finish the execution..");
    }
}