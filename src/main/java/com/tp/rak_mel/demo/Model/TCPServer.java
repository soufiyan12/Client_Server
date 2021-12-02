package com.tp.rak_mel.demo.Model;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Object;
public class TCPServer {

public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket(8080);
    System.out.println("listening");
    while (true) {
        final Socket socket = server.accept();

        //acceptation de cette connection et obtention d’un Socket de connection
        String inputLine = "";
        System.err.println(socket.toString() + " ~> connected");


        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            while (!inputLine.equals("!quit") && (inputLine = in.readLine()) != null) {
                System.out.println(socket.toString() + ": " + inputLine);
                // Echo server...
                //String to hexadicimal
                StringBuffer sb = new StringBuffer();
                //Converting string to character array
                char ch[] = inputLine.toCharArray();
                for(int i = 0; i < ch.length; i++) {
                    String hexString = Integer.toHexString(ch[i]);
                    sb.append(hexString);
                }
                String result = sb.toString();
                out.println(result);
            }
        }



    }
}



}
