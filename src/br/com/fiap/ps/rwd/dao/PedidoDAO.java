package br.com.fiap.ps.rwd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.ps.rwd.bean.Pedido;
import br.com.fiap.ps.rwd.bo.LinhaItemBO;
import br.com.fiap.ps.rwd.bo.UsuarioBO;
import br.com.showshoes.connection.ConnectionFactory;

public class PedidoDAO {
	
	ResultSet rs;
	PreparedStatement ps;
	Connection c;
	
	public PedidoDAO() throws ClassNotFoundException, SQLException {
		c = ConnectionFactory.conectar();
	}
	
	public boolean add(Pedido pedido) throws SQLException {
		
		ps = c.prepareStatement("INSERT INTO pedido (id_cliente, data_realizado) VALUES (?,?)");
		
		ps.setInt(1, pedido.getUsuario().getId());
		ps.setTimestamp(2, pedido.getDate());
		
		return ps.execute();
		
	}
	
	public List<Pedido> selectOrderByUser(int id) throws ParseException, SQLException, ClassNotFoundException{
		ps = c.prepareStatement("SELECT * FROM pedido WHERE id_cliente = ?");
		
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
		Pedido pedido = null;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		List<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		while(rs.next()) {
			pedido = new Pedido();
			pedido.setUsuario(UsuarioBO.trazUsuario(id));
			pedido.setId(rs.getInt("id"));
			pedido.setDate(rs.getTimestamp("data_realizado"));
			pedido.setListLinhaItens(LinhaItemBO.trazItensPorPedido(pedido.getId()));
			listaPedidos.add(pedido);
		}
		
		return listaPedidos;
	}
	
	public Pedido selectLastOrder() throws SQLException {
		ps = c.prepareStatement("SELECT * FROM pedido ORDER BY id DESC LIMIT 1");
		rs = ps.executeQuery();
		
		Pedido pedido = new Pedido();
		
		if(rs.next()) {
			pedido.setId(rs.getInt("id"));
			//pedido.setDate(rs.getString("data_realizado"));
		}
		
		return pedido;
	}

}
