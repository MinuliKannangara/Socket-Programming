package version6_threding;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main (String[] args) throws IOException {

        // send user defined messages from client to the server

        System.out.println("Connecting to the server");

        //write the code to connect to the server
        Socket socket = new Socket("localhost",5555);

        System.out.println("client 2 connected to the server");

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

            int i = 0;
            while(i<2){
                String serverMessage = dataInputStream.readUTF();
                System.out.println(serverMessage);
                i=i+1;
            }

        }






        dataOutputStream.close(); // close  the stream

        socket.close(); // close the connection
    }
}
