package lt.statas.invoicing.mapper;

import lt.statas.invoicing.dto.InvoiceResponseDTO;
import lt.statas.invoicing.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InvoiceMapper {

	public InvoiceResponseDTO mapToDTO(Invoice invoice) {
		return InvoiceResponseDTO.builder()
				.id(invoice.getId())
				.date(invoice.getLocalDate().toString())
				.number(invoice.getNumber())
				.clientName(invoice.getClient().getName())
				.totalWithoutVat(String.format("%.2f", invoice.getTotalWithoutVat()))
				.vatAmount(String.format("%.2f", invoice.getVatAmount()))
				.totalWithVat(String.format("%.2f", invoice.getTotalWithVat()))
				.build();
	}

	public List<InvoiceResponseDTO> mapToDTOList(List<Invoice> invoices) {
		return invoices.stream()
				.map(this::mapToDTO)
				.collect(Collectors.toList());
	}
}