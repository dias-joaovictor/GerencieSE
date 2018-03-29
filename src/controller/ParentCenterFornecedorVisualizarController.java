package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Fornecedor;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class ParentCenterFornecedorVisualizarController {

	@FXML TextField campo_fornecedor_razaoSocial;
	@FXML TextField campo_fornecedor_cnpj;
	@FXML TextField campo_fornecedor_telefone;
	@FXML TextField campo_fornecedor_ramal;
	@FXML TextField campo_fornecedor_endereco;
	@FXML TextField campo_fornecedor_bairro;
	@FXML TextField campo_fornecedor_cidade;
	@FXML TextField campo_fornecedor_Representante;
	@FXML TextField campo_fornecedor_email;
	@FXML TextField campo_fornecedor_uf;
	@FXML TextField campo_fornecedor_pais;
	@FXML Button bota_fornecedor_fechar;
	private Fornecedor fornecedor;
	
	public void carregaFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
		campo_fornecedor_razaoSocial.setText(fornecedor.getRazaoSocial());
		campo_fornecedor_cnpj.setText(fornecedor.getCnpj());
		campo_fornecedor_telefone.setText(fornecedor.getTelefone());
		campo_fornecedor_ramal.setText(fornecedor.getRamal());
		campo_fornecedor_endereco.setText(fornecedor.getEndereco());
		campo_fornecedor_bairro.setText(fornecedor.getBairro());
		campo_fornecedor_cidade.setText(fornecedor.getCidade());
		campo_fornecedor_uf.setText(fornecedor.getEstado());
		campo_fornecedor_pais.setText(fornecedor.getPais());
		campo_fornecedor_Representante.setText(fornecedor.getRepresentante());
		campo_fornecedor_email.setText(fornecedor.getEmail());
	}
	
	
	@FXML public void clickFechar(ActionEvent event) {}

}
