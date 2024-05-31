package lt.statas.invoicing.controller;

import lombok.RequiredArgsConstructor;
import lt.statas.invoicing.model.Signer;
import lt.statas.invoicing.repository.SignerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/signers")
@RequiredArgsConstructor
public class SignerController {

	private final SignerRepository signerRepository;

	@GetMapping
	public ResponseEntity<List<Signer>> getAllSigners() {
		try {
			List<Signer> signers = signerRepository.findAll();
			return ResponseEntity.ok(signers);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
