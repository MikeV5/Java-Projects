package esercizio2;

import esercizio1.Nastro;
import esercizio1.noRead;
import esercizio1.noWrite;

public class UtenteNastro extends Thread{

    private int id;
    private Nastro nastro;
    public UtenteNastro(int id, Nastro nastro) {
        this.id = id;
        this.nastro = nastro;
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

        } catch (noWrite | InterruptedException | noRead e) {
            if(e instanceof noWrite)
                System.err.println("Impossibile scrivere.");
            else if (e instanceof noRead)
                System.err.println("Impossibile leggere.");
            else e.printStackTrace();
        }

    }
}
