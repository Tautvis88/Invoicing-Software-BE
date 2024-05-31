package lt.statas.invoicing.mapper;

import lt.statas.invoicing.dto.ClientResponseDTO;
import lt.statas.invoicing.model.Client;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {

	public ClientResponseDTO mapToDTO(Client client) {
		return ClientResponseDTO.builder()
				.id(client.getId())
				.name(client.getName())
				.address(client.getAddress())
				.companyCode(client.getCompanyCode())
				.vatCode(client.getVatCode())
				.phoneNumber(client.getPhoneNumber())
				.email(client.getEmail())
				.build();
	}

	public List<ClientResponseDTO> mapToDTOList(List<Client> clients) {
		return clients.stream()
				.map(this::mapToDTO)
				.collect(Collectors.toList());
	}
}
