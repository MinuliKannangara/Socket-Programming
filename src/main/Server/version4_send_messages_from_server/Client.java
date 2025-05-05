package version4_send_messages_from_server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main (String[] args) throws IOException {

        // send user defined messages from client to the server

        System.out.println("Connecting to the server");

        //write the code to connect to the server
        Socket socket = new Socket("localhost",5555);

        System.out.println("connected to the server");

        //send data from client to the server
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        //to capture messages from server side
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        Scanner scanner = new Scanner(System.in);
        String message = "";

        while (!message.equals("stop")){
            message = scanner.nextLine();
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();

            String serverMessage = dataInputStream.readUTF();
            System.out.println(serverMessage);

//            int i = 0;
//            while(i<2){
//                String serverMessage = dataInputStream.readUTF();
//                System.out.println(serverMessage);
//                i=i+1;
//            }

        }





        dataOutputStream.close(); // close  the stream

        socket.close(); // close the connection
    }
}
