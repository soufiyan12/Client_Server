package com.tp.rak_mel.demo.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UDPClient {


    public static void main(String args[]) throws IOException {

        //creation de socket
        DatagramSocket client_socket = new DatagramSocket();
        //saisie de l'utilisateur
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        System.out.println("Enter your msg");
        //Scanner s=new Scanner(System.in);
        String data=br.readLine();
        System.out.println("my msg"+data);
        //String user_input=s.nextLine();
        //s.close();
        br.close();
        r.close();
        byte out_data [];
        //byte[] data = new byte[user_input.length()];
        //data=user_input.getBytes(StandardCharsets.UTF_8);
        out_data = data.getBytes(StandardCharsets.UTF_8);
        System.out.println("byte data"+out_data);
        //envoie de donnnes au serveur avec datgramme mode non connecte
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket packet=new DatagramPacket(out_data, out_data.length,ip,8080);

        client_socket.send(packet);



        System.out.println("valeur saisie  /  "+ new String(out_data));
    }
}
