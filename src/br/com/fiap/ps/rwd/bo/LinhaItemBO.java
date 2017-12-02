package br.com.fiap.ps.rwd.bo;

import java.sql.SQLException;

import br.com.fiap.ps.rwd.bean.LinhaItem;
import br.com.fiap.ps.rwd.dao.LinhaItemDAO;

public class LinhaItemBO {
	
	public static boolean adicionaLinhaItem(LinhaItem linhaItem) throws SQLException, ClassNotFoundException {
		LinhaItemDAO linhaItemDAO = new LinhaItemDAO();
		return linhaItemDAO.add(linhaItem);
	}

}
