package service.impl;

import model.ItemType;

import java.util.List;

public interface ImplItemTypeService {
    void saveItemType(ItemType itemType);
    ItemType getItemTypeByName(String name);
    List<ItemType> getAllItemTypes();
    String validateItemTypeByName(String name);
}
