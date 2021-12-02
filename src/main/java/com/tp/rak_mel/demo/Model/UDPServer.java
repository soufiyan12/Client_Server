package com.tp.rak_mel.demo.Model;

import java.io.IOException;
import java.lang.Integer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class UDPServer {
    private int port;
    private String data_received;

    //definire un constructeru avec un numero de port pour lecoute
    public UDPServer(int port) {
        this.port=port;
    }
    //un constructeur par defeut avec un port par defaut par exemple 8080

    public UDPServer() {
        this.port=8080;
    }
    //methode lunch qui demarre le serveur
    public void lunchServer() throws IOException {

        //Lancer une socket pour attendre les requetes envoyee
        DatagramSocket server_socket = new DatagramSocket(getPort());
        //la taille de packet
        byte buf [] = new byte[server_socket.getReceiveBufferSize()];
        //waiting for packets
        while(true){
            //datagrmme pour recoive les packets
            DatagramPacket packet=new DatagramPacket(buf, buf.length);
            server_socket.receive(packet);
            String data_received = packet.getSocketAddress().toString()
                    + ": " + new String(buf, "UTF-8");
            //String data_received =Arrays.toString(packet.getData());
            System.out.println(data_received);
        }

    }

    @Override
    public String toString() {
        //afficher les packets recu

        return "les donnes recuperate :"+data_received+"";
    }

    public int getPort() {
        return port;
    }
    //methode main pour demarrer le serveur avec numero de port passer en argument

    public static void main(String args[]) throws IOException {
        UDPServer udpServer=new UDPServer((Integer.parseInt(args[0])));
        System.out.println("start the server with port "+udpServer.getPort());

        udpServer.lunchServer();


    }


}

