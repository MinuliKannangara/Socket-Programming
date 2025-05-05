package version5_multiple_clients;

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
            System.out.println("Client connected");


            InputStream inputStream = socket.getInputStream();
            // inputStream is raw data, and we cant perform different functions on them. So we need to decorate it using dataInputStream
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            Scanner scanner = new Scanner(System.in);

            // read client data
            // read any number of data
//        while (true){
//            String message = dataInputStream.readUTF();
//            System.out.println("client says: "+ message);
//        }

            //stop when the client sends "stop"

            String message = "";
            while (!message.equals("stop")) {
                message = dataInputStream.readUTF();
                System.out.println("client says: " + message);

                //send a message to the client from the server
                dataOutputStream.writeUTF("Fixed message: Thanks for the message");
                dataOutputStream.flush();

                //send a user defined message from client side
                String dynamicInputMesssage = scanner.nextLine();
                dataOutputStream.writeUTF(dynamicInputMesssage);
                dataOutputStream.flush();

            }
            clientcount++;

        }




    }
}