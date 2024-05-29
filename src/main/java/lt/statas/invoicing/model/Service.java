package lt.statas.invoicing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "services")	// Without this, Hibernate creates database table 'service' (singular - uses class name).
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String unit;
	private Double quantity;
	private Double pricePerUnit;
	private Double totalPrice;

	@ManyToOne
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;
}
