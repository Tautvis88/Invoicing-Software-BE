package lt.statas.invoicing.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InvoiceResponseDTO {
	private Long id;
	private String date;
	private String number;
	private String clientName;
	private String totalWithoutVat;
	private String vatAmount;
	private String totalWithVat;
}