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
    Map<String, > Bill = new HashMap<>();

    public CashRegister(String priceFilename, String discountsFilename)
    {

        Scanner prices;
        try{
            prices = new Scanner(new File(priceFilename));
        } catch (FileNotFoundException e){
            e.printStackTrace();
            return;
        }



        initPrices(prices);

        System.out.println(Prices.get("3 601766 062447"));




    }


    //Inits prices, by loading text into scanner object, and seperating with comma.
    //Then it makes a new key (barcode) and a new item to the barcode.
    private void initPrices(Scanner prices)
    {
        String[] values;
        String catagory, name, kr, ear;
        while(prices.hasNextLine()){
            values = prices.nextLine().split(",");
            catagory = values[1];
            name = values[2];
            kr = values[3];
            ear = values[4];

            Prices.put(values[0], new Item(catagory, name, kr, ear));
        }
    }

}
