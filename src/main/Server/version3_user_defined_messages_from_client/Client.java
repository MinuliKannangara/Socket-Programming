package version3_user_defined_messages_from_client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

        Scanner scanner = new Scanner(System.in);
        String message = "";

        while (!message.equals("stop")){
            message = scanner.nextLine();
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
        }






        dataOutputStream.close(); // close  the stream

        socket.close(); // close the connection
    }
}
