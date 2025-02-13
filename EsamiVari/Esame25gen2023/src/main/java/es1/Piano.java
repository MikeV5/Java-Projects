package es1;

public class Piano {
    private int numStalli;
    private int postiOccupati;
    public Piano(int num){
        this.numStalli=num;
    }
    public void parcheggia(){
        postiOccupati++;
    }
    public void partenza(){
        postiOccupati--;
    }
    public int stalliLiberi(){
        return numStalli-postiOccupati;
    }
}
