package client.service;

import java.io.*;
import java.net.Socket;

public class Connector {
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public String sendRequest(String host, int port, String request)  {
        try {
            socket = new Socket(host, port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            writer.println(request);
            writer.flush();
            StringBuilder response = new StringBuilder();
            String str;
            while ((str = reader.readLine()) != null) {
                response.append(str + "\n");
            }
            writer.close();
            reader.close();
            socket.close();

            System.out.println(response);
            return response.toString();
        }
        catch (IOException e){
            return e.getMessage();
        }
    }
}
