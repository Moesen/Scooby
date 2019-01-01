import java.util.Random;

public class Plane implements java.io.Serializable {

    private String ID;
    public String type;
    public int age;

    public Plane(String type){
        this.age = 1;
        this.type = type;
        this.ID = makeNewID();
    }

    private String makeNewID(){
       char[] chars = "ABCDEFGHIJKLMNOPQRSTOVXYZabcdefghijklmnopqrstovxyz0123456789".toCharArray();
       String returnStr = "";
       Random r = new Random();
       for(int i = 0; i < 8; i++){
           returnStr+=chars[r.nextInt(chars.length)];
       }
       return returnStr;
    }

    public String toString(){
        return "Type: " + type + " - Age: " + age + ", ID: " + ID;
    }
}
