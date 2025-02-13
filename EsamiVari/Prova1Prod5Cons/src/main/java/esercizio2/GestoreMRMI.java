package esercizio2;

import esercizio1.ConsumatoreSconosciuto;
import esercizio1.DestinatarioPieno;
import esercizio1.GiaRegistrato;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

public class GestoreMRMI extends UnicastRemoteObject implements ProduttoreMsgInterface, ConsumatoreMsgInterface {
    private List<Descrittore> consumatori;
    private int maxMessaggi = 10;

    public class Descrittore{
        int idConsumatore;
        List<Msg> codaMessaggi;
        public Descrittore(int idConsumatore) {
            this.idConsumatore = idConsumatore;
            codaMessaggi = new LinkedList<>();
        }
    }
    public GestoreMRMI() throws RemoteException {
        consumatori = new LinkedList<>();
    }

    public static void main(String[] args) throws RemoteException {
        GestoreMRMI obj = new GestoreMRMI();
        Registry r = LocateRegistry.createRegistry(1099);
        r.rebind("GestoreM",obj);
        System.out.println("Server pronto...");
    }
    @Override
    public synchronized void signUp(int id) throws GiaRegistrato {
        for (Descrittore desc : consumatori){
            if(desc.idConsumatore==id)
                throw new GiaRegistrato();
        }
        consumatori.add(new Descrittore(id));
    }

    //Il consumatore verifica se ha un messaggio
    @Override
    public synchronized Msg receive(int id) throws InterruptedException, ConsumatoreSconosciuto {

        Descrittore descrittoreTMP = null;
        for(Descrittore desc : consumatori){
            if(desc.idConsumatore==id) {
                descrittoreTMP = desc;
                while(descrittoreTMP.codaMessaggi.isEmpty()) wait();
                return desc.codaMessaggi.remove(0); //FIFO rimuovo il primo elemento
            }
        }
        throw new ConsumatoreSconosciuto();
    }

    @Override
    public synchronized void send(Msg m) throws DestinatarioPieno {
        int destinatario = m.dest;
        for (Descrittore desc : consumatori) {
            if (desc.idConsumatore == destinatario) {
                if (desc.codaMessaggi.size() < maxMessaggi) {
                    desc.codaMessaggi.add(m);
                    notifyAll();
                    return;
                } else {
                    throw new DestinatarioPieno();
                }
            }
        }
    }
}
