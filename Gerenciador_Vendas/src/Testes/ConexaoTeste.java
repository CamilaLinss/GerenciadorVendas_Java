package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;

import BancoDados.BancoDados;
import BancoDados.Tabelas;

class ConexaoTeste {
	
	BancoDados bd = new BancoDados();

	@Test
	void testConexao_BD() {
		
		
		bd.conectar();
		assertNotEquals(null,bd.getConexao());
	
		bd.desconectar();
	}

	
	@Test
	void ConexaoException() {
		
NullPointerException rs = assertThrows(NullPointerException.class, () -> bd.conectar());

		//assertThrows(NullPointerException.class, () -> bd.conectar());
		//assertDoesNotThrow(() -> bd.conectar());

assertNotEquals(null,rs.getMessage());



	}
	
	
	
	
	
	
	
	
	
	
	
}
