package service;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
public class Connector{
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    //private final int port = 80;
    private Logger logger = LogManager.getLogger(Connector.class);

    public String sendRequest(String host, String request, String headers, String data)  {
        try {
            //String parameter = URLEncoder.encode("name=h","UTF-8");
            //String parameter = URLEncoder.encode("name","UTF-8")+URLEncoder.encode("=", "UTF-8")+URLEncoder.encode("zhenya", "UTF-8");
            //String parameter = "name=zhenya";
            //byte[] post = parameter.getBytes(StandardCharsets.UTF_8);
            //int postLength = parameter.length();
            System.out.println(host);
            socket = new Socket(InetAddress.getByName(host),8080);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(request);
            if (!data.equals("")){
                headers += "\n";
                headers +=data;
            }
            logger.info(headers);
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
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }
}