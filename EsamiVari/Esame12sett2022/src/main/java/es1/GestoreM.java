package es1;

import es1.eccezioni.ConsumatoreSconosciuto;
import es1.eccezioni.DestinatarioPieno;
import es1.eccezioni.GiaRegistrato;
import es1.common.ConsumatoreMsgInterface;
import es1.common.ProduttoreMsgInterface;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GestoreM implements ProduttoreMsgInterface, ConsumatoreMsgInterface {
    private static final int maxMsg = 10;
    private List<Descrittore> consumatori;
    public GestoreM(){
        consumatori = new LinkedList<Descrittore>();
    }
    @Override
    public synchronized void signUp(int id) throws GiaRegistrato {
        Iterator<Descrittore> i = consumatori.iterator();
        while (i.hasNext()){
            Descrittore tmp = i.next();
            if(tmp.id == id) throw new GiaRegistrato();
        }
        consumatori.add(new Descrittore(id));
    }
    @Override
    public synchronized Msg receive(int id) throws InterruptedException {
        Iterator<Descrittore> i = consumatori.iterator();
        while (i.hasNext()) {
            Descrittore tmp = i.next();
            if (tmp.id == id) {
                while (tmp.queue.isEmpty()) this.wait();
                return tmp.queue.remove(0);
            }
        }
        return null; //TMCH
    }
    @Override
    public synchronized void send(Msg m) throws DestinatarioPieno {
        Iterator<Descrittore> i = consumatori.iterator();
        while (i.hasNext()){
            Descrittore tmp = i.next();
            if (tmp.id == m.dest) {
                if (tmp.queue.size() < maxMsg) {
                    tmp.queue.add(m);
                    this.notifyAll();
                    return; // termina immediatamente se il messaggio viene
                    // correttamente aggiunto alla coda del destinatario
                } else {
                    throw new DestinatarioPieno(m.dest);
                }
            }
        }
    }
}
