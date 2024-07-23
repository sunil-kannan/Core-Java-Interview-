package primitive_types;

public class Byte {

    public static void main(String[] args) {
        int n = 129;
        byte ch = (byte) n;
        // Although you might expect an error because a byte can store only values between -128 and 127,
        // it will not show any error. Instead, it will perform the conversion and print the resulting value.
        // 127<129 so 128 = -128 and 129 = -127 .....
        System.out.println(ch); // -127
    }
}
//