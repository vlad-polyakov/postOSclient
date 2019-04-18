package service;

import controller.Controller;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URLEncoder;

public class Connector {
    private Socket socket;
    private HttpMethod httpMethod = new HttpMethod();
    private PrintWriter writer;
    private BufferedReader reader;
    //private final int port = 80;

    public String sendRequest(String host, String request, String headers,String data)  {
        try {
            socket = new Socket(InetAddress.getByName(host),8080);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(request);
            if(!data.equals("")) {
                headers += "\n";
                headers += data;
            }
            System.out.println(headers);
            writer.println(headers);


            writer.println("");
            writer.flush();
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
            return e.getMessage();
        }
    }
}