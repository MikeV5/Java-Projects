package esercizio2;

import esercizio1.Nastro;
import esercizio1.noRead;
import esercizio1.noWrite;

import java.util.Random;

public class UtenteNastro extends Thread{
    private int id;
    private Nastro nastro;
    public UtenteNastro(int id, Nastro nastro) {
        this.id = id;
        this.nastro = nastro;
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


        } catch (noWrite | noRead | InterruptedException e) {
            if(e instanceof noWrite)
                System.err.println("Non si può scrivere in pos corrente.");
            else if(e instanceof noRead)
                 System.err.println("Non si può leggere in pos corrente, fare prima il rewind.");
        }
    }
}
