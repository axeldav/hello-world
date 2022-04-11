import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader{

    String path = "test.txt";

    FileInputStream inputStream = null;
    Scanner sc = null;


    public void readFile() throws FileNotFoundException {
        inputStream = new FileInputStream(path);
        sc = new Scanner(inputStream, "UTF-8");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);
        }
    }
}
