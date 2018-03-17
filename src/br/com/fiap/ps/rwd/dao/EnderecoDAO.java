package br.com.fiap.ps.rwd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.ps.rwd.bean.Endereco;
import br.com.showshoes.connection.ConnectionFactory;

public class EnderecoDAO {
	
	private Connection c;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public EnderecoDAO() throws ClassNotFoundException, SQLException {
		c = ConnectionFactory.conectar();
	}
	
	public Endereco selectById(int id) throws SQLException {
		
		ps = c.prepareStatement("SELECT * FROM endereco WHERE id = ?");
		
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
		Endereco endereco = null;
		
		if(rs.next()) {
			endereco = new Endereco();
			
			endereco.setBairro(rs.getString("bairro"));
			endereco.setCidade(rs.getString("cidade"));
			endereco.setEstado(rs.getString("estado"));
			endereco.setLogradouro(rs.getString("logradouro"));
			endereco.setNumero(rs.getInt("numero"));
		}
		
		return endereco;
		
	}

}
