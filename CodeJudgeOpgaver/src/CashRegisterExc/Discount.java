package CashRegisterExc;

public class Discount {

    private int limit;
    private int kr;
    private int ear;

    public Discount(String limit, String kr, String ear){
        this.limit = Integer.parseInt(limit);
        this.kr = Integer.parseInt(kr);
        this.ear = Integer.parseInt(kr);
    }

}
