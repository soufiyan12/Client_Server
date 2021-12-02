package com.tp.rak_mel.demo.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {

public static void main(String[] args) throws IOException {

while(true) {
    Socket echoSocket = new Socket("localhost", 8080);

    PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

    BufferedReader stdIN = new BufferedReader(new InputStreamReader(System.in));
    String userinput;
    while((userinput=stdIN.readLine())!=null){
        out.println((userinput));
        System.out.println("echo   "+in.readLine());
    }
}
}
}
