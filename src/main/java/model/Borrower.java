package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Borrower")
public class Borrower {
    @Id
    @GeneratedValue
    @Column(name = "borrower_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "borrower")
    private List<Loan> loan = new ArrayList<>();

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName =lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public List<Loan> getLoan(){
        return loan;
    }
     public void setLoan(List<Loan> loan){
        this.loan = loan;
     }

     public void addLoan(Loan newLoan){
        this.loan.add(newLoan);
        newLoan.setBorrower(this);
     }

     public void removeLoan(Loan newLoan){
        this.loan.remove(newLoan);
        newLoan.setBorrower(null);
     }

     public double totalFine(){
        double totalFine = 0;;
        for(Loan 1 : loan){
            totalFine += 1.calculateFine();
         }
        return totalFine;
     }

     public void updateFine(double finePaid){
        double fine = 0;
        for(Loan 1 : loan){
            if(finePaid <= 0){
                break;
            }else{
                fine = 1.getTotalFine();
                1.setTotalFine(fine - finePaid);
                finePaid -= fine;
            }
         }
     }
}
