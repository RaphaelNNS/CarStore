package br.com.rngam;

import br.com.rngam.daos.BrandDao;
import br.com.rngam.daos.interfaces.IBrandDao;
import br.com.rngam.models.BrandModel;
import br.com.rngam.models.CarModel;
import org.junit.Test;

import java.util.ArrayList;

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
        brand.setCarList(new ArrayList<CarModel>());
        dao.add(brand);

        //remove the test brand
    }


}
