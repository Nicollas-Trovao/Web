package services;

import java.util.List;

import domain.Cliente;
import services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf);

	List<Cliente> filtrarClientes(String query);

}