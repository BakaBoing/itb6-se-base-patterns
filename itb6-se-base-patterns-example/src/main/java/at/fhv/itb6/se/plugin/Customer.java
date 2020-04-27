package at.fhv.itb6.se.plugin;

public class Customer {
    private Long _id;
    private String _name;

    private Customer(String name, Long id) {
        _id = id;
        _name = name;
    }

    public static Customer create(String name){
        Long newId = IIdGenerator.INSTANCE.nextId();
        return new Customer(name, newId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "_id=" + _id +
                ", _name='" + _name + '\'' +
                '}';
    }
}
