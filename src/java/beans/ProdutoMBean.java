/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidade.Produto;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import sessionbean.ProdutoSBean;
import uteis.UnidadeMedida;

/**
 *
 * @author joao-
 */
@Named(value = "produtoMBean")
@SessionScoped
public class ProdutoMBean implements Serializable {
    
    private Produto produto;
    private String parametroPesquisa;
    private List<Produto> listaProdutos;
    private List<UnidadeMedida> listaUnidadeMedida;
    @EJB
    private ProdutoSBean produtoSBean;
    
    public ProdutoMBean() {
    }
    
    @PostConstruct
    public void init() {
        produto = new Produto();
        listaProdutos = new ArrayList<>();
        listaUnidadeMedida = Arrays.asList(UnidadeMedida.values());
    }
    
    public void botaoPesquisar() {
       listaProdutos = produtoSBean.pesquisar(parametroPesquisa);
    }
    
    public String botaoSalvar() {
        produtoSBean.salvar(produto);
        produto = new Produto();
        return "consProduto?faces-redirect=true";
    }
    
    public String botaoEditar() {
        return "cadProduto?faces-redirect=true";
    }
    
    public void botaoExcluir() {
        produtoSBean.excluir(produto);
        produto = new Produto();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getParametroPesquisa() {
        return parametroPesquisa;
    }

    public void setParametroPesquisa(String parametroPesquisa) {
        this.parametroPesquisa = parametroPesquisa;
    }

    public List getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public List<UnidadeMedida> getListaUnidadeMedida() {
        return listaUnidadeMedida;
    }

    public void setListaUnidadeMedida(List<UnidadeMedida> listaUnidadeMedida) {
        this.listaUnidadeMedida = listaUnidadeMedida;
    }
    
    
    
    
    
}
