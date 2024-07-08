package string_package;


/*
The StringBuffer value will always be 2000, but coming to StringBuilder it can vary
due to race conditions where threads overwrite each other's changes, so length might not always be 2000
 */

public class StringBufferVsStringBuilder{
    public static void main(String[] args) throws InterruptedException {
        // Using StringBuffer
        StringBuffer stringBuffer = new StringBuffer();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringBuffer.append("A");
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringBuffer.append("B");
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("StringBuffer length: " + stringBuffer.length());

        // Using StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringBuilder.append("A");
            }
        });
        Thread thread4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                stringBuilder.append("B");
            }
        });

        thread3.start();
        thread4.start();
        thread3.join();
        thread4.join();
        System.out.println("StringBuilder length: " + stringBuilder.length());
    }
}
