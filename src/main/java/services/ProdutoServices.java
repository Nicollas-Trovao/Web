package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.IProdutoDAO;
import domain.Produto;
import services.generic.GenericService;

@Stateless
public class ProdutoServices extends GenericService<Produto, String> implements IProdutoServices {
	
	private IProdutoDAO produtoDao;

	@Inject
	public ProdutoServices(IProdutoDAO produtoDao) {
		super(produtoDao);
		this.produtoDao = produtoDao;
	}

	@Override
	public List<Produto> filtrarProdutos(String query) {
		return produtoDao.filtrarProdutos(query);
	}

}