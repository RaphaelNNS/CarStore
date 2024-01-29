package br.com.rngam.daos.interfaces;

import br.com.rngam.models.AccessoryModel;


import java.util.List;

public interface IAccessoryDao {
    public AccessoryModel add(AccessoryModel accessory);
    public void remove(AccessoryModel accessoryModel);
    public List<AccessoryModel> listAll();
}
