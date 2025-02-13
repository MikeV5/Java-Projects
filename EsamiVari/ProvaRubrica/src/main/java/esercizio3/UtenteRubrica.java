package esercizio3;

import esercizio1.GiaPresente;
import esercizio1.Inesistente;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class UtenteRubrica extends Thread{
    private int id;
    private RubricaInterfaceRMI rub;
    static int numT = 10;
    public UtenteRubrica(int id, RubricaInterfaceRMI rub) {
        this.id = id;
        this.rub = rub;
    }

    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
        Registry r = LocateRegistry.getRegistry();
        RubricaInterfaceRMI stub =
                (RubricaInterfaceRMI) r.lookup("Rubrica");
        for (int i = 0; i < numT; i++) {
            UtenteRubrica u = new UtenteRubrica(i+1,stub);
            u.start();
            Thread.sleep(500);
        }
    }
    public void run(){

        try {
            Random r = new Random();
            String nomeRub = "Utente:"+id;

            long n = r.nextLong(100000000L)+300000000L;
            String numR = "+39 3"+String.valueOf(n);

            System.out.println(nomeRub + " provo a inserire un numero.");
            rub.aggiungiNumero(String.valueOf(id), String.valueOf(numR));
            System.out.println(nomeRub + " ho inserito: "+id+" "+numR);
            Thread.sleep(1000);

            int nomeR = r.nextInt(numT)+1;
            System.out.println(nomeRub + " provo a cercare il numero di "+nomeR);
            String numTrovato = rub.trova(String.valueOf(nomeR));
            System.out.println(nomeRub + " trovato numero: "+ numTrovato
                    +"di "+nomeR);
            Thread.sleep(1000);

        } catch (GiaPresente | InterruptedException | Inesistente | RemoteException e) {
            if(e instanceof GiaPresente)
                System.err.println("Nome già presente in rubrica.");
            else if (e instanceof Inesistente) {
                System.err.println("Nome inesistente.");
            }
            e.printStackTrace();
        }
    }
}
