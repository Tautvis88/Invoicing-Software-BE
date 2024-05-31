package lt.statas.invoicing.controller;

import lombok.RequiredArgsConstructor;
import lt.statas.invoicing.dto.ClientResponseDTO;
import lt.statas.invoicing.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {

	private final ClientService clientService;

	@GetMapping
	public ResponseEntity<List<ClientResponseDTO>> getAllClients() {
		try {
			List<ClientResponseDTO> clients = clientService.getAllClients();
			return ResponseEntity.ok(clients);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
