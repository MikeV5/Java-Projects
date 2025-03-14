package org.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Hello world!
 *
 */
public class ClientMain
{
    static int PORT = 1234;

    public static void main(String[] args) {

        try {
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", PORT);

            // Looking up the registry for the remote object
            Loggable stub = (Loggable) registry.lookup("Loggable");

            // Calling the remote method using the obtained object
            //was: Boolean logged = stub.login("ingconti");
            String nick = "ingconti";
            if (args.length>0)
                nick = args[0];
            Boolean logged = stub.login(nick);

            System.out.println("Remote method invoked " + logged);


        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }
}
