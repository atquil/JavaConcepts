package designPattern.pattern.structural;

public class FlyweightDP {
    public static void main(String[] args) {
        TestingEmployee testingEmployee = new TestingEmployee();
        testingEmployee.setName("Something");
        testingEmployee.employeeCompanyDetails();
    }
}

class TestingEmployee implements EmployeeAttribute{

    private String employeeName;
    //Only need to create this attribute


    @Override
    public void setName(String name) {
        this.employeeName= name;
    }

    @Override
    public void employeeCompanyDetails() {
        System.out.println("CommonDetails"+CommonAttribute.companyName);
        System.out.println("CompanyAddress"+ CommonAttribute.companyAddress);
    }
}

interface EmployeeAttribute{
    void setName(String name);
    void employeeCompanyDetails();
}

//Create a sharableClass
class CommonAttribute{

    public static String companyName = "ABC";
    public static String companyAddress ="efg";
}