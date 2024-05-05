package dao;

import dao.generic.IGenericDAO;
import domain.Venda;

public interface IVendaDAO extends IGenericDAO<Venda, Long>{

	public void finalizarVenda(Venda venda);
	
	public void cancelarVenda(Venda venda);
	
	/**
	 * @see VendaJpa produtos
	 * 
	 * @param id
	 * @return
	 */
	public Venda consultarComCollection(Long id);

}