package esercizio3;

import java.io.Serializable;

public class Piano implements Serializable {
    static final long serialVersionUID = 1L;
    private int numStalli;
    private int postiLiberi;

    public Piano(int numStalli) {
        this.numStalli = numStalli;
        postiLiberi = numStalli;
    }

    public int getNumStalli() {
        return numStalli;
    }

    public void setNumStalli(int numStalli) {
        this.numStalli = numStalli;
    }

    public int getPostiLiberi() {
        return postiLiberi;
    }

    public void setPostiLiberi(int postiLiberi) {
        this.postiLiberi = postiLiberi;
    }

    void parcheggia(){
        postiLiberi--;
    }

    void partenza(){
        postiLiberi++;
    }
}
