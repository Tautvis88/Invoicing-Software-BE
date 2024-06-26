package lt.statas.invoicing.controller;

import lombok.RequiredArgsConstructor;
import lt.statas.invoicing.dto.InvoiceResponseDTO;
import lt.statas.invoicing.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/invoices")
@RequiredArgsConstructor
public class InvoiceController {

	private final InvoiceService invoiceService;

	@GetMapping
	public ResponseEntity<List<InvoiceResponseDTO>> getAllInvoices() {
		try {
			List<InvoiceResponseDTO> invoices = invoiceService.getAllInvoices();
			return ResponseEntity.status(HttpStatus.OK).body(invoices);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
