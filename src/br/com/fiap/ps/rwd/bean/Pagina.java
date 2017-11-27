package br.com.fiap.ps.rwd.bean;

import java.util.ArrayList;
import java.util.List;

public class Pagina {
	
	private List<ProdutoBean> listaProdutos = new ArrayList<ProdutoBean>();
	private int index;
	
	public List<ProdutoBean> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(List<ProdutoBean> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}	

}
