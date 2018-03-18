package br.com.fiap.ps.rwd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.fiap.ps.rwd.bean.ProdutoBean;
import br.com.showshoes.connection.ConnectionFactory;

public class ProdutoDAO {
	
	private Connection c;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ProdutoDAO() throws ClassNotFoundException, SQLException {
		c = ConnectionFactory.conectar();
	}
	
	public List<ProdutoBean> selectByParams(Map<String, String> params) throws SQLException{
		
		StringBuilder query = new StringBuilder();
		boolean jaPassou = false;
		List<ProdutoBean> listaProduto = new ArrayList<ProdutoBean>();
		
		query.append("SELECT * FROM produto where ");
		
		if(params.get("paramMarca") != null) {
			if(!jaPassou) {
				jaPassou = true;
			} else {
				query.append("and ");
			}
			query.append("descricao like " + "'%" + params.get("paramMarca") + "%'");
		}
		
		if(params.get("paramPreco") != null) {
			if(!jaPassou) {
				jaPassou = true;
			} else {
				query.append(" and ");
			}
			String[] valores = params.get("paramPreco").split(",");
			query.append("valor >= " + valores[0] + " and valor <= " + valores[1]);
		}
		
		ps = c.prepareStatement(query.toString());
		
		rs = ps.executeQuery();
		
		ProdutoBean produtoBean = null;
		
		while(rs.next()) {
			produtoBean = new ProdutoBean();
			produtoBean.setDesc(rs.getString("descricao"));
			produtoBean.setId(rs.getInt("id"));
			produtoBean.setInfo(rs.getString("info"));
			produtoBean.setUrlImg(rs.getString("urlImg"));
			produtoBean.setValor(rs.getDouble("valor"));
			
			listaProduto.add(produtoBean);
		}
		
		return listaProduto;
	}
	
	public List<ProdutoBean> select() throws SQLException{
		
		List<ProdutoBean> listaProduto = new ArrayList<ProdutoBean>();
		ps = c.prepareStatement("SELECT * FROM produto");
		
		rs = ps.executeQuery();
		
		ProdutoBean produtoBean;
		
		while(rs.next()) {
			produtoBean = new ProdutoBean();
			produtoBean.setDesc(rs.getString("descricao"));
			produtoBean.setId(rs.getInt("id"));
			produtoBean.setInfo(rs.getString("info"));
			produtoBean.setUrlImg(rs.getString("urlImg"));
			produtoBean.setValor(rs.getDouble("valor"));
			
			listaProduto.add(produtoBean);
		}
		
		return listaProduto;
	}

	public ProdutoBean select(int id) throws SQLException {
		
		ps = c.prepareStatement("SELECT * FROM produto where id = ?");
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
		ProdutoBean produtoBean = new ProdutoBean();
		
		if(rs.next()) {
			produtoBean.setDesc(rs.getString("descricao"));
			produtoBean.setId(rs.getInt("id"));
			produtoBean.setInfo(rs.getString("info"));
			produtoBean.setUrlImg(rs.getString("urlImg"));
			produtoBean.setValor(rs.getDouble("valor"));
		}
		
		return produtoBean;
	}	

}

