package access_modifier.firstPackage;

import access_modifier.firstPackage.sub_package.SubClass;

public class FirstClass extends SecondClass {

    SubClass subClass = new SubClass();
    SecondClass secondClass = new SecondClass();

    private void Method() {
        protectedMethod();
        publicMethod();
        defaultMethod();
//       subClass.defaultMethod();
    }

}

