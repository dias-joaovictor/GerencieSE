package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



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
			ps.setString(1, "%" + textoBusca + "%");
			ResultSet rs = ps.executeQuery();
			return rs;
	}
	
	public ObservableList<Fornecedor> listarFornecedores(Connection conn, String textoBusca) throws SQLException {
		ObservableList<Fornecedor> lista = FXCollections.observableArrayList();
		String sql = "select * from Fornecedores where RazaoSocial like ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + textoBusca + "%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Fornecedor fornecedor = new Fornecedor();
				fornecedor.setId(rs.getInt(1));
				fornecedor.setRazaoSocial(rs.getString(2));
				fornecedor.setCnpj(rs.getString(3));
				fornecedor.setRepresentante(rs.getString(4));
				fornecedor.setEmail(rs.getString(5));
				fornecedor.setTelefone(rs.getString(6));
				fornecedor.setRamal(rs.getString(7));
				fornecedor.setEndereco(rs.getString(8));
				fornecedor.setBairro(rs.getString(9));
				fornecedor.setCidade(rs.getString(10));
				fornecedor.setEstado(rs.getString(11));
				fornecedor.setPais(rs.getString(12));
				
				lista.add(fornecedor);
			}
			return lista;
	}

	public void alterarFornecedor(Connection conn, Fornecedor fornecedor) throws SQLException {

		String sql = "update Fornecedores set RazaoSocial = ?, CNPJ = ?, Representante = ?, Email = ?, Telefone = ?, Ramal = ?, Endereco = ?, Bairro = ?, Cidade = ?, Estado = ?, Pais = ? where IDFornecedor = ?";
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
		ps.setInt(12, fornecedor.getId());
		ps.executeUpdate();
		ps.close();
	}
	
	
	
}
