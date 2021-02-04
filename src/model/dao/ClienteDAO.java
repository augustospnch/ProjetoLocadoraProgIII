package model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Cliente> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cliente> cliente = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT * FROM cliente;");
			rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente f = new Cliente();
				f.setIdCliente(rs.getInt("idCliente"));
				f.setNome(rs.getString("nome"));
				f.setEmail(rs.getString("email"));
				f.setTelefone(rs.getString("telefone"));
				f.setEndereco(rs.getString("endereco"));
				f.setCpf(rs.getInt("cpf"));
				cliente.add(f);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar as informações do banco de dados: " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return cliente;
	}

	public Cliente read(int idCliente) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cliente f = new Cliente();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente WHERE idCliente=? LIMIT 1;");
			stmt.setInt(1, idCliente);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {
				f.setIdCliente(rs.getInt("idCliente"));
				f.setNome(rs.getString("nome"));
				f.setEmail(rs.getString("email"));
				f.setTelefone(rs.getString("telefone"));
				f.setEndereco(rs.getString("endereco"));
				f.setCpf(rs.getInt("cpf"));
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return f;
	}
	
	
	public void update(Cliente f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("UPDATE filme SET titulo=?, categoria=?, sinopse=?,"
					+ "tempo=?, imagem3d=?, dublado=? WHERE idFilme=?;");
			stmt.setString(1, f.getNome());
			stmt.setString(2, f.getEmail());
			stmt.setString(3, f.getTelefone());
			stmt.setString(4, f.getEndereco());
			stmt.setInt(5, f.getCpf());
			stmt.setInt(6, f.getIdCliente());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void delete(Cliente f) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("DELETE FROM cliente WHERE idCliente=?");
			stmt.setInt(1, f.getIdCliente());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}

}
