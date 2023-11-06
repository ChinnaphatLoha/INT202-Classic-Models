package sit.int202.classic_models;

import jakarta.persistence.*;
import sit.int202.classic_models.entities.Employee;
import sit.int202.classic_models.entities.Environment;
import sit.int202.classic_models.entities.Office;

import java.util.List;

public class TestQuery {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Environment.UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Query queryOfficeFindAll = em.createNamedQuery("OFFICE.FIND_ALL");
        List<Office> officeList = queryOfficeFindAll.getResultList();
        for (Office office : officeList) {
            System.out.printf("%-2s %-25s %-13s %-12s\n", office.getOfficeCode(), office.getAddressLine1(),
                    office.getCity(), office.getCountry());
        }
        System.out.println("------------------");
        Query queryEmployeeFindAll = em.createNamedQuery("EMPLOYEE.FIND_ALL");
        List<Employee> employeeList = queryEmployeeFindAll.getResultList();
        for (Employee employee : employeeList) {
            System.out.printf("%-2s %-25s %-13s %-12s\n", employee.getEmployeeNumber(), employee.getFirstName(),
                    employee.getLastName(), employee.getJobTitle());
        }
        em.close();
    }
}