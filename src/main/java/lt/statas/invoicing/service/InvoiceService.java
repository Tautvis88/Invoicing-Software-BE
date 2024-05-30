package lt.statas.invoicing.service;

import lt.statas.invoicing.dto.InvoiceResponseDTO;
import lt.statas.invoicing.model.Invoice;

import java.util.List;

public interface InvoiceService {
	List<InvoiceResponseDTO> getAllInvoices();
	Invoice getInvoiceById(Long id);
	Invoice createInvoice(Invoice invoice);
	Invoice updateInvoice(Long id, Invoice invoice);
	void deleteInvoice(Long id);
}
