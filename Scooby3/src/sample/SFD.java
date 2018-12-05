package sample;

import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class SFD {

    private int pointer = 0;
    private EuklidPoint[] punkter = new EuklidPoint[100];
    private int sfd;
    private int a;
    private int b;

    public SFD(int a, int b){
        if(a > b){this.a = a; this.b = b;}
        else {this.b = a; this.a = b;}
        calc();

    }

    private void calc(){
        punkter[0] = new EuklidPoint(a, 1, 0);
        punkter[1] = new EuklidPoint(b, 0, 1);

        int q, r, s, t;
        pointer = 1;
        while(punkter[pointer].getR()!=0 && pointer!=100){
            pointer++;
            punkter[pointer] = new EuklidPoint();

            q = punkter[pointer-2].getR()/punkter[pointer-1].getR();
            r = punkter[pointer-2].getR()%punkter[pointer-1].getR();

            punkter[pointer].setQ(q);
            punkter[pointer].setR(r);

            s = punkter[pointer-2].getS() - punkter[pointer].getQ() * punkter[pointer-1].getS();
            t = punkter[pointer-2].getT() - punkter[pointer].getQ() * punkter[pointer-1].getT();

            punkter[pointer].setS(s);
            punkter[pointer].setT(t);


        }

        sfd = punkter[pointer-1].getR();

        System.out.println("Calc done! SFD: " + sfd);
    }

    public String toString(){
        return "" + sfd;
    }

    public int getSFD(){
        return sfd;
    }
    public int getPointer(){
        return pointer;
    }

    public String[] getStrings(int i){
        String[] returnStr = new String[5];
        returnStr[0] = "" + i;
        returnStr[1] = "" + punkter[i].ifQ();
        returnStr[2] = "" + punkter[i].ifR();
        returnStr[3] = "" + punkter[i].ifS();
        returnStr[4] = "" + punkter[i].ifT();

        return returnStr;
    }

    public EuklidPoint returnPoint(int i){
        return punkter[i];
    }

    public void latexMeSFD(){
        String clipString = "";
        //Start tabular
        clipString+= "\\begin{equation}\n    \\begin{tabular}{|c|c c c c|} \\hline\n";
        //Explanation
        clipString+="        i & q & r & s & t \\\\ \\hline \n";
        //values
        for(int i = 0; i <= pointer; i++){
            clipString+= "        " + i + " & " + punkter[i].toLatex() + "\\\\ \\hline \n";
        }

        //End tabular
        clipString+= "    \\end{tabular}\n\\end{equation}";

        System.out.println(clipString);
        copyToClipboard(clipString);
    }

    private void copyToClipboard(String latex){
        String myString = latex;
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }


}
