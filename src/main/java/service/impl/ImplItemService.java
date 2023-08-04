package service.impl;

import model.Item;

import java.util.List;

public interface ImplItemService {
    Item getItemById(Long id);
    String validateItemId(Long id);
    Long findItemIdByLoanId(Long loanId);
    List<Item> getAllItems();
    void saveItem(Item item);
    String validateItemId(String itemName, String itemType);
    void deleteItem(Long itemId);
}
