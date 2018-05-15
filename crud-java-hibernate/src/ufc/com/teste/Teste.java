package ufc.com.teste;

import ufc.com.dao.ContatoDAO;
import ufc.com.modelo.Contato;

public class Teste {

	public static void main(String[] args) {
		Contato contato = new Contato();
		
		contato.setNome("geraldo");
		contato.setTelefone("9999-9999");
		
		ContatoDAO dao = new ContatoDAO();
		//dao.adiciona(contato);
		dao.lista();

	}

}
