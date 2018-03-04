package br.com.fiap.ps.rwd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.ps.rwd.bean.LinhaItem;
import br.com.fiap.ps.rwd.bean.Pedido;
import br.com.fiap.ps.rwd.bo.ProdutoBO;
import br.com.showshoes.connection.ConnectionFactory;

public class LinhaItemDAO {
	
	ResultSet rs;
	PreparedStatement ps;
	Connection c;
	
	public LinhaItemDAO() throws ClassNotFoundException, SQLException {
		c = ConnectionFactory.conectar();
	}
	
	public boolean add(LinhaItem linhaItem) throws SQLException {
		ps = c.prepareStatement("INSERT INTO linha_item (quantidade, id_pedido, id_produto) VALUES (?,?,?)");
		
		ps.setInt(1, linhaItem.getQuantidade());
		ps.setInt(2, linhaItem.getPedido());
		ps.setDouble(3, linhaItem.getProduto().getId());
		
		return ps.execute();
	}
	
	public List<LinhaItem> getByOrder(int pedido) throws SQLException, ClassNotFoundException{
		
		ps = c.prepareStatement("SELECT * FROM linha_item WHERE id_pedido = ?");		
		ps.setInt(1, pedido);		
		rs = ps.executeQuery();
		
		List<LinhaItem> list = new ArrayList<LinhaItem>();
		LinhaItem linhaItem = null;
		
		while(rs.next()) {
			linhaItem = new LinhaItem();
			
			linhaItem.setId(rs.getInt("id"));
			linhaItem.setPedido(pedido);
			linhaItem.setProduto(ProdutoBO.pesquisa(rs.getInt("id_produto")));
			linhaItem.setQuantidade(rs.getInt("quantidade"));
			list.add(linhaItem);
		}
		
		return list;
		
	}
}
