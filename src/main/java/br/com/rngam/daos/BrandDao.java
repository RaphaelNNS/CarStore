package br.com.rngam.daos;

import br.com.rngam.daos.interfaces.IBrandDao;
import br.com.rngam.models.BrandModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class BrandDao implements IBrandDao {
    @Override
    public BrandModel add(BrandModel brand) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(brand);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


        return brand;
    }

    @Override
    public void remove(BrandModel brand) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        brand = entityManager.merge(brand);
        entityManager.remove(brand);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public List<BrandModel> listAll() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BrandModel> query = builder.createQuery(BrandModel.class);
        Root<BrandModel> root = query.from(BrandModel.class);
        query.select(root);

        TypedQuery<BrandModel> tpQuery =
                entityManager.createQuery(query);
        List<BrandModel> list = tpQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return list;
    }
}
