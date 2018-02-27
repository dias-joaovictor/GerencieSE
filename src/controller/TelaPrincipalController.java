package controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TelaPrincipalController {

	@FXML Button botao_principal_logout;
	@FXML Button botao_principal_produtos;
	@FXML Button botao_principal_fornecedores;
	@FXML Button botao_principal_clientes;
	@FXML Button botao_principal_usuarios;
	@FXML Label label_principal_saudacao;
	
	@FXML public void handlerLogout(Event event) {
		
		Stage stagePrincipal = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stagePrincipal.close();
	}

}
