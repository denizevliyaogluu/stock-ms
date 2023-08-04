package service;

import model.Item;
import model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.ItemRepository;
import service.impl.ImplItemService;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements ImplItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Item getItemById(Long id) {
        Optional<Item> optional = itemRepository.findById(id);
        Item item = null;
        if (optional.isPresent()){
            item = optional.get();
        }else {
            //exception
        }
        return item;
    }

    @Override
    public String validateItemId(Long id) {
        String errorMessage = "";
        Item item = getItemById(id);
        if (item == null){
            errorMessage = "Item id does not exists";
        }
        return errorMessage;
    }

    @Override
    public Long findItemIdByLoanId(Long loanId) {
        List<Item> itemList = getAllItems();
        List<Loan> loanList;
        boolean found = false;
        long itemId = -1;
        for (Item item : itemList){
            loanList = item.getLoan();
            for (Loan loan : loanList){
                if (loan.getId() == loanId){
                    itemId = item.getId();
                    found = true;
                    break;
                }
            }
            if (found){
                break;
            }
        }
        return itemId;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public String validateItemId(String itemName, String itemType) {
        String errorMessage = "";
        List<Item> itemList = itemRepository.findAll();
        for(Item item : itemList){
            if (item.getName().equalsIgnoreCase(itemName)
                            & item.getItemType().getTypeName().equalsIgnoreCase(itemType)){
                errorMessage = "Item already exists in the database. Cannot add";
            }
        }
        return errorMessage;
    }

    @Override
    public void deleteItem(Long itemId) {
        Item item = getItemById(itemId);
        itemRepository.delete(item);
    }
}
