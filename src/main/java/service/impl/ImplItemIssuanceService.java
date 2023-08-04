package service.impl;

import model.Loan;

import java.util.List;

public interface ImplItemIssuanceService {
    void saveItemIssued(Loan loan);
    List<Loan> getAllIssuedItems();
    List<Loan> getAllReturnedItem();
    List<Loan> getItemsWithFine();
    void deleteIssuedItemById(Long id);
    Loan findItemIssuedById(Long id);
    String validateLoanId(Long loanId);
    Loan findItemIssued(Long borrowerId, Long itemId);
}
