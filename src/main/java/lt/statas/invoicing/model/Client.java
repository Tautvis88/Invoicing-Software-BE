package lt.statas.invoicing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clients")	// Without this, Hibernate creates database table 'client' (singular - uses class name).
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
