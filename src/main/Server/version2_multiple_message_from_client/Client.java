package version2_multiple_message_from_client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main (String[] args) throws IOException {

        // send multiple messages from client to the server

        System.out.println("Connecting to the server");

        //write the code to connect to the server
        Socket socket = new Socket("localhost",5555);

        System.out.println("connected to the server");

        //send data from client to the server
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("Hello Server");
        dataOutputStream.flush();


        dataOutputStream.writeUTF("This is the second message");
        dataOutputStream.flush();

        dataOutputStream.writeUTF("This is the third message");
        dataOutputStream.flush();

        dataOutputStream.writeUTF("stop");
        dataOutputStream.flush();

        dataOutputStream.writeUTF("message after stop");
        dataOutputStream.flush();
//
//        dataOutputStream.close(); // close  the stream

        socket.close(); // close the connection
    }
}
