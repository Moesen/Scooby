package CashRegisterExc;

public class Item implements Comparable<Item>{

    private String catagory;
    private String name;
    private float price;

    private float discountAmount;
    private int discountLim = -1;

    private int number = 0;

    public Item(String[] info){
        this.catagory   = info[1];
        this.name       = info[2];

        int a = Integer.parseInt(info[3]);
        int b = Integer.parseInt(info[4]);

        this.price = (float) a + (float) b/100;
    }

    //Returns the char of catagory corrosponding to index
    public char getCatagoryChar(int index){
        return this.catagory.charAt(index);
    }
    //Returns the char of name corrosponding to index.=
    public char getNameChar(int index){
        return name.charAt(index);
    }

    //---Getters---//

    public String getCatagory(){
        return catagory;
    }
    public String getName(){
        return name;
    }
    public int getNumber(){
        return number;
    }
    public float getPrice(){
        return price;
    }

    //ToString
    public String toString(){
        return name +" antal: " + number;
    }
    //Retusn the price, with comma instead of dot.
    public String getPriceStr(){
        return Float.toString(price).replace('.',',');
    }

    //---Prices manipulation---//

    //Adds the discount values to item
    public void addDiscount(String limit, String discountKr, String discountEar){
        this.discountLim = Integer.parseInt(limit);

        int a = Integer.parseInt(discountKr);
        int b = Integer.parseInt(discountEar);

        this.discountAmount = (float) a + (float) b/100;


    }
    //Adds one to the number of items on receipt.
    public void addOne(){
        number++;
    }
    //Sets number of items to zero.
    public void reset(){
        number = 0;
    }

    public String getMultPrice(int number){
        float temp = number * price;
        return removeLastDecimals(Float.toString(temp).replace('.',','));
    }

    //Checks if discount is above -1.
    public boolean hasDiscount(){
        return discountLim > 0;
    }
    //Checks if limit is met
    public String calcDiscount(){
         float temp = number*discountAmount;

         return Float.toString(temp).replace('.',',') + "-";
    }

    public float calcDiscount(String a){
        return number*discountAmount;
    }

    //Sorts the items by catagory.
    //If catagory is the same, then sorts by name.
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

    private String removeLastDecimals(String s){
        String[] a = s.split("");
        int index = 2;
        for(int i = 0; i < a.length; i++){
            if(a[i] == ","){
                index = i; break;
            }
        }

        String temp = "";
        for(int i = 0; i < index + 2; i++){
            temp += a[i];
        }

        if(temp.length() < 5){
            temp += "0";
        }
        return temp;

    }


}