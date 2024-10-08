package successive_refinement.abstraction;

import successive_refinement.exception.ArgsException;

import java.util.Iterator;

public class BooleanArgumentMarshaler implements ArgumentMarshaler {
    private boolean booleanValue = false;
    public void set(Iterator<String> currentArgument) throws ArgsException {
        booleanValue = true;
    }
    public static boolean getValue(ArgumentMarshaler am) {
        if (am instanceof BooleanArgumentMarshaler)
            return ((BooleanArgumentMarshaler) am).booleanValue;
        else
            return false;
    }
}
