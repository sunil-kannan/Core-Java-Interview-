
# Polymorphism
Polymorphism is one of the most important concepts in **OOPs**. 
It describes the ability of something to have or *to be displayed in more than one form*. 
The different forms arise because these entities can be assigned different meanings and used in various ways in multiple contexts. <br>
- Method overloading is a **compile-time polymorphism**. 
- Method overriding is a **run-time polymorphism**. 
- Method overloading helps to increase the readability of the program. Method overriding is used to grant the specific implementation of the method which is already provided by its parent class or superclass.

## Method Overloading
When there are multiple function with **same name but different parameter**
then these functions are said to be Method Overloading.


## Method Overriding
If the same method is defined in both the superclass and the subclass, then the method of the
*subclass class overrides the method of the superclass*. This is known as method overriding.

## Method Overhiding
Method hiding occurs when a subclass defines a static method with the same name and signature as a static method in the superclass.
Static methods are **not polymorphic** and are resolved at compile-time based on the reference type, not the actual object type.

```bash
# s1 will create 2 object 
String s1 = new String("code");
String s2 = "Java";
# s3 will create only 1 object
String s3 = new String("Java")
```

