package controller;


import java.sql.Connection;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.DataBase;
import model.Fornecedor;
import model.FornecedorDAO;

public class ParentCenterFornecedorIncluirController {

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
	@FXML Button botao_fornecedor_cadastrar;
	
	@FXML private void initialize() throws Exception {
		Connection conn = new DataBase().getConnection();
		ResultSet listaEstados = new FornecedorDAO().getListaEstado(conn);
		
		while(listaEstados.next()) {
			//System.out.println(listaEstados.getString(1));
			comboBox_fornecedor_estado.getItems().add(listaEstados.getString(1));
		}
		comboBox_fornecedor_pais.getItems().addAll("Brasil", "Outro");
	}
	
	@FXML public void clickCadastrar(ActionEvent event) {
		//System.out.println(campo_fornecedor_cnpj.getText());
		Fornecedor fornecedor = new Fornecedor();
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
		
		
		System.out.println(fornecedor.getRazaoSocial());
		System.out.println(fornecedor.getEstado());
		System.out.println(fornecedor.toString());
		System.out.println(fornecedor.getPais());
		
		
	}
}
