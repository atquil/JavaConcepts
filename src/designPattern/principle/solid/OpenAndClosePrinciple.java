package designPattern.principle.solid;

public class OpenAndClosePrinciple {
    public static void main(String[] args) {
        Employees emp = new Employees("Alpha",1);
        emp.printMe();
    }
}

class Employees{
    private String name;
    private int id;

    public Employees(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public void printMe(){
       System.out.println("EmployeeName"+name+" Id:"+id);
    }
    //Modifying it will cause a trouble - Close for modification

    //Now new requirement came to add officeLocation;

    // private String officeLocation;

//    public Employee(String name, int id, String officeLocation) {
//        this.name = name;
//        this.id = id;
//        this.officeLocation = officeLocation;
//    }
}

//What should we do then? Open for Extension
class OfficeLocation extends Employees{
    private String officeLocation;
    public OfficeLocation(String name, int id,String officeLocation) {
        super(name, id);
        this.officeLocation = officeLocation;
    }
}
//In this way old code will not break
