package br.com.rngam.daos;

import br.com.rngam.daos.interfaces.ICarDao;
import br.com.rngam.models.BrandModel;
import br.com.rngam.models.CarModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class CarDao implements ICarDao {
    @Override
    public CarModel add(CarModel carModel) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(carModel);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();


        return carModel;
    }

    @Override
    public void remove(CarModel carModel) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        carModel = entityManager.merge(carModel);
        entityManager.remove(carModel);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    @Override
    public List<CarModel> listAll() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CarModel> query = builder.createQuery(CarModel.class);
        Root<CarModel> root = query.from(CarModel.class);
        query.select(root);

        TypedQuery<CarModel> tpQuery =
                entityManager.createQuery(query);
        List<CarModel> list = tpQuery.getResultList();

        entityManager.close();
        entityManagerFactory.close();
        return list;
    }

}
