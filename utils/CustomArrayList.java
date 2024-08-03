package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Objects;
import java.util.function.Consumer;

public class CustomArrayList<T> {

    Object[] data;
    public int size = 0;
    private final int DEFAULT_SIZE = 10;

    CustomArrayList(){
        data = new Object[DEFAULT_SIZE];
    }

    public void add(T value){
        if(isFull()){
            resize();
        }
        data[size]=value;
        size++;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    private boolean isFull(){
        return size >= data.length;
    }
    private void resize(){
        Object[] temp = new Object[data.length * 2];
//        System.arraycopy(data, 0, temp, 0, data.length); // you can use this method to copy the array to the new one
        for(int i=0; i<data.length; i++){
            temp[i]=data[i];
        }
        data = temp;
    }
    public void set(int index, T value){
        if(index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        data[index] = value;
    }

    public void forEach(Consumer<? super T> action) {
        final int size = this.size;
        for (int i = 0; i < size; i++)
            action.accept((T)data[i]);
    }


    public static void main(String[] args) {
        CustomArrayList<Integer> arr = new CustomArrayList<>();
        for(int i=0; i<14; i++){
            arr.add(i*3);
        }
        System.out.println("Length of the Array: "+arr.size);
        arr.set(3,5);
        // below commented line will give ArrayIndexOutOfBoundsException
        // arr.set(19,2);
        arr.forEach(System.out::println);
    }
}
