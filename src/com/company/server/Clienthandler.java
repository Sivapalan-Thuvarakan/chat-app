package com.company.server;

import java.io.*;
import java.net.Socket;

public class Clienthandler implements Runnable{

    private Socket client;
    public Clienthandler(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(30000); // wait for 30 seconds before executing rest of the code


            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());

            //continuous reading data from client
            String inputData;
            while ((inputData=bufferedReader.readLine())!=null){

                System.out.println("Client:- "+inputData);

                //send data to client
                //can use scanner class to get data
                switch (inputData){
                    case "Hello from the person 1":
                        outputStream.writeBytes("Hello person1 from the server..\n");
                        break;
                    case "Hello from the person 2":
                        outputStream.writeBytes("Hello person2 from the server..\n");
                        break;
                    case "How are you?":
                        outputStream.writeBytes("I'm fine, and How are you?\n");
                        break;
                    case "I'm fine":
                        outputStream.writeBytes("ok good..\n");
                        break;
                    case "Thank you":
                        outputStream.writeBytes("you are welcome..\n");
                        break;
                    case "exit":
                        outputStream.writeBytes("good bye..\n");
                        break;
                    default:
                        outputStream.writeBytes("I didn't understand");
                }
                if (inputData.equals("exit")){
                    break;
                }
            }
            this.client.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }
}