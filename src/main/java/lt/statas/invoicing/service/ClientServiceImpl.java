package lt.statas.invoicing.service;

import lombok.RequiredArgsConstructor;
import lt.statas.invoicing.dto.ClientRequestDTO;
import lt.statas.invoicing.dto.ClientResponseDTO;
import lt.statas.invoicing.mapper.ClientMapper;
import lt.statas.invoicing.model.Client;
import lt.statas.invoicing.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{

	private final ClientRepository clientRepository;
	private final ClientMapper clientMapper;

	@Override
	public List<ClientResponseDTO> getAllClients() {
		List<Client> clients = clientRepository.findAll();
		return clientMapper.mapToDTOList(clients);
	}

	@Override
	public Client getClientById(final Long id) {
		return null;
	}

	@Override
	public ClientResponseDTO createClient(final ClientRequestDTO clientRequestDTO) {
		Client client = clientMapper.mapToEntityClass(clientRequestDTO);
		Client savedClient = clientRepository.save(client);
		return clientMapper.mapToDTO(savedClient);
	}

	@Override
	public Client updateClient(final Long id, final Client client) {
		return null;
	}

	@Override
	public void deleteClient(final Long id) {

	}
}
