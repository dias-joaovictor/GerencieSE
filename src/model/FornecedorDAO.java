package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class FornecedorDAO {

	public ResultSet getListaEstado(Connection conn) throws SQLException {
		String sql = "select sigla from ListaEstadosBrasileiros";
		Statement stmt = conn.createStatement();
		//PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}

	public void insereBanco(Connection conn, Fornecedor fornecedor) {
		String sql = "insert into Fornecedores(RazaoSocial, CNPJ, Representante, Email, Telefone, Ramal, Endereco, Bairro, Cidade, Estado, Pais) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, fornecedor.getRazaoSocial());
			ps.setString(2, fornecedor.getCnpj());
			ps.setString(3, fornecedor.getRepresentante());
			ps.setString(4, fornecedor.getEmail());
			ps.setString(5, fornecedor.getTelefone());
			ps.setString(6, fornecedor.getRamal());
			ps.setString(7, fornecedor.getEndereco());
			ps.setString(8, fornecedor.getBairro());
			ps.setString(9, fornecedor.getCidade());
			ps.setString(10, fornecedor.getEstado());
			ps.setString(11, fornecedor.getPais());
			ps.executeUpdate();
			ps.close();
			conn.close();
			System.out.println("Cadastrado com sucesso!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public ResultSet buscaFornecedores(Connection conn, String textoBusca) throws SQLException {
		String sql = "select * from Fornecedores where RazaoSocial like ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "'%" + textoBusca + "%'");
			ResultSet rs = ps.executeQuery();
			ps.close();
			return rs;
	}
}
