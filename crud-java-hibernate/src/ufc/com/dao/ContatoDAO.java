package ufc.com.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ufc.com.modelo.Contato;

public class ContatoDAO {
	
	public void adiciona(Contato contato) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		//codigo
		
		manager.getTransaction().begin();
		manager.persist(contato);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
	}
	
	public void altera(Contato contato) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		//codigo
		
		manager.getTransaction().begin();
		manager.merge(contato);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
	}
	
	public void remove(Long id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
				
		//codigo
		
		Contato contato = manager.find(Contato.class, id);
		
		manager.getTransaction().begin();
		manager.remove(contato);
		manager.getTransaction().commit();
		
		fabrica.close();
		manager.close();
		
	}
	
	public Contato buscarPorId(Long id) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		Contato contato = manager.find(Contato.class, id);
		
		fabrica.close();
		manager.close();
		
		return contato;
	}
	
	public List<Contato> lista(){
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("crud-jpa-hibernate");
		EntityManager manager = fabrica.createEntityManager();
		
		List<Contato> contatos = manager.createQuery("select c from Contato as c", Contato.class).getResultList();
		
		fabrica.close();
		manager.close();
		
		return contatos;
	}
	
}
