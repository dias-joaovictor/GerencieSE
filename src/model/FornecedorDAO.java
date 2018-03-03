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

	
}
