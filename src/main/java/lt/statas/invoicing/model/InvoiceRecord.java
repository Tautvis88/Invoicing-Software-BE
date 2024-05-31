package lt.statas.invoicing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoice_records")	// Without this, Hibernate creates database table 'service' (singular - uses class name).
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String unit;
	private int quantity;
	private Double pricePerUnit;
	private Double totalPrice;

	@ManyToOne
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;
}
