package CashRegisterExc;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CashRegister {
    //String = barcode, Item = rest of prices.txt;
    private Map<String, Item> Prices = new HashMap<>();
    //String = barcode, Discount = rest of discount.txt;
    private Map<String, Discount> Discounts = new HashMap<>();
    //String = barcode, Item = rest of list
    private Map<String, Integer> Purchases = new HashMap<>();
    //Makes a map of all the catagories
    private Map<String, Catagory> Catagories = new HashMap<>();

    private int total = 0;

    public CashRegister(String priceFilename, String discountsFilename)
    {
        //Loads files prices.txt and discount.txt;
        Scanner prices = loadFile(priceFilename);
        Scanner discounts = loadFile(discountsFilename);
        //Inits prices.txt into Prices
        initPrices(prices, Prices);
        //Inits discount.txt
        initDiscount(discounts, Discounts);
    }


    public void printReceipt(String barcodeFilename){
        Scanner bill = loadFile(barcodeFilename);
        String temp;
        while(bill.hasNextLine()){
            temp = bill.nextLine();
            if(Purchases.containsKey(temp)) Purchases.put( temp, new Integer(Purchases.get(temp) + 1)  );
            else Purchases.put(temp, new Integer(1));
        }
        printProducts();
        printTotal();
    }

    private void printProducts(){

        for(String key : Purchases.keySet() ){

            Prices.get(key).printItem(1);

        }


    }



    private void printTotal(){

    }

    //ToDo Make inits less redundant
    //ToDo 1. Init
    //Inits txt-values (Scanner txt) into a HashMap (register)
    private void initPrices(Scanner txt, Map register){
        String[] temp;

        while(txt.hasNextLine()){
            temp = txt.nextLine().split(",");
            register.put(temp[0], new Item(temp[0],temp[1], temp[2], temp[3], temp[4]));
        }
    }

    //ToDo 2. Init
    //Does the same as initPrices, just couldnt find a way to make it less
    //redundant
    private void initDiscount(Scanner txt, Map register){
        String[] temp;

        while(txt.hasNextLine()){
            temp = txt.nextLine().split(",");
            register.put(temp[0], new Discount(temp[1], temp[2], temp[3]));
        }

    }


    //Tries to load Scanner object from filepath. If not, prints
    //Which path was not loaded and returns null;
    private Scanner loadFile(String filePath){
        try{
            return new Scanner(new File(filePath));
        } catch (FileNotFoundException e){
            System.out.println("Did not find " + filePath);
            System.exit(0);
            return null;
        }
    }

}
