package es1;
import java.util.Random;
public class UtenteNastro extends Thread{
    private int id;
    Nastro nastro;
    public UtenteNastro(int id, Nastro nastro){
        this.id=id;
        this.nastro = nastro;
    }
    public void run() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000); //Ritardo di 1 secondo
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (r.nextInt(4)) { //numero casuale tra 0 e 3
                case 0: {
                    try {
                        // Scrive una nuova stringa nel nastro utilizzando
                        // l'identificatore e l'indice corrente
                        nastro.write(id + "El" + i);
                        System.out.println("Scrivo: " + id + " Messa: El" + i);
                    } catch (noWrite e) {
                        System.out.println("noWrite");
                    }
                    break;
                }
                case 1: {
                    try {
                        // Legge la stringa nella posizione corrente del nastro
                        System.out.println("Letto: " + nastro.read());
                    } catch (noRead e) {
                        System.out.println("noRead");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Rewind");
                    nastro.rewind();
                    break;
                }
                default:
                    System.out.println("Nastro vuoto? " + nastro.empty());
            }
            // Aggiunta della stampa della posizione corrente
            System.out.println("Posizione corrente: " + nastro.getCurrentPosition());
        }
    }
    public static void main( String[] args ) throws InterruptedException {
        Nastro n = new NastroImpl();
        //Integer.parseInt(args[0])
        for (int i = 0; i < 5; i++) {
            UtenteNastro e = new UtenteNastro(i, n);
            e.start();
            Thread.sleep(500);
        }
    }
}
