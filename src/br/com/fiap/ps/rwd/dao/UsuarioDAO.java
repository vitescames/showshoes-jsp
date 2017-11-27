package br.com.fiap.ps.rwd.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.ps.rwd.bean.Usuario;
import br.com.showshoes.connection.ConnectionFactory;

public class UsuarioDAO {
	
	Connection c;
	PreparedStatement ps;
	ResultSet rs;
	
	public UsuarioDAO() throws ClassNotFoundException, SQLException {
		c = ConnectionFactory.conectar();
	}
	
	public Usuario login(Usuario user) throws SQLException, NoSuchAlgorithmException {
		
		ps = c.prepareStatement("SELECT * FROM usuario WHERE login = ? and senha = ?");
		
		String s = user.getPassword();
		
		MessageDigest m = MessageDigest.getInstance("MD5");	       
		m.update(s.getBytes(),0,s.length());
       
		String passCript = new BigInteger(1,m.digest()).toString(16);
		
		ps.setString(1, user.getUser());
		ps.setString(2, passCript);
		
		rs = ps.executeQuery();
		
		Usuario usuario = null;
		
		if(rs.next()) {
			usuario = new Usuario();
			System.out.println("Entrou!");
		}
		
		return usuario;
		
	}

}
