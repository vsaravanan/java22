package console.collection;

import lombok.Data;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Sarav on 09 Jun 2024
 * @project govtech
 * @package console.collection
 * @class ProrityQueueObject
 */

// https://raw.githubusercontent.com/vsaravanan/java22/master/src/main/java/console/collection/ProrityQueueObject.java
/*

    PriorityQueue is a type of queue in Java that orders its elements according to their natural ordering
    (if they implement Comparable) or by a Comparator provided at queue construction time.


 */
@Data
class Employee  {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", salary=" + salary + "] \n";
    }

}


class EmpComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary() - o2.getSalary();
    }
}

public class ProrityQueueObject {
    public static void main(String[] args) {
        Employee e1 = new Employee("Sarav", 300);
        Employee e2 = new Employee("Raj", 200);
        Employee e3 = new Employee("Ravi", 4000);
        Employee e4 = new Employee("Rahul", 50);
        Employee e5 = new Employee("Juhi", 10);

        EmpComparator comparator = new EmpComparator();

        PriorityQueue<Employee > pq = new PriorityQueue<>(5, comparator);
        pq.add(e1);
        pq.add(e2);
        pq.add(e3);
        pq.add(e4);
        pq.add(e5);
        pq.add(new Employee("F", 3500));
        pq.add(new Employee("G", 50000));


        System.out.println("peek " +  pq.peek());

        System.out.println(pq);

        System.out.println("for loop will not print in sorted order");
        for (Employee e : pq) {
            System.out.println(e);
        }

        System.out.println("use sorted comparator to get sorted order");
        pq.stream().sorted(comparator).forEach(System.out::println);

        while (! pq.isEmpty()) {
            System.out.println("polled " + pq.poll());
            System.out.println(pq);
            System.out.println("-----------------------------------------------------");
        }

    }
}


