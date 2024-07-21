package designPattern.principle.solid;

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        // As per this even if we substitute the
        // Employee object with Office Object it should work

        Emp employee = new Emp("Testing",1);
        employee.printMe();

        Office offices = new Office("Testing",1,"Bangalore");
        offices.printMe(); //Though we don't have method there

        LiskovSubstitutionPrinciple liskovSubstitutionPrinciple = new LiskovSubstitutionPrinciple();
        liskovSubstitutionPrinciple.printData(employee);
        liskovSubstitutionPrinciple.printData(offices); // Inherited class should be able to use the super method
    }

    //Here i should be able to pass the Employee as well as Office data
    void printData(Emp employee) {
        employee.printMe();
    }
}
class Emp{
    private String name;
    private int id;
    public Emp(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public void printMe(){
        System.out.println("EmployeeName"+name+" Id:"+id);
    }

}

class Office extends Emp{
    private String officeLocation;
    public Office(String name, int id,String officeLocation) {
        super(name, id);
        this.officeLocation = officeLocation;
    }
}
