package br.com.fiap.ps.rwd.bo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import br.com.fiap.ps.rwd.bean.ProdutoBean;
import br.com.fiap.ps.rwd.dao.ProdutoDAO;

public class ProdutoBO {
	
	public static List<ProdutoBean> pesquisa() throws ClassNotFoundException, SQLException{
		ProdutoDAO pd = new ProdutoDAO();
		List<ProdutoBean> lista = pd.select();
		return lista;
	}
	
	public static ProdutoBean pesquisa(int id) throws ClassNotFoundException, SQLException{
		ProdutoDAO pd = new ProdutoDAO();
		ProdutoBean produtoBean = pd.select(id);
		return produtoBean;
	}
	
	public static List<ProdutoBean> pesquisaPorParams(Map<String, String> params) throws ClassNotFoundException, SQLException{
		ProdutoDAO pd = new ProdutoDAO();
		return pd.selectByParams(params);
	}

}
