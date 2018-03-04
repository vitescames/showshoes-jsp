package br.com.fiap.ps.rwd.bean;

import java.util.ArrayList;
import java.util.List;

public class LinhaItem {
	
	private ProdutoBean produto;
	private int quantidade;
	private int id;
	private int pedido;
	
	
	public ProdutoBean getProduto() {
		return produto;
	}
	public void setProduto(ProdutoBean produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPedido() {
		return pedido;
	}
	public void setPedido(int pedido) {
		this.pedido = pedido;
	}
	

}
