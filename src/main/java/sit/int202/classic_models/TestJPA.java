package sit.int202.classic_models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classic_models.model.Employee;
import sit.int202.classic_models.model.Office;

import java.util.List;
import java.util.Scanner;

public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        System.out.println("Search for employees in Office code: ");
        int officeCode = new Scanner(System.in).nextInt();
        System.out.println();

        Office office = em.find(Office.class, officeCode);
        if (office != null) {
            System.out.println("Employees in Office " + office.getOfficeCode() + ":");
            List<Employee> employees = office.getEmployeeList();
            if (employees != null && !employees.isEmpty()) {
                for (Employee employee : employees) {
                    System.out.println("Employee Number: " + employee.getEmployeeNumber());
                    System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName());
                    System.out.println("Job Title: " + employee.getJobTitle());
                    System.out.println("-----------------------");
                }
            } else {
                System.out.println("No employees found in this office.");
            }
        } else {
            System.out.println("Office not found for the given code.");
        }
        em.close();
        emf.close();
    }
}
