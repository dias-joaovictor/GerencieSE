package controller;

import java.sql.Connection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.DataBase;
import model.Fornecedor;
import model.FornecedorDAO;

public class ParentCenterFornecedorEditarController {

	@FXML TextField campo_fornecedor_razaoSocial;
	@FXML TextField campo_fornecedor_cnpj;
	@FXML TextField campo_fornecedor_telefone;
	@FXML TextField campo_fornecedor_ramal;
	@FXML TextField campo_fornecedor_endereco;
	@FXML TextField campo_fornecedor_bairro;
	@FXML TextField campo_fornecedor_cidade;
	@FXML ComboBox comboBox_fornecedor_estado;
	@FXML ComboBox comboBox_fornecedor_pais;
	@FXML TextField campo_fornecedor_Representante;
	@FXML TextField campo_fornecedor_email;
	@FXML Button botao_fornecedor_alterar;
	@FXML Button bota_fornecedor_cancelar;
	private Fornecedor fornecedor;
	
//	@FXML private void initialize() throws Exception {
//		campo_fornecedor_razaoSocial.setDisable(value);
//	}

	
	public void carregaFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		campo_fornecedor_razaoSocial.setText(fornecedor.getRazaoSocial());
		campo_fornecedor_cnpj.setText(fornecedor.getCnpj());
		campo_fornecedor_telefone.setText(fornecedor.getTelefone());
		campo_fornecedor_ramal.setText(fornecedor.getRamal());
		campo_fornecedor_endereco.setText(fornecedor.getEndereco());
		campo_fornecedor_bairro.setText(fornecedor.getBairro());
		campo_fornecedor_cidade.setText(fornecedor.getCidade());
		comboBox_fornecedor_estado.getSelectionModel().select(fornecedor.getEstado());
		comboBox_fornecedor_pais.getSelectionModel().select(fornecedor.getPais());
		campo_fornecedor_Representante.setText(fornecedor.getRepresentante());
		campo_fornecedor_email.setText(fornecedor.getEmail());
	}



	@FXML public void clickAlterar(ActionEvent event)  {
		fornecedor.setCnpj(campo_fornecedor_cnpj.getText());
		fornecedor.setRazaoSocial(campo_fornecedor_razaoSocial.getText());
		fornecedor.setTelefone(campo_fornecedor_telefone.getText());
		fornecedor.setRamal(campo_fornecedor_ramal.getText());
		fornecedor.setEndereco(campo_fornecedor_endereco.getText());
		fornecedor.setBairro(campo_fornecedor_bairro.getText());
		fornecedor.setCidade(campo_fornecedor_cidade.getText());
		fornecedor.setEstado(comboBox_fornecedor_estado.getValue().toString());
		fornecedor.setPais(comboBox_fornecedor_pais.getValue().toString());
		fornecedor.setRepresentante(campo_fornecedor_Representante.getText());
		fornecedor.setEmail(campo_fornecedor_email.getText());

		try {
			Connection conn = new DataBase().getConnection();
			new FornecedorDAO().alterarFornecedor(conn, fornecedor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@FXML public void clickCancelar(ActionEvent event) {
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
	}
	
	

	 
	 
}
