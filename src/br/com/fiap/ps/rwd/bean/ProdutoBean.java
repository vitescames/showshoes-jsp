package br.com.fiap.ps.rwd.bean;

public class ProdutoBean {
	
	private String desc;
	private String info;
	private double valor;
	private String urlImg;
	private long id;
	
	public ProdutoBean() {
		// TODO Auto-generated constructor stub
	}

	public ProdutoBean(String desc, String info, double valor, String urlImg, long id) {
		super();
		this.desc = desc;
		this.info = info;
		this.valor = valor;
		this.urlImg = urlImg;
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}
