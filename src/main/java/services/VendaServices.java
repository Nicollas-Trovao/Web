package services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.IVendaDAO;
import domain.Venda;
import domain.Venda.Status;
import services.generic.GenericService;

@Stateless
public class VendaServices extends GenericService<Venda, Long> implements IVendaServices {

	IVendaDAO dao;
	
	@Inject
	public VendaServices(IVendaDAO dao) {
		super(dao);
		this.dao = dao;
	}

	@Override
	public void finalizarVenda(Venda venda){
		venda.setStatus(Status.CONCLUIDA);
		dao.finalizarVenda(venda);
	}

	@Override
	public void cancelarVenda(Venda venda){
		venda.setStatus(Status.CANCELADA);
		dao.cancelarVenda(venda);
	}

	@Override
	public Venda consultarComCollection(Long id) {
		return dao.consultarComCollection(id);
	}

	@Override
	public Venda cadastrar(Venda entity){
		entity.setStatus(Status.INICIADA);
		return super.cadastrar(entity);
	}
	
	

}