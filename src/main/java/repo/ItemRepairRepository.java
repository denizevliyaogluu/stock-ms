package repo;

import model.ItemRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepairRepository extends JpaRepository<ItemRepair, Long> {
}
