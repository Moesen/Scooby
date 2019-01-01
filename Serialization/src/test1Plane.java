import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class test1Plane {

    public static void main(String[] args) {

        Plane p1 = new Plane("Boeing");
        String path = "/Users/Moesen/Desktop/Git/Scooby/Serialization/SavedObjects";

        try {
            FileOutputStream fileOut =
            new FileOutputStream(path + "/Plane1.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p1);
            out.close();
            fileOut.close();
            System.out.println("Data saved at: " + path);

        } catch(IOException i){
            i.printStackTrace();
        }

    }

}
