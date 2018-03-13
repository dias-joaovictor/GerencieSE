package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import model.DataBase;
import model.FornecedorDAO;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class ParentCenterFornecedorGerenciarController {

	@FXML TextField campo_fornecedor_gerenciar_busca;
	@FXML Button botao_fornecedor_gerenciar_buscar;
	@FXML ScrollPane scrollPane_fornecedor_gerenciar_scroll;
	@FXML ListView listView_fornecedor_gerenciar_lista;
	@FXML Button botao_fornecedor_gerenciar_editar;
	@FXML Button botao_fornecedor_gerenciar_excluir;
	@FXML Button botao_fornecedor_gerenciar_ver;
	@FXML TableView tableView_fornecedor_gerenciar_tableView;
	@FXML TableColumn tableColumn_fornecedor_gerenciar_razaoSocial;
	@FXML TableColumn tableColumn_fornecedor_gerenciar_representante;
	
	@FXML public void clickBuscar(ActionEvent event) throws Exception {
		String textoBusca = campo_fornecedor_gerenciar_busca.getText();
		Connection conn = new DataBase().getConnection();
		ResultSet rs = new FornecedorDAO().buscaFornecedores(conn, textoBusca);
		
		
//		while(rs.next()) {
//			tableColumn_fornecedor_gerenciar_razaoSocial.setCellValueFactory(cellData -> cellDat
//		}
//		rs.close();
//		conn.close();
//		
//		tableView_fornecedor_gerenciar_tableView.getColumns().addAll(tableColumn_fornecedor_gerenciar_razaoSocial, tableColumn_fornecedor_gerenciar_representante);
//		
	}
	
}
