package model;

import jakarta.persistence.*;

@Entity
@Table(name = "Loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long id;

    @Column(name = "loan_duration")
    private Long loanDuration;

    @Column(name = "issue_date")
    private String issueDate;

    @Column(name = "return_date")
    private String returnDate;

    @Column(name = "total_fine")
    private double totalFine;

    @ManyToOne(fetch = FetchType.LAZY)
    private Borrower borrower;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public double getTotalFine() {
        return totalFine;
    }

    public void setTotalFine(double totalFine) {
        this.totalFine = totalFine;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public long getLoanDuration() {
        return loanDuration;
    }

    public void setLoanDuration(long loanDuration) {
        this.loanDuration = loanDuration;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Loan))
            return false;
        return (Long) id != null && id == (((Loan) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
