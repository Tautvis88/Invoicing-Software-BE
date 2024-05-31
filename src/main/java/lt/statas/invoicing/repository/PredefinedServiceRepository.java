package lt.statas.invoicing.repository;

import lt.statas.invoicing.model.PredefinedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PredefinedServiceRepository extends JpaRepository<PredefinedService, Long> {
}
