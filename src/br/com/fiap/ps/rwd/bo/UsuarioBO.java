package br.com.fiap.ps.rwd.bo;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import br.com.fiap.ps.rwd.bean.Usuario;
import br.com.fiap.ps.rwd.dao.UsuarioDAO;

public class UsuarioBO {
	
	public static Usuario login(Usuario user) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.login(user);
	}

}
