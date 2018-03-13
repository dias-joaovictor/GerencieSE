package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import org.omg.CORBA.INITIALIZE;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DataBase;
import model.FornecedorDAO;

public class ParentCenterFornecedorGerenciarController {

	@FXML TextField campo_fornecedor_gerenciar_busca;
	@FXML Button botao_fornecedor_gerenciar_buscar;
	@FXML ScrollPane scrollPane_fornecedor_gerenciar_scroll;
	@FXML Button botao_fornecedor_gerenciar_editar;
	@FXML Button botao_fornecedor_gerenciar_excluir;
	@FXML Button botao_fornecedor_gerenciar_ver;
	@FXML ListView listView_fornecedor_gerenciar_lista;
	@FXML TableView<String> tableView_fornecedor_gerenciar_tableView;
	@FXML TableColumn tableColumn_fornecedor_gerenciar_razaoSocial;
	@FXML TableColumn tableColumn_fornecedor_gerenciar_representante;

	
	@FXML public void clickBuscar(ActionEvent event) throws Exception {
		String textoBusca = campo_fornecedor_gerenciar_busca.getText();
		Connection conn = new DataBase().getConnection();
		ResultSet rs = new FornecedorDAO().buscaFornecedores(conn, textoBusca);
		ObservableList<String> list = FXCollections.observableArrayList();
		
		while(rs.next()) {
			String RazaoSocial = rs.getString(2);
			list.add(RazaoSocial);
			System.out.println(RazaoSocial);
		}
		
		tableView_fornecedor_gerenciar_tableView.setItems(list);

	}
	
}
