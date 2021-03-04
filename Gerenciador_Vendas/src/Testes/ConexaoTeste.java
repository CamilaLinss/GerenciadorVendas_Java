package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import BancoDados.BancoDados;

class ConexaoTeste {
	
	BancoDados bd = new BancoDados();

	@Test
	void testConexao_BD() {
		
		
		bd.conectar();
		assertNotEquals(null,bd.getConexao());
	
		bd.desconectar();
	}

}
