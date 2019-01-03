package CashRegisterExc;

import jdk.internal.org.objectweb.asm.tree.analysis.BasicValue;

public class Item {

    private String barcode;
    private String catagory;
    private String name;
    private int kr;
    private int ear;

    public Item(String barcode, String catagory, String name, String kr, String ear){
        this.barcode = barcode;
        this.catagory = catagory;
        this.name = name;
        this.kr = Integer.parseInt(kr);
        this.ear = Integer.parseInt(ear);
    }


    public void printItem(int number){
        int numLen = Math.round((kr*100+ear)/10) + 1;
        int space = 38 - (numLen + name.length());
        String price = "" + kr + "," + ear;
        if(number == 1){
            System.out.printf("%-30s %s \n", name, price);
        } else {

        }
    }

    public String getBarcode(){
        return barcode;
    }
    public String getName(){
        return name;
    }
    public String getCatagory() {
        return catagory;
    }
    public int getKr() {
        return kr;
    }
    public int getEar() {
        return ear;
    }
    public String toString(){
        return "Catagory: " + catagory + ", name: " + name + ", price: " + kr + "," + ear;
    }

}
