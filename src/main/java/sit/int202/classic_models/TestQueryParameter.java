package sit.int202.classic_models;

import jakarta.persistence.*;
import sit.int202.classic_models.entities.Employee;
import sit.int202.classic_models.entities.Environment;

import java.util.List;
import java.util.Scanner;

public class TestQueryParameter {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Query queryEmpFindByName = em.createNamedQuery("EMPLOYEE.FIND_BY_NAME");
        Scanner sc = new Scanner(System.in);
        char choice = 'x';
        do {
            System.out.print("Search Employee by name (enter . to stop) : ");
            String name = sc.next();
            choice = name.charAt(0);
            if (choice == '.') {
                break;
            }
            queryEmpFindByName.setParameter("first_name", name + "%");
            queryEmpFindByName.setParameter("last_name", name + "%");
            List<Employee> employeeList = queryEmpFindByName.getResultList();
            if (employeeList.isEmpty()) {
                System.out.println("Employee name start with " + name + " does not exist !!!");
            } else {
                displayEmployees(employeeList);
            }
        } while (true);
    }

    private static void displayEmployees(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.printf("%4d %-10s %-12s %-15s\n", employee.getEmployeeNumber(), employee.getFirstName(), employee.getLastName(), employee.getJobTitle());
        }
    }
}
