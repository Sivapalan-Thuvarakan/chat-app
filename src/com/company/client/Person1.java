package com.company.client;

import java.io.*;

public class Person1 {
    public static void main(String[] args) throws IOException {
        //send data to server
        Client client = new Client();
        client.sendMessage("Hello from the person 1");
        client.sendMessage("How are you?");
        client.sendMessage("I'm fine");
        client.sendMessage("Thank you");
        client.sendMessage("exit");

        System.out.println("Client finish the execution..");
    }
}