package es3.client;

import es3.common.RubricaInterface;
import es1.GiaPresente;
import es1.NomeNonEsistente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

//CLIENT
public class UtenteRubrica extends Thread{
    private int id;
    RubricaInterface rubrica;

    public UtenteRubrica(int id, RubricaInterface rubrica){
        this.id = id;
        this.rubrica = rubrica;
    }

    public void run(){
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            String randomNumber = String.valueOf(100000000 + r.nextInt(900000000));
            String nome = "ID"+i;
            switch (r.nextInt(4)){ //Tra 0 e 3
                case 0:
                    try {
                        rubrica.aggiungiNumero(nome,randomNumber);
                        System.out.println("Utente " + id+ " - Ha aggiunto un numero: "+randomNumber);
                    } catch (GiaPresente | RemoteException e) {
                        System.out.println("Utente " + id+ " Nome: "+ nome +" già presente.");
                    }
                    break;
                case 1:
                    try {
                        rubrica.eliminaNumero(nome);
                        System.out.println("Utente " + id + " : Numero eliminato dalla rubrica - Nome: " + nome);
                    } catch (NomeNonEsistente | RemoteException e) {
                        System.out.println("Utente " + id+ " Nome: "+ nome + " non esistente.");
                    }
                    break;

                case 2:
                    try {
                       System.out.println("Utente " + id + " : Numero trovato " +
                               "per il nome " + nome + ": " + rubrica.trova(nome));
                    } catch (RemoteException | InterruptedException e) {
                        System.out.println("Utente " + id + " : Numero non trovato per il nome " + nome);
                    }
                    break;

                case 3:
                    try {
                         System.out.println("Utente " + id + " : Il nome " + nome + " " +
                                 "è presente nella rubrica? " + rubrica.inRubrica(nome));
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }

    }

    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
        Registry r = LocateRegistry.getRegistry();
        RubricaInterface rub = (RubricaInterface) r.lookup("RubricaRMI");
        for (int i=0; i<3; i++) {
            //UtenteRubrica u = new UtenteRubrica(Integer.parseInt(args[0]),rub);
            UtenteRubrica u = new UtenteRubrica(i,rub);
            u.start();
            Thread.sleep(2000);
        }

    }
}
