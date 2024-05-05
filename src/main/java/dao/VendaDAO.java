package dao;

import dao.generic.GenericDAO;
import domain.Cliente;
import domain.Produto;
import domain.Venda;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class VendaDAO extends GenericDAO<Venda, Long> implements IVendaDAO {

	public VendaDAO() {
		super(Venda.class);
	}

	@Override
	public void finalizarVenda(Venda venda){
		super.alterar(venda);
	}

	@Override
	public void cancelarVenda(Venda venda){
		super.alterar(venda);
	}

	@Override
	public void excluir(Venda entity){
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public Venda cadastrar(Venda entity){
		try {
			entity.getProdutos().forEach(prod -> {
				Produto prodJpa = entityManager.merge(prod.getProduto());
				prod.setProduto(prodJpa);
			});
			Cliente cliente = entityManager.merge(entity.getCliente());
			entity.setCliente(cliente);
			entityManager.persist(entity);
//			entityManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
		
		}
        return entity;
		
	}

	@Override
	public Venda consultarComCollection(Long id) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Venda> query = builder.createQuery(Venda.class);
		Root<Venda> root = query.from(Venda.class);
		root.fetch("cliente");
		root.fetch("produtos");
		query.select(root).where(builder.equal(root.get("id"), id));
		TypedQuery<Venda> tpQuery = 
				entityManager.createQuery(query);
		Venda venda = tpQuery.getSingleResult(); 
		return venda;
	}
}
