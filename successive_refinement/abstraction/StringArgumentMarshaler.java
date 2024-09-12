package successive_refinement.abstraction;

import successive_refinement.exception.ArgsException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static successive_refinement.exception.ArgsException.ErrorCode.MISSING_STRING;

public class StringArgumentMarshaler implements ArgumentMarshaler {
    private String stringValue = "";
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING);
        }
    }
    public static String getValue(ArgumentMarshaler am) {
        if (am instanceof StringArgumentMarshaler){
            System.out.println("value: "+((StringArgumentMarshaler) am).stringValue);
            return ((StringArgumentMarshaler) am).stringValue;
        }

        else
            return "";
    }
}