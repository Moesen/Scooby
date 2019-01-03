package CashRegisterExc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CashRegister {
    //String = barcode, Item = rest of prices.txt;
    Map<String, Item> Prices = new HashMap<>();
    //String = Catagory,
    Map<String, Discount> Discounts = new HashMap<>();
    //


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

    }






    //Inits txt-values (Scanner txt) into a HashMap (register)
    private void initPrices(Scanner txt, Map register){
        String[] temp;

        while(txt.hasNextLine()){
            temp = txt.nextLine().split(",");
            register.put(temp[0], new Item(temp[1], temp[2], temp[3], temp[4]));
        }
    }

    //ToDo Make this less redundant
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
