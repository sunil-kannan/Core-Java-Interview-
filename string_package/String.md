


## Why is String made immutable in Java?
Immutable means unmodifiable or unchangeable.
**Security** is the major reason why strings in java are made to be immutable.
Strings in Java can be used to access datasources like files, databases or
even Objects found across networks. Even sometimes, strings store passwords 
and usernames, which can't be modified once created.


## What happens If you create String using 'new' keyword ?
**Two objects** are created: when you use the new keyword or when you create a string literal that doesn't exist in the pool yet.
First object is created in String Constant pool and another one will check whether the value is presented in the String constant pool,
if it is not presented means it will create one object in the String Constant pool

```bash
# s1 will create 2 object 
String s1 = new String("code");
String s2 = "Java";
# s3 will create only 1 object
String s3 = new String("Java")
```

## StringBuffer and Thread Safety
StringBuffer is designed to be thread-safe. It achieves thread safety by synchronizing its methods, which means only one thread can execute a synchronized method at a time for a given object. This prevents concurrent access issues but can lead to performance bottlenecks due to the overhead of acquiring and releasing locks.

## StringBuilder and Non-Thread Safety
StringBuilder, on the other hand, is not thread-safe. It does not synchronize its methods, which means multiple threads can access and modify a StringBuilder instance simultaneously, leading to potential data inconsistencies. However, because it does not have the overhead of synchronization, it is generally faster and more efficient for single-threaded operations.

