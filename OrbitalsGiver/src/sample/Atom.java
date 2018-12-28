package sample;

import sun.awt.Symbol;

import java.util.ArrayList;

public class Atom implements Comparable<Atom>{

    private String symbol;
    private int no;
    private double M;
    private int orbitalS;
    private int orbitaLP;
    private int orbitalD;
    private int orbitalF;
    private String order;


    public Atom (String symbol){
        this.symbol = symbol;
    }

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

    public String getSymbol(){
        return symbol;
    }


    public int compareTo(Atom o) {
        if(o.getSymbol() == symbol) return 1;
        else return -1;
    }
}
