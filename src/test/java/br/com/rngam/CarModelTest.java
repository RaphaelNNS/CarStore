package br.com.rngam;

import br.com.rngam.daos.BrandDao;
import br.com.rngam.daos.CarDao;
import br.com.rngam.daos.interfaces.IBrandDao;
import br.com.rngam.daos.interfaces.ICarDao;
import br.com.rngam.models.BrandModel;
import br.com.rngam.models.CarModel;
import br.com.rngam.models.AccessoryModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarModelTest {
    private ICarDao carDao;
    private IBrandDao brandDao;


    public CarModelTest(){
        brandDao = new BrandDao();
        carDao =  new CarDao();

    }
    @Test
    public void add(){
        BrandModel brand = new BrandModel();

        brand.setSince(1950);
        brand.setDescription("description here");
        brand.setName("ferrari");
        brand.setCarList(new ArrayList<CarModel>());
        brandDao.add(brand);

        CarModel car = new CarModel();
        car.setCarBrand(brand);
        car.setType("SUV");
        car.setAcessories(new ArrayList<AccessoryModel>());
        carDao.add(car);
        System.out.println(carDao.listAll());
        assertTrue(carDao.listAll().contains(car));
    }

    @Test
    public void listAll(){
        List list = carDao.listAll();
        assertNotNull(list);
    }

    @Test
    public void remove(){
        BrandModel brand = new BrandModel();

        brand.setSince(1950);
        brand.setDescription("description here");
        brand.setName("ferrari");
        brand.setCarList(new ArrayList<CarModel>());
        brandDao.add(brand);

        CarModel car = new CarModel();
        car.setCarBrand(brand);
        car.setType("SUV");
        car.setAcessories(new ArrayList<AccessoryModel>());
        carDao.add(car);
        System.out.println(carDao.listAll());
        assertTrue(carDao.listAll().contains(car));
        carDao.remove(car);
        //assert that the Brand doesnt exist at the db anymore
        assertFalse(carDao.listAll().contains(car));
    }




    @AfterAll
    public static void removeCarAndBrandAddeds(){
        ICarDao carDao = new CarDao();
        IBrandDao brandDao =  new BrandDao();
        carDao.listAll().forEach(carDao::remove);
        brandDao.listAll().forEach(brandDao::remove);
    }











}

