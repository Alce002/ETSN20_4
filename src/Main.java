import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println("Missing required parameters: <pattern> <file>");
            return;
        }

        Pattern pattern = Pattern.compile(args[0]);

        try {
            BufferedReader br = new BufferedReader(new FileReader(args[1]));
            for(String line; (line = br.readLine()) != null;) {
                if(pattern.matcher(line).find()) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e)  {
            System.err.println("Could not find file: " + args[1]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
