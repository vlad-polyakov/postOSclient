package service;

import controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Connector {
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    private final int port = 80;
    private Logger logger = LogManager.getLogger(Connector.class);

    public String sendRequest(String host, String request, String headers)  {
        try {
            socket = new Socket(InetAddress.getByName(host),port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(request);

            writer.println(headers);
            writer.println("");
            StringBuilder response = new StringBuilder();
            String str;
            while ((str = reader.readLine()) != null) {
                response.append(str + "\n");
            }
            writer.close();
            reader.close();
            socket.close();

            return response.toString();
        }
        catch (IOException e){
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }
}