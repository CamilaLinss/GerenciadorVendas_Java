package BancoDados;


import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class acao {

	public static void main(String[] args) {


		BancoDados bd = new BancoDados();
		Funcionario_Venda tes = new Funcionario_Venda();
		
		//bd.conectar();
		tes.conectar();
		
		ResultSet mostra = tes.Busca_Func_Venda(Tabelas.funcionario, Tabelas.ID_func, Tabelas.nome_func, Tabelas.CPF,
				Tabelas.senha, Tabelas.ADM, "994", "", "", "", "");
	
		
		try{
		
		System.out.println("Cod: " + mostra.getString("ID_func") + " NOME: " + mostra.getString("nome_func"));
		
		}
		catch(Exception fa) {
			//System.out.println("ERRO: " + fa.getMessage());
			JOptionPane.showMessageDialog(null, "ERRO NA BUSCA: " + fa);	
		}
		 
		
		

		
	//	System.out.println(bd.Busca_Funcionario(Tabelas.funcionario, Tabelas.ID_func, Tabelas.nome_func, Tabelas.CPF,
				//Tabelas.senha, Tabelas.ADM, "995", "", "", "", ""));
		
	//JOptionPane.showMessageDialog(null,	bd.Busca_Funcionario(Tabelas.funcionario, Tabelas.ID_func, Tabelas.nome_func, Tabelas.CPF,
			//Tabelas.senha, Tabelas.ADM, "995", "", "", "", ""));
		
		
		tes.desconectar();
		//JOptionPane.showMessageDialog(null,Tabelas.funcionario);
		
		
	}

}
