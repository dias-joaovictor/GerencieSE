package view;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class QuadroPrincipalView {
	
	@FXML private Label label_inicial;
	@FXML private AnchorPane principal_anchorPane;
	@FXML private Menu principal_menu;
	@FXML private MenuBar principal_menuBar;

	public Label setLabelInicial() {
		label_inicial = new Label();
		label_inicial.setAlignment(Pos.CENTER);
		label_inicial.setText("Gerencie.SE");
		label_inicial.setRotate(-45);
		label_inicial.setFont(Font.font(60));
		
		return label_inicial;
	}
	
	public MenuBar setMenuBarProduto() {
		principal_menu = new Menu("Produtos");
		MenuItem listarProduto = new MenuItem("Listar Produtos");
		MenuItem gerenciarProduto = new MenuItem("Gerenciar Produtos");
		principal_menu.getItems().addAll(listarProduto, gerenciarProduto);
		principal_menuBar.getMenus().add(principal_menu);
		return principal_menuBar;
	}
	
	public AnchorPane centralizarParent(Parent parent) {
		principal_anchorPane.setTopAnchor(parent, 20.0);
		principal_anchorPane.setBottomAnchor(parent, 0.0);
		principal_anchorPane.setLeftAnchor(parent, 0.0);
		principal_anchorPane.setRightAnchor(parent, 0.0);
		return principal_anchorPane;
		
	}

}
