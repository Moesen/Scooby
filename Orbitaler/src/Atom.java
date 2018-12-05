public class Atom {

    private String symbol;
    private int no;
    private double M;
    private int orbitalS;
    private int orbitaLP;
    private int orbitalD;
    private int orbitalF;

    public Atom(String symbol, int no, double M, int S, int P, int D, int F){
        this.symbol = symbol;
        this.no = no;
        this.M = M;
        this.orbitalS = S;
        this.orbitaLP = P;
        this.orbitalD = D;
        this.orbitalF = F;
    }

    public int getNo(){
        return this.no;
    }
}
