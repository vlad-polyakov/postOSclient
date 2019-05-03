package service;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


public class Connector{
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    //private final int port = 80;
    private Logger logger = LogManager.getLogger(Connector.class);

    public String sendRequest(String host, String request, String headers, String data, String content)  {
        try {
            socket = new Socket(InetAddress.getByName(host), 80);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            StringBuilder response = new StringBuilder();
            writer = new PrintWriter(socket.getOutputStream(), true);
            if (new TransformURL().isFileName(request)) {
                String fileName = new TransformURL().transformToImageName(content);
                writer.println(request);
                writer.println(headers);
                writer.println("");
                writer.flush();
                final FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                final InputStream inputStream = socket.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int count, offset;
                byte[] buffer = new byte[2048];
                boolean eohFound = false;
                while ((count = inputStream.read(buffer)) != -1)
                {
                    offset = 0;
                    if(!eohFound){
                        String string = new String(buffer, 0, count);
                        int indexOfEOH = string.indexOf("\r\n\r\n");
                        if(indexOfEOH != -1) {
                            count = count-indexOfEOH-4;
                            offset = indexOfEOH+4;
                            baos.write(buffer,0,offset);
                            byte[] dataByte = baos.toByteArray();
                            response.append(new String(dataByte));
                            eohFound = true;
                        } else {
                            count = 0;
                        }
                    }
                    fileOutputStream.write(buffer, offset, count);
                    fileOutputStream.flush();
                }
                inputStream.close();
                fileOutputStream.close();
            }
            else {

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
                    System.out.println(str);
                    response.append(str + "\n");
                }
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