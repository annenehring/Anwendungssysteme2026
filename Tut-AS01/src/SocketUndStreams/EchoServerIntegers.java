package SocketUndStreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
TODO:Implementieren Sie einen einfachen Echo-Server und einen dazugehörigen Client.
 Der Server soll auf einem frei wählbaren Port auf eingehende Verbindungen warten und vom
 Client gesendete Integer-Werte empfangen. Jeder empfangene Integer ist vom Server unverändert an den Client
 zurückzusenden. Der Client soll mehrere Integer an den Server senden und die jeweils zurückgesendeten Werte
 auf der Konsole ausgeben.
 */
public class EchoServerIntegers {

    public static void main(String[] args) {



        try(ServerSocket s = new ServerSocket(8000);
            Socket client = s.accept();
            InputStream in = client.getInputStream();
            OutputStream out = client.getOutputStream();){

            int input;
            while((input = in.read()) != -1){
                out.write(input);
            }


        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
}
class EchoClient{

    public static void main(String[] args) {

        try(Socket s = new Socket("localhost", 8000);
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();){

            out.write(13);
            System.out.println(in.read());

            out.write(2);
            System.out.println(in.read());

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
     

    }
}
