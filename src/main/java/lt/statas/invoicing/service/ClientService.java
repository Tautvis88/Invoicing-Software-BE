package lt.statas.invoicing.service;

import lt.statas.invoicing.dto.ClientResponseDTO;
import lt.statas.invoicing.model.Client;

import java.util.List;

public interface ClientService {
	List<ClientResponseDTO> getAllClients();
	Client getClientById(final Long id);
	Client createClient(Client client);
	Client updateClient(Long id, Client client);
	void deleteClient(final Long id);
}
