package sit.int202.classic_models;

import jakarta.persistence.*;
import sit.int202.classic_models.entities.Employee;
import sit.int202.classic_models.entities.Environment;

import java.util.List;
import java.util.Scanner;

public class TestPagination {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Query queryEmpFindAll = em.createNamedQuery("EMPLOYEE.FIND_ALL");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of entity per page: ");
        int pageSize = sc.nextInt();
        int beginFrom = 0;
        queryEmpFindAll.setMaxResults(pageSize);
        while (true) {
            queryEmpFindAll.setFirstResult(beginFrom);
            List<Employee> employeeList = queryEmpFindAll.getResultList();
            if (employeeList.isEmpty()) {
                break;
            }
            displayEmployees(employeeList);
            System.out.println("---------------------");
            System.out.print("Press any key the enter to see next page ...");
            sc.next();
            beginFrom = beginFrom + pageSize;
        }
        em.close();
    }

    private static void displayEmployees(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.printf("%4d %-12s %-12s %-15s\n",
                    employee.getEmployeeNumber(), employee.getFirstName(),
                    employee.getLastName(), employee.getJobTitle());
        }
    }
}
