package utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/*
    In Java, a PrintStream is an output stream that allows users to format and print data in a convenient way.
    It has a set of methods for formatting and printing various types of data, such as println() and printf().
    Unlike other output streams, a PrintStream doesn't throw an IOException, but it does set a flag in case of errors
    that can be tested using the checkError() method.
*/
public class PrintStreamClass {

    public static void main(String[] args) throws IOException {



        System.out.println(34 + 34); // this will return the string value because println method has toString method

//      Character
        System.out.println('a'+3); // 100
        System.out.println((char)('a'+3)); // d

        // If one of the data type is String the answer will be in String
        System.out.println("a" + 'b');
        System.out.println('a' + "b");


        double a = 35.55845;
        double b = 40.1245414;
        System.out.printf("a = %.2f b = %.4f", a, b); //a = 35.56   b = 40.1245


        /*
        There are many format specifiers we can use. Here are some common ones:

                %c - Character
                %d - Decimal number (base 10)
                %e - Exponential floating-point number
                %f - Floating-point number
                %i - Integer (base 10)
                %o - Octal number (base 8)
                %s - String
                %u - Unsigned decimal (integer) number
                %x - Hexadecimal number (base 16)
                %t - Date/time
                %n - Newline
    */

        PrintStream ps = System.out;
        System.out.format("Hello, %s %s!\n", "Java","world "); // Hello, Java world!
        ps.format("Hello, %s! Current Time is %tT", "Java world", Calendar.getInstance()); // Hello, Java world! Current Time is 18:15:56
        System.out.printf("\"");


    }
}
