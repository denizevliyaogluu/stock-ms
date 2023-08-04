package service;

import model.Borrower;
import model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.BorrowerRepository;
import service.impl.ImplBorrowerService;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowerService implements ImplBorrowerService {
    @Autowired
    private BorrowerRepository borrowerRepository;

    @Override
    public Borrower getBorrowerById(Long id) {
        Optional<Borrower> optional = borrowerRepository.findById(id);
        Borrower borrower = null;
        if(optional.isPresent()){
            borrower = optional.get();
        }else{
            //exception
        }
        return borrower;
    }

    @Override
    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    @Override
    public Long getBorrowerIdByLoanId(Long loanId) {
       List<Borrower> borrowerList = getAllBorrowers();
       List<Loan> loanList;
       boolean found = false;
       long borrowerId = -1;
       for (Borrower borrower : borrowerList){
           loanList = borrower.getLoan();
           for (Loan loan : loanList){
               if (loan.getId() == loanId){
                   borrowerId =borrower.getId();
                   found = true;
                   break;
               }
           }
           if (found){
               break;
           }
       }
       return borrowerId;
    }

    @Override
    public String validateBorrowerId(Long borrowerId){
        String errorMessage = "";
        Borrower borrower = getBorrowerById(borrowerId);
        if (borrower == null){
            errorMessage = "Borrower id does not exists";
        }
        return errorMessage;
    }

    @Override
    public void updateBorrower(Borrower borrower) {
        borrowerRepository.save(borrower);
    }
}
