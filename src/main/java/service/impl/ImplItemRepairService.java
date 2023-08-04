package service.impl;

import model.ItemRepair;

import java.util.List;

public interface ImplItemRepairService {
    List<ItemRepair> getAllRepairItems();
    void saveItemRepair(ItemRepair itemRepair);
    void deleteItemRepairById(Long id);
    ItemRepair findItemRepairById(Long id);
}
