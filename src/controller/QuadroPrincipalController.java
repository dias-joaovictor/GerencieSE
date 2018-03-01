package controller;



import com.sun.deploy.config.Platform;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class QuadroPrincipalController {

	@FXML Button botao_principal_usuarios;
	@FXML Button botao_principal_fornecedores;
	@FXML Button botao_principal_produtos;
	@FXML Button botao_principal_logout;
	@FXML AnchorPane principal_anchorPane;
	@FXML Label label_inicial;
	@FXML AnchorPane central_anchorPane;
	@FXML MenuBar principal_menuBar;
	
	@FXML public void initialize() throws Exception {
		label_inicial = new Label();
		label_inicial.setAlignment(Pos.CENTER);
		label_inicial.setText("Gerencie.SE");
		label_inicial.setRotate(45);
		label_inicial.setFont(Font.font(100));
		principal_anchorPane.setBottomAnchor(label_inicial, 0.0);
		principal_anchorPane.setTopAnchor(label_inicial, 0.0);
		principal_anchorPane.setLeftAnchor(label_inicial, 50.0);
		principal_anchorPane.setRightAnchor(label_inicial, 0.0);
		principal_anchorPane.getChildren().add(label_inicial);
	}
	
	@FXML public void clickProduto(ActionEvent event) throws Exception {
		limparTelaInicial();		
		ativarTodosBotoes();
		botao_principal_produtos.setDisable(true);

		Menu menuProdutos = new Menu("Produtos");
		MenuItem listarProduto = new MenuItem("Listar Produtos");
		MenuItem gerenciarProduto = new MenuItem("Gerenciar Produtos");
		menuProdutos.getItems().addAll(listarProduto, gerenciarProduto);

		principal_menuBar.getMenus().add(menuProdutos);
		
		listarProduto.setOnAction(ActionEvent -> System.out.println("funciona"));
		
	}
	@FXML public void clickFornecedor(ActionEvent event) throws Exception {
		limparTelaInicial();
		ativarTodosBotoes();
		botao_principal_fornecedores.setDisable(true);
		Parent formulario = FXMLLoader.load(getClass().getResource("../view/ParentCenterFornecedores.fxml"));

		Menu menuFornecedor = new Menu("Fornecedor");
		MenuItem listaFornecedor = new MenuItem("Listar");
		MenuItem incluirFornecedor = new MenuItem("Incluir");
		MenuItem AlterarFornecedor = new MenuItem("Alterar");
		
		menuFornecedor.getItems().addAll(listaFornecedor, incluirFornecedor, AlterarFornecedor);
		principal_menuBar.getMenus().add(menuFornecedor);
		
		incluirFornecedor.setOnAction(ActionEvent -> {
			central_anchorPane.setTopAnchor(formulario, 0.0);
			central_anchorPane.setBottomAnchor(formulario, 0.0);
			central_anchorPane.setLeftAnchor(formulario, 0.0);
			central_anchorPane.setRightAnchor(formulario, 0.0);
			central_anchorPane.getChildren().add(formulario);
		});
		
		
//		Parent menu = FXMLLoader.load(getClass().getResource("../view/ParentFornecedores.fxml"));
//		principal_anchorPane.setLeftAnchor(menu, 0.0);
//		principal_anchorPane.setRightAnchor(menu, 0.0);
//		
		
	}
	@FXML public void clickUsuario(ActionEvent event) {
		limparTelaInicial();
	}
	
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
	
	private void limparTelaInicial() {
		principal_anchorPane.getChildren().remove(principal_menuBar);
		principal_anchorPane.getChildren().remove(label_inicial);
	}

}
