package BancoDados;

import javax.swing.JOptionPane;

public class acao {

	public static void main(String[] args) {


		BancoDados bd = new BancoDados();
		
		bd.conectar();
	
		bd.Busca_Funcionario(Tabelas.funcionario, Tabelas.ID_func, Tabelas.nome_func, Tabelas.CPF,
				Tabelas.senha, Tabelas.ADM, "995", "", "", "", "");
		
		
	//	JOptionPane.showMessageDialog(null,	bd.Busca_Funcionario(Tabelas.funcionario, Tabelas.ID_func, Tabelas.nome_func, Tabelas.CPF,
		//		Tabelas.senha, Tabelas.ADM, "995", "", "", "", ""));
		
		
		//JOptionPane.showMessageDialog(null,Tabelas.funcionario);
		
		
	}

}
