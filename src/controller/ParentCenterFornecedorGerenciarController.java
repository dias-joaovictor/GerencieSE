package controller;

import java.sql.Connection;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.DataBase;
import model.Fornecedor;
import model.FornecedorDAO;

public class ParentCenterFornecedorGerenciarController {

	@FXML TextField campo_fornecedor_gerenciar_busca;
	@FXML Button botao_fornecedor_gerenciar_buscar;
	@FXML ScrollPane scrollPane_fornecedor_gerenciar_scroll;
	@FXML Button botao_fornecedor_gerenciar_editar;
	@FXML Button botao_fornecedor_gerenciar_excluir;
	@FXML Button botao_fornecedor_gerenciar_ver;
	@FXML ListView listView_fornecedor_gerenciar_lista;
	@FXML TableView<Fornecedor> tableView_fornecedor_gerenciar_tableView;
	@FXML TableColumn<Fornecedor, Integer> tableColumn_fornecedor_gerenciar_id;
	@FXML TableColumn<Fornecedor, String> tableColumn_fornecedor_gerenciar_razaoSocial;
	@FXML TableColumn<Fornecedor, String> tableColumn_fornecedor_gerenciar_representante;
	
	@FXML private void initialize() throws Exception {
		clickBuscar(new ActionEvent());
	}

	
	@FXML public void clickBuscar(ActionEvent event) throws Exception {
		tableView_fornecedor_gerenciar_tableView.getColumns().clear();
		String textoBusca = campo_fornecedor_gerenciar_busca.getText();
		Connection conn = new DataBase().getConnection();
		ObservableList<Fornecedor> list = new FornecedorDAO().listarFornecedores(conn, textoBusca);
		
		tableView_fornecedor_gerenciar_tableView.setItems(list);
		
		tableColumn_fornecedor_gerenciar_id = new TableColumn<>("ID");
		tableColumn_fornecedor_gerenciar_id.setCellValueFactory(new PropertyValueFactory("id"));
		
		tableColumn_fornecedor_gerenciar_razaoSocial = new TableColumn<>("Raz�o Social");
		tableColumn_fornecedor_gerenciar_razaoSocial.setCellValueFactory(new PropertyValueFactory("razaoSocial"));
		
		tableColumn_fornecedor_gerenciar_representante = new TableColumn<>("Representante");
		tableColumn_fornecedor_gerenciar_representante.setCellValueFactory(new PropertyValueFactory("representante"));
		
		tableView_fornecedor_gerenciar_tableView.getColumns().addAll(tableColumn_fornecedor_gerenciar_id,
				tableColumn_fornecedor_gerenciar_razaoSocial, tableColumn_fornecedor_gerenciar_representante);
		
		botao_fornecedor_gerenciar_editar.setOnMouseClicked(ActionEvent -> {
			Fornecedor fornecedor = new Fornecedor(
					tableView_fornecedor_gerenciar_tableView.getSelectionModel().getSelectedItem().getId(), 
					tableView_fornecedor_gerenciar_tableView.getSelectionModel().getSelectedItem().getRazaoSocial(),
					tableView_fornecedor_gerenciar_tableView.getSelectionModel().getSelectedItem().getCnpj(),
					tableView_fornecedor_gerenciar_tableView.getSelectionModel().getSelectedItem().getRepresentante(),
					tableView_fornecedor_gerenciar_tableView.getSelectionModel().getSelectedItem().getTelefone(),
					tableView_fornecedor_gerenciar_tableView.getSelectionModel().getSelectedItem().getRamal(),
					tableView_fornecedor_gerenciar_tableView.getSelectionModel().getSelectedItem().getEmail(),
					tableView_fornecedor_gerenciar_tableView.getSelectionModel().getSelectedItem().getEndereco(),
					tableView_fornecedor_gerenciar_tableView.getSelectionModel().getSelectedItem().getBairro(),
					tableView_fornecedor_gerenciar_tableView.getSelectionModel().getSelectedItem().getCidade(), 
					tableView_fornecedor_gerenciar_tableView.getSelectionModel().getSelectedItem().getEstado(),
					tableView_fornecedor_gerenciar_tableView.getSelectionModel().getSelectedItem().getPais());
			
			try {
				ParentCenterFornecedorEditarController telaEditar = new ParentCenterFornecedorEditarController();
				telaEditar.recebeFornecedor(fornecedor);
				Stage stageEditar = new Stage();
				Parent parent = FXMLLoader.load(getClass().getResource("../view/ParentCenterFornecedorEditar.fxml"));
				Scene cenaEditar = new Scene(parent, 800, 600);
				stageEditar.setScene(cenaEditar);
				stageEditar.setResizable(false);
				stageEditar.show();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//System.out.println(fornecedor);
			
		});
		

	}
	
}
