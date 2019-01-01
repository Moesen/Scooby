import java.io.File;
import java.io.FilenameFilter;
import java.util.Date;

public class ListAllFiles {

    public static void main(String a[])
    {
        //Saves data about files at location
        File file = new File("/Users/Moesen/Desktop/Git/Scooby/JavaInputOutputExcercises/.idea");

        /*FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.charAt(0) == 'v';
            }
        };*/
        //Lists all files, saved at location
        String[] filesList = file.list(/*filter*/);

        //Prints it all
        for(String name:filesList) System.out.println(name);
    }






}
