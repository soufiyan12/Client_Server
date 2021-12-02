package com.tp.rak_mel.demo.Model;

import java.io.InputStream;
import java.io.*;
import java.net.*;

public class httpClient {

    public static void main(String[] args) throws IOException {

        String in= "https://www.ietf.org:80";  // declaration de variable avec l'URL souhaitee
        OutputStream out = new FileOutputStream("htmlPage.txt");  //instanciation d'un flux de sortie en format text
        get(in,out);  //Appel de la methode get
    }
    //definition du methode get avec deux arguments
    public static void get(String in, OutputStream out) throws IOException {
        URL url=new URL(in);
        URL aURL = new URL(url, "/rfc/rfc000.txt");
        //affichage des differentes informations de connexion
        System.out.println("protocol = " + aURL.getProtocol());
        System.out.println("host = " + aURL.getHost());
        System.out.println("port = " + aURL.getPort());
        System.out.println("filename = " + aURL.getFile());

        Socket socket=new Socket(aURL.getHost(),aURL.getPort());  //ouverture d'une socket avec l'host et port adequat
        //on cree les objets InputStream from et PrintWriter to pour récupérer les flux d'entrée et de sortie de la socket

        InputStream from;
        PrintWriter to=new PrintWriter(socket.getOutputStream());
        to.println("GET "+aURL.getFile()+" HTTP/1.1");
        to.println("Host : "+aURL.getHost()+"");
        to.println("");
        to.flush();//vider flux(stream)
        //Lire et écrire la réponse du serveur :
        from = socket.getInputStream();
        byte[] buf = new byte[4096];
        int bytes_read;
        while((bytes_read = from.read(buf)) != -1)
            out.write(buf, 0, bytes_read);
        socket.close();//fermeture du socket
    }
}
