package br.com.rngam;

import br.com.rngam.daos.AccessoryDao;
import br.com.rngam.daos.BrandDao;
import br.com.rngam.daos.CarDao;
import br.com.rngam.daos.interfaces.IAccessoryDao;
import br.com.rngam.daos.interfaces.IBrandDao;
import br.com.rngam.daos.interfaces.ICarDao;
import br.com.rngam.models.AccessoryModel;
import br.com.rngam.models.BrandModel;
import br.com.rngam.models.CarModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccessoryDaoTest {

    private ICarDao carDao;
    private IBrandDao brandDao;
    private IAccessoryDao accessoryDao;

    public AccessoryDaoTest(){
        brandDao = new BrandDao();
        carDao =  new CarDao();
        accessoryDao = new AccessoryDao();
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

        AccessoryModel accessory = new AccessoryModel();
        accessory.setCar(car);
        accessory.setName("grilles");
        accessory.setDescription("here comes the car description");
        accessoryDao.add(accessory);

        assertTrue(accessoryDao.listAll().contains(accessory));
        assertEquals("grilles", accessory.getName());
        assertEquals("here comes the car description", accessory.getDescription());
    }
    @Test
    public void remove(){


        AccessoryModel accessory = new AccessoryModel();
        accessory.setName("grilles");
        accessory.setDescription("here comes the car description");
        accessoryDao.add(accessory);

        assertEquals("grilles", accessory.getName());
        assertEquals("here comes the car description", accessory.getDescription());

        accessoryDao.remove(accessory);

        assertFalse(accessoryDao.listAll().contains(accessory));


    }

    @Test
    public void listAll(){
        AccessoryModel accessory = new AccessoryModel();
        assertFalse(accessoryDao.listAll().contains(accessory));

    }

    @AfterAll
    public static void resetDB(){
        ICarDao carDao = new CarDao();
        IBrandDao brandDao =  new BrandDao();
        IAccessoryDao accessoryDao = new AccessoryDao();
        accessoryDao.listAll().forEach(accessoryDao::remove);
        carDao.listAll().forEach(carDao::remove);
        brandDao.listAll().forEach(brandDao::remove);
    }


}
