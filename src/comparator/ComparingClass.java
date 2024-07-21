package comparator;

import java.util.*;
import java.util.stream.Collectors;

public class ComparingClass {
    public static void main(String[] args) {

        //Creating the object
        Employee employee1 = new Employee("Atul","Anand",new Address(1,"somethig"));
        Employee employee2 = new Employee("Atul","Himu",new Address(2,"somethig"));
        Employee employee3 = new Employee("Atul","zdma",new Address(4,"somethig"));
        Employee employee4 = new Employee("Atul","something",new Address(12,"somethig"));

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        // Now sort based on the is comparision

        Collections.sort(employees, new CustomEmployeeComparator());

        Collections.sort(employees, new EmployeeComparatorBasedOnLastName());

        System.out.println(employees);

    }
}
