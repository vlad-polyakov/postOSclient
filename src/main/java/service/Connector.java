package service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Connector {
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    //private final int port = 80;

    private static Logger logger = LogManager.getLogger(Connector.class);

    public String sendRequest(String host, String request, String headers, String data, int port)  {
        try {
            String delete="";
            int start = host.indexOf(":");
            int end = host.length();
            if (start!=-1){
            delete = host.substring(start, end);}
            String newHost = host.replace(delete,"");
            //String parameter = URLEncoder.encode("name=h","UTF-8");
            //String parameter = URLEncoder.encode("name","UTF-8")+URLEncoder.encode("=", "UTF-8")+URLEncoder.encode("zhenya", "UTF-8");
            //String parameter = "name=zhenya";
            //byte[] post = parameter.getBytes(StandardCharsets.UTF_8);
            //int postLength = parameter.length();

            socket = new Socket(InetAddress.getByName(newHost),port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);

            StringBuilder response = new StringBuilder();

            if (!new TransformURL().isFileName(request)) {
                writer.println(request);
                if (!data.equals("")) {
                    headers += "\n";
                    headers += data;
                }
                logger.info(headers);
                writer.println(headers);
                writer.println("");
                writer.flush();
                String str;
                while ((str = reader.readLine()) != null) {
                    response.append(str + "\n");
                }
            }
            else {
                writer.println(request);
                writer.println(headers);
                final FileOutputStream fileOutputStream = new FileOutputStream("test.jpg");
                final InputStream inputStream = socket.getInputStream();

                // Header end flag.
                boolean headerEnded = false;

                byte[] bytes = new byte[2048];
                int length;
                while ((length = inputStream.read(bytes)) != -1) {
                    if (headerEnded)
                        fileOutputStream.write(bytes, 0, length);

                    else {
                        for (int i = 0; i < 2045; i++) {
                            if (bytes[i] == 13 && bytes[i + 1] == 10 && bytes[i + 2] == 13 && bytes[i + 3] == 10) {
                                headerEnded = true;
                                fileOutputStream.write(bytes, i+4 , 2048-i-4);
                                break;
                            }

                        }
                    }
                }
                inputStream.close();
                fileOutputStream.close();
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