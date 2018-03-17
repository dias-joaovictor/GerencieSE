package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Fornecedor;

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
	Fornecedor fornecedor;

	@FXML public void initialize() {
//		System.out.println(fornecedor.getRazaoSocial());
//		campo_fornecedor_razaoSocial.setText(a);
//			campo_fornecedor_telefone.setText(fornecedor.getTelefone());
//			campo_fornecedor_ramal.setText(fornecedor.getRamal());
//			campo_fornecedor_endereco.setText(fornecedor.getEndereco());
//			campo_fornecedor_cidade.setText(fornecedor.getCidade());
	}
	public void recebeFornecedor(Fornecedor fornecedor){
		
		this.fornecedor = fornecedor;
		String a = fornecedor.getBairro();
		
		campo_fornecedor_cnpj.setText(fornecedor.getCnpj());
		
	}
	 
}
