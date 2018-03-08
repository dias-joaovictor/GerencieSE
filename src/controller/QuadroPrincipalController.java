package controller;



import java.io.IOException;

//import com.sun.deploy.config.Platform;

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
import view.QuadroPrincipalView;

public class QuadroPrincipalController {

	@FXML Button botao_principal_usuarios;
	@FXML Button botao_principal_fornecedores;
	@FXML Button botao_principal_produtos;
	@FXML Button botao_principal_logout;
	@FXML AnchorPane principal_anchorPane;
	@FXML Label label_inicial;
	@FXML AnchorPane central_anchorPane;
	@FXML MenuBar principal_menuBar;
	@FXML Menu principal_menu;
	
	@FXML public void initialize() throws Exception {
		principal_anchorPane.getChildren().clear();
		label_inicial = new QuadroPrincipalView().setLabelInicial();
		principal_anchorPane.setBottomAnchor(label_inicial, 100.0);
		principal_anchorPane.setTopAnchor(label_inicial, 0.0);
		principal_anchorPane.setLeftAnchor(label_inicial, 130.0);
		principal_anchorPane.setRightAnchor(label_inicial, 100.0);
		principal_anchorPane.getChildren().add(label_inicial);
		
	}
	
	@FXML public void clickProduto(ActionEvent event) throws Exception {
		limparTelaInicial();		
		ativarTodosBotoes();
		botao_principal_produtos.setDisable(true);

		principal_menu = new Menu("Produtos");
		MenuItem listarProduto = new MenuItem("Listar Produtos");
		MenuItem gerenciarProduto = new MenuItem("Gerenciar Produtos");
		principal_menu.getItems().addAll(listarProduto, gerenciarProduto);
		principal_menuBar.getMenus().add(principal_menu);

		principal_anchorPane.setLeftAnchor(principal_menuBar, 0.0);
		principal_anchorPane.setRightAnchor(principal_menuBar, 0.0);
		principal_anchorPane.setTopAnchor(principal_menuBar, 0.0);
		principal_anchorPane.getChildren().add(principal_menuBar);
		

		
		listarProduto.setOnAction(ActionEvent -> System.out.println("funciona"));
		
	}
	@FXML public void clickFornecedor(ActionEvent event) throws Exception {
		limparTelaInicial();
		ativarTodosBotoes();
		botao_principal_fornecedores.setDisable(true);

		principal_menu = new Menu("Fornecedor");
		MenuItem gerenciarFornecedor = new MenuItem("Gerenciar Fornecedores");
		MenuItem incluirFornecedor = new MenuItem("Incluir Fornecedor");
		
		principal_menu.getItems().addAll(gerenciarFornecedor, incluirFornecedor);
		principal_menuBar.getMenus().add(principal_menu);
		
		principal_anchorPane.setLeftAnchor(principal_menuBar, 0.0);
		principal_anchorPane.setRightAnchor(principal_menuBar, 0.0);
		principal_anchorPane.setTopAnchor(principal_menuBar, 0.0);
		principal_anchorPane.getChildren().add(principal_menuBar);
		
		
		
		incluirFornecedor.setOnAction(ActionEvent -> {
			try {
				principal_anchorPane.getChildren().clear();
				Parent formulario = FXMLLoader.load(getClass().getResource("../view/ParentCenterFornecedorIncluir.fxml"));
				principal_anchorPane.setTopAnchor(formulario, 20.0);
				principal_anchorPane.setBottomAnchor(formulario, 0.0);
				principal_anchorPane.setLeftAnchor(formulario, 0.0);
				principal_anchorPane.setRightAnchor(formulario, 0.0);
				principal_anchorPane.getChildren().add(formulario);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		gerenciarFornecedor.setOnAction(ActionEvent -> {
			try {
				Parent lista = FXMLLoader.load(getClass().getResource("../view/ParentCenterFornecedorGerenciar.fxml"));
				principal_anchorPane.setTopAnchor(lista, 20.0);
				principal_anchorPane.setBottomAnchor(lista, 0.0);
				principal_anchorPane.setLeftAnchor(lista, 0.0);
				principal_anchorPane.setRightAnchor(lista, 0.0);
				principal_anchorPane.getChildren().add(lista);
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		});
		
		
//		Parent menu = FXMLLoader.load(getClass().getResource("../view/ParentFornecedores.fxml"));
//		principal_anchorPane.setLeftAnchor(menu, 0.0);
//		principal_anchorPane.setRightAnchor(menu, 0.0);
//		
		
	}
	@FXML public void clickUsuario(ActionEvent event) {
		limparTelaInicial();
		ativarTodosBotoes();
		botao_principal_usuarios.setDisable(true);
		
		principal_menu = new Menu("Usuários");
		MenuItem incluirUsuario = new MenuItem("Incluir");
		MenuItem gerenciarUsuario = new MenuItem("Gerenciar");
		principal_menu.getItems().addAll(incluirUsuario, gerenciarUsuario);
		
		Menu principal_menuGrupo = new Menu("Grupos");
		MenuItem incluirGrupo = new MenuItem("Incluir");
		MenuItem gerenciarGrupo = new MenuItem("Gerenciar");
		principal_menuGrupo.getItems().addAll(incluirGrupo, gerenciarGrupo);
		
		principal_menuBar.getMenus().addAll(principal_menu, principal_menuGrupo);
		
		principal_anchorPane.setLeftAnchor(principal_menuBar, 0.0);
		principal_anchorPane.setRightAnchor(principal_menuBar, 0.0);
		principal_anchorPane.setTopAnchor(principal_menuBar, 0.0);
		principal_anchorPane.getChildren().add(principal_menuBar);
	}
	
	@FXML public void clickLogout(ActionEvent event) {
		
		Stage stageClose = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stageClose.close();
	}
	
	public void ativarTodosBotoes() {
		botao_principal_usuarios.setDisable(false);
		botao_principal_fornecedores.setDisable(false);
		botao_principal_produtos.setDisable(false);
	}
	
	private void limparTelaInicial() {
		principal_anchorPane.getChildren().clear();
		principal_menuBar.getMenus().clear();
	}

}
