package br.com.fiap.ps.rwd.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.com.fiap.ps.rwd.bean.Pedido;
import br.com.fiap.ps.rwd.dao.PedidoDAO;

public class PedidoBO {
	
	public static boolean adicionarPedido(Pedido pedido) throws ClassNotFoundException, SQLException {
		PedidoDAO pedidoDAO = new PedidoDAO();
		boolean bool = pedidoDAO.add(pedido);
		return bool;
	}
	
	public static Pedido selecionaUltimoPedido() throws SQLException, ClassNotFoundException {
		PedidoDAO pedidoDAO = new PedidoDAO();
		Pedido pedido = pedidoDAO.selectLastOrder();
		return pedido;
	}
	
	public static List<Pedido> selecionaPorUsuario(int id) throws ParseException, SQLException, ClassNotFoundException{
		PedidoDAO pedidoDAO = new PedidoDAO();
		List<Pedido> lista = pedidoDAO.selectOrderByUser(id); 
		return lista;
	}

}
