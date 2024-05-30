package lt.statas.invoicing.service;

import lombok.RequiredArgsConstructor;
import lt.statas.invoicing.dto.InvoiceResponseDTO;
import lt.statas.invoicing.mapper.InvoiceMapper;
import lt.statas.invoicing.model.Invoice;
import lt.statas.invoicing.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

	private final InvoiceRepository invoiceRepository;
	private final InvoiceMapper invoiceMapper;

	@Override
	public List<InvoiceResponseDTO> getAllInvoices() {
		List<Invoice> invoices = invoiceRepository.findAll();
		return invoiceMapper.mapToDTOList(invoices);
	}

	@Override
	public Invoice getInvoiceById(Long id) {
		return null;
	}

	@Override
	public Invoice createInvoice(Invoice invoice) {
		return null;
	}

	@Override
	public Invoice updateInvoice(Long id, Invoice invoice) {
		return null;
	}

	@Override
	public void deleteInvoice(Long id) {

	}
}
