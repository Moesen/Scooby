package CashRegisterExc;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class CashRegister {
    //Using items as both the price, the discount and the shopping list
    //When done with a purchase use resetPurchase(), to
    //go back to 0 items purchased.
    private Map<String, Item> items = new HashMap<>();
    private float totalPrice = 0;

    public CashRegister(String priceFilename, String discountsFilename)
    {
        //Loads files prices.txt and discount.txt;
        Scanner prices = loadFile(priceFilename);
        Scanner discounts = loadFile(discountsFilename);

        loadItems(prices);
        loadDiscount(discounts);


    }


    public void printReceipt(String barcodeFilename){
        loadPurchase( loadFile(barcodeFilename) );
        //Makes arraylist of all purchases
        ArrayList<Item> bar = new ArrayList<>();
        //Loads the purchase into bar, and sorts the items
        loadAndSortBar(bar);

        ArrayList<String> receipt = new ArrayList<>();

        //Makes a string of String.format, with every item on list. Every item is added to given ArrayList<String>;
        String curCat = "";
        for(Item item : bar){
            curCat = makeItemString(item, receipt, curCat);
        }

        //Prints the receipt of formatted strings.

        for(String string : receipt){
            System.out.printf(string);
        }

    }

    //Adds every item on list to an ArrayList<String>, with correct format, and correct catagories.
    private String makeItemString(Item item, ArrayList<String> receipt, String curCat){
        //For every item checks
        //1. Is it a new catagory. if true -> make new title
        //2. How many items purchased of product.
        //2.1 if 1 print one way
        //2.2 if > 1 print another
        //If the catagory of the item doesnt match current cat, change the catagory to new.
        if( !item.getCatagory().equals(curCat) ){
            curCat = item.getCatagory();
            receipt.add( calcDifTitle(stitchCat(curCat)));
        }
        //If number of item == 1, print the item name and price
        if(item.getNumber() == 1){
            receipt.add(calcMiddleItem(item.getName(), item.getPriceStr()));
            receipt.add(checkDiscount(item));
            totalPrice += item.getPrice();
            //If number of item > 1 first print item, then print the total price of the item.
        } else {
            receipt.add(item.getName() + "\n");
            receipt.add(multipleItem(item));
            receipt.add(checkDiscount(item));
            totalPrice += item.getPrice() * item.getNumber();

        }
        return curCat;

    }

    //Returns a String of Catagory correctly centered.
    private String calcDifTitle(String title){
        return String.format( "%" + (title.length()+36)/2 +"s\n", title);
    }

    //Returns String with correct spacing between name and price.
    private String calcMiddleItem(String item, String price){
        return String.format("%" + (price.length() - 36) + "s %s\n", item, price);
    }

    //Returns two Strings, first name of the item.
    //Next Line is number of the product x the price, whiteSpace the total price.
    private String multipleItem(Item item){

        int whiteSpace = item.getPriceStr().length() - 35;
        String price = item.getMultPrice(item.getNumber());
        String prices = item.getNumber() + " x " + item.getPriceStr();

        return String.format("  %" + whiteSpace + "s%s\n",prices, price);
    }

    private String checkDiscount(Item item){
        String discount = "";
        if(item.hasDiscount()){
            discount = item.calcDiscount();
        }
        if(!discount.equals("")){
            discount = String.format( "%" + ("rabat".length() - 38) + "s%s\n","RABAT", discount);
        }

        return discount;
    }

    //For every item with num > 0 loads into ArrayList bar;
    private void loadAndSortBar(ArrayList<Item> bar){
        for(String key : items.keySet()){
            if( items.get(key).getNumber() > 0 ){
                bar.add(items.get(key));
            }
        }
        //Sorts by first char in catagory and then first 3 chars in name.=
        Collections.sort(bar);
    }

    //Scans purchases. One purchase = Item.number++;
    private void loadPurchase(Scanner purchase){
        while(purchase.hasNextLine()){
            items.get(purchase.nextLine()).addOne();
        }
    }

    //Loads discounts, by giving the items in HashMap new values,
    //if they have a discount
    private void loadDiscount(Scanner discount){
        String[] temp;
        while(discount.hasNextLine()){
            temp = discount.nextLine().split(",");
            items.get(temp[0]).addDiscount(temp[1],temp[2],temp[3]);
        }
    }

    //Inits items, by giving barcode as key, and item as value.
    private void loadItems(Scanner prices){
        String[] temp;
        while(prices.hasNextLine()){
            temp = prices.nextLine().split(",");
            items.put(temp[0],new Item(temp));
        }
    }

    //Tries to load Scanner object from filepath. If not, prints
    //which path was not loaded and returns null;
    private Scanner loadFile(String filePath){
        try{
            return new Scanner(new File(filePath));
        } catch (FileNotFoundException e){
            System.out.println("Did not find " + filePath);
            System.exit(0);
            return null;
        }
    }

    //Resets number of purchases of every item.
    private void resetPurchase(){
        for(String key : items.keySet()){
            items.get(key).reset();
        }
        totalPrice = 0;
    }

    private String stitchCat(String cat){
        return "* " + cat + " *";
    }

}
