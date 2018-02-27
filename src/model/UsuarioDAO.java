package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Classe UsuarioDAO, acesso ao banco
public class UsuarioDAO {

	public ResultSet autenticaUsuario(Connection conn, String codUsuario, String senha) throws SQLException {
		String sql = "select IDUsuario, Senha from Usuarios where IDUsuario=? and Senha=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, codUsuario);
		ps.setString(2, senha);
		ResultSet rs = ps.executeQuery();
		return rs;
	}
}
