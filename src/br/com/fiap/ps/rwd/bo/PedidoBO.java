package br.com.fiap.ps.rwd.bo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import br.com.fiap.ps.rwd.bean.Pedido;
import br.com.fiap.ps.rwd.dao.PedidoDAO;

public class PedidoBO {
	
	public static boolean adicionarPedido(Pedido pedido) throws ClassNotFoundException, SQLException {
		PedidoDAO pedidoDAO = new PedidoDAO();
		return pedidoDAO.add(pedido);
	}
	
	public static Pedido selecionaUltimoPedido() throws SQLException, ClassNotFoundException {
		PedidoDAO pedidoDAO = new PedidoDAO();
		return pedidoDAO.selectLastOrder();
	}
	
	public static List<Pedido> selecionaPorUsuario(int id) throws ParseException, SQLException, ClassNotFoundException{
		PedidoDAO pedidoDAO = new PedidoDAO();
		return pedidoDAO.selectOrderByUser(id);
	}

}
