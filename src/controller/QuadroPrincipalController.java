package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class QuadroPrincipalController {

	@FXML Button botao_principal_usuarios;
	@FXML Button botao_principal_fornecedores;
	@FXML Button botao_principal_produtos;
	@FXML Button botao_principal_logout;
	@FXML AnchorPane principal_anchorPane;
	@FXML BorderPane borderPane;
	@FXML Pane aaaaa;
	
	public QuadroPrincipalController() throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("../view/ParentInicial.fxml"));
		principal_anchorPane.setBottomAnchor(parent, 0.0);
		principal_anchorPane.setTopAnchor(parent, 0.0);
		principal_anchorPane.setLeftAnchor(parent, 0.0);
		principal_anchorPane.setRightAnchor(parent, 0.0);
		principal_anchorPane.getChildren().add(parent);
	}
	
	@FXML public void clickProduto(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("../view/ParentProduto.fxml"));
		principal_anchorPane.setLeftAnchor(parent, 0.0);
		principal_anchorPane.setRightAnchor(parent, 0.0);
		principal_anchorPane.getChildren().add(parent);
		
		//aaaaa.set;
		ativarTodosBotoes();
		botao_principal_produtos.setDisable(true);
		
	}
	@FXML public void clickFornecedor(ActionEvent event) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("../view/ParentFornecedores.fxml"));
		principal_anchorPane.setLeftAnchor(parent, 0.0);
		principal_anchorPane.setRightAnchor(parent, 0.0);
		principal_anchorPane.getChildren().add(parent);
		ativarTodosBotoes();
		botao_principal_fornecedores.setDisable(true);
		
	}
	@FXML public void clickUsuario(ActionEvent event) {}
	
	@FXML public void clickLogout(ActionEvent event) {
		
		Stage stageClose = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stageClose.close();
	}
	
	public void ativarTodosBotoes() {
		botao_principal_usuarios.setDisable(false);
		botao_principal_fornecedores.setDisable(false);
		botao_principal_produtos.setDisable(false);
		botao_principal_logout.setDisable(false);
	}

}
