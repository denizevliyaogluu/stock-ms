package service;

import model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.ItemIssuanceRepository;
import service.impl.ImplItemIssuanceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemIssuanceService implements ImplItemIssuanceService {
    @Autowired
    private ItemIssuanceRepository itemIssuanceRepository;

    @Override
    public void saveItemIssued(Loan loan) {
        this.itemIssuanceRepository.save(loan);
    }

    @Override
    public List<Loan> getAllIssuedItems() {
        List<Loan> loanList = itemIssuanceRepository.findAll();
        List<Loan> issuedItems = new ArrayList<>();
        for (Loan l : loanList){
            if (l.getReturnDate().isEmpty()){
                issuedItems.add(l);
            }
        }
        return issuedItems;
    }

    @Override
    public List<Loan> getAllReturnedItem() {
        List<Loan> loanList = itemIssuanceRepository.findAll();
        List<Loan> returnedItems = new ArrayList<>();
        for (Loan l : loanList){
            if (!(l.getReturnDate().isEmpty())){
                returnedItems.add(l);
            }
        }
        return returnedItems;
    }

    @Override
    public List<Loan> getItemsWithFine() {
        List<Loan> loanList = itemIssuanceRepository.findAll();
        List<Loan> itemWithFine = new ArrayList<>();
        for (Loan l : loanList){
            if (l.getTotalFine() > 0){
                itemWithFine.add(l);
            }
        }
        return itemWithFine;
    }

    @Override
    public void deleteIssuedItemById(Long id) {
        this.itemIssuanceRepository.deleteById(id);
    }

    @Override
    public Loan findItemIssuedById(Long id) {
        Optional<Loan> optional = itemIssuanceRepository.findById(id);
        Loan loanItem = null;
        if (optional.isPresent()){
            loanItem = optional.get();
        }else {
            //exception
        }
        return loanItem;
    }

    @Override
    public String validateLoanId(Long loanId) {
        String errorMessage = "";
        Loan loan = findItemIssuedById(loanId);
        if (loan == null){
            errorMessage = "Loan ID does not exists. Invalid Input";
        }
        return errorMessage;
    }

    @Override
    public Loan findItemIssued(Long borrowerId, Long itemId) {
        List<Loan> loanList = getAllIssuedItems();
        Loan loan = null;
        for (Loan l : loanList){
            if (l.getReturnDate() == null | l.getReturnDate().isEmpty()){
                if (l.getBorrower().getId() == borrowerId & l.getItem().getId() == itemId){
                    loan = l;
                    break;
                }
            }
        }
        return loan;
    }
}
