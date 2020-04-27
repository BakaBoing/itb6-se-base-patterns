package at.fhv.itb6.se.plugin;

public class RunMe {

    public static void main(String[] args) {

        System.setProperty("plugins", args[0]);
        Customer pp = Customer.create("Patrick Poiger");
        Customer sl = Customer.create("Sumin Lee");

        System.out.println("--------------------------------------------------------------");
        System.out.println(IIdGenerator.INSTANCE.getClass().getSimpleName());
        System.out.println("--------------------------------------------------------------");
        System.out.println(pp);
        System.out.println(sl);
        System.out.println("--------------------------------------------------------------");
    }
}
