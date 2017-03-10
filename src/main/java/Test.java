import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by geyao on 2017/3/10.
 */
public class Test {
    public static void main(String[] args) {
        String pathDirectory = System.getenv("HOME") + "/files/";
        File directory = new File(pathDirectory);
        File[] files = directory.listFiles();
        System.out.println(files.length);
        ArrayList<File> file = new ArrayList<>();
        for (File tempfile :
                files) {
            if (tempfile.isDirectory())
                ;
            else {
                if (tempfile.getName().endsWith(".DS_Store"))
                    continue;
                file.add(tempfile);
                System.out.println(tempfile.getName());
            }
        }
        System.out.println(file);
    }
}
