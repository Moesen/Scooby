package CashRegisterExc;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Catagory {

    ArrayList<Item> items = new ArrayList<>();

    public Catagory(){};

    public void addItem(Item item){
        items.add(item);
    }

    public String toString() {
        String temp = "";
        temp += items.get(0).toString() + "\n";

        for(int i = 1; i < items.size(); i++){
            if(!items.get(i - 1).equals(items.get(i))){
                temp += items.get(i).toString() + "\n";
            }
        }
        return temp;
    }

    public int size(){
        return items.size();
    }
}
