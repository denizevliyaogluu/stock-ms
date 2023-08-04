package service;

import model.ItemRepair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.ItemRepairRepository;
import service.impl.ImplItemRepairService;

import java.util.List;
import java.util.Optional;

@Service
public class ItemRepairService implements ImplItemRepairService {
    @Autowired
    private ItemRepairRepository itemRepairRepository;
    @Override
    public List<ItemRepair> getAllRepairItems() {
        return itemRepairRepository.findAll();
    }

    @Override
    public void saveItemRepair(ItemRepair itemRepair) {
        this.itemRepairRepository.save(itemRepair);
    }

    @Override
    public void deleteItemRepairById(Long id) {
        this.itemRepairRepository.deleteById(id);
    }

    @Override
    public ItemRepair findItemRepairById(Long id) {
        Optional<ItemRepair> optional = itemRepairRepository.findById(id);
        ItemRepair itemRepair = null;
        if(optional.isPresent()){
            itemRepair = optional.get();
        }else {
            //exception
        }
        return itemRepair;
    }
}
