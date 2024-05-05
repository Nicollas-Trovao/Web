package services;

import java.util.List;

import domain.Produto;
import services.generic.IGenericService;

public interface IProdutoServices extends IGenericService<Produto, String> {

	List<Produto> filtrarProdutos(String query);

}