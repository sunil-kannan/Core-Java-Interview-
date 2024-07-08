package exception_package;

//It occurs when an application tries to load a class at runtime which is not updated in the classpath.
//It occurs when classpath is not updated with required JAR files. It is an exception of type java.lang.Exception.
//It occurs when classpth is not updated with required JAR files.

/*
java.lang.ClassNotFoundException: com.mysql.jdbc.Driver
at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
at java.base/java.lang.Class.forName0(Native Method)
at java.base/java.lang.Class.forName(Class.java:383)
at java.base/java.lang.Class.forName(Class.java:376)
at Errors.ClassNotFoundExceptionClass.main(ClassNotFoundExceptionClass.java:11) */

public class ClassNotFoundExceptionClass {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
