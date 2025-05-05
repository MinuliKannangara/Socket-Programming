package version6_threding;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {

        // socket = ip+port
        ServerSocket serverSocket= new ServerSocket(5555); //create the scocket object
        System.out.println("Listening to the client conection on port 5555");

        int clientcount = 0;

        //restrict the number of clients can connect
        while(clientcount<5) {
            //once we accept the connection, the serverSocket becomes a socket (this is actually the client)
            Socket socket = serverSocket.accept(); // strat listening to the clients connections. Untill the client connect, it doesn't go beyond this line.

            //pass the socket to the thread
            //create threads for each client
            ServerClientThread serverClientThread = new ServerClientThread(socket);
            serverClientThread.start();
            clientcount++;
        }




    }
}