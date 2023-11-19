package sit.int202.classic_models.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classic_models.model.Office;
import sit.int202.classic_models.util.EntityManagerBuilder;

import java.util.List;

public class OfficeRepository {
    private EntityManager entityManager;

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public List<Office> findAll() {
        return getEntityManager().createNamedQuery("OFFICE.FIND_ALL", Office.class).getResultList();
    }

    public Office find(String officeCode) {
        return getEntityManager().find(Office.class, officeCode);
    }

    public List<Office> findByCityOrCountry(String cityOrCountry) {
        cityOrCountry = cityOrCountry.toLowerCase();
        Query query = getEntityManager().createNamedQuery("OFFICE.FIND_BY_CITY_OR_COUNTRY", Office.class);
        query.setParameter("city", cityOrCountry);
        query.setParameter("country", cityOrCountry);
        List<Office> filteredOffices = query.getResultList();
        return filteredOffices;
    }

    private int getNumberOfEmployees(String officeCode) {
        Query query = getEntityManager().createNamedQuery("OFFICE.GET_NUMBER_OF_EMPLOYEES_IN_OFFICE");
        query.setParameter("officeCode", officeCode);
        return ((Number) query.getSingleResult()).intValue();
    }

    public int getNumberOfEmployees(List<Office> offices) {
        if (offices.isEmpty()) return 0;
        int total = 0;
        for (Office office : offices) {
            total += getNumberOfEmployees(office.getOfficeCode());
        }
        return total;
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public boolean insert(Office office) {
        try {
            EntityManager entityManager =
                    getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(office);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean delete(Office office) {
        if (office != null) {
            EntityManager entityManager =
                    getEntityManager();
            if (entityManager.contains(office)) {
                entityManager.getTransaction().begin();
                entityManager.remove(office);
                entityManager.getTransaction().commit();
                return true;
            } else {
                return delete(office.getOfficeCode());
            }
        }
        return false;
    }

    public boolean delete(String officeCode) {
        EntityManager entityManager =
                getEntityManager();
        Office office = find(officeCode);
        if (office != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(office);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    public boolean update(Office newOffice) {
        if (newOffice != null) {
            EntityManager entityManager = getEntityManager();
            Office existingOffice = find(newOffice.getOfficeCode());

            if (existingOffice != null) {
                try {
                    entityManager.getTransaction().begin();

                    existingOffice.setAddressLine1(newOffice.getAddressLine1());
                    existingOffice.setAddressLine2(newOffice.getAddressLine2());
                    existingOffice.setCity(newOffice.getCity());
                    existingOffice.setState(newOffice.getState());
                    existingOffice.setCountry(newOffice.getCountry());
                    existingOffice.setPostalCode(newOffice.getPostalCode());
                    existingOffice.setPhone(newOffice.getPhone());
                    existingOffice.setTerritory(newOffice.getTerritory());

                    entityManager.getTransaction().commit();
                    return true;
                } catch (Exception e) {
                    entityManager.getTransaction().rollback();
                }
            }
        }
        return false;
    }

}