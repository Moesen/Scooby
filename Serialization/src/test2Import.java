import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class test2Import {

    public static void main(String[] args) {

        Plane p1 = null;

        try {
            FileInputStream fileIn = new FileInputStream("/Users/Moesen/Desktop/Git/Scooby/Serialization/SavedObjects/Plane1.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            p1 = (Plane) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException i) {
            i.printStackTrace();
        } catch(ClassNotFoundException c) {
            System.out.println("Plane class not found");
            c.printStackTrace();
            return;
        }

        System.out.println(p1);
    }


}
