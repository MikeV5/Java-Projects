package esercizio3;

import esercizio1.noRead;
import esercizio1.noWrite;
import esercizio2.UtenteNastro;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class UtenteNastroRMI extends Thread{
    private int id;
    private NastroRMI nastro;
    public UtenteNastroRMI(int id, NastroRMI nastro) {
        this.id = id;
        this.nastro = nastro;
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {

        Registry r = LocateRegistry.getRegistry();
        NastroRMI stub = (NastroRMI) r.lookup("Nastro");
        UtenteNastroRMI u = new UtenteNastroRMI(1,stub);
        u.start();
    }
    public void run(){
        try {
            Random r = new Random();
            int rand = r.nextInt(10)+30;
            String utente = "Utente: "+id;
            String tmp = "Text"+rand;
            System.out.println(utente+" prova a scrivere nel nastro...");
            nastro.write(tmp);
            System.out.println(utente+" scritto nel nastro: "+tmp);
            Thread.sleep(1000);

            System.out.println(utente+" prova a fare rewind...");
            nastro.rewind();
            System.out.println(utente+" rewind fatto, ora pos corrente = 0.");

            System.out.println(utente+" prova a leggere il nastro...");
            String lettura = nastro.read();
            System.out.println(utente+" letto: "+lettura);
            Thread.sleep(1000);


        } catch (noWrite | noRead | InterruptedException | RemoteException e) {
            if(e instanceof noWrite)
                System.err.println("Non si può scrivere in pos corrente.");
            else if(e instanceof noRead)
                 System.err.println("Non si può leggere in pos corrente, fare prima il rewind.");
        }
    }
}
