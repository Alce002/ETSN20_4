import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        if(args.length != 3) {
            System.err.println("Wrong number of parameters. Expected: search <pattern> <file>");
            System.exit(1);
        }

        if(!Objects.equals(args[0], "search")) {
            System.err.println("Incorrect first parameter: " + args[0]);
            System.exit(1);
        }

        findPattern(args[1], args[2]);
    }

    static void findPattern(String pattern, String file) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            for(String line; (line = br.readLine()) != null;) {
                if(line.contains(pattern)) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e)  {
            System.err.println("Could not find file: " + file);
        }
    }
}
