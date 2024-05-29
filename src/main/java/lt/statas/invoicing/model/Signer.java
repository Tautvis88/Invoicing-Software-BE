package lt.statas.invoicing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "signers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Signer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String position;
}
