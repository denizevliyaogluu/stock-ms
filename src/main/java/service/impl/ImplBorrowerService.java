package service.impl;

import model.Borrower;

import java.util.List;

public interface ImplBorrowerService {
    Borrower getBorrowerById(Long id);
    List<Borrower> getAllBorrowers();
    Long getBorrowerIdByLoanId(Long borrowerId);
    String validateBorrowerId(Long borrowerId);
    void updateBorrower(Borrower borrower);
}
