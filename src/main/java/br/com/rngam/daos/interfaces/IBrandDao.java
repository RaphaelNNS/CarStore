package br.com.rngam.daos.interfaces;

import br.com.rngam.models.BrandModel;
import br.com.rngam.models.CarModel;

import java.util.List;

public interface IBrandDao {
    public BrandModel add(BrandModel brand);
    public void remove(BrandModel brand);
    public List<BrandModel> listAll();
}
