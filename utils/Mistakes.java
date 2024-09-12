package utils;

import java.util.Optional;

public class Mistakes {
    public boolean stringComparison(String str){
        // It will throw NullPointerException in case if the String is null
        // return str.equals("Java");
        return "java".equals(str);
    }
    public int sum(int... args){
        // use varargs for calculation
        int sum =0;
        for(int val: args){
          sum = val + sum;
        }
        return sum;
    }

    public int getLength(String str){
        // always use optional to get the length of the value or accessing any value of the object
        Optional<String> opt = Optional.ofNullable(str);
        if(opt.isPresent()){
            // this will increase time complexity because in every loop it will fetch the length
            for(int i=0; i<opt.get().length(); i++){}

            int length = opt.get().length(); // store like this and then use it in iteration
            for(int i=0; i<length; i++){}
            return opt.get().length();
        }
        return 0;
    }



    public static void main(String[] args) {
        Mistakes mistakes = new Mistakes();
        mistakes.getLength(null);
    }

}
