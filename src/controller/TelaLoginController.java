package controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DataBase;
import model.Usuario;
import model.UsuarioDAO;

public class TelaLoginController {

	private String codUsuario;
	private String senha;
	
	@FXML private TextField tela_login_usuario;
	@FXML private PasswordField tela_login_senha;
	@FXML private Button tela_login_botao_enviar;
	
	@FXML private void handlerMouseClick(Event event) throws SQLException, Exception {
		
		codUsuario = tela_login_usuario.getText();
		senha = tela_login_senha.getText();
//		System.out.println("Senha: " + tela_login_senha.getText());
//		System.out.println("Usuário: " + tela_login_usuario.getText());
		
		Connection conn = DataBase.getConnection();
		ResultSet rs = new UsuarioDAO().autenticaUsuario(conn, codUsuario, senha);
		if(rs.next()) {
			System.out.println("Usuário autenticado!");
			Usuario user = new Usuario();
			user.setNome(rs.getString(2));
			
			
			Parent parent = FXMLLoader.load(getClass().getResource("../view/TelaPrincipal.fxml")); 
			Scene cenaTelaPrincipal = new Scene(parent, 450, 500);
			Stage stagePrincipal = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stagePrincipal.setScene(cenaTelaPrincipal);
			stagePrincipal.setResizable(false);
			stagePrincipal.show();
		}
		rs.close();
		conn.close();
	}

	
		
		 
		
		
	
	
	
}
