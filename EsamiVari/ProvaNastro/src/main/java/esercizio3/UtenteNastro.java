package esercizio3;

import esercizio1.noRead;
import esercizio1.noWrite;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class UtenteNastro extends Thread{

    private int id;
    private NastroRMI nastro;
    public UtenteNastro(int id, NastroRMI nastro) {
        this.id = id;
        this.nastro = nastro;
    }

    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {

        NastroRMI n = new NastroImplRMI();
        Registry r = LocateRegistry.getRegistry();
        NastroRMI stub =
                (NastroRMI) r.lookup("Nastro");
        UtenteNastro u = new UtenteNastro(Integer.parseInt(args[0]),n);
        u.start();
        Thread.sleep(500);
    }

    public void run(){
        try {
        String ut = "Utente: "+id;
        String testo = "Testo:"+id;
        System.out.println(ut+" prova a scrivere: "+testo);
        nastro.write(testo);
        System.out.println(ut+" ha scritto: "+testo);
        Thread.sleep(1000);

        System.out.println(ut+" prova a fare rewind.");
        nastro.rewind();
        System.out.println(ut+" ha fatto rewind - posCorrente =0.");
        Thread.sleep(1000);

        System.out.println(ut+" prova a leggere in posizione corrente.");
        String str = nastro.read();
        System.out.println(ut+" ha letto: "+str);
        Thread.sleep(1000);

        } catch (noWrite | InterruptedException | noRead | RemoteException e) {
            if(e instanceof noWrite)
                System.err.println("Impossibile scrivere.");
            else if (e instanceof noRead)
                System.err.println("Impossibile leggere.");
            else e.printStackTrace();
        }

    }
}
