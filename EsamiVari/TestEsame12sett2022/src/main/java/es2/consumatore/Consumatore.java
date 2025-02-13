package es2.consumatore;
import es1.ConsumatoreSconosciuto;
import es1.GiaRegistrato;
import es2.common.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Consumatore extends Thread {
    private int id; //identificatore univoco del consumatore
    //Rappresenta il gestore dei messaggi a cui il consumatore è registrato
    private ConsumatoreMsgInterfaceRMI gestore;
    public Consumatore(int n) throws RemoteException, NotBoundException {
        Registry r = LocateRegistry.getRegistry();
        this.gestore = (ConsumatoreMsgInterfaceRMI)r.lookup("GestoreMessaggi") ;
        this.id = n;
    }
    @Override
    public void run() {
        try {
            //Il consumatore si registra presso il gestore dei messaggi
            gestore.signUp(id);
            //Per ricevere continuamente i messaggi dal gestore dei messaggi
            while(true) {
                //In ogni iterazione del ciclo, viene effettuata una pausa di 2s
                //tra la ricezione dei messaggi
                Thread.sleep(2000);
                //Il consumatore richiede continuamente al gestore dei messaggi
                // il messaggio destinato a lui
                Msg message = gestore.receive(id);
                System.out.println("C" + id + " - Ricevuto: " +
                        "Destinatario: " + message.dest + " - Contenuto: " + message.txt);
            }
        } catch (InterruptedException | ConsumatoreSconosciuto
                 | GiaRegistrato | RemoteException e) {
            e.printStackTrace();
        }
    }
}


