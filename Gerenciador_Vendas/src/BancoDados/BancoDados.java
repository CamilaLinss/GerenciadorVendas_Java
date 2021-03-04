package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BancoDados {

	
	
	//Objeto que vai fazer a conexão
	protected Connection conexao = null;
	//Objeto que vai armazenar os comandos sql para consulta
	protected Statement consulta = null;
	//Objeto que vai armazenar os resultados da consulta
	protected ResultSet resultado = null;
	
	
	
	
	
	
	
	
	
	

public Connection getConexao() {
		return conexao;
	}



	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}



	public Statement getConsulta() {
		return consulta;
	}



	public void setConsulta(Statement consulta) {
		this.consulta = consulta;
	}



	public ResultSet getResultado() {
		return resultado;
	}



	public void setResultado(ResultSet resultado) {
		this.resultado = resultado;
	}

	
	
	
	
	
	
	
	
	


public void conectar() {
	//COLOCO "?serverTimezone=UTC" DEPOIS DO NOME DO BANCO PARA N TER ERRO DE FUSO HORARIO
	String servidor = "jdbc:mysql://localhost:3306/auto_pecas?serverTimezone=UTC";
	String usuario = "root";
    String senha = "1234c";
	
	//String servidor = "jdbc:mysql://mysql742.umbler.com:41890/auto_pecas?serverTimezone=UTC";
	//String usuario = "camzroot";
	//String senha = "25139110c";
	
	
	//String servidor = "jdbc:mysql://mysql742.umbler.com:41890/auto_pecas?serverTimezone=UTC";
	//String usuario = "camzroot";
	//String senha = "25139110c";
	
	
	
	String driver = "com.mysql.cj.jdbc.Driver";
	
//"TENTE" este comando vai tentar fazer um processo ou conexão, se esse processo não funcionar
//ele não vai interromper o programa e apenas armazenar o erro em uma variavel
//Uma consulta é muito passivel de erros e por isso deve sempre usar o try, muitas vezes nem compila e se rodar vem erro
try {
	Class.forName(driver);
	//o "this" é usado quando quero referenciar um atributo da propria classe
	this.conexao = DriverManager.getConnection(servidor, usuario, senha);
	this.consulta = this.conexao.createStatement();
}
//Pegar uma exceção (erro) e colocar na variavel "fa"
catch (NullPointerException | SQLException |ClassNotFoundException  fa) {
	JOptionPane.showMessageDialog(null, "ERRO: " + fa);	
}



     }




public boolean estaConectado() {
	//é por isso que damos um valor null nos objetos de conexão
	//Quando não é nem true ou false, ele é null
//No momento ele é = null, a if vai perguntar se ele é != de null, se a conexão não me trouxe nada e assim continuar nula, então ela ainda é = null, então a questão se ela é != null é falsa, se for realmente != null então ela é verdadeira
	if(this.conexao != null) {
		return true; 
		}
	else {
		return false;
	}
				
}
	



public void listarDados() {

try {
	String query = "SELECT * FROM funcionario ORDER BY nome_func";
	//executeQuery usado apenas para SELEÇÃO
	this.resultado = this.consulta.executeQuery(query);
	
	//Looping para a cada item que ele passar da lista fazer tal ação.O comando Next vai para a proxima linha da lista
	while(this.resultado.next()) {
		//getString vai pegar um texto/dado do resultado retornado pela query, e como parametro o nome da coluna
	System.out.println("Cod: " + this.resultado.getString("ID_func") + " NOME: " + this.resultado.getString("nome_func"));
		//JOptionPane.showMessageDialog(null,"Cod: " + this.resultado.getString("ID_func") + " NOME: " + this.resultado.getString("nome_func"));
		
		
	       }
}
		
	catch(Exception fa) {
		//System.out.println("ERRO: " + fa.getMessage());
		
		JOptionPane.showMessageDialog(null, "ERRO AO LISTAR: " + fa);	
	}
	
  }
	


public void desconectar() {
	
	try {
		//Fechar a conexão
		//São boas praticas sempre fechar a conexão assim não deixando um serviço aberto que não está sendo utilizado
		//O banco geralmente tem limite de conexões! Mais um motivo para ser fechado apos usado
		this.conexao.close();
	}
	catch(Exception fa) {
			System.out.println("ERRO PARA DESCONECTAR: " + fa.getMessage());
		
	}
	
	
}






	
	
}
