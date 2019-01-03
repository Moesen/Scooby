package CashRegisterExc;

public class Item {

    private String catagory;
    private String name;
    private int kr;
    private int ear;

    public Item(String catagory, String name, String kr, String ear){
        this.catagory = catagory;
        this.name = name;
        this.kr = Integer.parseInt(kr);
        this.ear = Integer.parseInt(ear);
    }

    public String toString(){
        return "Catagory: " + catagory + ", name: " + name + ", price: " + kr + "," + ear;
    }

}
