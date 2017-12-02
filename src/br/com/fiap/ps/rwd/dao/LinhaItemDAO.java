package br.com.fiap.ps.rwd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.ps.rwd.bean.LinhaItem;
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
		ps.setInt(2, linhaItem.getPedido().getId());
		ps.setDouble(3, linhaItem.getProduto().getId());
		
		return ps.execute();
	}

}
