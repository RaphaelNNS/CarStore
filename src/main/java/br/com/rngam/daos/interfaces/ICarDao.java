package br.com.rngam.daos;

import br.com.rngam.models.CarModel;
import br.com.rngam.models.acessorieModel;

import java.util.List;

public interface ICarDao {
    public CarModel add(CarModel carModel);
    public void remove(CarModel carModel );
    public List<acessorieModel> listAll();

}
