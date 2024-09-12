package successive_refinement;

import successive_refinement.abstraction.ArgumentMarshaler;
import successive_refinement.exception.ArgsException;
import java.util.Map;


public class Main {
    public static void executeApplication(boolean logging, int port, String dir){
        System.out.println("logging: "+logging+" port: "+port+" Directory: "+dir);
    }

    public static void main(String[] args) {
        Map<Character, ArgumentMarshaler> marshalers;
        try {
            Args arg = new Args("l,p#,d*", new String[]{ "-l", "-p", "8080", "-d" ,"/path/to/directory"});
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            executeApplication(logging, port, directory);
        } catch (ArgsException e) {
            System.out.printf("Argument error: %s\n", e.errorMessage());
        }
    }
}
