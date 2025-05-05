package version6_threding;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ServerClientThread extends Thread{

    private Socket socket;

    public ServerClientThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
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

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
