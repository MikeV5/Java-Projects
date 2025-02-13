package esercizio1;

public class Piano {
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
