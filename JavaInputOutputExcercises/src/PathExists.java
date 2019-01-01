import java.io.File;

public class PathExists {

    public static void main(String[] args) {

        File file = new File("/Users/Moesen/Dropbox/Skolegang/GrundSkole/6.C/Dansk");

        String[] files = file.list();

        if(file.isDirectory() || file.isFile()) System.out.println("It is");
        else System.out.println("Its nok");




    }

}
