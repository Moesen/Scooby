public class Atom {

    private String symbol;
    private int no;
    private double M;
    private int orbitalS;
    private int orbitaLP;
    private int orbitalD;
    private int orbitalF;
    private String order;

    public Atom(String symbol, int no, int S, int P, int D, int F, String order){
        this.symbol = symbol;
        this.no = no;
        this.orbitalS = S;
        this.orbitaLP = P;
        this.orbitalD = D;
        this.orbitalF = F;
        this.order = order;
    }

    public String toString(){
        return "" + symbol + ", S: " + orbitalS + ", P: " +  orbitaLP + ", D: " + orbitalD + ", F: " + orbitalF + ", Order: " + order;
    }

}
