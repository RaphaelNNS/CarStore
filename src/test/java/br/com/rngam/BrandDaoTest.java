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

public class BrandDaoTest {
    IBrandDao dao;

    public BrandDaoTest() {
        dao = new BrandDao();
    }


    @Test
    public void add(){
        BrandModel brand = new BrandModel();
        brand.setSince(1950);
        brand.setDescription("descrito");   
        brand.setName("ferrari");
        brand.setCarList(new ArrayList<CarModel>());
        BrandModel brandModelAdded = dao.add(brand);
        List<BrandModel> brandModelList = dao.listAll();

        //verifies if the added brand exists in DB
        assertTrue(brandModelList.contains(brandModelAdded));
    }

    @Test
    public void remove(){
        BrandModel brand = new BrandModel();
        brand.setSince(1950);
        brand.setDescription("descrito");
        brand.setName("ferrari");
        brand.setCarList(new ArrayList<CarModel>());

        dao.add(brand);


        dao.remove(brand);
        //assert that the Brand doesnt exist at the db anymore
        assertFalse(dao.listAll().contains(brand));
    }
    @Test
    public void listAll(){
        assertNotNull(dao.listAll());
    }

    @AfterAll
    public static void removeCarAndBrandAddeds(){
        ICarDao carDao = new CarDao();
        IBrandDao brandDao =  new BrandDao();
        carDao.listAll().forEach(carDao::remove);
        brandDao.listAll().forEach(brandDao::remove);
    }



}