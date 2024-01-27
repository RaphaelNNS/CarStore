package br.com.rngam;

import br.com.rngam.daos.CarDao;
import br.com.rngam.daos.interfaces.ICarDao;
import br.com.rngam.models.CarModel;
import br.com.rngam.models.acessorieModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CarModelTest {
    private ICarDao dao;


    public CarModelTest(){
        dao =  new CarDao();
    }

    @Test
    public void instancia(){
        CarModel car = new CarModel();
        car.setLicencePlate(12123);
        car.setAcessories(new ArrayList<acessorieModel>());

        Assert.assertNotNull(car.getAcessories());
    }









}

