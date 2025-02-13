package esercizio3;

import java.io.Serializable;

public class Piano implements Serializable {
    static final long serialVersionUID = 1L;
    private int nStalli;
    private int postiLiberi;

    public Piano(int nStalli) {
        this.nStalli = nStalli;
        postiLiberi =  nStalli;
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
