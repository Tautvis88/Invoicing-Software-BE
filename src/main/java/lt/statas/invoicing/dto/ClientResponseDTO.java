package lt.statas.invoicing.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientResponseDTO {
	private Long id;
	private String name;
	private String address;
	private String companyCode;
	private String vatCode;
	private String phoneNumber;
	private String email;
}
