package object_package.polymorphism;


// An abstract class can not be final in Java
// You can not create instances of abstract class in Java
//
interface  sunil{
    int interfaceMethod();
}
class sunil1{
    public void Methods(){

    }

}

// abstract class can implements the interface and also extends the normal class, but if you need to call the method means you
abstract class Parent extends sunil1 implements sunil {

    int id;
    String name;
    public Parent(int id, String name){
        this.id = id;
        this.name= name;
    }
    public static void staticMethod(){
        System.out.println("Static method called from the parent class");
    }

    public void method1(){
        System.out.println("Called from parent class");
        super.Methods(); // like this you can call the parent class method from the abstract class
    }

    abstract String method2();



}

public class AbstractClass extends Parent{
    String company;

    public AbstractClass(int id, String name, String company){
        super(id, name);
        this.company = company;
    }

    @Override
    public int interfaceMethod() { // this method if from the abstract parent class (interface) which is implemented
        return 0;
    }
    @Override
    String method2() {
        return "Java";
    }

    public void method1(){
        System.out.println("Called from child class"+"id: "+super.id + " name: "+super.name + " Company: "+company);
    }

    public static void staticMethod(){
        System.out.println("Static method called from the child class");
    }
    public static void main(String[] args) {
        Parent parent = new AbstractClass(3,"Sunil", "Amazon");
        parent.method1(); // this will call the child class

        parent.staticMethod(); // you can call the static method like this it will invoke the method from Parent class

//      Parent parent class = new Parent(); // Parent' is abstract; cannot be instantiated

//        String s = "abass";
//        StringBuffer sol = new StringBuffer();
//        StringBuffer solReverse = new StringBuffer();
//        for(int i=0; i<s.length(); i++){
//            sol.append(s.charAt(i));
//            for(int j=i+1; j<s.length(); j++){
//                sol.append(s.charAt(j));
//                sol.reverse();
//                sol.reverse();
//                System.out.println(sol.reverse()+ " "+sol.toString() +" "+ sol.reverse().toString().contentEquals(sol.toString()));
//                if(sol.reverse().toString().contentEquals(sol.toString())){
//                    System.out.println(sol);
//                }
//            }
//            sol.setLength(0);
//    }
        String s = "tscvrnsnnwjzkynzxwcltutcvvhdivtmcvwdiwnbmdyfdvdiseyxyiiurpnhuuufarbwalzysetxbaziuuywugfzzmhoessycogxgujmgvnncwacziyybryxjagesgcmqdryfbofwxhikuauulaqyiztkpgmelnoudvlobdsgharsdkzzuxouezcycsafvpmrzanrixubvojyeuhbcpkuuhkxdvldhdtpkdhpiejshrqpgsoslbkfyraqbmrwiykggdlkgvbvrficmiignctsxeqslhzonlfekxexpvnblrfatvetwasewpglimeqemdgdgmemvdsrzpgacpnrbmomngjpiklqgbbalzxiikacwwzbzapqmatqmexxqhssggsyzpnvvpmzngtljlrhrjbnxgpcjuokgxcbzxqhmitcxlzfehwfiwcmwfliedljghrvrahlcoiescsbupitckjfkrfhhfvdlweeeverrwfkujjdwtcwbbbbwctwdjjukfwrreveeewldvfhhfrkfjkctipubscseioclharvrhgjldeilfwmcwifwhefzlxctimhqxzbcxgkoujcpgxnbjrhrljltgnzmpvvnpzysggsshqxxemqtamqpazbzwwcakiixzlabbgqlkipjgnmombrnpcagpzrsdvmemgdgdmeqemilgpwesawtevtafrlbnvpxexkeflnozhlsqexstcngiimcifrvbvgkldggkyiwrmbqaryfkblsosgpqrhsjeiphdkptdhdlvdxkhuukpcbhueyjovbuxirnazrmpvfascyczeuoxuzzkdsrahgsdbolvduonlemgpktziyqaluuaukihxwfobfyrdqmcgsegajxyrbyyizcawcnnvgmjugxgocysseohmzzfguwyuuizabxtesyzlawbrafuuuhnpruiiyxyesidvdfydmbnwidwvcmtvidhvvctutlcwxznykzjwnnsnrvcst";
        StringBuilder sol = new StringBuilder();
        StringBuilder solFinal = new StringBuilder();

        int i = 0;
        int n = 0;
        while (s.length() > n) {
            sol.append(s.charAt(n));
            StringBuilder originalSol = new StringBuilder(sol); // Create a copy of sol
            if (originalSol.reverse().toString().contentEquals(sol.toString()) && sol.length() > solFinal.length()) {
                solFinal.setLength(0);
                solFinal.append(sol);
            } else {
                sol.delete(0, 1);
            }
            n++;
        }

//        for(int i=0; i<s.length(); i++){
//            sol.append(s.charAt(i));
//            for(int j=i+1; j<s.length(); j++){
//                sol.append(s.charAt(j));
//                StringBuilder originalSol = new StringBuilder(sol);  // Create a copy of sol
//                if(originalSol.reverse().toString().contentEquals(sol.toString())){
//                    if(sol.length() > solFinal.length()){
//                        solFinal.setLength(0);
//                        solFinal.append(sol);
//                    }
//                }
//            }
//            sol.setLength(0);
//        }
        System.out.println(solFinal.toString());
        }



}
