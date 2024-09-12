package successive_refinement.abstraction;

import successive_refinement.exception.ArgsException;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static successive_refinement.exception.ArgsException.ErrorCode.INVALID_INTEGER;
import static successive_refinement.exception.ArgsException.ErrorCode.MISSING_INTEGER;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {
    private int intValue = 0;
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            intValue = Integer.parseInt(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_INTEGER);
        } catch (NumberFormatException e) {
            throw new ArgsException(INVALID_INTEGER, parameter);
        }
    }
    public static int getValue(ArgumentMarshaler am) {
        if (am instanceof IntegerArgumentMarshaler)
            return ((IntegerArgumentMarshaler) am).intValue;
        else
            return 0;
    }
}