package sample;

public class EuklidPoint {

    //Field
    private int q = -1;
    private int r;
    private int s;
    private int t;

    public EuklidPoint(){

    }

    public EuklidPoint(int r, int s, int t){
        this.r = r;
        this.s = s;
        this.t = t;
    }

    //Getters
    public int getQ() {
        return q;
    }
    public int getR() {
        return r;
    }
    public int getS() {
        return s;
    }
    public int getT() {
        return t;
    }
    //Setters
    public void setQ(int q) {
        this.q = q;
    }
    public void setR(int r) {
        this.r = r;
    }
    public void setS(int s) {
        this.s = s;
    }
    public void setT(int t) {
        this.t = t;
    }
    //toString
    public String toString(){
        return ifQ() + "\t" + ifR() + "\t" + ifS() + "\t" + ifT();
    }
    public String toLatex(){
        return ifQ() + " & " + ifR() + " & " + ifS() + " & " + ifT();
    }
    //toString if's
    public String ifQ(){
        if(q==-1) return "-";
        else return "" + q;
    }
    public String ifR(){
        if(r==-1) return "-";
        else return "" + r;
    }
    public String ifS(){
        if(r==0) return "-";
        else return "" + s;
    }
    public String ifT(){
        if(r==0) return "-";
        else return "" + t;
    }

}
