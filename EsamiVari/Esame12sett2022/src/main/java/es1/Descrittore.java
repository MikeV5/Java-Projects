package es1;

import java.util.LinkedList;
import java.util.List;

public class Descrittore {
    public int id; //
    public List<Msg> queue;
    public Descrittore(int id) {
        this.id = id;
        queue = new LinkedList<Msg>();
    }
}