package lt.statas.invoicing.runner;

import lombok.RequiredArgsConstructor;
import lt.statas.invoicing.model.Client;
import lt.statas.invoicing.model.Invoice;
import lt.statas.invoicing.model.Service;
import lt.statas.invoicing.model.Signer;
import lt.statas.invoicing.repository.ClientRepository;
import lt.statas.invoicing.repository.InvoiceRepository;
import lt.statas.invoicing.repository.ServiceRepository;
import lt.statas.invoicing.repository.SignerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class DatabaseTestRunner implements CommandLineRunner {

	private final ClientRepository clientRepository;
	private final SignerRepository signerRepository;
	private final InvoiceRepository invoiceRepository;
	private final ServiceRepository serviceRepository;

	@Override
	public void run(String... args) throws Exception {
		Client client = Client.builder()
				.name("MAŽEIKIŲ RAJONO SAVIVALDYBĖS ADMINISTRACIJA")
				.address("Laisvės g. 8, LT-89223, Mažeikiai")
				.country("Lithuania")
				.type("Legal entity")
				.personalIdNumber(null)
				.companyCode("167371234")
				.vatCode("nėra PVM mokėtojas")
				.phoneNumber("+370 693 91985")
				.email("daiva.kuodiene@mazeikiai.lt")
				.build();
		clientRepository.save(client);

		Signer signer = Signer.builder()
				.name("Director Viktoras Statkus")
				.position("Director")
				.build();
		signerRepository.save(signer);

		Invoice invoice = Invoice.builder()
				.date(new Date())
				.number("STA01501")
				.totalWithoutVat(3500.00)
				.vatAmount(700.00)
				.totalWithVat(4200.00)
				.client(client)
				.signer(signer)
				.build();
		invoiceRepository.save(invoice);

		Service service = Service.builder()
				.name("Service A")
				.unit("pcs")
				.quantity(10.0)
				.pricePerUnit(350.0)
				.totalPrice(3500.0)
				.invoice(invoice)
				.build();
		serviceRepository.save(service);

	}
}
