package repo;

import model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemIssuanceRepository extends JpaRepository<Loan, Long> {
}
