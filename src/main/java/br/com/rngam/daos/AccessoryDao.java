package br.com.rngam.daos;

import br.com.rngam.daos.interfaces.IAccessoryDao;
import br.com.rngam.models.AccessoryModel;
import br.com.rngam.models.CarModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class AccessoryDao implements IAccessoryDao {

    @Override
    public AccessoryModel add(AccessoryModel accessory) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(accessory);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


        return accessory;
    }

    @Override
    public void remove(AccessoryModel accessoryModel) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        accessoryModel = entityManager.merge(accessoryModel);
        entityManager.remove(accessoryModel);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public List<AccessoryModel> listAll() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AccessoryModel> query = builder.createQuery(AccessoryModel.class);
        Root<AccessoryModel> root = query.from(AccessoryModel.class);
        query.select(root);

        TypedQuery<AccessoryModel> tpQuery =
                entityManager.createQuery(query);
        List<AccessoryModel> list = tpQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return list;
    }
}
