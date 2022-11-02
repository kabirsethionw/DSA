package dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
    private int id;
    private long salary;

    public int getId() {
        return id;
    }

    public long getSalary() {
        return salary;
    }

    public Employee(int id, long salary){
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "[ id = " + id + ", salary = " + salary + " ]";
    }
}

public class SortEmpDesc {

    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<Employee>();
        empList.add(new Employee(1, 3000000));
        empList.add(new Employee(2, 1700000));
        empList.add(new Employee(3, 1100000));
        empList.add(new Employee(4, 2000000));
        empList.add(new Employee(5, 1000000));
        empList.add(new Employee(6, 2300000));
        Collections.sort(empList, (emp1, emp2) -> (int)(emp1.getSalary() - emp2.getSalary()));
        for(Employee emp : empList){
            System.out.println(emp);
        }

        List<Employee> reversedEmpList = empList.stream().sorted((emp1, emp2) -> (int)(emp2.getSalary() - emp1.getSalary())).collect(Collectors.toList());
        System.out.println("\nAfter reversing:\n");
        for(Employee emp : reversedEmpList){
            System.out.println(emp);
        }
        System.out.println("\nTop 3:\n");
        List<Employee> top3 = reversedEmpList.stream().limit(3).collect(Collectors.toList());
        for(Employee emp : top3){
            System.out.println(emp);
        }

        System.out.println("\n3rd highest:\n");
        List<Employee> third = reversedEmpList.stream().skip(2).limit(1).collect(Collectors.toList());
        System.out.println(third.get(0));
    }
}
