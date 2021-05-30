package com.company.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("server is running..");
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("server socket created...");

        //server running forever
        while (true){
            Socket client = serverSocket.accept();//wait until a client connects
            System.out.println("server accepted a client..");

            Clienthandler clientHandler = new Clienthandler(client);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }


    }
}