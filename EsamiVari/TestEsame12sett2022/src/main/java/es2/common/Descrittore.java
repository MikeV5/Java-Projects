package es2.common;
import java.util.LinkedList;
import java.util.List;

public class Descrittore {
    public int id; //identificatore del consumatore
    public List<Msg> queue; // Coda dei messaggi ricevuti dal consumatore.

    public Descrittore(int id) {
        this.id = id;
        this.queue = new LinkedList<>();
    }
}