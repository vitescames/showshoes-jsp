package br.com.fiap.ps.rwd.bean;

import java.sql.Timestamp;
import java.util.List;

public class Pedido {
	
	private int id;
	private Usuario usuario;
	private Timestamp date;
	private List<LinhaItem> listLinhaItens;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public List<LinhaItem> getListLinhaItens() {
		return listLinhaItens;
	}
	public void setListLinhaItens(List<LinhaItem> listLinhaItens) {
		this.listLinhaItens = listLinhaItens;
	}	

}
