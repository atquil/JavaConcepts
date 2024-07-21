package designPattern.principle.solid;

//One class should have only one responsibility
public class SingleResponsibility {
    public static void main(String[] args) {

    }

}
class Employee{
    // Single Responsibility of Employee Details
    private int Id;
    private String Name;

    //private String streetName; //Not here.. but in separate Address
    private Address address;
    //Getter, Setter etc
}
class Address{
    //Single Responsibility of Address
    private String streetName;
    private int pincode;
    //Getter, Setter etc
}