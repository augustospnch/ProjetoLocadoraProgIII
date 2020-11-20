package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Cliente;

public class ClienteDAO {
	
	public void create(Cliente f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO CLIENTE (nome, email, telefone, endereço, cpf) VALUES"
					+ "(?,?,?,?,?)");
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getEmail());
			stmt.setString(3, f.getTelefone());
			stmt.setString(4, f.getEndereco());
			stmt.setInt(5, f.getCpf());
			
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar: "+ e);
		}finally{
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
