package es1;
import java.util.*;

public class GestoreM implements ProduttoreMsgInterface, ConsumatoreMsgInterface {
    //capacità massima della coda dei messaggi per ogni consumatore
    private static final int maxMsg = 10;
    //Rappresentano i consumatori registrati presso il gestore dei messaggi
    private List<Descrittore> consumatori;
    public GestoreM() {
        consumatori = new LinkedList<Descrittore>();
    }
    @Override
    //Viene chiamato da un consumatore per registrarsi
    // presso il gestore dei messaggi
    public synchronized void signUp(int id) throws GiaRegistrato {
        for (Descrittore desc : consumatori) {// Scorre la lista dei consumatori registrati
            if (desc.id == id) { // Verifica se il consumatore è già registrato
                throw new GiaRegistrato(); // Solleva un'eccezione se il consumatore è già registrato
            }
        }
        /// Aggiunge un nuovo Descrittore per il consumatore alla lista dei consumatori
        consumatori.add(new Descrittore(id));
    }
    @Override
    //Viene chiamato da un consumatore per ricevere un messaggio destinato a lui
    public synchronized Msg receive(int id) throws InterruptedException {
        Descrittore descrittore = null;
        for (Descrittore desc : consumatori) { // Scorre la lista dei consumatori registrati
            if (desc.id == id) { // Verifica se il consumatore è presente nella lista
                descrittore = desc;
                // Si blocca se la coda del consumatore è vuota finché
                //venga risvegliato dopo un inserimento(send())
                while (descrittore.queue.isEmpty()) this.wait();
                // Rimuove e restituisce il primo messaggio dalla coda del consumatore
                return descrittore.queue.remove(0);
            }
        }
        return null; //TMCH
    }
    @Override
    //Viene chiamato da un produttore per inviare un messaggio
    // al gestore dei messaggi
    public synchronized void send(Msg m) throws DestinatarioPieno{
        int dest = m.dest;
        for (Descrittore desc : consumatori) { // Scorre la lista dei consumatori registrati
            if (desc.id == dest) { // Verifica se il consumatore destinatario è presente nella lista
                if (desc.queue.size() < maxMsg) { // Verifica se la coda del consumatore ha raggiunto la capacità massima
                    desc.queue.add(m); // Aggiunge il messaggio alla coda del consumatore se la coda non ha raggiunto la capacità massima
                    notifyAll(); // Notifica tutti i thread in attesa(quelli bloccati in receive())
                    return;
                }else throw new DestinatarioPieno(dest);
            }
        }
    }
}
