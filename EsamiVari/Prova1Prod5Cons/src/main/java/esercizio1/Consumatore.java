package esercizio1;

public class Consumatore  extends Thread{
    int idConsumatore;
    ConsumatoreMsgInterface gestore;
    public Consumatore(int idConsumatore, ConsumatoreMsgInterface gestore) {
        this.idConsumatore = idConsumatore;
        this.gestore = gestore;
    }

    public void run(){

        try {
            System.out.println("Sono il consumatore: " + idConsumatore +
                    " e provo a registrarmi...");
            gestore.signUp(idConsumatore);
            System.out.println("Sono il consumatore: " + idConsumatore +
                    " e mi sono registrato");
            Thread.sleep(1000);

            while(true) {
                Thread.sleep(1000);
                System.out.println("Cons: " + idConsumatore +
                        " e provo a avedere se ho messaggi...");
                Msg messaggio = gestore.receive(idConsumatore);
                System.out.println("Cons: " + idConsumatore +
                        " messaggio ricevuto: "+messaggio.txt);
            }

        } catch (GiaRegistrato | InterruptedException | ConsumatoreSconosciuto e) {
            System.err.println("Consumatore: "+ idConsumatore +" già ersgitrato");

        }
    }
}
