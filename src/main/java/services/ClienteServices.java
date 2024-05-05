package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.el.ELException;
import javax.inject.Inject;

import dao.IClienteDAO;
import domain.Cliente;
import services.generic.GenericService;

@Stateless
public class ClienteServices extends GenericService<Cliente, Long> implements IClienteService {
	
	private IClienteDAO clienteDAO;
	
	@Inject
	public ClienteServices(IClienteDAO clienteDAO) {
		super(clienteDAO);
		this.clienteDAO = clienteDAO;
	}

	@Override
	public Cliente buscarPorCPF(Long cpf)  {
		try {
			return this.dao.consultar(cpf);
		} catch (ELException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Cliente> filtrarClientes(String query) {
		return clienteDAO.filtrarClientes(query);
	}

}