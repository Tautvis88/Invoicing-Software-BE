package lt.statas.invoicing.runner;

import lombok.RequiredArgsConstructor;
import lt.statas.invoicing.model.*;
import lt.statas.invoicing.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TestDataLoader implements CommandLineRunner {

	private final ClientRepository clientRepository;
	private final SignerRepository signerRepository;
	private final InvoiceRepository invoiceRepository;
	private final InvoiceRecordRepository invoiceRecordRepository;
	private final PredefinedServiceRepository predefinedServiceRepository;

	@Override
	public void run(String... args) {
		List<Client> clients = new ArrayList<>();
		List<Signer> signers = new ArrayList<>();
		List<Invoice> invoices = new ArrayList<>();
		List<InvoiceRecord> invoiceRecords = new ArrayList<>();
		List<PredefinedService> predefinedServices = new ArrayList<>();

		Client client1 = Client.builder()
				.name("MAŽEIKIŲ RAJONO SAVIVALDYBĖS ADMINISTRACIJA")
				.address("Laisvės g. 8, LT-89223, Mažeikiai")
				.country("Lithuania")
				.type("Legal entity")
				.personalIdNumber(null)
				.companyCode("167371234")
				.vatCode("nėra PVM mokėtojas")
				.phoneNumber("+370 693 91985")
				.email("akmenesmuziejus@gmail.com")
				.build();
		clients.add(client1);

		Client client2 = Client.builder()
				.name("AKMENĖS RAJONO SAVIVALDYBĖS AKMENĖS KRAŠTO MUZIEJUS")
				.address("Kasakausko g. 17, LT-85367, Akmenė")
				.country("Lithuania")
				.type("Legal entity")
				.personalIdNumber(null)
				.companyCode("300629754")
				.vatCode("nėra PVM mokėtojas")
				.phoneNumber("8-425-55075")
				.email("daiva.kuodiene@mazeikiai.lt")
				.build();
		clients.add(client2);

		Client client3 = Client.builder()
				.name("VĮ MAŽEIKIŲ PIRMINĖS SVEIKATOS PRIEŽIŪROS CENTRAS")
				.address("Naftininkų g. 9, LT-89239, Mažeikiai")
				.country("Lithuania")
				.type("Legal entity")
				.personalIdNumber(null)
				.companyCode("166913931")
				.vatCode("nėra PVM mokėtojas")
				.phoneNumber("8-443-95177")
				.email("info@mazeikiupspc.lt")
				.build();
		clients.add(client3);

		Client client4 = Client.builder()
				.name("AB \"LIETUVOS RADIJO IR TELEVIZIJOS CENTRAS\"")
				.address("Sausio 13-osios g. 10, Vilnius")
				.country("Lithuania")
				.type("Legal entity")
				.personalIdNumber(null)
				.companyCode("120505210")
				.vatCode("LT205052113")
				.phoneNumber("(8 5) 204 03 00")
				.email("info@telecentras.lt")
				.build();
		clients.add(client4);

		Client client5 = Client.builder()
				.name("UAB SANTJANA")
				.address("Erfurto g. 30, LT-04100, Vilnius")
				.country("Lithuania")
				.type("Legal entity")
				.personalIdNumber(null)
				.companyCode("122656944")
				.vatCode("LT226569415")
				.phoneNumber("+370 700 35525")
				.email("info@santjana.lt")
				.build();
		clients.add(client5);
		clientRepository.saveAll(clients);

		Signer director = Signer.builder()
				.name("direktorius Viktoras Statkus")
				.build();
		signers.add(director);

		Signer employee = Signer.builder()
				.name("L. e. direktoriaus pareigas Ernesta Lukoševičienė")
				.build();
		signers.add(employee);

		signerRepository.saveAll(signers);

		Invoice invoice1 = Invoice.builder()
				.localDate(LocalDate.parse("2023-11-05"))
				.number("STA01501")
				.totalWithoutVat(3500.00)
				.vatAmount(735.00)
				.totalWithVat(4235.00)
				.client(client1)
				.signer(director)
				.build();
		invoices.add(invoice1);

		Invoice invoice2 = Invoice.builder()
				.localDate(LocalDate.parse("2023-11-25"))
				.number("STA01502")
				.totalWithoutVat(5000.00)
				.vatAmount(1050.00)
				.totalWithVat(6050.00)
				.client(client2)
				.signer(employee)
				.build();
		invoices.add(invoice2);

		Invoice invoice3 = Invoice.builder()
				.localDate(LocalDate.parse("2023-12-15"))
				.number("STA01503")
				.totalWithoutVat(2800.00)
				.vatAmount(588.00)
				.totalWithVat(3388.00)
				.client(client3)
				.signer(director)
				.build();
		invoices.add(invoice3);

		Invoice invoice4 = Invoice.builder()
				.localDate(LocalDate.parse("2024-01-05"))
				.number("STA01504")
				.totalWithoutVat(18000.00)
				.vatAmount(3780.00)
				.totalWithVat(21780.00)
				.client(client4)
				.signer(director)
				.build();
		invoices.add(invoice4);

		Invoice invoice5 = Invoice.builder()
				.localDate(LocalDate.parse("2024-02-15"))
				.number("STA01505")
				.totalWithoutVat(6400.00)
				.vatAmount(1344.00)
				.totalWithVat(7744.00)
				.client(client5)
				.signer(employee)
				.build();
		invoices.add(invoice5);

		invoiceRepository.saveAll(invoices);

		InvoiceRecord invoiceRecord1 = InvoiceRecord.builder()
				.name("Statybos darbai pagal sutartį Nr. 123")
				.unit("vnt.")
				.quantity(7)
				.pricePerUnit(500.0)
				.totalPrice(3500.0)
				.invoice(invoice1)
				.build();
		invoiceRecords.add(invoiceRecord1);

		InvoiceRecord invoiceRecord2 = InvoiceRecord.builder()
				.name("Projektavimo darbai pagal sutartį Nr. 456")
				.unit("vnt.")
				.quantity(1)
				.pricePerUnit(5000.0)
				.totalPrice(5000.0)
				.invoice(invoice2)
				.build();
		invoiceRecords.add(invoiceRecord2);

		InvoiceRecord invoiceRecord3 = InvoiceRecord.builder()
				.name("Stogo remonto darbai adresu Naftininkų g. 9, Mažeikiai")
				.unit("vnt.")
				.quantity(1)
				.pricePerUnit(2800.0)
				.totalPrice(2800.0)
				.invoice(invoice3)
				.build();
		invoiceRecords.add(invoiceRecord3);

		InvoiceRecord invoiceRecord4 = InvoiceRecord.builder()
				.name("Pamatų ir tvoros įrengimas adresu Rūtų g. 15, Anykščiai")
				.unit("m")
				.quantity(110)
				.pricePerUnit(150.0)
				.totalPrice(16500.0)
				.invoice(invoice4)
				.build();
		invoiceRecords.add(invoiceRecord4);

		InvoiceRecord invoiceRecord5 = InvoiceRecord.builder()
				.name("Evakuacinių priešgaisrinių kopėčių įrengimas adresu Rūtų g. 15, Anykščiai")
				.unit("vnt.")
				.quantity(2)
				.pricePerUnit(750.0)
				.totalPrice(1500.0)
				.invoice(invoice4)
				.build();
		invoiceRecords.add(invoiceRecord5);

		InvoiceRecord invoiceRecord6 = InvoiceRecord.builder()
				.name("Metalinių konstrukcijų paruošimas ir montavimas adresu Erfurto g. 10, Vilnius")
				.unit("t")
				.quantity(10)
				.pricePerUnit(600.0)
				.totalPrice(6000.0)
				.invoice(invoice5)
				.build();
		invoiceRecords.add(invoiceRecord6);

		InvoiceRecord invoiceRecord7 = InvoiceRecord.builder()
				.name("Pastato būklės nuolatiniai stebėjimai (1 mėn.) adresu Erfurto g. 10, Vilnius")
				.unit("vnt.")
				.quantity(1)
				.pricePerUnit(400.0)
				.totalPrice(400.0)
				.invoice(invoice5)
				.build();
		invoiceRecords.add(invoiceRecord7);

		invoiceRecordRepository.saveAll(invoiceRecords);

		PredefinedService predefinedService1 = PredefinedService.builder()
				.name("Statybos darbai pagal sutartį Nr.")
				.build();
		predefinedServices.add(predefinedService1);

		PredefinedService predefinedService2 = PredefinedService.builder()
				.name("Projektavimo darbai pagal sutartį Nr.")
				.build();
		predefinedServices.add(predefinedService2);

		PredefinedService predefinedService3 = PredefinedService.builder()
				.name("Stogo remonto darbai adresu ")
				.build();
		predefinedServices.add(predefinedService3);

		PredefinedService predefinedService4 = PredefinedService.builder()
				.name("Pamatų ir tvoros įrengimas adresu ")
				.build();
		predefinedServices.add(predefinedService4);

		PredefinedService predefinedService5 = PredefinedService.builder()
				.name("Evakuacinių priešgaisrinių kopėčių įrengimas adresu ")
				.build();
		predefinedServices.add(predefinedService5);

		PredefinedService predefinedService6 = PredefinedService.builder()
				.name("Metalinių konstrukcijų paruošimas ir montavimas adresu ")
				.build();
		predefinedServices.add(predefinedService6);

		PredefinedService predefinedService7 = PredefinedService.builder()
				.name("Pastato būklės nuolatiniai stebėjimai (1 mėn.)")
				.build();
		predefinedServices.add(predefinedService7);

		predefinedServiceRepository.saveAll(predefinedServices);
	}
}
