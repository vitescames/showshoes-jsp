package br.com.fiap.ps.rwd.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.ps.rwd.bean.ProdutoBean;
import br.com.fiap.ps.rwd.dao.ProdutoDAO;

public class ProdutoBO {
	
	public static List<ProdutoBean> pesquisa() throws ClassNotFoundException, SQLException{
		ProdutoDAO pd = new ProdutoDAO();
		return pd.select();
	}
	
	public static ProdutoBean pesquisa(int id) throws ClassNotFoundException, SQLException{
		ProdutoDAO pd = new ProdutoDAO();
		return pd.select(id);
	}

}
