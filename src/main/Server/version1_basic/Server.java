package version1_basic;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        // socket = ip+port
        ServerSocket serverSocket= new ServerSocket(5555); //create the scocket object
        System.out.println("Listening to the client conection on port 5555");

        //once we accept the connection, the serverSocket becomes a socket (this is actually the client)
        Socket socket =  serverSocket.accept(); // strat listening to the clients connections. Untill the client connect, it doesn't go beyond this line.
        System.out.println("Client connected");


        InputStream inputStream = socket.getInputStream();
        // inputStream is raw data, and we cant perform different functions on them. So we need to decorate it using dataInputStream
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        // read client data
        String message = dataInputStream.readUTF();
        System.out.println("client says: "+ message);

        serverSocket.close();
        //code to capture the client data


    }
}