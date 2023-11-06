package sit.int202.classic_models.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sit.int202.classic_models.entities.Environment;

public class EntityManagerBuilder {
    private final static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("classic-models");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}

