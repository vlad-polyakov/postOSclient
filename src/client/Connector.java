package client;

import java.io.*;
import java.net.Socket;

public class Connector {
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public void sendRequest(String host, int port, String request)  {
        try {
            socket = new Socket(host, port);
            if(socket.isConnected()) System.out.println("ll");
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            /*writer.println(request);
            writer.flush();
            StringBuilder response = new StringBuilder();
            String str;
            while ((str = reader.readLine()) != null) {
                response.append(str + "\n");
            }*/
            writer.close();
            reader.close();
            socket.close();

            //return response.toString();
        }
        catch (IOException e){
            //return e.getMessage();
        }
    }
}
