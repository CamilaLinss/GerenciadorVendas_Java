package BancoDados;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Funcionario_Venda extends BancoDados{

	//private BancoDados bd;
	

	
public ResultSet Busca_Func_Venda(String tabela, String campo1,  String campo2, String campo3, 
		String campo4, String campo5,String dado1,String dado2,String dado3,String dado4,String dado5) {

	
	try {
		String query = "SELECT * FROM "+tabela+" WHERE "+campo1+" LIKE '%" + dado1 + "%' AND "+campo2+" LIKE '%" + dado2 +"%' AND "+campo3+" LIKE '%" + dado3 + "%'"
				+ " AND "+ campo4 +" LIKE '%" + dado4 + "%' AND "+campo5+" LIKE '%" + dado5 + "%';";
		
		//JOptionPane.showMessageDialog(null,query);
		//executeQuery usado apenas para SELECT
		this.resultado = this.consulta.executeQuery(query);
		
		this.resultado.next();
		
	}
		catch(NullPointerException | SQLException fa) {
			//System.out.println("ERRO: " + fa.getMessage());
			JOptionPane.showMessageDialog(null, "ERRO NA BUSCA: " + fa);	
		}

	
	
	return resultado;



}
	
	

	
	
	
	
	
	
	
}
