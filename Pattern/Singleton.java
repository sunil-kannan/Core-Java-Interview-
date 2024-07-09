package Pattern;

class SingletonClass{
    // making constructor private so that object will not be created by any other class
    private SingletonClass(){}

    //2 ways to

    //Initialized directly in the field declaration
    private static final SingletonClass singletonInstance = new SingletonClass();
    public static SingletonClass getInstance(){
        return singletonInstance;
    }

    // If you want to use lazy initialization (initializing the instance when it is first accessed), you can use the following approach:
    private static SingletonClass singletonInstance1 =null;
    public  static SingletonClass getInstance1(){
        if(singletonInstance1 == null){
            singletonInstance1 = new SingletonClass();
        }
        return singletonInstance1;
    }
}

public class Singleton {
    public static void main(String[] args) {
        // 1st way
        SingletonClass object = SingletonClass.getInstance();
        System.out.println(object.hashCode());
        SingletonClass object1 = SingletonClass.getInstance();
        System.out.println(object1.hashCode());

        //2nd way
        SingletonClass object2 = SingletonClass.getInstance1();
        System.out.println(object2.hashCode());

    }
}
