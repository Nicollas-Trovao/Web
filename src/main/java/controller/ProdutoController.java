package controller;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import domain.Produto;
import services.IProdutoServices;

@Named
@ViewScoped
public class ProdutoController implements Serializable {

	private static final long serialVersionUID = 367088063926303823L;
	
	private Produto produto;
	
	private Collection<Produto> produtos;
	
	@Inject
	private IProdutoServices produtoService;
	
	private Boolean isUpdate;
	
	@PostConstruct
    public void init() {
		try {
			this.isUpdate = false;
			this.produto = new Produto();
			this.produtos = produtoService.buscarTodos();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", null);
		}
	}
	
	public void cancel() {
		try {
			this.isUpdate = false;
			this.produto = new Produto();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", null);
		}
		
    } 
	
	public void edit(Produto produto) {
		try {
			this.isUpdate = true;
			this.produto = produto;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", null);
		}
		
    } 
	
	public void delete(Produto produto) {
		try {
			produtoService.excluir(produto);
			produtos.remove(produto);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", null);
		}
		
    } 
	
	public void add() {
		try {
			produtoService.cadastrar(produto);
			this.produtos = produtoService.buscarTodos();
			this.produto = new Produto();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", null);
		}
		
        
    }

    public void update() {
    	try {
    		produtoService.alterar(this.produto);
			cancel();
			FacesContext.getCurrentInstance().addMessage("growl", null);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("growl", null);
		}
        
    }
    
    public String voltarTelaInicial() {
		return "/index.xhtml"; 
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
}