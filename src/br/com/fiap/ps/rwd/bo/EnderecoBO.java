package br.com.fiap.ps.rwd.bo;

import java.sql.SQLException;

import br.com.fiap.ps.rwd.bean.Endereco;
import br.com.fiap.ps.rwd.dao.EnderecoDAO;

public class EnderecoBO {
	
	public static Endereco selecionaPorId(int id) throws SQLException, ClassNotFoundException {
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = enderecoDAO.selectById(id);
		return endereco;
	}

}
