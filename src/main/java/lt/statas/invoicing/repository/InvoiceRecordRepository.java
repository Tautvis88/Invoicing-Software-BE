package lt.statas.invoicing.repository;

import lt.statas.invoicing.model.InvoiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRecordRepository extends JpaRepository<InvoiceRecord, Long> {
}
