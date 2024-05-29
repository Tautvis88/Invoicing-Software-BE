package lt.statas.invoicing.repository;

import lt.statas.invoicing.model.Signer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignerRepository extends JpaRepository<Signer, Long> {
}
