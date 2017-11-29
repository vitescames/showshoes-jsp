package br.com.fiap.ps.rwd.bean;

import java.util.Date;

public class Pedido {
	
	private int id;
	private Usuario usuario;
	private Date date;
	
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
