package es2.server;

import es2.common.Rubrica;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server avviato. In attesa di connessioni...");

            Rubrica rubrica = new RubricaImpl();

            while (true) {
                Socket clientSocket = serverSocket.accept();
                RubricaSkel skel = new RubricaSkel(clientSocket, rubrica);
                skel.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}