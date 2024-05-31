package lt.statas.invoicing.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientRequestDTO {
	private String name;
	private String address;
	private String country;
	private String type;
	private String personalIdNumber;
	private String companyCode;
	private String vatCode;
	private String phoneNumber;
	private String email;
}
