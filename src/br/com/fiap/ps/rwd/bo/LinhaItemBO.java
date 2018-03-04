package br.com.fiap.ps.rwd.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.ps.rwd.bean.LinhaItem;
import br.com.fiap.ps.rwd.bean.Pedido;
import br.com.fiap.ps.rwd.dao.LinhaItemDAO;

public class LinhaItemBO {
	
	public static boolean adicionaLinhaItem(LinhaItem linhaItem) throws SQLException, ClassNotFoundException {
		LinhaItemDAO linhaItemDAO = new LinhaItemDAO();
		boolean bool = linhaItemDAO.add(linhaItem);
		return bool;
	}
	
	public static List<LinhaItem> trazItensPorPedido(int pedido) throws ClassNotFoundException, SQLException{
		LinhaItemDAO linhaItemDAO = new LinhaItemDAO();
		List<LinhaItem> lista = linhaItemDAO.getByOrder(pedido);
		return lista;
	}

}
