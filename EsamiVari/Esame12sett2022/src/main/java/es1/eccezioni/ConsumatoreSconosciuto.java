package es1.eccezioni;

public class ConsumatoreSconosciuto extends Exception {
    public int consumatore;

    public ConsumatoreSconosciuto(int consumatore) {
        this.consumatore = consumatore;
    }
}
