package service;

import model.ItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.ItemTypeRepository;
import service.impl.ImplItemTypeService;

import java.util.List;

@Service
public class ItemTypeService implements ImplItemTypeService {
    @Autowired
    private ItemTypeRepository itemTypeRepository;

    @Override
    public void saveItemType(ItemType itemType) {
        itemTypeRepository.save(itemType);
    }

    @Override
    public ItemType getItemTypeByName(String name) {
        List<ItemType> itemTypeList = getAllItemTypes();
        ItemType itemType = null;
        for (ItemType it : itemTypeList){
            if (it.getTypeName().equalsIgnoreCase(name)){
                itemType = it;
                break;
            }
        }
        return itemType;
    }

    @Override
    public List<ItemType> getAllItemTypes() {
        return itemTypeRepository.findAll();
    }

    @Override
    public String validateItemTypeByName(String name) {
        String errorMessage = "";
        ItemType itemType = getItemTypeByName(name);
        if (itemType == null){
            errorMessage = "ItemType with name: " + name + " does not exists.";
        }
        return errorMessage;
    }
}
