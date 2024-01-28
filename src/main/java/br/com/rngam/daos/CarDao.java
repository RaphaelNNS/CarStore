package br.com.rngam.daos;

import br.com.rngam.daos.interfaces.ICarDao;
import br.com.rngam.models.CarModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

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

    }

    @Override
    public List<CarModel> listAll() {
        return null;
    }

}
