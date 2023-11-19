package sit.int202.classic_models.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classic_models.model.Product;
import sit.int202.classic_models.util.EntityManagerBuilder;

import java.util.List;

public class ProductRepository {
    private static final int PAGE_SIZE = 10;
    private EntityManager entityManager;

    private EntityManager getEntityManager() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = EntityManagerBuilder.getEntityManager();
        }
        return entityManager;
    }

    public int getDefaultPageSize() {
        return PAGE_SIZE;
    }

    public List<Product> findAll(int page, int pageSize) {
        int startPosition = (page - 1) * pageSize;
        Query query = getEntityManager().createNamedQuery("PRODUCT.FIND_ALL");
        query.setFirstResult(startPosition);
        query.setMaxResults(pageSize);
        return (List<Product>) query.getResultList();
    }

    public int countAll() {
        EntityManager entityManager = getEntityManager();
        int number = ((Number)
                entityManager.createNamedQuery("PRODUCT.COUNT").getSingleResult()).intValue();
        entityManager.close();
        return number;
    }

    public void close() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
