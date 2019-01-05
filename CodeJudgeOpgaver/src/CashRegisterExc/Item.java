package CashRegisterExc;

public class Item implements Comparable<Item>{

    private String catagory;
    private String name;
    private float price;

    private int discountKr;
    private int discountEar;
    private int discountLim;

    private int number = 0;

    public Item(String[] info){
        this.catagory   = info[1];
        this.name       = info[2];

        int a = Integer.parseInt(info[3]);
        int b = Integer.parseInt(info[4]);

        this.price = (float) a + (float) b/100;


    }

    public void addDiscount(String limit, String discountKr, String discountEar){
        this.discountLim = Integer.parseInt(limit);
        this.discountEar = Integer.parseInt(discountEar);
        this.discountKr  = Integer.parseInt(discountKr);
    }

    public void addOne(){
        number++;
    }

    public void reset(){
        number = 0;
    }

    public char getCatagoryChar(int index){
        return this.catagory.charAt(index);
    }

    public char getNameChar(int index){
        return name.charAt(index);
    }

    public String getCatagory(){
        return catagory;
    }

    public String getName(){
        return name;
    }

    public int getNumber(){
        return number;
    }

    public String toString(){
        return name +" antal: " + number;
    }

    public String getPriceStr(){
        return Float.toString(price).replace('.',',');
    }

    public String getPriceStr(int number){
        return number +  " x " + Float.toString(price).replace('.',',');
    }

    public String getMultPrice(int number){
        return Float.toString(price * number).replace('.',',');
    }

    //Sorts the items by catagory
    @Override
    public int compareTo(Item i) {
            for(int j = 0; j < 3; j++){
            if (i.getCatagoryChar(j) > getCatagoryChar(j)) return -1;
            else if (i.getCatagoryChar(j) < getCatagoryChar(j)) return 1;
            }
            for(int j = 0; j < 5; j++){
                if(i.getNameChar(j) > getNameChar(j)) return -1;
                else if( i.getNameChar(j) < getNameChar(j)) return 1;
            }
            return 0;

    }
}