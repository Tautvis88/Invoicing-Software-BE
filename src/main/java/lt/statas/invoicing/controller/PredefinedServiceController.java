package lt.statas.invoicing.controller;

import lombok.RequiredArgsConstructor;
import lt.statas.invoicing.model.PredefinedService;
import lt.statas.invoicing.repository.PredefinedServiceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/predefined-services")
@RequiredArgsConstructor
public class PredefinedServiceController {

	private final PredefinedServiceRepository predefinedServiceRepository;

	@GetMapping
	public ResponseEntity<List<PredefinedService>> getAllPredefinedServices() {
		try {
			List<PredefinedService> predefinedServices = predefinedServiceRepository.findAll();
			return ResponseEntity.ok(predefinedServices);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
