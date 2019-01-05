package CashRegisterExc;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class CashRegister {
    //Using items as both the price, the discount and the shopping list
    //When done with a purchase use resetPurchase(), to
    //go back to 0 items purchased.
    Map<String, Item> items = new HashMap<>();

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

        String curCat = "";
        //For every item checks
        //1. Is it a new catagory. if true -> make new title
        //2. How many items purchased of product.
        //2.1 if 1 print one way
        //2.2 if > 1 print another
        for(Item item : bar){
            if( !item.getCatagory().equals(curCat) ){
                curCat = item.getCatagory();
                receipt.add( calcDifTitle(stitchCat(curCat)));
            }

            if(item.getNumber() > 1){
                receipt.add(calcMiddleItem(item.getName(), item.getPriceStr()));
            } else {
                receipt.add(item.getName() + "\n");
                receipt.add(multipleItem(item));
            }




        }

        for(String string : receipt){
            System.out.printf(string);
        }

        /*
        for(Item item : bar){
            System.out.println(item);
        }
        */

    }

    private String calcDifTitle(String title){
        return String.format( "%" + (title.length()+38)/2 +"s \n", title);
    }

    private String calcMiddleItem(String item, String price){
        return String.format("%" + (price.length() - 37) + "s %s \n", item, price);
    }
    

    private String multipleItem(Item item){

        int whiteSpace = item.getPriceStr().length() - 35;
        String price = item.getMultPrice(item.getNumber());
        String prices = item.getPriceStr(item.getNumber());

        return String.format("  %" + whiteSpace + "s %s",prices, price);
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
    }

    private String stitchCat(String cat){
        return "* " + cat + " *";
    }

}
